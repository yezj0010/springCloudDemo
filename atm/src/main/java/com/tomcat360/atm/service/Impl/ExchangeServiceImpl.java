package com.tomcat360.atm.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.tomcat360.atm.constant.AtmConstant;
import com.tomcat360.atm.enums.EnumResponseMsg;
import com.tomcat360.atm.enums.TransStatusEnum;
import com.tomcat360.atm.model.*;
import com.tomcat360.atm.model.redis.AtmTokenInfo;
import com.tomcat360.atm.model.redis.UserInfo;
import com.tomcat360.atm.properties.AppProperties;
import com.tomcat360.atm.service.*;
import com.tomcat360.atm.util.CalendarUtil;
import com.tomcat360.atm.util.IDUtil;
import com.tomcat360.atm.util.LogUtils;
import com.tomcat360.atm.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class ExchangeServiceImpl implements ExchangeService {
	@Autowired
	private IDUtil iDUtil;
	@Autowired
	private RedisService redisService;
	@Autowired
	private TbSettingsService tbSettingsService;
	
	
	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private TbUserAccountService tbUserAccountService;

	@Autowired
	private TbTransService tbTransService;

	@Autowired
	private AppProperties appProperties;

	@Autowired
	private TbCheckResultService tbCheckResultService;

	@Autowired
	private TbCCheckTransService tbCCheckTransService;

	@Autowired
	private TbPCheckTransService tbPCheckTransService;

	@Autowired
	private TbExCheckTransService tbExCheckTransService;

	@Autowired
	private TbCheckCCountService tbCheckCCountService;

	@Autowired
	private TbEquipmentService tbEquipmentService;

	@Autowired
	private TbAreaService tbAreaService;

	private final Integer loginNumMax = 30;// 每天最大登录次数

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public JSONData getQRCode(String atmNum) {
		//调用交易所获取二维码接口 start
		// 组装参数
		Map<String, Object> params = new HashMap();
		params.put("atmNum", atmNum);
		Long time = System.currentTimeMillis();
		params.put("_dt", time);
		params.put("_s", getSignatureByexchange(params));

		Map<String, Object> headers = new HashMap();

		JSONData jsonData = doPost(appProperties.getBaseUrl() + "/qrcode", params, headers);
		if (jsonData == null) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_EXCHANFE_ERROR.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_EXCHANFE_ERROR.getMsg()).build();
		} else if (!EnumResponseMsg.isSuccess(jsonData.getCode())) {
			return jsonData;
		}

		Map<String, ?> exResult = jsonData.getData();

		Map result = new HashMap<String, String>();
		result.put("qrcode", exResult.get("qrtoken"));

		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(result).build();
	}

	@Override
	public JSONData loginByQRCode(HttpServletRequest request, String qrtoken, String date) {
		// 调用交易所根据二维码获取token接口 start
		// 组装参数
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("qrtoken", qrtoken);
		Long time = System.currentTimeMillis();
		params.put("_dt", time);
		params.put("_s", getSignatureByexchange(params));

		Map<String, Object> headers = new HashMap<String, Object>();

		JSONData jsonData = doPost(appProperties.getBaseUrl() + "/qrcode/result", params, headers);
		if (jsonData == null) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_EXCHANFE_ERROR.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_EXCHANFE_ERROR.getMsg()).build();
		} else if (!EnumResponseMsg.isSuccess(jsonData.getCode())) {
			return jsonData;
		}

		Map<String, ?> exResult = jsonData.getData();

		String loginNum = stringRedisTemplate.opsForValue().get(date + exResult.get("userId"));
		if (!StringUtils.isEmpty(loginNum)) {
			Integer a = Integer.valueOf(loginNum);
			if (a >= loginNumMax) {
				return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_LOGIN_OUT.getCode())
						.msg(EnumResponseMsg.RESP_ERROR_LOGIN_OUT.getMsg()).build();
			}
		}
		Long id = Long.parseLong(exResult.get("userId") + "");// 交易所用户id
		String userName = (String)(exResult.get("loginAccount"));
		// 更新用户表数据
		TbUserInfo tbUserInfo = userInfoService.selectByPrimaryKey(id);
		if (tbUserInfo == null) {
			tbUserInfo = new TbUserInfo();
			tbUserInfo.setId(id);
			tbUserInfo.setUserName(userName);
			tbUserInfo.setUpdateTime(new Date());
			userInfoService.save(tbUserInfo);// 新增
		} else {
			tbUserInfo.setUserName(userName);
			tbUserInfo.setUpdateTime(new Date());
			userInfoService.update(tbUserInfo);// 更新userinfo表
		}

		// 通用登录后处理
		return commonAfterLogin(request, exResult);
	}

	private JSONData commonAfterLogin(HttpServletRequest request, Map<String, ?> exResult) {
		// 从交易所接口，得到用户id，用户名，手机号，交易所token
		Long id = Long.parseLong(exResult.get("userId") + "");// 交易所用户id
		String exchangeToken = (String) exResult.get("token");
		String localToken = generateToken();// 生成本地token

		// 更新用户表数据
		TbUserInfo tbUserInfo = userInfoService.selectByPrimaryKey(id);
		if (tbUserInfo == null) {
			tbUserInfo = new TbUserInfo();
			tbUserInfo.setId(id);
			tbUserInfo.setUserToken(exchangeToken);// 交易所token
			tbUserInfo.setUserLocalToken(localToken);// 本地token
			tbUserInfo.setUpdateTime(new Date());
			userInfoService.save(tbUserInfo);// 新增
		} else {
			tbUserInfo.setUserToken(exchangeToken);// 交易所token
			tbUserInfo.setUserLocalToken(localToken);// 本地token
			tbUserInfo.setUpdateTime(new Date());
			userInfoService.update(tbUserInfo);// 更新userinfo表
		}

		// 将本地token等信息存入redis
		UserInfo userInfo = new UserInfo();
		userInfo.setId(id);
		userInfo.setUserName(tbUserInfo.getUserName());
		AtmTokenInfo atmTokenInfo = AtmTokenInfo.builder().id(id + "")// 交易所用户id
				.userInfo(userInfo).token(localToken).exchangeToken(exchangeToken).expiration((long) 30000)// 超时时间
																											// 单位：秒
				.build();
		redisService.saveAtmTokenInfo(atmTokenInfo);

		// 将token信息放入request中，方便日志记录
		request.setAttribute(AtmConstant.USER, atmTokenInfo.getUserInfo());
		request.setAttribute(AtmConstant.LOCAL_TOKEN, atmTokenInfo.getToken());// 本地token
		request.setAttribute(AtmConstant.EXCHANGE_TOKEN, atmTokenInfo.getExchangeToken());// 交易所token

		// 将当天该用户的登录次数记录在redis中
		String date = (String) request.getAttribute("date");

		String loginNum = stringRedisTemplate.opsForValue().get(date + id) == null ? "0"
				: stringRedisTemplate.opsForValue().get(date + id);
		int a = Integer.valueOf(loginNum);

		stringRedisTemplate.opsForValue().set(date + id, (++a) + "", 3601 * 24, TimeUnit.SECONDS);

		Map<String, String> result = new HashMap<String, String>();
		result.put("token", atmTokenInfo.getToken());// 本地token返回
		result.put("userName", tbUserInfo.getUserName());

		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(result).build();
	}

	@Override
	public JSONData sendValidateMsg(String account, String type, String language) {
		String key = account + "|" + type;
		// 判断是否发送频率太快
		String smsTimeStr = stringRedisTemplate.opsForValue().get(key);
		if (!StringUtils.isEmpty(smsTimeStr)) {
			Long smsTime = Long.valueOf(smsTimeStr);

			if (smsTime != null) {
				long time = new Date().getTime();
				time = time - smsTime;
				if ((time / 1000) < 60) {
					log.info(String.format("短信服务接受的参数：account=%s,type=%s", account, type));
					return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_SMS_FAST.getCode())
							.msg("请在" + (60 - (time / 1000)) + "秒后再使用发送验证码功能|Please use the send verification code function after "+ (60 - (time / 1000)) +" seconds").build();
				}
			}
		}

		// 调用交易所发送验证码接口 start
		// 组装参数
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("account", account);
		params.put("type", Integer.parseInt(type));// 1 为短信验证码， 2 为邮箱验证码
		params.put("platform", 4);// 登陆设备类别 1 PC，2 IOS，3 android ，4 atm
		//language = null;
		params.put("country", language);
		Long time = System.currentTimeMillis();
		params.put("_dt", time);
		params.put("_s", getSignatureByexchange(params));
		Map<String, Object> headers = new HashMap<String, Object>();

		JSONData jsonData = doPost(appProperties.getBaseUrl() + "/code", params, headers);
		if (jsonData == null) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_EXCHANFE_ERROR.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_EXCHANFE_ERROR.getMsg()).build();
		} else if (!EnumResponseMsg.isSuccess(jsonData.getCode())) {
			return jsonData;
		}
		Map<String, ?> exResult = jsonData.getData();
		// 调用交易所发送验证码接口 end

		// redis中更新最后发送短信时间,并设置超时时间5分钟
		Date now = new Date();
		stringRedisTemplate.opsForValue().set(key, now.getTime() + "", 5 * 60, TimeUnit.SECONDS);

		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(exResult).build();
	}

	@Override
	public JSONData login(HttpServletRequest request, String userName, String password) {
		// 调用交易所用户密码登录接口 start
		// 组装参数
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("account", userName);
		params.put("password", password);
		params.put("type", 4);// 登陆设备类别 1 PC，2 IOS，3 android ，4 atm
		Long time = System.currentTimeMillis();
		params.put("_dt", time);
		params.put("_s", getSignatureByexchange(params));
		Map<String, Object> headers = new HashMap<String, Object>();

		JSONData jsonData = doPost(appProperties.getBaseUrl() + "/login", params, headers);
		if (jsonData == null) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_EXCHANFE_ERROR.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_EXCHANFE_ERROR.getMsg()).build();
		} else if (!EnumResponseMsg.isSuccess(jsonData.getCode())) {
			return jsonData;
		}
		Map<String, ?> exResult = jsonData.getData();
		// 调用交易所用户密码登录接口 end

		// 检查当天的登录次数是否超过30次，从redis中获取次数
		String date = (String) request.getAttribute("date");
		String loginNum = stringRedisTemplate.opsForValue().get(date + exResult.get("userId"));
		if (!StringUtils.isEmpty(loginNum)) {
			Integer a = Integer.valueOf(loginNum);
			if (a > loginNumMax) {
				return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_LOGIN_OUT.getCode())
						.msg(EnumResponseMsg.RESP_ERROR_LOGIN_OUT.getMsg()).build();
			}
		}
		
		Long id = Long.parseLong(exResult.get("userId") + "");// 交易所用户id
		
		// 更新用户表数据 只有这里能拿到用户账号
		TbUserInfo tbUserInfo = userInfoService.selectByPrimaryKey(id);
		if (tbUserInfo == null) {
			tbUserInfo = new TbUserInfo();
			tbUserInfo.setId(id);
			tbUserInfo.setUserName(userName);
			tbUserInfo.setUpdateTime(new Date());
			userInfoService.save(tbUserInfo);// 新增
		} else {
			tbUserInfo.setUserName(userName);
			tbUserInfo.setUpdateTime(new Date());
			userInfoService.update(tbUserInfo);// 更新userinfo表
		}

		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(exResult).build();

	}

	@Override
	public JSONData loginCheck(HttpServletRequest request) {
		String googleCode = (String) request.getAttribute("googleCode");// 谷歌验验证码1
		String phoneCode = (String) request.getAttribute("phoneCode");// 手机验证码2
		String phoneToken = (String) request.getAttribute("phoneToken");// 手机token2
		String emailCode = (String) request.getAttribute("emailCode");// 邮箱验证码3
		String emailToken = (String) request.getAttribute("emailToken");// 邮箱token3
		String userId = (String) request.getAttribute("userId");// 用户id

		// 调用交易所登录校验接口 start
		// 组装参数
		Map<String, Object> params = new HashMap<String, Object>();
		if (!StringUtils.isEmpty(googleCode)) {
			params.put("googleCode", googleCode);
		}
		if (!StringUtils.isEmpty(phoneCode)) {
			params.put("phoneCode", phoneCode);
		}
		if (!StringUtils.isEmpty(phoneToken)) {
			params.put("phoneToken", phoneToken);
		}
		if (!StringUtils.isEmpty(emailCode)) {
			params.put("emailCode", emailCode);
		}
		if (!StringUtils.isEmpty(emailToken)) {
			params.put("emailToken", emailToken);
		}
		params.put("userId", Integer.parseInt(userId));
		Long time = System.currentTimeMillis();
		params.put("_dt", time);
		params.put("_s", getSignatureByexchange(params));
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("time", time);
		JSONData jsonData = doPost(appProperties.getBaseUrl() + "/loginCheckAuth", params, headers);
		if (jsonData == null) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_EXCHANFE_ERROR.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_EXCHANFE_ERROR.getMsg()).build();
		} else if (!EnumResponseMsg.isSuccess(jsonData.getCode())) {
			return jsonData;
		}
		Map<String, ?> exResult = jsonData.getData();
		// 调用交易所登录校验接口 end

		// 通用登录后处理
		return commonAfterLogin(request, exResult);
	}

	@Override
	public JSONData logout(String localToken, String exchangeToken) {
		boolean result = redisService.deleteToken(localToken);
		if (!result) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_LOGOUT.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_LOGOUT.getMsg()).build();
		}

		// 调用交易所退出登录接口 end
		// 组装参数
		Map<String, Object> params = new HashMap<String, Object>();
		Long time = System.currentTimeMillis();
		params.put("_dt", time);
		params.put("_s", getSignatureByexchange(params));
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("token", exchangeToken);
		headers.put("time", time);
		JSONData jsonData = doPost(appProperties.getBaseUrl() + "/logout", params, headers);
		if (jsonData == null) {
			log.info("调用交易所退出登录超时，但不影响终端退出");
		} else if (!EnumResponseMsg.isSuccess(jsonData.getCode())) {
			log.info("调用交易所退出登录失败,code=" + jsonData.getCode() + ",msg=" + jsonData.getMsg() + "，但不影响终端退出");
		}
		// 调用交易所退出登录接口 end

		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	@Override
	public JSONData getUserAccount(HttpServletRequest request, String exchangeToken, String currency) {
		// 调用交易所退出登录接口 start
		// 组装参数
		Map<String, Object> params = new HashMap<String, Object>();
		Long time = System.currentTimeMillis();
		params.put("_dt", time);
		params.put("_s", getSignatureByexchange(params));
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("time", time);
		headers.put("token", exchangeToken);
		JSONData jsonData = doPost(
				appProperties.getBaseUrl() + "/auth/atm/account/" + currency, params,
				headers);
		if (jsonData == null) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_EXCHANFE_ERROR.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_EXCHANFE_ERROR.getMsg()).build();
		} else if (!EnumResponseMsg.isSuccess(jsonData.getCode())) {
			return jsonData;
		}
		Map<String, ?> exResult = jsonData.getData();
		List<Map> exlist = (List<Map>) exResult.get("data");
		List<Map> accountList = new ArrayList<Map>();
		BigDecimal totalAmount = new BigDecimal("0");
		
		//查询参数管理中的数字货币币种
		TbSettingsExample tbSettingsExample = new TbSettingsExample();
		tbSettingsExample.createCriteria().andSettingsTypeEqualTo("2").andStatusEqualTo("0");//数字货币，启用
		List<TbSettings> TbSettingsList = tbSettingsService.selectByExample(tbSettingsExample);
		List list = new ArrayList<String>();
		for (TbSettings tbSettings : TbSettingsList) {
			list.add(tbSettings.getSettingsValue().toUpperCase());
		}
		if (!CollectionUtils.isEmpty(exlist)) {
			for (Map map : exlist) {
				if(!"1".equals(map.get("coinStatus")+"")){//只返回可取的币
					continue;
				}
				Map temp = new HashMap();
				String coinName = (String)map.get("coinName");
				temp.put("currencyCode", coinName);
				
				if(!list.contains(coinName.toUpperCase())){
					continue;
				}
				
				if (map.get("exchangeRate") != null) {
					temp.put("price", new BigDecimal((String) map.get("exchangeRate")).doubleValue());
					BigDecimal amount = new BigDecimal((String) map.get("exchangeRate"))
							.multiply(new BigDecimal((String) map.get("coinAvailable")));
					temp.put("amount", amount.doubleValue());
					totalAmount = totalAmount.add(amount);
				} else {
					temp.put("price", 0.00);
					temp.put("amount", 0.00);
				}
				temp.put("num",new BigDecimal ((String) map.get("coinAvailable")).doubleValue());
				temp.put("coinId", map.get("coinId"));
				temp.put("coinStatus", map.get("coinStatus"));// 币状态 0-停用，1-启用
				temp.put("toUsdt",new BigDecimal((String)map.get("toUsdt")));
				accountList.add(temp);
			}
		}
		// 调用交易所退出登录接口 end

		// 添加本地资产流水记录
