package com.tomcat360.gateway.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.tomcat360.gateway.LocalCache;
import com.tomcat360.gateway.Token;
import com.tomcat360.gateway.properties.AppProperties;
import com.tomcat360.gateway.util.AesUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 请求过滤器
 * 
 * 对APP请求
 * 	1.以“/Api-App/”路由到APP的服务端App-Service，需要校验token
 * 	2.包含“/auth/” 的请求是需要校验token的
 * 	3.其他的请求为安全请求
 * 
 * @author 秦瑞华
 *
 */
@Slf4j
@Component
public class PreRequestFilter extends ZuulFilter {
	private @Autowired AppProperties appProperties;
	private String BigFile = "http://download.springsource.com/release/STS/3.9.1.RELEASE/dist/e4.7/spring-tool-suite-3.9.1.RELEASE-e4.7.1a-win32-x86_64.zip";

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		long start = System.currentTimeMillis();
		RequestContext ctx = RequestContext.getCurrentContext();
		ctx.getResponse().setContentType("text/html;charset=UTF-8"); //解决中文乱码问题
		HttpServletRequest request = ctx.getRequest();
		
		
		long now = System.currentTimeMillis();
    	
		String requestPath = request.getServletPath();


    	/*
    	 * Atm接口
    	 */
    	if(isAtm(requestPath)) {
            String ip = request.getHeader("x-forwarded-for");
//            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//                ip = request.getHeader("Proxy-Client-IP");
//            } else if (ip.contains(",")) {
//                ip = ip.split(",")[0];
//            }
//            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//                ip = request.getHeader("WL-Proxy-Client-IP");
//            }
//            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//                ip = request.getRemoteAddr();
//            }
    		log.info(String.format("ip=%s, req=%s", ip, requestPath));
//    		if(!StringUtils.isEmpty(ip)) {
//    			//IP黑名单检测
//        		boolean hitBlackIP = LocalCache.hitBlackIP(ip);
//        		if(hitBlackIP) {
//            		log.error(String.format("命中IP黑名单, ip=%s, req=%s", ip, requestPath));
//            		blackResponseBody(ctx);
//            		return null;
//        		}
//    		}
//
//    		/*
//    		 * 1.安全请求检测
//    		 * 不包含/auth/的请求为安全请求
//    		 */
//    		if(!requestPath.contains("/auth/")) {
//    			log.info("安全请求"+requestPath);
//    			return null;
//    		}
//
//			log.info("请求="+requestPath);
//    		/*
//    		 * 2.过滤重复请求
//    		 * path+parameters+headers
//    		 */
////    		StringBuilder parameters = new StringBuilder();
////    		Enumeration<String> parameterNames = request.getParameterNames();
////    		while(parameterNames.hasMoreElements()) {
////    			String pKey = parameterNames.nextElement();
////    			String pValue = request.getParameter(pKey);
////    			parameters.append(pKey).append("=").append(pValue).append(",");
////    		}
////    		StringBuilder headersStr = new StringBuilder();
////    		Enumeration<String> headers = request.getHeaderNames();
////    		while(headers.hasMoreElements()) {
////    			String headerName = headers.nextElement();
////    			if(Sets.newHashSet("cache-control").contains(headerName)) {
////    				continue;
////    			}
////    			String headerValue = request.getHeader(headerName);
////    			headersStr.append(headerName).append("=").append(headerValue).append(",");
////    		}
////    		String req = requestPath +"|" + parameters +"|" + headersStr.toString();
////        	if(LocalCache.repeatRequest(req)) {
////        		log.error("重复请求,req="+req);
////        		repeatResponseBody(ctx);
////        		return null;
////        	}
//
//        	/*
//        	 * 3.是否登录
//        	 */
//    		String token = request.getHeader("token");
//    		
//    		//解密token
//    		Token tokenOk = decryptToken(token);
//    		if(tokenOk == null || tokenOk.getId() == null || tokenOk.getId() < 0) {
//        		log.error("无效token");
//    			unloginResponseBody(ctx);
//        		return null;
//    		}
//			//Token有效期验证
//    		Long loginTime = tokenOk.getLoginTime();
//    		if(loginTime == null || (now - loginTime) >= appProperties.getTokenDay()*1L*24*60*60*1000) {
//        		log.error("token已失效，请重新登录");
//    			unloginResponseBody(ctx);
//        		return null;
//    		}
//    		
//    		
//			//将userId传递给App-Service
//			ctx.addZuulRequestHeader("userId", tokenOk.getId()+"");
//    		ctx.addZuulRequestHeader("vr", request.getHeader("vr")+""); //当前app的版本信息
//			ctx.addZuulRequestHeader("pf", request.getHeader("pf")+""); //当前app的平台
//
			long end = System.currentTimeMillis();
			log.info("Atm路由检测完毕，use="+(end-start));
    	}else if(isAdmin(requestPath)||isThird(requestPath)){
            String ip = request.getHeader("x-forwarded-for");
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            } else if (ip.contains(",")) {
                ip = ip.split(",")[0];
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
    		log.info(String.format("ip=%s, req=%s", ip, requestPath));
    		if(!StringUtils.isEmpty(ip)) {
    			//IP黑名单检测
        		boolean hitBlackIP = LocalCache.hitBlackIP(ip);
        		if(hitBlackIP) {
            		log.error(String.format("命中IP黑名单, ip=%s, req=%s", ip, requestPath));
            		blackResponseBody(ctx);
            		return null;
        		}
    		}

    		/*
    		 * 1.安全请求检测
    		 * 不包含/auth/的请求为安全请求
    		 */
    		if(!requestPath.contains("/auth/")) {
    			log.info("安全请求"+requestPath);
    			return null;
    		}

			log.info("请求="+requestPath);
    		/*
    		 * 2.过滤重复请求
    		 * path+parameters+headers
    		 */
//    		StringBuilder parameters = new StringBuilder();
//    		Enumeration<String> parameterNames = request.getParameterNames();
//    		while(parameterNames.hasMoreElements()) {
//    			String pKey = parameterNames.nextElement();
//    			String pValue = request.getParameter(pKey);
//    			parameters.append(pKey).append("=").append(pValue).append(",");
//    		}
//    		StringBuilder headersStr = new StringBuilder();
//    		Enumeration<String> headers = request.getHeaderNames();
//    		while(headers.hasMoreElements()) {
//    			String headerName = headers.nextElement();
//    			if(Sets.newHashSet("cache-control").contains(headerName)) {
//    				continue;
//    			}
//    			String headerValue = request.getHeader(headerName);
//    			headersStr.append(headerName).append("=").append(headerValue).append(",");
//    		}
//    		String req = requestPath +"|" + parameters +"|" + headersStr.toString();
//        	if(LocalCache.repeatRequest(req)) {
//        		log.error("重复请求,req="+req);
//        		repeatResponseBody(ctx);
//        		return null;
//        	}

        	/*
        	 * 3.是否登录
        	 */
    		String token = request.getHeader("token");
    		
    		//解密token
    		Token tokenOk = decryptToken(token);
    		if(tokenOk == null || tokenOk.getId() == null || tokenOk.getId() < 0) {
        		log.error("无效token");
    			unloginResponseBody(ctx);
        		return null;
    		}
			//Token有效期验证
    		Long loginTime = tokenOk.getLoginTime();
    		if(loginTime == null || (now - loginTime) >= appProperties.getTokenDay()*1L*24*60*60*1000) {
        		log.error("token已失效，请重新登录");
    			unloginResponseBody(ctx);
        		return null;
    		}
    		
    		
			//将userId传递给App-Service
			ctx.addZuulRequestHeader("userId", tokenOk.getId()+"");
			ctx.addZuulRequestHeader("userName", tokenOk.getUsername()+"");
    		ctx.addZuulRequestHeader("vr", request.getHeader("vr")+""); //当前app的版本信息
			ctx.addZuulRequestHeader("pf", request.getHeader("pf")+""); //当前app的平台

			long end = System.currentTimeMillis();
			log.info("App路由检测完毕，use="+(end-start));
    	}
    	
    	
    	
