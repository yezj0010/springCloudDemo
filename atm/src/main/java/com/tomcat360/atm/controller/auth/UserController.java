package com.tomcat360.atm.controller.auth;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tomcat360.atm.aspect.UserLog;
import com.tomcat360.atm.constant.AtmConstant;
import com.tomcat360.atm.enums.EnumResponseMsg;
import com.tomcat360.atm.enums.TransStatusEnum;
import com.tomcat360.atm.model.JSONData;
import com.tomcat360.atm.model.TbArea;
import com.tomcat360.atm.model.TbEquipment;
import com.tomcat360.atm.model.TbEquipmentSettings;
import com.tomcat360.atm.model.TbEquipmentStatus;
import com.tomcat360.atm.model.TbTrans;
import com.tomcat360.atm.model.redis.UserInfo;
import com.tomcat360.atm.service.ExchangeService;
import com.tomcat360.atm.service.TbAreaService;
import com.tomcat360.atm.service.TbEquipmentService;
import com.tomcat360.atm.service.TbEquipmentSettingsService;
import com.tomcat360.atm.service.TbEquipmentStatusService;
import com.tomcat360.atm.service.TbTransService;
import com.tomcat360.atm.util.CalendarUtil;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/api/auth")
public class UserController {
	
	@Autowired
	private TbEquipmentSettingsService tbEquipmentSettingsService;

	@Autowired
	private TbEquipmentService tbEquipmentService;

	@Autowired
	private ExchangeService exchangeService;

	@Autowired
	private TbTransService tbTransService;
	
	@Autowired
	private TbAreaService tbAreaService;
	
	@Autowired
	private TbEquipmentStatusService tbEquipmentStatusService;
	
	
	/**
	 * 退出登陆
	 * 
	 * @param request
	 * @return
	 */
	@UserLog(interfaceCode = "/api/auth/logout", interfaceDesc = "用户退出登录")
	@RequestMapping("/logout")
	public JSONData logout(HttpServletRequest request) {
		String localToken = (String) request.getAttribute(AtmConstant.LOCAL_TOKEN);
		String exchangeToken = (String) request.getAttribute(AtmConstant.EXCHANGE_TOKEN);

		return exchangeService.logout(localToken, exchangeToken);
	}

