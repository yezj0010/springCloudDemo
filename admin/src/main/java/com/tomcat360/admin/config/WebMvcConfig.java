package com.tomcat360.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.tomcat360.admin.constant.PathMathcerConst;
import com.tomcat360.admin.interceptor.UserStatusInterceptor;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Autowired
    private UserStatusInterceptor userStatusInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 添加请求鉴权拦截器
         */
        registry.addInterceptor(userStatusInterceptor)
                .addPathPatterns(PathMathcerConst.AUTH_API_ENTRY_POINT);
                //.excludePathPatterns(PathMathcerConst.API_ENTRY_POINT);
        super.addInterceptors(registry);
    }
}