        return null;
	}

	/**
	 * 是Atm请求
	 * 
	 * @param pathInfo
	 * @return
	 */
	private boolean isAtm(String pathInfo) {
		return pathInfo.indexOf("/Api-Atm/") == 0;
	}
	
	/**
	 * 是后台管理平台的请求
	 * 
	 * @param pathInfo
	 * @return
	 */
	private boolean isAdmin(String pathInfo) {
		return pathInfo.indexOf("/Api-Admin/") == 0;
	}
	
	/**
	 * 是第三方平台的请求
	 * 
	 * @param pathInfo
	 * @return
	 */
	private boolean isThird(String pathInfo) {
		return pathInfo.indexOf("/Api-Third/") == 0;
	}

	/**
	 * 解密Token
	 * 
	 * @param token
	 * @return userId
	 */
	private Token decryptToken(String token) {
		if(StringUtils.isEmpty(token)) {
			return null;
		}
		
		String tokenKey = appProperties.getTokenKey();
		try {
			String tokenOk = AesUtils.aesDecryptHexString(token, tokenKey);
			Token tk = JSONObject.parseObject(tokenOk, Token.class);
			return tk;
		} catch (Exception e) {
			log.error(String.format("token解密失败：token=%s", token));

			return null;
		}
	}
	


	/**
	 * 请求异常responseBody
	 */
	@SuppressWarnings("unused")
	private void errorResponseBody(RequestContext ctx) {
        ctx.setResponseStatusCode(HttpServletResponse.SC_OK);
        if (ctx.getResponseBody() == null) {
            ctx.setResponseBody("");
            ctx.setSendZuulResponse(false);
        }
	}
	
	/**
	 * 重复请求responseBody
	 */
	@SuppressWarnings("unused")
	private void repeatResponseBody(RequestContext ctx) {
        ctx.setResponseStatusCode(HttpServletResponse.SC_OK);
        if (ctx.getResponseBody() == null) {
            ctx.setResponseBody("{\"code\":\"9997\",\"msg\":\"操作频繁，请稍候再操作\",\"data\":{}}");
            ctx.setSendZuulResponse(false);
        }
        
        HttpServletResponse response = ctx.getResponse();
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setLocale(new java.util.Locale("zh","CN"));
	}

	/**
	 * 未登录responseBody
	 */
	private void unloginResponseBody(RequestContext ctx) {
        ctx.setResponseStatusCode(HttpServletResponse.SC_OK);
        if (ctx.getResponseBody() == null) {
            ctx.setResponseBody("{\"code\":\"9998\",\"msg\":\"用户未登录\",\"data\":{}}");
            ctx.setSendZuulResponse(false);
        }
        
        HttpServletResponse response = ctx.getResponse();
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setLocale(new java.util.Locale("zh","CN"));
	}

	/**
	 * 黑名单请求responseBody
	 */
	private void blackResponseBody(RequestContext ctx) {
		try {
			ctx.getResponse().sendRedirect(BigFile);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
	}
}