//		String localToken = (String) request.getAttribute(AtmConstant.LOCAL_TOKEN);
//		UserInfo userInfo = (UserInfo) request.getAttribute(AtmConstant.USER);
//		for (Map map : accountList) {
//			TbUserAccount tbUserAccount = new TbUserAccount();
//			tbUserAccount.setUserId(userInfo.getId());
//			tbUserAccount.setUserToken(exchangeToken);
//			tbUserAccount.setUserLocalToken(localToken);
//			tbUserAccount.setCurrencyCode((String) map.get("currencyCode"));
//			tbUserAccount.setCurrencyMoney(new BigDecimal((double) map.get("num")));
//			tbUserAccount.setCreateTime(new Date());
//			tbUserAccountService.save(tbUserAccount);
//		}

		Map result = new HashMap<String, String>();
		result.put("list", getSortAccountList(accountList));
		result.put("totalAmount", totalAmount.doubleValue());

		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(result).build();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getSortAccountList(List accountList){
		Collections.sort(accountList, new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				Map map1 = (Map)o1;
				Map map2 = (Map)o2;
				Double amount1 = (Double)map1.get("amount");
				Double amount2 = (Double)map2.get("amount");
				Double d = amount2-amount1;
				if(d>0){
					return 1;
				}else if(d==0){
					return 0;
				}else{
					return -1;
				}
			}
		});
		
		
		return accountList;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public JSONData drawMoney(HttpServletRequest request, String deductCurrency, String drawCurrency, double drawMoney) {
		String equipmentId = (String) request.getAttribute("termNo");//设备编号
		String captcha = (String)request.getAttribute("captcha");//防重码

		//防重码校验
		log.info("开始防重复校验");
		JSONData captchaJsonData = checkCaptcha(request, equipmentId, captcha);
		if(!EnumResponseMsg.isSuccess(captchaJsonData.getCode())){
			return captchaJsonData;
		}
		log.info("结束防重复校验");

		// 记录交易表tb_trans，在此处记录流水，避免对账时，出现过多因为限额问题导致的atm有失败记录，但本地没有
		String equipmentLogSeq = (String) request.getAttribute("termSeq");
		String termDate = (String) request.getAttribute("termDate");// 交易日期yyyy-MM-dd
		String password = (String) request.getAttribute("password");// 交易所交易密码,经过md5加密
		// String transFee = (String)request.getAttribute("transFee");//手续费
		UserInfo userInfo = (UserInfo) request.getAttribute(AtmConstant.USER);
		String localToken = (String) request.getAttribute(AtmConstant.LOCAL_TOKEN);
		String exchangeToken = (String) request.getAttribute(AtmConstant.EXCHANGE_TOKEN);
		String toUsdt = (String)request.getAttribute("toUsdt");//获取资产列表返回，原样返回
		String priceStr = (String) request.getAttribute("price");// 取款币种/扣款币种 汇率
		String drawMoneystr = (String) request.getAttribute("drawMoney");// 取款金额
		String coinIdStr = (String) request.getAttribute("coinId");// 扣款币种id
		Long coinId = Long.parseLong(coinIdStr);
		double deductMoney = getDeductMoney(priceStr, drawMoneystr);// 扣款币种金额
		TbArea area = tbAreaService.findWithdrawsum(equipmentId);
		double rate = area.getServiceCharge().doubleValue();// 根据设备对应的国家，查询出手续费
		log.info("手续费率："+rate);
		double transFee = deductMoney * rate;// 扣款币种手续费



		String timestamp = iDUtil.getTimestamp();
		TbTrans tbTrans = new TbTrans();
		tbTrans.setId(timestamp);//代码生成的id
		tbTrans.setEquipmentId(equipmentId);
		tbTrans.setEquipmentLogSeq(equipmentLogSeq);
		tbTrans.setTermDate(CalendarUtil.toDate(termDate, CalendarUtil.DATE_FMT_3));// 终端交易日期
		tbTrans.setTransFee(new BigDecimal(transFee));// 扣款币种手续费
		tbTrans.setDeductMoney(new BigDecimal(deductMoney).setScale(13,BigDecimal.ROUND_HALF_UP).add(new BigDecimal(transFee).setScale(13,BigDecimal.ROUND_HALF_UP)));// 扣款币种总金额，含手续费
		tbTrans.setUserId(userInfo.getId());
		tbTrans.setUserToken(exchangeToken);
		tbTrans.setUserLocalToken(localToken);
		tbTrans.setInterfaceCode("/api/auth/drawMoney");
		tbTrans.setInterfaceType("0");// 0-正常交易 1-反向交易
		tbTrans.setDeductCurrency(deductCurrency);
		tbTrans.setWithdrawCurrency(drawCurrency);
		tbTrans.setWithdrawMoney(new BigDecimal(drawMoney));
		tbTrans.setStatus(TransStatusEnum.INITIAL.getStatus());
		tbTrans.setTransTime(new Date());
		tbTrans.setPrice(new BigDecimal(priceStr));//扣款币种相对于取款币种的价格
		tbTrans.setcCheckStatus("0");//与c端交易流水的对账状态（0未对账，1已对账)
		tbTrans.setExCheckStatus("0");//与交易所的交易流水对账状态（0未对账，1已对账)
		tbTransService.save(tbTrans);

		Date now = new Date();
		String nowStr = CalendarUtil.toString(now, CalendarUtil.DATE_FMT_3);

		//查询是否已经超过当天设备取款限额
		Map tbParams = new HashMap();
		tbParams.put("termNo", equipmentId);
		tbParams.put("transTime", CalendarUtil.toDate(nowStr +" 00:00:00", CalendarUtil.DATE_FMT_6));
		tbParams.put("transTimeEnd", CalendarUtil.toDate(nowStr +" 23:59:59", CalendarUtil.DATE_FMT_6));
		BigDecimal totalAmount = tbTransService.getTransAmountByIdAndDate(tbParams);//已成功取款金额
		TbEquipmentSettings tbEquipmentSettings = (TbEquipmentSettings)request.getAttribute(AtmConstant.EQUIPMENT_SETTINGS);
		if(totalAmount==null){
			totalAmount = new BigDecimal("0");
		}
		log.info("当日该设备"+equipmentId+"已取资金："+totalAmount+" "+drawCurrency);
		if(totalAmount.add(new BigDecimal(drawMoneystr)).compareTo(tbEquipmentSettings.getLimitPerDay())>0){
			//更新交易表
			tbTrans.setRespCode(EnumResponseMsg.RESP_ERROR_EXCEED_EQUIPMENT_DAY_LIMIT_.getCode());
			tbTrans.setRespMsg(EnumResponseMsg.RESP_ERROR_EXCEED_EQUIPMENT_DAY_LIMIT_.getMsg());
			tbTrans.setStatus(TransStatusEnum.FAIL.getStatus());// 根据响应码，写上对应的状态成功改为吐钞中，失败改为失败，超时改为超时
			tbTrans.setUpdateTime(new Date());
			tbTransService.update(tbTrans);
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_EXCEED_EQUIPMENT_DAY_LIMIT_.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_EXCEED_EQUIPMENT_DAY_LIMIT_.getMsg()).build();
		}

		//查询是否已经超过账户每日取款限额
		UserInfo attribute = (UserInfo) request.getAttribute(AtmConstant.USER);
			//查询机器所在地区用户每日限额
		BigDecimal withdrawDayOfArea = area.getWithdrawSum();
		if(withdrawDayOfArea==null){
			withdrawDayOfArea = new BigDecimal("0");
		}
		log.info(area.getAreaName()+"地区用户每日限额："+area.getWithdrawSum());
		BigDecimal drawMoneyNow = new BigDecimal(drawMoneystr);
			//查询该用户当天累积取款金额
		Map map = new HashMap();
		map.put("userId", attribute.getId());
		map.put("transTime", CalendarUtil.toDate(nowStr +" 00:00:00", CalendarUtil.DATE_FMT_6));
		map.put("transTimeEnd", CalendarUtil.toDate(nowStr +" 23:59:59", CalendarUtil.DATE_FMT_6));
		BigDecimal withdrawSumToday = tbTransService.findWithdrawsum(map);
		if(withdrawSumToday==null){
			withdrawSumToday=new BigDecimal("0");
		}
		log.info("用户"+attribute.getId()+"当天已取金额"+withdrawSumToday);
		BigDecimal availableAmt = withdrawDayOfArea.subtract(withdrawSumToday);
			//判断本次要取金额和今日已取金额之和是否超过了每日限额
		BigDecimal temp = withdrawSumToday.add(drawMoneyNow);
		if(temp.compareTo(withdrawDayOfArea) > 0){
			//更新交易表
			tbTrans.setRespCode(EnumResponseMsg.RESP_ERROR_ACCOUNT_WITHDRAWSUM.getCode());
			String msg = "本账户今日还可取"+availableAmt.intValue()+" "+drawCurrency+"|Dear users, your account can withdraw "+availableAmt.intValue()+" "+drawCurrency+" today";
			tbTrans.setRespMsg(msg);
			tbTrans.setStatus(TransStatusEnum.FAIL.getStatus());// 根据响应码，写上对应的状态成功改为吐钞中，失败改为失败，超时改为超时
			tbTrans.setUpdateTime(new Date());
			tbTransService.update(tbTrans);
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_ACCOUNT_WITHDRAWSUM.getCode())
					.msg(msg).build();
		}

		// 调用交易所扣款接口 start
		// 组装参数：扣款币种，手续费率，取款币种，取款金额，我们的交易流水
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("capitalPwd", password);// 经过md5加密的密码
		params.put("atmWater", tbTrans.getId() + "");// 交易流水
		params.put("atmNum", equipmentId);// atm编号
		params.put("coinId", coinId);// long 扣款币种
		params.put("draw", new BigDecimal(deductMoney).setScale(13,BigDecimal.ROUND_HALF_UP));// BigDecimal 扣币数量（不含手续费）
		params.put("drawMoney", new BigDecimal(drawMoneystr));//取款金额
		params.put("fee", new BigDecimal(transFee).setScale(13,BigDecimal.ROUND_HALF_UP));// BigDecimal 手续费
		params.put("exchangeRate", new BigDecimal(priceStr));// BigDecimal 汇率值
		params.put("type", drawCurrency);//  汇率币种  CNY， USD
		params.put("feeRate", area.getServiceCharge());//手续费比例
		params.put("toUsdt", new BigDecimal(toUsdt));//	usdt兑换比例
		Long time = System.currentTimeMillis();
		params.put("_dt", time);
		params.put("_s", getSignatureByexchange(params));
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("time", time);
		headers.put("token", exchangeToken);
		JSONData jsonData = doPost(appProperties.getBaseUrl() + "/auth/atm/withdraw", params, headers);
		// 调用交易所扣款接口 end

		// 根据交易所返回情况，更改正向交易状态
		String status = TransStatusEnum.INITIAL.getStatus();
		if (jsonData == null) {// 超时
			status = TransStatusEnum.TIMEOUT.getStatus();
			tbTrans.setStatus(status);// 根据响应码，写上对应的状态成功改为吐钞中，失败改为失败，超时改为超时
			tbTrans.setUpdateTime(new Date());
			tbTrans.setRespCode(EnumResponseMsg.RESP_ERROR_EXCHANFE_ERROR.getCode());
			tbTrans.setRespMsg(EnumResponseMsg.RESP_ERROR_EXCHANFE_ERROR.getMsg());
			tbTransService.update(tbTrans);
		} else if (EnumResponseMsg.isSuccess(jsonData.getCode())) {
			Map<String, ?> exResult = jsonData.getData();
			String exTransSeq = "";
			Long exTransTime = 0l;
			if (exResult != null) {
				exTransSeq = exResult.get("drawWater") + "";
				exTransTime = (Long)exResult.get("ts");
			}
			status = TransStatusEnum.SPITMONEY.getStatus();
			tbTrans.setRespCode(jsonData.getCode());
			tbTrans.setRespMsg(jsonData.getMsg());
			tbTrans.setStatus(status);// 根据响应码，写上对应的状态成功改为吐钞中，失败改为失败，超时改为超时
			tbTrans.setUpdateTime(new Date());
			tbTrans.setExTransSeq(exTransSeq);// 记录交易所交易流水
			tbTrans.setExTransTime(exTransTime);// 记录交易所交易时间
			tbTransService.update(tbTrans);
		} else {// 失败
			Map<String, ?> exResult = jsonData.getData();
			String exTransSeq = "";
			Long exTransTime = 0l;
			if (exResult != null) {
				exTransSeq = exResult.get("drawWater") + "";
				exTransTime = (Long)exResult.get("ts");
			}
			status = TransStatusEnum.FAIL.getStatus();
			tbTrans.setRespCode(jsonData.getCode());
			tbTrans.setRespMsg(jsonData.getMsg());
			tbTrans.setStatus(status);// 根据响应码，写上对应的状态成功改为吐钞中，失败改为失败，超时改为超时
			tbTrans.setUpdateTime(new Date());
			tbTrans.setExTransSeq(exTransSeq);// 记录交易所交易流水
			tbTrans.setExTransTime(exTransTime);// 记录交易所交易时间
			tbTransService.update(tbTrans);
		}

		// 如果超时，要发起冲正
		if (TransStatusEnum.TIMEOUT.getStatus().equals(status)) {
			JSONData cojsonData = transCorrect(request, tbTrans.getId());
			if (EnumResponseMsg.isSuccess(cojsonData.getCode())) {
				return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_CORRECTION_OK.getCode())
						.msg(EnumResponseMsg.RESP_ERROR_CORRECTION_OK.getMsg()).build();
			} else {
				return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_CORRECTION_ERR.getCode())
						.msg(EnumResponseMsg.RESP_ERROR_CORRECTION_ERR.getMsg()).build();
			}
		} else {
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("transSeqNo", tbTrans.getId());
			jsonData.setData(result);
			return jsonData;
		}
	}

	/**
	 * transId：P端流水
	 */
	@Override
	public JSONData transCorrect(HttpServletRequest request, String transId) {
		String equipmentId = (String) request.getAttribute("termNo");
		// 在redis中保存数据，时间1分钟，用来防止重复冲正
		String ckey = transId + equipmentId +"correct";
		String status = stringRedisTemplate.opsForValue().get(ckey);
		if (!StringUtils.isEmpty(status)) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_CORRECTION_RUNNING.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_CORRECTION_RUNNING.getMsg()).build();
		}
		stringRedisTemplate.opsForValue().set(ckey, "1", 60, TimeUnit.SECONDS);
		try {
			// 首先判读交易状态是否可以冲正（如果是成功，失败以及已冲正，则不能再次冲正）
			UserInfo userInfo = (UserInfo) request.getAttribute(AtmConstant.USER);
			String localToken = (String) request.getAttribute(AtmConstant.LOCAL_TOKEN);
			String exchangeToken = (String) request.getAttribute(AtmConstant.EXCHANGE_TOKEN);
			TbTransExample example = new TbTransExample();
			example.createCriteria().andIdEqualTo(transId).andUserIdEqualTo(userInfo.getId());
			List<TbTrans> list = tbTransService.selectByExample(example);
			if (list == null || list.size() == 0) {
				return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_ORITRANS_NOT_FOUND.getCode())
						.msg(EnumResponseMsg.RESP_ERROR_ORITRANS_NOT_FOUND.getMsg()).build();
			}

			TbTrans oriTrans = list.get(0);
			String oriStatus = oriTrans.getStatus();
			if (TransStatusEnum.SUCCESS.getStatus().equals(oriStatus)
					|| TransStatusEnum.FAIL.getStatus().equals(oriStatus)
					|| TransStatusEnum.CORRECTION.getStatus().equals(oriStatus)) {

				return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_CORRECTION_STATUS_ERR.getCode())
						.msg(EnumResponseMsg.RESP_ERROR_CORRECTION_STATUS_ERR.getMsg()).build();
			}

			// 记录交易日志表（冲正记录）
			String timestamp = iDUtil.getTimestamp();
			String termDate = (String) request.getAttribute("termDate");// 交易日期yyyy-MM-dd
			String equipmentLogSeq = (String) request.getAttribute("termSeq");
			TbTrans tbTrans = new TbTrans();
			tbTrans.setId(timestamp);
			tbTrans.setEquipmentId(equipmentId);
			tbTrans.setEquipmentLogSeq(equipmentLogSeq);
			tbTrans.setTermDate(CalendarUtil.toDate(termDate, CalendarUtil.DATE_FMT_3));// 终端交易日期
			tbTrans.setOriId(oriTrans.getId());
			tbTrans.setUserId(userInfo.getId());
			tbTrans.setUserToken(exchangeToken);
			tbTrans.setUserLocalToken(localToken);
			tbTrans.setInterfaceCode("/api/auth/transCorrect");
			tbTrans.setInterfaceType("1");// 0-正常交易 1-反向交易
			tbTrans.setDeductCurrency(oriTrans.getDeductCurrency());
			tbTrans.setDeductMoney(oriTrans.getDeductMoney());
			tbTrans.setWithdrawCurrency(oriTrans.getWithdrawCurrency());
			tbTrans.setWithdrawMoney(oriTrans.getWithdrawMoney());
			tbTrans.setStatus(TransStatusEnum.INITIAL.getStatus());// 初始状态
			tbTrans.setPrice(oriTrans.getPrice());
			tbTrans.setcCheckStatus("0");//与c端交易流水的对账状态（0未对账，1已对账) 无需对账
			tbTrans.setExCheckStatus("0");//与交易所的交易流水对账状态（0未对账，1已对账) 无需对账
			tbTrans.setTransTime(new Date());
			tbTransService.save(tbTrans);

			// 调用交易所冲正接口 start
			// 组装参数,token，P端交易流水
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("atmWater", transId + "");// p端交易流水
			params.put("atmNum", equipmentId);// atm设备编号
			Long time = System.currentTimeMillis();
			params.put("_dt", time);
			params.put("_s", getSignatureByexchange(params));
			Map<String, Object> headers = new HashMap<String, Object>();
			headers.put("time", time);
			headers.put("token", exchangeToken);
			JSONData jsonData = doPost(appProperties.getBaseUrl() + "/auth/atm/reverse", params, headers);
			// 调用交易所冲正接口 end

			if (jsonData == null) {
				// 冲正交易
				tbTrans.setStatus(TransStatusEnum.TIMEOUT.getStatus());// 冲正交易-超时
				tbTrans.setUpdateTime(new Date());
				tbTrans.setRespCode(EnumResponseMsg.RESP_ERROR_EXCHANFE_ERROR.getCode());
				tbTrans.setRespMsg(EnumResponseMsg.RESP_ERROR_EXCHANFE_ERROR.getMsg());
				tbTransService.update(tbTrans);
				// 原交易
				oriTrans.setStatus(TransStatusEnum.CORRECTION_E.getStatus());// 原交易-冲正异常
				oriTrans.setUpdateTime(new Date());
				tbTransService.update(oriTrans);
				// 返回
				return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_EXCHANFE_ERROR.getCode())
						.msg(EnumResponseMsg.RESP_ERROR_EXCHANFE_ERROR.getMsg()).build();
			} else if (EnumResponseMsg.isSuccess(jsonData.getCode())) {
				Map<String, ?> exResult = jsonData.getData();
				String exTransSeq = "";
				Long exTransTime = 0l;
				if (exResult != null) {
					exTransSeq = exResult.get("drawWater") + "";
					exTransTime = (Long)exResult.get("ts");
				}
				// 修改冲正交易
				tbTrans.setRespCode(jsonData.getCode());
				tbTrans.setRespMsg(jsonData.getMsg());
				tbTrans.setStatus(TransStatusEnum.SUCCESS.getStatus());// 冲正交易-成功
				tbTrans.setUpdateTime(new Date());
				tbTrans.setExTransSeq(exTransSeq);
				tbTrans.setExTransTime(exTransTime);
				tbTransService.update(tbTrans);
				// 修改原交易为成功
				oriTrans.setStatus(TransStatusEnum.CORRECTION.getStatus());// 原交易-已冲正
				oriTrans.setUpdateTime(new Date());
				tbTransService.update(oriTrans);
				// 返回
				return jsonData;
			} else {
				Map<String, ?> exResult = jsonData.getData();
				String exTransSeq = "";
				Long exTransTime = 0l;
				if (exResult != null) {
					exTransSeq = exResult.get("drawWater") + "";
					exTransTime = (Long)exResult.get("ts");
				}
				// 修改冲正交易
				tbTrans.setRespCode(jsonData.getCode());
				tbTrans.setRespMsg(jsonData.getMsg());
				tbTrans.setStatus(TransStatusEnum.FAIL.getStatus());// 冲正交易-失败
				tbTrans.setUpdateTime(new Date());
				tbTrans.setExTransSeq(exTransSeq);
				tbTrans.setExTransTime(exTransTime);
				tbTransService.update(tbTrans);
				// 原交易
				oriTrans.setStatus(TransStatusEnum.CORRECTION_E.getStatus());// 原交易-冲正异常
				oriTrans.setUpdateTime(new Date());
				tbTransService.update(oriTrans);
				// 返回
				return jsonData;
			}

		} catch (Exception e) {
			throw e;
		} finally {
			stringRedisTemplate.delete(ckey);
		}
	}

	/**
	 * 生成Token
	 * <p>
	 * 生成策略暂时使用UUID
	 * </p>
	 *
	 * @return
	 */
	private static String generateToken() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * 调用http请求交易所(请求体使用json格式)
	 * 
	 * @param url
	 * @param params
	 * @param headers
	 * @return JSONData
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", })
	public JSONData doPost(String url, Map<String, Object> params, Map<String, Object> headers) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		RequestConfig config = RequestConfig.custom().
				setConnectionRequestTimeout(5000).//connection超时时间
				setSocketTimeout(20000).//获取数据超时时间
				setConnectTimeout(10000).build();//连接超时时间
		HttpPost post = new HttpPost(url);
		post.setConfig(config);
		// 使用addHeader方法添加请求头部,诸如User-Agent, Accept-Encoding等参数.
		post.setHeader("Content-Type", "application/json;charset=UTF-8");

		// List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
		//
		// for(Entry<String,String> entry :params.entrySet() ){
		// BasicNameValuePair basicNameValuePair = new
		// BasicNameValuePair(entry.getKey(), entry.getValue());
		// list.add(basicNameValuePair);
		// }
		String string = "";
		try {
			// 设置请求头部参数
			for (Entry<String, Object> entry : headers.entrySet()) {
				post.setHeader(entry.getKey(), entry.getValue() + "");
			}
			// 设置 参数
			// 组织数据
			StringEntity entity = new StringEntity(JSONObject.toJSONString(params));
			// 设置编码格式
			entity.setContentEncoding("utf-8");
			// 设置数据类型
			entity.setContentType("application/json");
			post.setEntity(entity);
			log.info("调用交易所接口"+url);
			log.info("入参："+params);
			CloseableHttpResponse response = httpClient.execute(post);
			string = EntityUtils.toString(response.getEntity());
			log.info("respnse信息为:"+response.toString());
			log.info("出参："+string);
			// 将string转成map
			Map result = JSONObject.parseObject(string);
			if (result == null) {
				return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getCode())
						.msg(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getMsg()).build();
			}
			if (("true").equals(result.get("success") + "")) {
				return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
						.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data((Map) result.get("body")).build();
			}

			if ("E001".equals(result.get("errCode") + "")) {// 交易所请求子服务超时
				return null;
			}

			if (!StringUtils.isEmpty(result.get("errCode"))) {
				if("E0024".equals(result.get("errCode") + "")){
					return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_VERIFICATION_ERROR.getCode()).
							msg(EnumResponseMsg.RESP_ERROR_VERIFICATION_ERROR.getMsg()).build();
				}else if("E0003".equals(result.get("errCode") + "")){
					return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_ACCOUNT_NOT_EXIST.getCode()).
							msg(EnumResponseMsg.RESP_ERROR_ACCOUNT_NOT_EXIST.getMsg()).build();
				}
				String msg = (String) result.get("errMsg");
				if(!StringUtils.isEmpty(msg) && msg.length()>150){
					msg = msg.substring(0,150);
				}
				return JSONData.builder().code(result.get("errCode") + "").msg(msg).build();
			} else if (!StringUtils.isEmpty(result.get("status"))) {
				String msg = (String) result.get("error");
				if(!StringUtils.isEmpty(msg) && msg.length()>150){
					msg = msg.substring(0,150);
				}
				return JSONData.builder().code(result.get("status") + "").msg(msg).build();
			} else {
				return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getCode())
						.msg(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getMsg()).build();
			}

		} catch (Exception e) {
			log.error(LogUtils.getExceptionInfo(e));
			return null;
		}
	}

	public static void main(String[] args) {
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("account", "yyy");
//		params.put("captcha", "38028");
//		params.put("password", "e9bc0e13a8a16cbb07b175d92a113126");
//		params.put("type", "1");
//		params.put("token",
//				"1F55D406DEFF56D2D3F1826F8BCD8A4D7B366109A6B7813B027CBF3084EEFE88C40AD03A9C5571E1F72A0881F05E501E");
//		params.put("_dt", "1534838117598");
//		System.out.println(getSignatureByexchange(params));
//		String[] str = ("HAYEK00000037|e760a6577e1848d195144e105dceb779|1".split("\\|"));
//		for(int i=0;i<str.length;i++){
//			System.out.println(str[i]);
//		}
		String msg = "234324324";
		System.out.println(msg.substring(0,5));

	}

	public static String getSignatureByexchange(Map<String, Object> reqParam) {
		// 验签
		if (!CollectionUtils.isEmpty(reqParam)) {
			Object[] pks = reqParam.keySet().toArray();
			Arrays.sort(pks);
			StringBuilder s = new StringBuilder();
			for (int i = 0; i < pks.length; i++) {
				String key = (String) pks[i];
				if ("_s".equals(key)) {
					continue;
				}
				s.append(key).append("=").append(reqParam.get(key) == null ? "null" : reqParam.get(key));
			}
			String sign = null;
			try {
				System.out.println("待签名字符串" + s.toString());
				sign = MD5Util.getMD5Code(s.toString()) + reqParam.get("_dt");
				System.out.println("签名值" + sign);
			} catch (Exception e) {
				log.info("加签名失败" + LogUtils.getExceptionInfo(e));
				return "";
			}
			return sign;
		}
		return "";
	}

	@Override
	public JSONData getTransFee(String deductAndPrice, String drawMoneystr, String equipmentId) {
		//解析deductAndPrice，拿到扣款币种和价格对(扣款币种1,价格1;扣款币种 2,价格2)
		String[] deductAndPricePair = deductAndPrice.split(";");
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for(String str : deductAndPricePair){
			String[] pair = str.split(",");
			// 计算扣款币种金额，不含手续费
			double deductMoney = getDeductMoney(pair[1], drawMoneystr);
			//计算手续费
			double transFee = getTransFeeOnly(deductMoney, pair[0], equipmentId);
			Map<String, Object> transFeeMap = new HashMap<String, Object>();
			transFeeMap.put("deductCurrency", pair[0]);
			transFeeMap.put("transFee", transFee);// 手续费（仅供参考）
			list.add(transFeeMap);
		}
		
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("list", list);
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(result).build();
	}

	/**
	 * 计算扣款币种金额，不含手续费
	 * 
	 * @param priceStr
	 * @param drawMoneystr
	 * @return
	 */
	public double getDeductMoney(String priceStr, String drawMoneystr) {
		// 查询数据库费率，
		double price = Double.valueOf(priceStr);// 每一个扣款币种对应的取款币种的金额
		double drawMoney = Double.valueOf(drawMoneystr);// 取款金额
		double deductMoney = drawMoney / price;// 扣款币种对应的数量或者金额(取款金额除以价格)
		return deductMoney;
	}

	/**
	 * 根据扣款币种金额，扣款币种，计算扣款币种手续费
	 * 
	 * @param deductMoney
	 * @param equipmentId
	 * @return
	 */
	public double getTransFeeOnly(double deductMoney, String deductCurrency, String equipmentId) {
		// 查询数据库费率，计算手续费
		TbEquipment tbEquipment = tbEquipmentService.selectByKey(equipmentId);
		TbArea area = tbAreaService.selectById(tbEquipment.getCountryId());
		double rate = area.getServiceCharge().doubleValue();// 根据设备对应的国家，查询出手续费
		log.info("手续费率："+rate);
		double transFee = deductMoney * rate;
		return transFee;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public JSONData spitMoneyResult(String id, String amount, String language, String extoken, TbTrans tbTrans, String spitMoneyStatus) {
		// 调用交易所获取二维码接口 start
		// 组装参数
		Map<String, Object> params = new HashMap();

		Map<String, Object> headers = new HashMap();
		params.put("atmNum", id);// 设备编号
		params.put("atmWater", tbTrans.getId());//P端交易流水号
		
		params.put("money", amount);
		params.put("country", language);
		params.put("date", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+" UTC");
		String status = "";
		if(spitMoneyStatus.equals("0")){//成功
			status = "1";//成功
		}else if(spitMoneyStatus.equals("1")){//失败
			status = "2";//失败
		}else if(!spitMoneyStatus.equals("2") && !spitMoneyStatus.equals("1") && !!spitMoneyStatus.equals("0")){
			status = "4";//未知
		}
		params.put("status", status);
		Long time = System.currentTimeMillis();
		params.put("_dt", time);
		params.put("_s", getSignatureByexchange(params));

		headers.put("time", time);
		headers.put("token", extoken);

		JSONData jsonData = doPost(appProperties.getBaseUrl() + "/auth/atm/drawTip", params, headers);

		if (jsonData == null) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_EXCHANFE_ERROR.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_EXCHANFE_ERROR.getMsg()).build();
		} else if (!EnumResponseMsg.isSuccess(jsonData.getCode())) {
			return jsonData;
		}

		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
	}

	@Override
	public JSONData checkTrans(HttpServletRequest request) {
		String termNo = (String)request.getAttribute(AtmConstant.TERMNO);
		String batchNo = (String)request.getAttribute("batchNo");//对账批次号
		String currencyCode = (String)request.getAttribute("currencyCode");//钞箱币种
		log.info("对账批次号："+ batchNo+ "，P端与atm对账开始");
		checkDataWithC(request);
		log.info("对账批次号："+ batchNo+ "，P端与atm对账结束");
		//开启新的线程，调用交易所接口，找到交易所对应的交易明细记录，下载到本服务器并进行解析。
		new Thread(new Runnable() {
			@Override
			public void run() {
				try{
					log.info("新开线程，跟交易所进行对账");
					checkDataWithEx(batchNo, termNo, currencyCode);
				}catch (Exception e){
					log.info("对账批次号："+ batchNo+ "，与交易所对账失败");
					log.info(LogUtils.getExceptionInfo(e));
				}

			}
		}).start();

		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
	}

	@Transactional
	public void checkDataWithC(HttpServletRequest request){
		String termNo = (String)request.getAttribute(AtmConstant.TERMNO);
		String batchNo = (String)request.getAttribute("batchNo");//对账批次号
		String currencyCode = (String)request.getAttribute("currencyCode");//钞箱币种
		String AddAmt = (String)request.getAttribute("AddAmt");//加钞总金额
		String balanceAmt = (String)request.getAttribute("balanceAmt");//剩余总金额
		String drawBalanceAmt = (String)request.getAttribute("drawBalanceAmt");//取款箱剩余总金额
		String depositBalanceAmt = (String)request.getAttribute("depositBalanceAmt");//存款箱剩余总金额
		String drawSucNum = (String)request.getAttribute("drawSucNum");//取款成功笔数
		BigDecimal drawSucAmt = new BigDecimal((String)request.getAttribute("drawSucAmt"));//取款成功金额
		String drawFailNum = (String)request.getAttribute("drawFailNum");//取款失败笔数
		BigDecimal drawFailAmt = new BigDecimal((String)request.getAttribute("drawFailAmt"));//取款失败金额
		String drawUnkNum = (String)request.getAttribute("drawUnkNum");//取款疑问笔数
		BigDecimal drawUnkAmt = new BigDecimal((String)request.getAttribute("drawUnkAmt"));//取款疑问金额
		String drawRevNum = (String)request.getAttribute("drawRevNum");//取款冲正笔数
		BigDecimal drawRevAmt = new BigDecimal((String)request.getAttribute("drawRevAmt"));//取款冲正金额
		String depositSucNum = (String)request.getAttribute("depositSucNum");//存款成功笔数
		String depositSucAmt = (String)request.getAttribute("depositSucAmt");//存款成功金额
		String depositFailNum = (String)request.getAttribute("depositFailNum");//存款失败笔数
		String depositFailAmt = (String)request.getAttribute("depositFailAmt");//存款失败金额
		String depositUnkNum = (String)request.getAttribute("depositUnkNum");//存款疑问笔数
		String depositUnkAmt = (String)request.getAttribute("depositUnkAmt");//存款疑问金额
		List<Map> drawUnkList = (List<Map>)request.getAttribute("drawUnkList");//取款疑问交易明细

		//根据条件（设备编号,终端未对账，取款接口）对本地交易进行汇总
		Map<String,Object> localDrawCheckResult = tbTransService.getDrawCheckTransData(termNo);
		log.info("对账批次号："+ batchNo+ "，本地汇总"+localDrawCheckResult+"，设备编号"+termNo);

		//本地细分汇总的数据和atm传过来的数据作比较，将结果记录到对账结果表中。
		BigDecimal sucNum = (BigDecimal)localDrawCheckResult.get("sucNum");//本地成功笔数
		BigDecimal sucAmt = (BigDecimal)localDrawCheckResult.get("sucAmt");//本地成功金额
		BigDecimal failNum = (BigDecimal)localDrawCheckResult.get("failNum");//本地失败笔数
		BigDecimal failAmt = (BigDecimal)localDrawCheckResult.get("failAmt");//本地失败金额
		BigDecimal revNum = (BigDecimal)localDrawCheckResult.get("revNum");//本地冲正笔数
		BigDecimal revAmt = (BigDecimal)localDrawCheckResult.get("revAmt");//本地冲正金额
		BigDecimal unkNum = (BigDecimal)localDrawCheckResult.get("unkNum");//本地未知笔数
		BigDecimal unkAmt = (BigDecimal)localDrawCheckResult.get("unkAmt");//本地未知金额

		Date now = new Date();
		//将atm的汇总数据存入到终端对账汇总表tb_check_c_count中
		TbCheckCCount tbCheckPCount = new TbCheckCCount();
		tbCheckPCount.setEquipmentId(termNo);
		tbCheckPCount.setCheckBatchNo(batchNo);
		tbCheckPCount.setSuccessNum(sucNum.intValue());
		tbCheckPCount.setSuccessAmt(sucAmt);
		tbCheckPCount.setErrNum(failNum.intValue());
		tbCheckPCount.setErrAmt(failAmt);
		tbCheckPCount.setCorrectNum(revNum.intValue());
		tbCheckPCount.setCorrectAmt(revAmt);
		tbCheckPCount.setUnknownNum(unkNum.intValue());
		tbCheckPCount.setUnknownAmt(unkAmt);
		tbCheckPCount.setCreateTime(now);
		tbCheckPCount.setUpdateTime(now);
		tbCheckPCount.setType("1");//0-c端 1-P端 2-交易所
		tbCheckCCountService.insert(tbCheckPCount);

		//将atm的汇总数据存入到终端对账汇总表tb_check_c_count中
		TbCheckCCount tbCheckCCount = new TbCheckCCount();
		tbCheckCCount.setEquipmentId(termNo);
		tbCheckCCount.setCheckBatchNo(batchNo);
		tbCheckCCount.setSuccessNum(Integer.parseInt(drawSucNum));
		tbCheckCCount.setSuccessAmt(drawSucAmt);
		tbCheckCCount.setErrNum(Integer.parseInt(drawFailNum));
		tbCheckCCount.setErrAmt(drawFailAmt);
		tbCheckCCount.setCorrectNum(Integer.parseInt(drawRevNum));
		tbCheckCCount.setCorrectAmt(drawRevAmt);
		tbCheckCCount.setUnknownNum(Integer.parseInt(drawUnkNum));
		tbCheckCCount.setUnknownAmt(drawUnkAmt);
		tbCheckCCount.setCreateTime(now);
		tbCheckCCount.setUpdateTime(now);
		tbCheckCCount.setType("0");//0-c端 1-P端 2-交易所
		tbCheckCCountService.insert(tbCheckCCount);

		log.info("对账批次号："+ batchNo+ "，开始本地与atm进行金额比对");
		BigDecimal localTotal = sucAmt.add(failAmt).add(revAmt).add(unkAmt);
		BigDecimal atmTotal = drawSucAmt.add(drawFailAmt).add(drawUnkAmt).add(drawRevAmt);
		//统计总交易额,取最大的金额
		BigDecimal totalAmt = localTotal.compareTo(atmTotal)>=0?localTotal:atmTotal;

		//统计平账金额，相同状态最小的金额相加
		BigDecimal sameAmt = new BigDecimal("0");//平账金额
		BigDecimal diffAmt = new BigDecimal("0");//差错金额
		if(sucAmt.compareTo(drawSucAmt)>=0){//如果本地成功金额大于atm成功金额
			sameAmt = sameAmt.add(drawSucAmt);
		}else{
			sameAmt = sameAmt.add(sucAmt);
		}

		if(failAmt.compareTo(drawFailAmt)>=0){//如果本地失败的金额大于atm失败金额
			sameAmt = sameAmt.add(drawFailAmt);
		}else{
			sameAmt = sameAmt.add(failAmt);
		}

		if(revAmt.compareTo(drawRevAmt)>=0){//如果本地冲正的金额大于atm冲正金额
			sameAmt = sameAmt.add(drawRevAmt);
		}else{
			sameAmt = sameAmt.add(revAmt);
		}

		if(unkAmt.compareTo(drawUnkAmt)>=0){//如果本地冲正的金额大于atm冲正金额
			sameAmt = sameAmt.add(drawUnkAmt);
		}else{
			sameAmt = sameAmt.add(unkAmt);
		}
		diffAmt = totalAmt.subtract(sameAmt);

		TbCheckResult tbCheckResult = new TbCheckResult();
		tbCheckResult.setCheckBatchNo(batchNo);
		tbCheckResult.setEquipmentId(termNo);
		tbCheckResult.setSuccessAmount(sameAmt);
		tbCheckResult.setErrorAmount(diffAmt);
		tbCheckResult.setWithdrawCurrency(currencyCode);
		tbCheckResult.setCheckTime(now);
		if(sameAmt.compareTo(totalAmt)==0){
			tbCheckResult.setCheckStatus("1");//对账结果（0：差错，1：平账）
		}else{
			tbCheckResult.setCheckStatus("0");//对账结果（0：差错，1：平账）
		}
		tbCheckResult.setType("0");//对账对象（0-与C端，1-与交易所）
		tbCheckResult.setCreateTime(now);
		tbCheckResultService.insert(tbCheckResult);

		log.info("对账批次号："+ batchNo+ "，将本次本地对账明细存入本地对账明细表中");
		//根据条件（设备编号，终端未对账，取款接口），查询出交易明细列表，并复制到本地交易明细表tb_p_check_trans中
		TbTransExample example = new TbTransExample();
		example.createCriteria().andEquipmentIdEqualTo(termNo).andCCheckStatusNotEqualTo("1").
				andInterfaceCodeEqualTo("/api/auth/drawMoney");
		List<TbTrans> list = tbTransService.selectByExample(example);
		for(TbTrans trans : list){
			TbPCheckTrans tbPCheckTrans = new TbPCheckTrans();
			tbPCheckTrans.setAtmcSeq(trans.getEquipmentLogSeq());
			tbPCheckTrans.setAtmpSeq(trans.getId()+"");
			tbPCheckTrans.setExSeq(trans.getExTransSeq());
			tbPCheckTrans.setCheckBatchNo(batchNo);
			tbPCheckTrans.setEquipmentId(termNo);
			tbPCheckTrans.setUserId(trans.getUserId());
			tbPCheckTrans.setWithdrawMoney(trans.getWithdrawMoney());
			tbPCheckTrans.setWithdrawCurrency(trans.getWithdrawCurrency());
			tbPCheckTrans.setDeductCurrency(trans.getDeductCurrency());
			tbPCheckTrans.setDeductMoney(trans.getDeductMoney().subtract(trans.getTransFee()));
			tbPCheckTrans.setDeductFee(trans.getTransFee());
			tbPCheckTrans.setTransTime(trans.getTransTime());
			if(!"1".equals(trans.getStatus())&&!"2".equals(trans.getStatus())&&!"4".equals(trans.getStatus())){
				tbPCheckTrans.setTransStatus("7");//取款结果：1-完成 2-失败 4-已冲正 7-状态不明
			}else{
				tbPCheckTrans.setTransStatus(trans.getStatus());
			}
			tbPCheckTrans.setWithCDiff("1");//默认有差异，与c端是否有差异，0-无差异，1-有差异（暂时不用）
			tbPCheckTrans.setWithExDiff("1");//默认有差异，与交易所是否有差异，0-无差异，1-有差异
			tbPCheckTransService.insert(tbPCheckTrans);
		}

		//将数据根据条件（设备编号，终端未对账，取款接口）将与c端对账状态都修改为已对账
		tbTransService.updateCToCheckedByEquipmentId(termNo);

		log.info("对账批次号："+ batchNo+ "，将本次atm未知交易存入atm对账明细表中");
		//将atm疑问的交易存入atm交易表中
		for(Map map : drawUnkList){
			String termSeq = (String)map.get("termSeq");
			String tempTermDate = (String)map.get("termDate");
			String status = (String)map.get("status");//0为成功，1为失败，2已冲正，3状态不明
			//根据设备编号，流水，日期唯一查询出交易流水
			TbTransExample exa = new TbTransExample();
			exa.createCriteria().andEquipmentIdEqualTo(termNo).andEquipmentLogSeqEqualTo(termSeq).
					andTermDateEqualTo(CalendarUtil.toDate(tempTermDate,CalendarUtil.DATE_FMT_3));
			List<TbTrans> tempList = tbTransService.selectByExample(exa);
			if(CollectionUtils.isEmpty(tempList)){
				log.info("对账批次号："+ batchNo+ "，未找到atm流水信息：atm流水号="+termSeq+",atm日期="+tempTermDate);
				continue;
			}
			TbTrans ctrans = tempList.get(0);
			TbCCheckTrans tbCCheckTrans = new TbCCheckTrans();
			tbCCheckTrans.setAtmcSeq(ctrans.getEquipmentLogSeq());
			tbCCheckTrans.setAtmpSeq(ctrans.getId()+"");
			tbCCheckTrans.setExSeq(ctrans.getExTransSeq());
			tbCCheckTrans.setCheckBatchNo(batchNo);
			tbCCheckTrans.setEquipmentId(termNo);
			tbCCheckTrans.setUserId(ctrans.getUserId());
			tbCCheckTrans.setWithdrawMoney(ctrans.getWithdrawMoney());
			tbCCheckTrans.setWithdrawCurrency(ctrans.getWithdrawCurrency());
			tbCCheckTrans.setDeductCurrency(ctrans.getDeductCurrency());
			tbCCheckTrans.setDeductMoney(ctrans.getDeductMoney().subtract(ctrans.getTransFee()));
			tbCCheckTrans.setDeductFee(ctrans.getTransFee());
			tbCCheckTrans.setTransTime(ctrans.getTransTime());
			if("0".equals(status)){
				tbCCheckTrans.setTransStatus("1");//取款结果：1-完成 2-失败 4-已冲正 7-状态不明
			}else if("1".equals(status)){
				tbCCheckTrans.setTransStatus("2");
			}else if("2".equals(status)){
				tbCCheckTrans.setTransStatus("4");
			}else {
				tbCCheckTrans.setTransStatus("7");
			}
			tbCCheckTransService.insert(tbCCheckTrans);
		}
	}



	/**
	 * 和交易所进行对账
	 * @param batchNo 对账批次号
	 * @param termNo 设备编号
	 */
	@Transactional
	public void checkDataWithEx(String batchNo, String termNo, String currencyCode) throws Exception{
		log.info("对账批次号："+ batchNo+",开始与交易所对账，设备编号"+termNo);
		//更新的操作在异步线程中也要放，否则可能由于使用了事务控制，导致前面的事务未完成，从而下面的localCheckList查询不到数据
		//将数据根据条件（设备编号，终端未对账，取款接口）将与c端对账状态都修改为已对账
//		tbTransService.updateCToCheckedByEquipmentId(termNo);

		//根据条件（终端已对账，交易所未对账，设备编号，取款接口），按交易所时间排序升序,查询交易表,用来和交易所对账
		//TODO 修改成查询P端对账表，修改状态也修改在那里面有的记录
//		List<TbTrans> localCheckList = tbTransService.queryDrawTransByCChecked(termNo);
//		System.out.println("查询出未对账列表"+localCheckList);
//		System.out.println("查询出未对账数量"+localCheckList.size());
		TbPCheckTransExample tbPCheckTransExample = new TbPCheckTransExample();
		tbPCheckTransExample.createCriteria().andEquipmentIdEqualTo(termNo).andCheckBatchNoEqualTo(batchNo);
		List<TbPCheckTrans> localCheckListP = tbPCheckTransService.findByExample(tbPCheckTransExample);
		log.info("查询出未对账数量P："+localCheckListP.size());
		//根据条件（交易所已对账，设备编号，取款接口），按交易所时间倒叙，查询出最近一条已对账交易，获得起始时间
		TbTrans firstTrans = tbTransService.queryDrawTransByPCheckedFirstRow(termNo);

		//向交易所发起对账，传第一条交易数据中交易所的交易时间,交易所查询大于该时间的交易
		Long startTime = 0l;
		if(firstTrans!=null){//如果未查询到数据，说明是第一次和交易所对账，传0，查询出所有记录
			startTime = firstTrans.getExTransTime();
		}
		// 组装参数
		Map<String, String> startCheckParams = new HashMap<String, String>();
		startCheckParams.put("startTime",startTime+"");
//		startCheckParams.put("endTime", null);
		startCheckParams.put("atmNum",termNo);//设备编号
		JSONData startCheck = noAuthDoPost(getUrl("/api/atm/reconcile",startCheckParams));
		if (startCheck == null) {
			log.error("对账批次号："+ batchNo+ "，交易所返回超时");
			return;
		} else if (!EnumResponseMsg.isSuccess(startCheck.getCode())) {
			log.error("对账批次号："+ batchNo+ "，交易所返处理错误，返回响应码："+startCheck.getCode()+",返回响应信息："+startCheck.getMsg());
			return;
		}
		Map result = startCheck.getData();
		String fileName = (String)result.get("fileName");

		boolean flag = false;
		int i = 1;
		int time = 2000;

		while(!flag && i<= 10){
			//向交易所询问对账文件是否已经生成
			// 组装参数
			Map<String, String> pollParams = new HashMap<String, String>();
			pollParams.put("filename",fileName);
			JSONData pollResult = noAuthDoPost(getUrl("/api/query/"+fileName,pollParams));
			if (pollResult == null) {
				log.error("对账批次号："+ batchNo+ "，交易所返回超时");
				try{
					//2，4，8，16，32，64，128，256，512，1024，共2046秒，大约半小时
					log.info("对账批次号："+ batchNo+ "，休眠"+time/1000+"秒");
					Thread.sleep(time);
					time = time * 2;
				}catch(Exception e){
					e.printStackTrace();
					log.error("对账批次号："+ batchNo+ "，休眠出现异常");
				}
				continue;
			} else if (!EnumResponseMsg.isSuccess(pollResult.getCode())) {
				log.error("对账批次号："+ batchNo+ "，返回响应码：code="+pollResult.getCode()+",返回响应信息"+pollResult.getMsg());
				try{
					//2，4，8，16，32，64，128，256，512，1024，共2046秒，大约半小时
					log.info("对账批次号："+ batchNo+ "，休眠"+time/1000+"秒");
					Thread.sleep(time);
					time = time * 2;
				}catch(Exception e){
					e.printStackTrace();
					log.error("对账批次号："+ batchNo+ "，休眠出现异常");
				}
				continue;
			}
			Map pollData = pollResult.getData();
			flag = (Boolean)pollData.get("exist");
			if(!flag){
				try{
					//2，4，8，16，32，64，128，256，512，1024，共2046秒，大约半小时
					log.info("对账批次号："+ batchNo+ "，休眠"+time/1000+"秒");
					Thread.sleep(time);
					time = time * 2;
				}catch(Exception e){
					e.printStackTrace();
					log.error("对账批次号："+ batchNo+ "，休眠出现异常");
				}
			}
			i++;
		}

		if(!flag){
			log.error("对账批次号："+ batchNo+ "，对账文件生成超时");
			return;
		}

		//向交易所获取对账文件(P端流水号，交易所流水号，状态)，根据P端流水号和交易所流水号，查询tb_trans表,
		//解析对账文件成Map，（key为本地流水id,value为交易表对象tbTrans
		//value对应的交易表对象中的状态，已经根据交易所的状态转换成了本地的状态，且只有4种状态
		Map<String,TbExCheckTrans> exTransMap = downloadCheckFile(fileName, batchNo);

		//根据交易流水号，进行对账，一致的放到平账金额，不一致的记录到差错金额中
		BigDecimal sameAmt = new BigDecimal("0");
		Long sameNum = 0l;
		BigDecimal diffAmt = new BigDecimal("0");
		Long diffNum =0l;
		if(!CollectionUtils.isEmpty(localCheckListP)){
			log.info("本地有流水");
			for(TbPCheckTrans localTrans : localCheckListP){
				TbExCheckTrans exTrans = exTransMap.get(localTrans.getAtmpSeq());
				if(exTrans==null){//如果交易所没有数据（说明是失败了），本地状态是失败或者未知，则属于平账，否则属于差错
					log.info("本地流水号"+localTrans.getAtmpSeq()+",未找到对应交易所端的流水");
					if("2".equals(localTrans.getTransStatus())||"7".equals(localTrans.getTransStatus())){
						sameAmt = sameAmt.add(localTrans.getWithdrawMoney());
						sameNum++;
						//将交易所对账明细、本地对账明细 的差异状态改成无差异
						localTrans.setWithExDiff("0");//无差异
						tbPCheckTransService.update(localTrans);
					}else{
						diffAmt = diffAmt.add(localTrans.getWithdrawMoney());
						diffNum++;
					}
				}else{//如果交易所有数据,状态双方一致的是平账，不一致的是差错。
					if(localTrans.getTransStatus().equals(exTrans.getTransStatus())){
						sameAmt = sameAmt.add(localTrans.getWithdrawMoney());
						sameNum++;
						//将交易所对账明细、本地对账明细 的差异状态改成无差异
						exTrans.setWithPDiff("0");//无差异
						tbExCheckTransService.update(exTrans);
						localTrans.setWithExDiff("0");//无差异
						tbPCheckTransService.update(localTrans);
					}else{
						diffAmt = diffAmt.add(localTrans.getWithdrawMoney());
						diffNum++;
					}
				}

				//更新交易表为已对账
				TbTrans tbTrans = new TbTrans();
				tbTrans.setId(localTrans.getAtmpSeq());
				//更新与交易所对账为已经对账
				tbTrans.setExCheckStatus("1");//与交易所的交易流水对账状态（0未对账，1已对账)
				tbTransService.updateBySelective(tbTrans);
			}



		}else{
			log.info("本地未找到流水");
			for(TbExCheckTrans trans : exTransMap.values()){
				diffAmt = diffAmt.add(trans.getWithdrawMoney());
				diffNum++;
			}
		}

		//将结果记录到对账结果表中
		TbCheckResult tbCheckResult = new TbCheckResult();
		Date now = new Date();
		tbCheckResult.setCheckBatchNo(batchNo);
		tbCheckResult.setEquipmentId(termNo);
		tbCheckResult.setSuccessAmount(sameAmt);
		tbCheckResult.setSuccessNum(sameNum);
		tbCheckResult.setErrorAmount(diffAmt);
		tbCheckResult.setErrorNum(diffNum);
		tbCheckResult.setWithdrawCurrency(currencyCode);
		tbCheckResult.setCheckTime(now);
		if(diffAmt.compareTo(new BigDecimal("0"))==0){//没有差错金额，属于平账
			tbCheckResult.setCheckStatus("1");//对账结果（0：差错，1：平账）
		}else{
			tbCheckResult.setCheckStatus("0");//对账结果（0：差错，1：平账）
		}
		tbCheckResult.setType("1");//对账对象（0-与C端，1-与交易所）
		tbCheckResult.setCreateTime(now);
		tbCheckResultService.insert(tbCheckResult);

		//TODO 根据条件（终端已对账，交易所未对账，设备编号，取款接口），更新交易表，将交易所对账状态改为已对账
		//已将更新操作放到比对对账结果的for循环中。
//		tbTransService.updateDrawTransByCChecekdToPChecked(termNo);

		log.info("对账批次号："+ batchNo+ "，与交易所对账结束");
	}

	//start 无需登录签名规则和访问路径获取以及post请求

	public Map<String,TbExCheckTrans> downloadCheckFile(String fileName, String batchNo) throws Exception{
		log.info("对账批次号："+ batchNo+ "，开始从交易所获取对账文件");
		//向交易所询问对账文件是否已经生成
		// 组装参数
		Map<String, String> pollParams = new HashMap<String, String>();
		pollParams.put("filename",fileName);
		InputStream is = noAuthDoGet(getUrl("/api/download/"+fileName,pollParams));
		if(is==null){
			log.error("对账批次号："+ batchNo+ "，获取文件流失败");
			return null;
		}
		//解析文件流
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		Map<String,TbExCheckTrans> exTransMap = new HashMap<String, TbExCheckTrans>();
		try{
			String tmp ="";
			while((tmp = br.readLine())!=null){
				System.out.println(tmp);//TODO 是否需要存入文件中
				String str[] = tmp.split("\\|");
				String id = str[1];
				String status = str[2];//1-取款成功,2-取款失败,3-已扣款,4-未知,5-扣款后补贴);
				String deductMoney = str[3];//扣款数字货币金额
				String fee = str[4];//手续费
				String exTime = str[9];//交易所时间（Long类型）
//				log.info("exTime:"+exTime);

				TbTrans tbTrans = tbTransService.selectByPrimaryKey(id);
				if(tbTrans == null){
					log.info("对账批次号："+ batchNo+ "，未查询到交易表id为"+id+"的数据");
					continue;
				}
				if(StringUtils.isEmpty(tbTrans.getExTransTime())||0l == (tbTrans.getExTransTime())){
					log.info("本地存储交易所流水为空，更新交易所流水号");
					tbTrans.setExTransTime(Long.parseLong(exTime));
					tbTrans.setUpdateTime(new Date());
					tbTransService.update(tbTrans);
				}
				//根据交易所状态，修改成本地对应的状态，仅4种，1-完成 2-失败 4-已冲正 7-状态不明
				if("1".equals(status)){
					tbTrans.setStatus("1");
				}else if("2".equals(status)){
					tbTrans.setStatus("2");
				}else if("5".equals(status)){
					tbTrans.setStatus("4");
				}else{
					tbTrans.setStatus("7");
				}

				//更新扣款币种金额为交易所返回的数据
				tbTrans.setDeductMoney(new BigDecimal(deductMoney).add(new BigDecimal(fee)));
				tbTrans.setTransFee(new BigDecimal(fee));

				//将交易表对象转换成交易所对账对象,存入交易所交易明细表tb_ex_check_trans中
				TbExCheckTrans tbExCheckTrans = new TbExCheckTrans();
				tbExCheckTrans.setAtmcSeq(tbTrans.getEquipmentLogSeq());
				tbExCheckTrans.setAtmpSeq(tbTrans.getId()+"");
//				log.info("对账批次号："+ batchNo+ "，交易表id:"+tbTrans.getId());
				tbExCheckTrans.setExSeq(tbTrans.getExTransSeq());
				tbExCheckTrans.setCheckBatchNo(batchNo);
				tbExCheckTrans.setEquipmentId(tbTrans.getEquipmentId());
				tbExCheckTrans.setUserId(tbTrans.getUserId());
				tbExCheckTrans.setWithdrawMoney(tbTrans.getWithdrawMoney());
				tbExCheckTrans.setWithdrawCurrency(tbTrans.getWithdrawCurrency());
				tbExCheckTrans.setDeductCurrency(tbTrans.getDeductCurrency());
				tbExCheckTrans.setDeductMoney(tbTrans.getDeductMoney().subtract(tbTrans.getTransFee()));
				tbExCheckTrans.setDeductFee(tbTrans.getTransFee());
				tbExCheckTrans.setTransTime(tbTrans.getTransTime());
				tbExCheckTrans.setTransStatus(tbTrans.getStatus());
				tbExCheckTrans.setWithPDiff("1");//默认有差异，与P端是否有差异，0-无差异，1-有差异
				tbExCheckTransService.insert(tbExCheckTrans);

				//放入到map中
				exTransMap.put(id, tbExCheckTrans);
			}
		}catch (IOException e){//只抓取IO异常
			log.error("对账批次号："+ batchNo+ "，解析文件异常");
			log.error(LogUtils.getExceptionInfo(e));
			return null;
		}
		log.info("对账批次号："+ batchNo+ "，获取对账文件成功并已完成解析");
		return exTransMap;
	}


	/**
	 * 无需登录，调用http请求交易所
	 *
	 * @param url
	 * @return JSONData
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", })
	public JSONData noAuthDoPost(String url) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		RequestConfig config = RequestConfig.custom().
				setConnectionRequestTimeout(5000).//connection超时时间
				setSocketTimeout(60000).//获取数据超时时间,等待返回时间
				setConnectTimeout(10000).build();//连接超时时间
		HttpPost post = new HttpPost(url);
		post.setConfig(config);
		// 使用addHeader方法添加请求头部,诸如User-Agent, Accept-Encoding等参数.
		post.setHeader("Content-Type", "application/json;charset=UTF-8");
		String string = "";
		try {
			log.info("调用交易所接口"+url);
			log.info("入参：无");
			CloseableHttpResponse response = httpClient.execute(post);
			string = EntityUtils.toString(response.getEntity());
			log.info("出参："+string);
			// 将string转成map
			Map result = JSONObject.parseObject(string);
			if (result == null) {
				return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getCode())
						.msg(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getMsg()).build();
			}
			if (("true").equals(result.get("success") + "")) {
				return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
						.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data((Map) result.get("body")).build();
			}

			if ("E001".equals(result.get("errCode") + "")) {// 交易所请求子服务超时
				return null;
			}

			if (!StringUtils.isEmpty(result.get("errCode"))) {
				String msg = (String) result.get("errMsg");
				if(!StringUtils.isEmpty(msg) && msg.length()>150){
					msg = msg.substring(0,150);
				}
				return JSONData.builder().code(result.get("errCode") + "").msg(msg).build();
			} else if (!StringUtils.isEmpty(result.get("status"))) {
				String msg = (String) result.get("error");
				if(!StringUtils.isEmpty(msg) && msg.length()>150){
					msg = msg.substring(0,150);
				}
				return JSONData.builder().code(result.get("status") + "").msg(msg).build();
			} else {
				return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getCode())
						.msg(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getMsg()).build();
			}

		} catch (Exception e) {
			log.error(LogUtils.getExceptionInfo(e));
			return null;
		}
	}

	/**
	 * 无需登录，调用http请求交易所
	 *
	 * @param url
	 * @return JSONData
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", })
	public InputStream noAuthDoGet(String url) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		RequestConfig config = RequestConfig.custom().
				setConnectionRequestTimeout(5000).//connection超时时间
				setSocketTimeout(60000).//获取数据超时时间,等待返回时间
				setConnectTimeout(10000).build();//连接超时时间
		HttpGet get = new HttpGet(url);
		get.setConfig(config);
		// 使用addHeader方法添加请求头部,诸如User-Agent, Accept-Encoding等参数.
		get.setHeader("Content-Type", "application/json;charset=UTF-8");
		String string = "";
		try {
			log.info("调用交易所接口"+url);
			log.info("入参：无");
			HttpResponse response = httpClient.execute(get);
			HttpEntity entity = response.getEntity();
			InputStream is = entity.getContent();
			return is;
		} catch (Exception e) {
			log.error("获取文件流失败");
			log.error(LogUtils.getExceptionInfo(e));
			return null;
		}
	}

	/**
	 *
	 * @param interfaceCode 接口名称
	 * @return
	 */
	public String getUrl(String interfaceCode, Map<String, String> params){
		//公钥
		String accessKey = appProperties.getAccessKey();
		//私钥
		String secretKey = appProperties.getSecretKey();
		String requestUrl = interfaceCode;
		String localhost = appProperties.getNoauthBaseUrl();

		Map<String, String> common = Maps.newHashMap();
		common.put("accessKey",accessKey);
		common.put("_dt", String.valueOf(System.currentTimeMillis()));
		common.putAll(params);
		String sign = genSign(requestUrl, common, secretKey, accessKey);
		System.out.println(sign);
		StringBuilder url=new StringBuilder(localhost+requestUrl+"?sign="+sign);
		if(!StringUtils.isEmpty(common)){
			common.forEach((key,value) ->{
				url.append("&"+key+"="+value);
			});
		}
		return url.toString();
	}

	public String genSign(String url, Map<String, String> params, String secretKey, String accessKey) {

		if (StringUtils.isEmpty(url) || CollectionUtils.isEmpty(params)){
			//wrong
			return "";
		}

		if(!params.keySet().contains("_dt") || !params.keySet().contains("accessKey")) {
			//wrong
			return "";
		}

		Object[] bodyKs =  params.keySet().toArray();
		Arrays.sort(bodyKs);		//key 排序


		StringBuilder wait = new StringBuilder(url);
		wait.append("|");
		for(int i=0; i<bodyKs.length; i++) {
			String key = (String)bodyKs[i];
			String value = params.get(key);
			if(StringUtils.isEmpty(value)) {
				//wrong
				return "";
			}
			if("sign".equals(key)) {
				continue;
			}
			wait.append(key).append("=").append(value);
		}
		wait.append("|");
		wait.append(secretKey);

		//验签
		String sign = "";
		try {
			sign = getMD5Code(wait.toString());
		} catch (Exception e) {
		}

		return sign;
	}

	public static String getMD5Code(String strObj) throws Exception{
		MessageDigest md = MessageDigest.getInstance("MD5");
		// md.digest() 该函数返回值为存放哈希值结果的byte数组
		return byteToString(md.digest(strObj.getBytes()));
	}
	private static String byteToString(byte[] bByte) {
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < bByte.length; i++) {
			sBuffer.append(byteToArrayString(bByte[i]));
		}
		return sBuffer.toString();
	}
	private static String byteToArrayString(byte bByte) {
		int iRet = bByte;
		if (iRet < 0) {
			iRet += 256;
		}
		int iD1 = iRet / 16;
		int iD2 = iRet % 16;
		return strDigits[iD1] + strDigits[iD2];
	}
	private static final String[] strDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	//end 无需登录签名规则和访问路径获取以及post请求


	@Override
	public JSONData getCaptcha(HttpServletRequest request, String termNo) {
		String key = termNo + "captcha";
		//生成随机的四位字母+数字
		String captcha = getCaptcha();
		
		//以设备编号为key，存放到redis中，60秒超时
		stringRedisTemplate.opsForValue().set(key, captcha, 60, TimeUnit.SECONDS);
		
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("captcha", captcha);
		
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(result).build();
	}
	
	/**
	 * 获取4位防重码
	 * 
	 * @return
	 */
	private static String getCaptcha() {
		int n = 4;
		String val = "";
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			String str = random.nextInt(2) % 2 == 0 ? "num" : "char";
			if ("char".equalsIgnoreCase(str)) { // 产生字母
				int nextInt = random.nextInt(2) % 2 == 0 ? 65 : 97;
				// System.out.println(nextInt + "!!!!"); 1,0,1,1,1,0,0
				val += (char) (nextInt + random.nextInt(26));
			} else if ("num".equalsIgnoreCase(str)) { // 产生数字
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}
	
	/**
	 * 校验防重码
	 * @param request
	 * @param termNo
	 * @param captcha
	 * @return
	 */
	public JSONData checkCaptcha(HttpServletRequest request, String termNo, String captcha) {
		String key = termNo + "captcha";
		//从redis中取出数据比对
		String localCaptcha = stringRedisTemplate.opsForValue().get(key);
		log.info("取出防重码："+captcha);
		//本地captcha为空，或者和传过来的不相符，报错重复交易
		if(localCaptcha==null || !captcha.equals(localCaptcha)){
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_REPEAT_REQUEST.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_REPEAT_REQUEST.getMsg()).build();
		}
		
		//不论成功失败，删除captcha
		stringRedisTemplate.delete(key);
		log.info("删除redis中防重复码");
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
	}

}
