package com.tomcat360.admin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.tomcat360.admin.cache.PermissionCache;
import com.tomcat360.admin.constant.AdminConstant;
import com.tomcat360.admin.enums.EnumResponseMsg;
import com.tomcat360.admin.model.TbAdminUser;
import com.tomcat360.admin.service.AdminUserService;

/**
 * 用户状态拦截器
 */
@Component
public class UserStatusInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private AdminUserService adminUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        TbAdminUser adminUser = adminUserService.findById(Long.parseLong(request.getHeader("userId")));
        //判断用户是否存在 
        if(adminUser == null){
        	response.addHeader("Access-Control-Allow-Origin", "*");
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        response.setLocale(new java.util.Locale("zh","CN"));
	        String str = "{\"code\":\"1000\",\"msg\":\"用户不存在\",\"data\":{}}";
	        response.getWriter().println(str);
			return false;
        }
        //判断用户状态
		if(!"0".equals(adminUser.getStatus())){//0 正常  1-停用
			response.addHeader("Access-Control-Allow-Origin", "*");
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        response.setLocale(new java.util.Locale("zh","CN"));
	        String str = "{\"code\":\"1012\",\"msg\":\"您当前账号已被停用\",\"data\":{}}";
	        response.getWriter().println(str);
			return false;
		}
		
		//判断有没有操作此项的权限
		String requestPath = request.getServletPath();
		requestPath = requestPath.substring(requestPath.indexOf("/auth"));
		if(!PermissionCache.checkPermission(adminUser.getRoleId(), requestPath)){
			response.addHeader("Access-Control-Allow-Origin", "*");
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        response.setLocale(new java.util.Locale("zh","CN"));
	        String code = EnumResponseMsg.RESP_ERROR_PERMISSION_NOT_ENOUGH.getCode();
	        String msg = EnumResponseMsg.RESP_ERROR_PERMISSION_NOT_ENOUGH.getMsg();
	        String str = "{\"code\":\""+code+"\",\"msg\":\""+msg+"\",\"data\":{}}";
	        response.getWriter().println(str);
			return false;
		}
		
		request.setAttribute(AdminConstant.ADMIN, adminUser);
        
		return true;

    }
}
