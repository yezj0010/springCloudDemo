package com.tomcat360.atm.config;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//import com.tomcat360.atm.constant.PathMathcerConst;
//import com.tomcat360.atm.interceptor.RequestInterceptor;

//@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

//    @Autowired
//    private RequestInterceptor requestInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 添加请求鉴权拦截器
         */
//        registry.addInterceptor(requestInterceptor)
//                .addPathPatterns(PathMathcerConst.AUTH_API_ENTRY_POINT);
        super.addInterceptors(registry);
    }
}
