package com.tomcat360.atm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tomcat360.atm.aspect.UserLog;
import com.tomcat360.atm.enums.EnumResponseMsg;
import com.tomcat360.atm.model.JSONData;
import com.tomcat360.atm.service.ExchangeService;

@RestController
@RequestMapping("/api")
public class loginController {

	@Autowired
	private ExchangeService exchangeService;

	/**
	 * 获取二维码
	 * @param request
	 * @return
	 */
	@UserLog(interfaceCode = "/api/getQRCode", interfaceDesc = "获取二维码")
	@RequestMapping("/getQRCode")
	public JSONData getQuickResponse(HttpServletRequest request) {
		String termNo = (String) request.getAttribute("termNo");
		//调用交易所获取二维码登录接口
		return exchangeService.getQRCode(termNo);
	}

	/**
	 *  二维码登陆接口，根据二维码获取token
	 * @param request
	 * @return
	 */
	@UserLog(interfaceCode = "/api/loginByQRCode", interfaceDesc = "二维码登录，根据二维码获取token")
	@RequestMapping("/loginByQRCode")
	public JSONData loginByQRCode(HttpServletRequest request) {
		String qrtoken = (String)request.getAttribute("qrcode");
		String date = (String)request.getAttribute("date");
		if (StringUtils.isEmpty(qrtoken) || StringUtils.isEmpty(date)) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getMsg()).build();
		}
		//调用交易所根据二维码获取token接口
		return exchangeService.loginByQRCode(request, qrtoken,date);
	}

	/**
	 * 用户登陆接口，仅仅校验用户密码，只返回用户id
	 * @param request
	 * @return
	 */
	@UserLog(interfaceCode = "/api/login", interfaceDesc = "用户名密码登录，只返回用户id")
	@RequestMapping("/login")
	public JSONData login(HttpServletRequest request) {
		String userName = (String)request.getAttribute("userName");
		String password = (String)request.getAttribute("password");
		String date = (String)request.getAttribute("date");
		if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)||
				StringUtils.isEmpty(date)) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getMsg()).build();
		}
		
		return exchangeService.login(request,userName, password);
	}

	/**
	 * 发送验证码
	 * @param request
	 * @return
	 */
	@UserLog(interfaceCode = "/api/sendValidateMsg", interfaceDesc = "发送验证码")
	@RequestMapping("/sendValidateMsg")
	public JSONData sendValidateMsg(HttpServletRequest request) {
		String account = (String)request.getAttribute("account");
		String type = (String)request.getAttribute("type");
		String language = (String)request.getAttribute("language")==null?"1":(String)request.getAttribute("language");//界面语言 null或1-中国  2-其他
		
		if (StringUtils.isEmpty(account) || StringUtils.isEmpty(type)) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getMsg()).build();
		}
		// 发送短信验证码
		return exchangeService.sendValidateMsg(account, type, language);
	}
	
	/**
	 * 登录校验,成功才会真正返回token
	 * @param request
	 * @return
	 */
	@UserLog(interfaceCode = "/api/loginCheck", interfaceDesc = "登录校验，成功返回token")
	@RequestMapping("/loginCheck")
	public JSONData loginCheck(HttpServletRequest request) {
		String googleCode = (String)request.getAttribute("googleCode");//谷歌验验证码1
		String phoneCode = (String)request.getAttribute("phoneCode");//手机验证码2
		String phoneToken = (String)request.getAttribute("phoneToken");//手机token2
		String emailCode = (String)request.getAttribute("emailCode");//邮箱验证码3
		String emailToken = (String)request.getAttribute("emailToken");//邮箱token3
		String userId = (String)request.getAttribute("userId");//用户id
		String date = (String)request.getAttribute("date");//yyyyMMdd
		
		if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(date) ) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getMsg()).build();
		}
		if(StringUtils.isEmpty(googleCode) && 
				StringUtils.isEmpty(phoneCode) && 
				StringUtils.isEmpty(emailCode)){
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getMsg()).build();
		}
		if(!StringUtils.isEmpty(phoneCode)&&StringUtils.isEmpty(phoneToken)){
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getMsg()).build();
		}
		if(!StringUtils.isEmpty(emailCode)&&StringUtils.isEmpty(emailToken)){
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getMsg()).build();
		}
		
		// 发送短信验证码
		return exchangeService.loginCheck(request);
	}

}