	/**
	 * 用户资产信息
	 * 
	 * @param request
	 * @return
	 */
	@UserLog(interfaceCode = "/api/auth/userAccount", interfaceDesc = "用户资产信息")
	@RequestMapping("/userAccount")
	public JSONData userAccount(HttpServletRequest request) {
		String currency = (String)request.getAttribute("drawCurrency");// 取款币种
		String exchangeToken = (String) request.getAttribute(AtmConstant.EXCHANGE_TOKEN);

		if (StringUtils.isEmpty(currency)) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getMsg()).build();
		}
		
		//校验取款币种是否是该设备支持的币种
		TbEquipmentSettings tbEquipmentSettings = (TbEquipmentSettings)request.getAttribute(AtmConstant.EQUIPMENT_SETTINGS);
		if(!currency.equals(tbEquipmentSettings.getEquipmentSubType())){
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_CURRENCY_IS_ERROR.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_CURRENCY_IS_ERROR.getMsg()).build();
		}

		return exchangeService.getUserAccount(request, exchangeToken, currency);
	}

	/**
	 * 获取手续费信息
	 * 
	 * @param request
	 * @return
	 */
	@UserLog(interfaceCode = "/api/auth/getTransFee", interfaceDesc = "获取手续费信息")
	@RequestMapping("/getTransFee")
	public JSONData getTransFee(HttpServletRequest request) {
		String equipmentId = (String)request.getAttribute(AtmConstant.TERMNO);
//		String deductCurrency = (String)request.getAttribute("deductCurrency");// 扣款币种
		String deductAndPrice = (String)request.getAttribute("deductAndPrice");// 扣款币种和价格
//		String priceStr = (String)request.getAttribute("price");// 取款币种/扣款币种 汇率
		String drawCurrency = (String)request.getAttribute("drawCurrency");// 取款币种
		String drawMoneystr = (String)request.getAttribute("drawMoney");// 取款金额

		if (StringUtils.isEmpty(deductAndPrice) || StringUtils.isEmpty(drawCurrency)
				|| StringUtils.isEmpty(drawMoneystr)) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getMsg()).build();
		}
		
		//校验取款币种是否是该设备支持的币种
		TbEquipmentSettings tbEquipmentSettings = (TbEquipmentSettings)request.getAttribute(AtmConstant.EQUIPMENT_SETTINGS);
		if(!drawCurrency.equals(tbEquipmentSettings.getEquipmentSubType())){
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_CURRENCY_IS_ERROR.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_CURRENCY_IS_ERROR.getMsg()).build();
		}
		
		
		return exchangeService.getTransFee(deductAndPrice, drawMoneystr, equipmentId);
	}
	
	/**
	 * 获取防重码
	 * 
	 * @param request
	 * @return
	 */
	@UserLog(interfaceCode = "/api/auth/getCaptcha", interfaceDesc = "获取防重码")
	@RequestMapping("/getCaptcha")
	public JSONData getCaptcha(HttpServletRequest request) {
		String termNo = (String)request.getAttribute("termNo");
		
		if (StringUtils.isEmpty(termNo)) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getMsg()).build();
		}
		
		return exchangeService.getCaptcha(request, termNo);
	}

	/**
	 * 取款
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
	@UserLog(interfaceCode = "/api/auth/drawMoney", interfaceDesc = "取款")
	@RequestMapping("/drawMoney")
	public JSONData drawMoney(HttpServletRequest request) {
		String deductCurrency = (String)request.getAttribute("deductCurrency");// 扣款币种
		String drawCurrency = (String)request.getAttribute("drawCurrency");// 取款币种
		String drawMoneystr = (String)request.getAttribute("drawMoney");// 取款金额
		String id = (String)request.getAttribute("termNo");//设备编号
		String equipmentLogSeq = (String)request.getAttribute("termSeq");//交易流水号
		String termDate = (String)request.getAttribute("termDate");//交易日期yyyy-MM-dd
		String password = (String)request.getAttribute("password");//交易所交易密码
		String transFee = (String)request.getAttribute("transFee");//手续费
		String price = (String)request.getAttribute("price");//扣款币种单个对应取款币种价格
		String coinId = (String)request.getAttribute("coinId");//扣款币种id
		String captcha = (String)request.getAttribute("captcha");//防重码
		String toUsdt = (String)request.getAttribute("toUsdt");//获取资产列表返回，原样返回
		
		if (StringUtils.isEmpty(deductCurrency) || StringUtils.isEmpty(drawCurrency)|| StringUtils.isEmpty(price)
				|| StringUtils.isEmpty(drawMoneystr)||StringUtils.isEmpty(id)||StringUtils.isEmpty(equipmentLogSeq)||
				StringUtils.isEmpty(transFee)||StringUtils.isEmpty(termDate)||StringUtils.isEmpty(password)||
				StringUtils.isEmpty(coinId)||StringUtils.isEmpty(toUsdt)||StringUtils.isEmpty(captcha)) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getMsg()).build();
		}
		
		//校验取款币种是否是该设备支持的币种
		TbEquipmentSettings tbEquipmentSettings = (TbEquipmentSettings)request.getAttribute(AtmConstant.EQUIPMENT_SETTINGS);
		if(!drawCurrency.equals(tbEquipmentSettings.getEquipmentSubType())){
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_CURRENCY_IS_ERROR.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_CURRENCY_IS_ERROR.getMsg()).build();
		}
		
		double drawMoney = Double.valueOf(drawMoneystr);
		return exchangeService.drawMoney(request, deductCurrency, drawCurrency, drawMoney);
	}

	/**
	 * 取款冲正
	 * 
	 * @param request
	 * @return
	 */
	@UserLog(interfaceCode = "/api/auth/transCorrect", interfaceDesc = "交易冲正")
	@RequestMapping("/transCorrect")
	public JSONData transCorrect(HttpServletRequest request) {
		String termNo = (String)request.getAttribute("termNo");//设备编号
		String oriTermSeq = (String)request.getAttribute("oriTermSeq");// 原取款交易流水
		String oriTermDate = (String)request.getAttribute("oriTermDate");// 原终端交易日期
		String termSeq = (String)request.getAttribute("termSeq");// 终端交易流水
		String termDate = (String)request.getAttribute("termDate");// 终端交易日期
		if (StringUtils.isEmpty(oriTermSeq)||StringUtils.isEmpty(termSeq)||
				StringUtils.isEmpty(oriTermDate)||StringUtils.isEmpty(termDate)) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getMsg()).build();
		}
		
		UserInfo userInfo = (UserInfo)request.getAttribute(AtmConstant.USER);
		//查询原取款交易
		TbTrans tbTrans = tbTransService.selectByPrimaryTermSeq(oriTermSeq,CalendarUtil.toDate(oriTermDate, CalendarUtil.DATE_FMT_3),"0",termNo,userInfo.getId());
		if(tbTrans==null){
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_ORITRANS_NOT_FOUND.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_ORITRANS_NOT_FOUND.getMsg()).build();
		}
		String transId = tbTrans.getId();
		
		return exchangeService.transCorrect(request, transId);
	}

	@Transactional
	@UserLog(interfaceCode = "/api/auth/spitMoneyResult", interfaceDesc = "吐钞结果通知,成功要发送短信告知客户")
	@RequestMapping("/spitMoneyResult")
	public JSONData spitMoneyResult(HttpServletRequest request) {
		String id = (String)request.getAttribute("termNo");// 设备编号
		String oriTermSeq = (String)request.getAttribute("oriTermSeq");// 原取款交易流水
		String oriTermDate = (String)request.getAttribute("oriTermDate");// 原终端交易日期 yyyy-MM-dd
		String spitMoneyStatus = (String)request.getAttribute("spitMoneyStatus");// 吐钞是否成功，0为成功，1为失败，2已冲正，3状态不明
		String language = (String)request.getAttribute("language");//界面语言 1-中国  2-其他
		if ( StringUtils.isEmpty(oriTermSeq) || StringUtils.isEmpty(oriTermDate)
				|| StringUtils.isEmpty(id) || StringUtils.isEmpty(spitMoneyStatus) 
				|| StringUtils.isEmpty(language)) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getMsg()).build();
		}
		
		UserInfo userInfo = (UserInfo)request.getAttribute(AtmConstant.USER);
		// 查询原交易流水
		TbTrans tbTrans = tbTransService.selectByPrimaryTermSeq(oriTermSeq,CalendarUtil.toDate(oriTermDate, CalendarUtil.DATE_FMT_3),"0",id,userInfo.getId());
		
		if(tbTrans == null){
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_ORITRANS_NOT_FOUND.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_ORITRANS_NOT_FOUND.getMsg()).build();
		}
		//如果已经成功，则直接返回成功，说明已经收到过一次通知，不需要返回错误信息
		if(tbTrans.getStatus().equals(TransStatusEnum.SUCCESS.getStatus())){
			return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
					.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
		}
		
		//不需要冲正，和东信开会后，取款不成功，东信会发送冲正请求
