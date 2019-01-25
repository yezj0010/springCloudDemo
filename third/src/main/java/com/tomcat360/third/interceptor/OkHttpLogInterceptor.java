package com.tomcat360.third.interceptor;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import okio.Buffer;

import java.io.IOException;

/**
 * OkHTTP 日志打印拦截器
 *
 * @author
 */
@Slf4j
public class OkHttpLogInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        long startTime = System.currentTimeMillis();
        Response response = chain.proceed(request);
        long endTime = System.currentTimeMillis();
        final long duration = endTime - startTime;
        final String url = request.url().toString();
        final String method = request.method();
        Buffer buffer = new Buffer();
        if(request.body() != null){
        	 request.body().writeTo(buffer);
        }
        final String requestBody = buffer.readUtf8();
        final MediaType mediaType = response.body().contentType();
        final String responseBody = response.body().string();

        log.info("OKHttp use:{}, Request url:{}, Request body:{}, Response body:{}", duration, url,
                requestBody.length() < 3000 ? requestBody : "requestBody too large",
                responseBody.length() < 5000 ? responseBody : "responseBody too large");
        return response.newBuilder()
                .body(ResponseBody.create(mediaType, responseBody))
                .build();
    }
}
