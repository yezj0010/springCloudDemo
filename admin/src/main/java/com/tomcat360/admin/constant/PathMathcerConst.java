package com.tomcat360.admin.constant;

public class PathMathcerConst {

    public static final String[] STATICS = new String[] {"/**/*.js", "/**/*.css", "/**/*.jpg", "/**/*.png", "/**/*.woff", "/webjars/**"};
    // swagger相关路径
    public static final String[] SWAGGER = new String[] {"/swagger-ui.html","/swagger*","/swagger-resources/**","/v2/api-docs/**"};

    public static final String AUTH_API_ENTRY_POINT = "/auth/**";

    public static final String API_ENTRY_POINT = "/**";
}