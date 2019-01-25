package com.tomcat360.atm.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//import java.io.OutputStream;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.Random;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.catalina.connector.CoyoteOutputStream;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import com.alibaba.fastjson.JSONObject;
//import com.tomcat360.atm.constant.AtmConstant;
//import com.tomcat360.atm.enums.EnumResponseMsg;
//import com.tomcat360.atm.model.TbEquipmentSettings;
//import com.tomcat360.atm.model.redis.AtmTokenInfo;
//import com.tomcat360.atm.repository.AtmTokenRepository;
//import com.tomcat360.atm.service.TbEquipmentSettingsService;
//import com.tomcat360.atm.util.MD5Util;
//
//import lombok.extern.slf4j.Slf4j;

/**
 * token鉴权拦截器
 * 用来拦截所有需要登录校验的请求，如果没有token，或者根据token没有找到用户信息，则返回未登录
 */
//@Component
//@Slf4j
public class RequestInterceptor extends HandlerInterceptorAdapter {

//    @Autowired
//    private AtmTokenRepository atmTokenRepository;
//    
//    @Autowired
//    private TbEquipmentSettingsService tbEquipmentSettingsService;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//    	//解析入参
//    	String termNo = request.getHeader("termNo");
//    	String signature = request.getHeader("signature");
//    	
//    	String content = request.getParameter("content");//json字符串密文
//    	String key = request.getParameter("key");//堆成密钥，经过rsa公钥加密后的密文
//    	
//    	if(StringUtils.isEmpty(termNo)||StringUtils.isEmpty(signature)||StringUtils.isEmpty(content)||StringUtils.isEmpty(key)){
//    		paramEmpty(response);
//    		return false;
//    	}
//    	
//    	String saltKey = signature.substring(0,10);//获取salt
//    	String preSignature = "termNo="+termNo+"&content="+content+"&salt="+saltKey;
//    	
//    	//验签
//    	String localSignature = MD5Util.getMD5(preSignature);
//    	localSignature = saltKey + localSignature;
//    	if(!localSignature.equals(signature)){
//    		validateFail(response);
//    		return false;
//    	}
//    	
//    	//解密content
//    	//查询私钥
//    	TbEquipmentSettings tbEquipmentSettings = tbEquipmentSettingsService.find(termNo);
//    	//String privateKey = tbEquipmentSettings.getPrivateKey();
//    	//将密文解密成明文json字符串
//    	String plainContent = content;
////    	RSAUtil.decryptToString(content.getBytes(), privateKey);
//    	
//    	
//    	//将json字符串转成map，并将相关数据放到request中。
//    	Map<String,Object> contentMap =  JSONObject.parseObject(plainContent);
//		for(Entry<String,Object> entry :contentMap.entrySet() ){
//			request.setAttribute(entry.getKey(), entry.getValue());
//		}
//    	
//    	String requestPath = request.getServletPath();
//    	
//    	if(!requestPath.contains("/auth/")) {
//			log.info("安全请求"+requestPath);
//			return true;
//		}
//    	
//    	//如果需要登录，我再
//    	
//        final String token = (String)request.getAttribute("token");
//        if(StringUtils.isEmpty(token)){
//        	noLogin(response);
//        	return false;
//        }
//        AtmTokenInfo atmTokenInfo = atmTokenRepository.findByToken(token);
//        if(atmTokenInfo == null||atmTokenInfo.getUserInfo() == null){
//        	noLogin(response);
//			return false;
//        }
//        
//        
//        
//        //需要登录的交易，用户信息和token都放到request中。
//        request.setAttribute(AtmConstant.USER, atmTokenInfo.getUserInfo());
//        request.setAttribute(AtmConstant.LOCAL_TOKEN, atmTokenInfo.getToken());//本地token
//        request.setAttribute(AtmConstant.EXCHANGE_TOKEN, atmTokenInfo.getExchangeToken());//交易所token
//        
//        
//        
//        return true;
//    }
//    
//    
//    
//    @Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//    	System.out.println(modelAndView);
//    	OutputStream  os = response.getOutputStream();
//    	
//    	CoyoteOutputStream cos = (CoyoteOutputStream)os;
//    	
//    	System.out.println(os.toString());
//    	
//    	
//		super.postHandle(request, response, handler, modelAndView);
//	}
//
//
//
//	public HttpServletResponse noLogin(HttpServletResponse response) throws Exception{
//    	response.addHeader("Access-Control-Allow-Origin", "*");
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        response.setLocale(new java.util.Locale("zh","CN"));
//        String str = "{\"code\":\""+EnumResponseMsg.RESP_ERROR_USER_NOT_LOGIN.getCode()
//        +"\",\"msg\":\""+EnumResponseMsg.RESP_ERROR_USER_NOT_LOGIN.getMsg()
//        +"\",\"data\":{}}";
//        response.getWriter().println(str);
//        return response;
//    }
//    
//	/**
//	 * 验签失败
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//    public HttpServletResponse validateFail(HttpServletResponse response) throws Exception{
//    	response.addHeader("Access-Control-Allow-Origin", "*");
//    	response.setContentType("application/json");
//    	response.setCharacterEncoding("UTF-8");
//    	response.setLocale(new java.util.Locale("zh","CN"));
//    	String str = "{\"code\":\""+EnumResponseMsg.RESP_ERROR_VALIDATE_FAIL.getCode()
//    	+"\",\"msg\":\""+EnumResponseMsg.RESP_ERROR_VALIDATE_FAIL.getMsg()
//    	+"\",\"data\":{}}";
//    	response.getWriter().println(str);
//    	return response;
//    }
//    
//    /**
//     * 参数为空
//     * @param response
//     * @return
//     * @throws Exception
//     */
//    public HttpServletResponse paramEmpty(HttpServletResponse response) throws Exception{
//    	response.addHeader("Access-Control-Allow-Origin", "*");
//    	response.setContentType("application/json");
//    	response.setCharacterEncoding("UTF-8");
//    	response.setLocale(new java.util.Locale("zh","CN"));
//    	String str = "{\"code\":\""+EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getCode()
//    	+"\",\"msg\":\""+EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getMsg()
//    	+"\",\"data\":{}}";
//    	response.getWriter().println(str);
//    	return response;
//    }
//    
    
}
