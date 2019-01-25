package com.tomcat360.atm.aspect;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.tomcat360.atm.constant.AtmConstant;
import com.tomcat360.atm.enums.EnumResponseMsg;
import com.tomcat360.atm.model.JSONData;
import com.tomcat360.atm.model.TbEquipmentSettings;
import com.tomcat360.atm.model.TbEquipmentStatus;
import com.tomcat360.atm.model.redis.AtmTokenInfo;
import com.tomcat360.atm.repository.AtmTokenRepository;
import com.tomcat360.atm.service.TbEquipmentSettingsService;
import com.tomcat360.atm.service.TbEquipmentStatusService;
import com.tomcat360.atm.util.AesUtils;
import com.tomcat360.atm.util.LogUtils;
import com.tomcat360.atm.util.MD5Util;
import com.tomcat360.atm.util.RSAUtil;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SecurityRule {
	@Autowired
	private AtmTokenRepository atmTokenRepository;

	@Autowired
	private TbEquipmentSettingsService tbEquipmentSettingsService;
	
	@Autowired
	private TbEquipmentStatusService tbEquipmentStatusService;

	public JSONData tokenCheck(HttpServletRequest request) throws Exception {
		String requestPath = request.getServletPath();
		// 解析入参
		String termNo = request.getHeader("termNo");// 设备编号
		String signature = request.getHeader("signature");
		String content = request.getParameter("content");// json字符串密文
		String key = request.getParameter("key");// 对称密钥，经过rsa公钥加密后的密文

		if(content!=null){
			content = content.replaceAll(" ", "+");
		}
		if(key!=null){
			key = key.replaceAll(" ", "+");
		}

		log.info("请求接口："+requestPath);
		log.info("请求入参termNo=" + termNo);
		log.info("请求入参signature=" + signature);
		log.info("请求入参key=" + key);
		log.info("请求入参content=" + content);
		if (StringUtils.isEmpty(termNo) || StringUtils.isEmpty(signature) || StringUtils.isEmpty(content)
				|| StringUtils.isEmpty(key)) {
			return paramEmpty();
		}

		// 签名规范
		String saltKey = signature.substring(0, 10);// 获取salt
		String preSignature = "termNo=" + termNo + "&content=" + content + "&salt=" + saltKey;

		// 验签
		String localSignature = MD5Util.getMD5(preSignature);
		localSignature = saltKey + localSignature;
		log.info("签名是：" + localSignature);
		if (!localSignature.equals(signature)) {
			return validateFail();
		}
		
		//判断机器状态是否是闲置，如果是闲置直接返回失败
		TbEquipmentStatus tbEquipmentStatus = tbEquipmentStatusService.findById(termNo);
		if(tbEquipmentStatus==null){
			return noFoundEquipment();
		}
		if("2".equals(tbEquipmentStatus.getRunningStatus())){//整机状态 0设备正常  ,1未激活 , 2-停用 3-异常
			return equipmentUnused();
		}
		request.setAttribute(AtmConstant.EQUIPMENT_STATUS, tbEquipmentStatus);

		// 如果是获取主密钥接口，则不进行解密操作。
		request.setAttribute(AtmConstant.TERMNO, termNo);// 设备编号
		if (requestPath.contains("api/getMasterKey")) {
			log.info("获取主密钥请求，数据尚未加密，content也无请求参数" + requestPath);
			return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
					.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
		}

		// 解密content
		// 查询私钥
		TbEquipmentSettings tbEquipmentSettings = tbEquipmentSettingsService.find(termNo);
		if (tbEquipmentSettings == null) {
			return noFoundEquipment();
		}
		request.setAttribute(AtmConstant.EQUIPMENT_SETTINGS, tbEquipmentSettings);
		String privateKey = tbEquipmentSettings.getPrivateKey();// rsa私钥

		// 使用rsa私钥，解密得到aes密钥
		String aesKey = RSAUtil.decryptBase64ToPlain(key, RSAUtil.getPrivateKey(privateKey));
		request.setAttribute(AtmConstant.AES_KEY, aesKey);
		// 将密文解密成明文json字符串
		String plainContent = AesUtils.aesDecryptBaseString(content, aesKey);

		log.info("请求入参解析后，content=" + plainContent);

		// 将json字符串转成map，并将相关数据放到request中。
		Map<String, Object> contentMap = JSONObject.parseObject(plainContent);
		for (Entry<String, Object> entry : contentMap.entrySet()) {
			request.setAttribute(entry.getKey(), entry.getValue());
		}

		if (!requestPath.contains("/auth/")) {
			log.info("无需登录请求" + requestPath);
			return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
					.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
		}

		// 如果需要登录，校验token是否有效
		final String token = (String) request.getAttribute("token");
		if (StringUtils.isEmpty(token)) {
			return noLogin();
		}
		AtmTokenInfo atmTokenInfo = atmTokenRepository.findByToken(token);
		if (atmTokenInfo == null || atmTokenInfo.getUserInfo() == null) {
			return noLogin();
		}

		// 需要登录的交易，用户信息和token都放到request中。
		request.setAttribute(AtmConstant.USER, atmTokenInfo.getUserInfo());
		request.setAttribute(AtmConstant.LOCAL_TOKEN, atmTokenInfo.getToken());// 本地token
		request.setAttribute(AtmConstant.EXCHANGE_TOKEN, atmTokenInfo.getExchangeToken());// 交易所token

		log.info("用户交易所id：" + atmTokenInfo.getUserInfo().getId());
		log.info("用户本地token：" + atmTokenInfo.getToken());
		log.info("用户交易所extoken：" + atmTokenInfo.getExchangeToken());
		
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
	}

	public static void main(String[] args) {
//		System.out.print(new BigDecimal("0.12345678912345678984115").setScale(13,BigDecimal.ROUND_HALF_UP));
		 testRsaAndAes();
		// testSignature();

		// String
		// preSignature="termNo=4298123b3993642e3849ac3f56c62f99a&content=U2FsdGVkX19oV6VhoJoP/qfQEcmqev6akxs400ZmzEQS+BKDLY/SMqp/bF3SR6MmKIO33wKLq4GzVoMhkyH6lPbzK3A/mgBfVdPDDF9rpsYvbbzVDOpOcDxzcKJ8I4pzZs75iP3jADXDpSuYGacW1unB3y1LZw21J+EKwAx/LWhhi3In8ju3BFBbA9F/GGxb/Sp8oZWKHMmcb6f64IyutQ==&salt=yxkizqfgMv";
//		 afterSignature :1b59444f88ef91e9f3162362783e96ca
//		 signature :yxkizqfgMv1b59444f88ef91e9f3162362783e96ca
		 //System.out.println(MD5Util.getMD5("dc483e80a7a0bd9ef71d8cf973673924"));

	}

	public static void testRsaAndAes() {
		String termNo = "HAYEK00000001";
		String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCJJ5eYL4e8dB2zSPNA171GtLeiGYtndT1TFeOm3+BdnfQsxFaPmcrYU52QM7M0R6rI6CHluXes2TazMNKn3sNxqmJuISnZcA5/kBgkSM+LOqhD8MNwwAWLakX8p0YDIUc7HhIvpf/BpVimStmMqZJ1Tb3bbBd5T/QsHf3m8iSPmwIDAQAB";
		String aesKey = "20180819_key_dev";
		//获取二维码
//		String plain = "{}";
		// 发送短信验证码
//		String plain = "{\"account\":\"15356674556\",\"type\":\"1\",\"language\":\"1\"}";
		//String plain = "{\"account\":\"983412051@qq.com\",\"type\":\"2\",\"language\":\"1\"}";
		// 登陆
//		String plain = "{\"userName\":\"17342061645\",\"password\":\"9081720cdaf2afb2d88ef598a61c7a6d\",\"date\":\"20181008\"}";
		// 登录检测
//		String plain = "{\"phoneCode\":\"266115\",\"phoneToken\":\"6510EDC309E81AF72D440AEA8638ED200ED565B69EBF3B7F0553EC983CF80F82F15E7DC982FBA4D1F2E2BA08B282F64319714E79444E8BDE4D785B28EBA2A929\",\"userId\":\"7449\",\"date\":\"20181022\"}";
		// 获取资产列表
		// String plain = "{\"drawCurrency\":\"USD\",\"token\":\"72fee8e82f364dc099e102381f17b37d\"}";
		// 获取手续费
//		 String plain =  "{\"token\":\"d329223c1ea84aec8465896b53c2c447\",\"deductAndPrice\":\"BTC,44444.44;LTC,235.12\",\"drawCurrency\":\"USD\",\"drawMoney\":\"500\"}";
		//获取防重码
		//String plain = "{\"token\":\"72fee8e82f364dc099e102381f17b37d\"}";
		//取款
//		String plain = "{\"token\":\"0bed547691e44304bc668b784b7eba34\",\"captcha\":\"Q6x9\",\"deductCurrency\":\"BTC\",\"drawCurrency\":\"USD\",\"drawMoney\":\"400\",\"termSeq\":\"013345\",\"termDate\":\"2018-10-22\",\"password\":\"dc483e80a7a0bd9ef71d8cf973673924\",\"transFee\":\"0.012\",\"price\":\"7200.15\",\"coinId\":\"1\",\"toUsdt\":\"7203.51\"}";
		// 冲正
		//String plain =  "{\"token\":\"72fee8e82f364dc099e102381f17b37d\",\"termSeq\":\"013339\",\"oriTermSeq\":\"013339\",\"oriTermDate\":\"2018-10-08\",\"termDate\":\"2018-10-08\"}";
		// 二维码token获取登录token
		// String plain = "{\"qrcode\":\"8472e4d0640a498891b046ed51f54486&HAYEK00000037&isAtmQrcode\",\"date\":\"20180823\"}";
		// 吐钞结果通知
//		 String plain = "{\"oriTermSeq\":\"013333\",\"oriTermDate\":\"2018-10-08\",\"spitMoneyStatus\":\"0\",\"token\":\"72fee8e82f364dc099e102381f17b37d\",\"language\":\"1\"}";
		//通信检测
		//String plain = "{\"runningStatus\":\"0\",\"prrStatus\":\"1\",\"cimStatus\":\"0\",\"cdmStatus\":\"0\",\"prrPagerStatus\":\"0\",\"cdmCuInfo\":\"0\",\"dor\":\"0\"}";
		//对账
		String plain = "{\"batchNo\":\"12345678912345\",\"addAmt\":\"10000\",\"balanceAmt\":\"200\",\"drawBalanceAmt\":\"200\",\"depositBalanceAmt\":\"0\"," +
				"\"currencyCode\":\"CNY\",\"drawSucNum\":\"11\",\"drawSucAmt\":\"2000\"," +
				"\"drawFailNum\":\"30\",\"drawFailAmt\":\"2600\",\"drawUnkNum\":\"1\",\"drawUnkAmt\":\"100\",\"drawRevNum\":\"5\",\"drawRevAmt\":\"1100\"," +
				"\"depositSucNum\":\"0\",\"depositSucAmt\":\"0\",\"depositFailNum\":\"0\",\"depositFailAmt\":\"0\",\"depositUnkNum\":\"0\",\"depositUnkAmt\":\"0\"," +
				"\"drawUnkList\":[{\"termSeq\":\"002357\",\"termDate\":\"2018-09-19\",\"status\":\"3\"},{\"termSeq\":\"002491\",\"termDate\":\"2018-09-17\",\"status\":\"3\"}]" +
				"}";

		String secret = "";
		try {
			secret = AesUtils.aesEncryptToBase64String(plain, aesKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("内容经过aes加密后的密文：" + secret);

		try {
			String transKey = RSAUtil.encryptPlainToBase64(aesKey, RSAUtil.getPublicKey(publicKey));
			System.out.println("rsa公钥加密后的aes的密钥的密文：" + transKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String content = secret;
		String preSignature = "termNo="+termNo+"&content=" + content + "&salt=1234567890";

		// 验签
		String localSignature = MD5Util.getMD5(preSignature);
		localSignature = "1234567890" + localSignature;
		System.out.println(localSignature);

	}

	public static void testSignature() {
		String content = "U2FsdGVkX19hLNmkNpxWTDr7H69wq4gTvaaMv1g9dIejWfZI2UOJvfHZhDppreUgP7 ohiwcqzqooLpbnlJjK1LjF7CpPUb0fnq8M0tpH7/27T9CX8xnHAXFQHWkikHleOtwFFmdizeLF87RRKL5EB2EnRJ wO6QZfIohh kNMeN9GrlZIOPBWcjeIwqZAZWdKhJGhoAiZmQYkoa9kjIvA==";
		String preSignature = "termNo=HAYEK00000036&content=" + content + "&salt=4N0i8CpN9E";
		System.out.println(preSignature);
		// 验签
		String localSignature = MD5Util.getMD5(preSignature);
		localSignature = "4N0i8CpN9E" + localSignature;
		System.out.println(localSignature);
	}

	/**
	 * 验签失败
	 * 
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public JSONData validateFail() throws Exception {
		String code = EnumResponseMsg.RESP_ERROR_VALIDATE_FAIL.getCode();
		String msg = EnumResponseMsg.RESP_ERROR_VALIDATE_FAIL.getMsg();
		String plainContent = "{}";// json字符串明文
		String content = afterEncrypt(plainContent, null);// 加密

		String salt = getSalt();
		String preSignature = "code=" + code + "&content=" + content + "&salt=" + salt;// 待签名数据
		String signature = salt + MD5Util.getMD5(preSignature);

		return JSONData.builder().code(code).msg(msg).content(content).signature(signature).build();
	}
	
	/**
	 * 设备闲置
	 * 
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public JSONData equipmentUnused() throws Exception {
		String code = EnumResponseMsg.RESP_ERROR_EQUIPMENT_UNUSED.getCode();
		String msg = EnumResponseMsg.RESP_ERROR_EQUIPMENT_UNUSED.getMsg();
		String plainContent = "{}";// json字符串明文
		String content = afterEncrypt(plainContent, null);// 加密
		
		String salt = getSalt();
		String preSignature = "code=" + code + "&content=" + content + "&salt=" + salt;// 待签名数据
		String signature = salt + MD5Util.getMD5(preSignature);
		
		return JSONData.builder().code(code).msg(msg).content(content).signature(signature).build();
	}

	/**
	 * 参数为空
	 * 
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public JSONData paramEmpty() throws Exception {
		String code = EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getCode();
		String msg = EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getMsg();
		String plainContent = "{}";// json字符串明文
		String content = afterEncrypt(plainContent, null);// 加密

		String salt = getSalt();
		String preSignature = "code=" + code + "&content=" + content + "&salt=" + salt;// 待签名数据
		String signature = salt + MD5Util.getMD5(preSignature);

		return JSONData.builder().code(code).msg(msg).content(content).signature(signature).build();
	}

	/**
	 * 未登录
	 * 
	 * @return
	 * @throws Exception
	 */
	public JSONData noLogin() throws Exception {
		String code = EnumResponseMsg.RESP_ERROR_USER_NOT_LOGIN.getCode();
		String msg = EnumResponseMsg.RESP_ERROR_USER_NOT_LOGIN.getMsg();
		String plainContent = "{}";// json字符串明文
		String content = afterEncrypt(plainContent, null);// 加密

		String salt = getSalt();
		String preSignature = "code=" + code + "&content=" + content + "&salt=" + salt;// 待签名数据
		String signature = salt + MD5Util.getMD5(preSignature);

		return JSONData.builder().code(code).msg(msg).content(content).signature(signature).build();
	}

	/**
	 * 未找到该设备
	 * 
	 * @return
	 * @throws Exception
	 */
	public JSONData noFoundEquipment() throws Exception {
		String code = EnumResponseMsg.RESP_ERROR_EQUIPMENT_NULL.getCode();
		String msg = EnumResponseMsg.RESP_ERROR_EQUIPMENT_NULL.getMsg();
		String plainContent = "{}";// json字符串明文
		String content = afterEncrypt(plainContent, null);// 加密

		String salt = getSalt();
		String preSignature = "code=" + code + "&content=" + content + "&salt=" + salt;// 待签名数据
		String signature = salt + MD5Util.getMD5(preSignature);

		return JSONData.builder().code(code).msg(msg).content(content).signature(signature).build();
	}

	/**
	 * 系统错误
	 * 
	 * @return
	 * @throws Exception
	 */
	public JSONData err() throws Exception {
		String code = EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getCode();
		String msg = EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getMsg();
		String plainContent = "{}";// json字符串明文
		String content = afterEncrypt(plainContent, null);// 加密

		String salt = getSalt();
		String preSignature = "code=" + code + "&content=" + content + "&salt=" + salt;// 待签名数据
		String signature = salt + MD5Util.getMD5(preSignature);

		return JSONData.builder().code(code).msg(msg).content(content).signature(signature).build();
	}

	/**
	 * 
	 * @param result
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public JSONData encryption(JSONData result, HttpServletRequest request) throws Exception {
		String code = result.getCode();
		String msg = result.getMsg();
		Map<String, Object> data = (Map<String, Object>) result.getData();

		String plainContent = "{}";// 默认json字符串明文
		if (data != null) {
			plainContent = JSONObject.toJSONString(data);// map转json字符串明文
		}
		log.info("返回错误码="+code);
		log.info("返回错误信息="+msg);
		log.info("返回出参明文content=" + plainContent);
		String content = afterEncrypt(plainContent, (String) request.getAttribute(AtmConstant.AES_KEY));// 加密

		String salt = getSalt();
		String preSignature = "code=" + code + "&content=" + content + "&salt=" + salt;// 待签名数据
		String signature = salt + MD5Util.getMD5(preSignature);

		return JSONData.builder().code(code).msg(msg).content(content).signature(signature).build();
	}

	/**
	 * 获取10位salt
	 * 
	 * @return
	 */
	private static String getSalt() {
		int n = 10;
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

	public String afterEncrypt(String plainContent, String aesKey) throws Exception {
		if (StringUtils.isEmpty(aesKey)) {
			return plainContent;
		} else {
			try {
				return AesUtils.aesEncryptToBase64String(plainContent, aesKey);
			} catch (Exception e) {
				log.info(LogUtils.getExceptionInfo(e));
				throw e;
			}
		}

	}

}