//		if (!spitMoneyStatus.equals("0")) {
//			exchangeService.transCorrect(request, Long.valueOf(tbTrans.getId()));
//
//			return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
//					.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
//		}

		// 调用交易所发送短信接口
		if(!"2".equals(spitMoneyStatus)){//如果是已冲正，不需要发送到交易所
			String extoken = (String) request.getAttribute(AtmConstant.EXCHANGE_TOKEN);
			JSONData jsonData = exchangeService.spitMoneyResult(id,tbTrans.getWithdrawMoney().setScale(0)+tbTrans.getWithdrawCurrency(),language,extoken,tbTrans,spitMoneyStatus);

			if (jsonData == null) {
				log.info("短信发送异常。");
			}else if(!EnumResponseMsg.isSuccess(jsonData.getCode())){
				log.info("调用交易所失败,code="+jsonData.getCode()+",msg="+jsonData.getMsg());
			}
		}
		
		//更新交易流水状态
		if (spitMoneyStatus.equals("0")) {//成功，更新对应标的金额
			tbTrans.setStatus(TransStatusEnum.SUCCESS.getStatus());
			//设备余额减少对应的金额
			TbEquipmentSettings tbEquipmentSettings = tbEquipmentSettingsService.find(id);
			BigDecimal amount2 = tbEquipmentSettings.getAmount();
			if (amount2 != null) {
				tbEquipmentSettings.setAmount(amount2.subtract(tbTrans.getWithdrawMoney()));
			} else {
				BigDecimal bigDecimal = new BigDecimal(0);
				tbEquipmentSettings.setAmount(bigDecimal);
			}
			tbEquipmentSettingsService.updateDate(tbEquipmentSettings);

			//设备流水增加
			TbEquipment tbEquipment = tbEquipmentService.find(tbEquipmentSettings.getId());
			tbEquipment.setTransAmount(tbEquipment.getTransAmount()==null?tbTrans.getWithdrawMoney():tbEquipment.getTransAmount().add(tbTrans.getWithdrawMoney()));
			tbEquipment.setTransNum(tbEquipment.getTransNum() == null ? 0 : tbEquipment.getTransNum() + 1);
			tbEquipmentService.update(tbEquipment);
		} else if(spitMoneyStatus.equals("1")){//失败
			tbTrans.setStatus(TransStatusEnum.FAIL.getStatus());
		} else if(spitMoneyStatus.equals("2")){//已冲正
			//已冲正这里不修改了，如果调用了 冲正接口，会将状态改为已冲正
//			tbTrans.setStatus(TransStatusEnum.SUCCESS.getStatus());
		} else{//状态不明
			tbTrans.setStatus(TransStatusEnum.UNKNOW.getStatus());
		}
		tbTransService.update(tbTrans);
		
		//更新设备状态表交易时间
		TbEquipmentStatus equipmentStatus = tbEquipmentStatusService.findById(id);
		equipmentStatus.setTransTime(new Date());
		tbEquipmentStatusService.updateByTbEquipmentStatus(equipmentStatus);
		
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
	}

}
