package com.tomcat360.third.util;

import com.tomcat360.third.interceptor.OkHttpLogInterceptor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * HTTP 请求工具
 *
 * @author
 */
@Slf4j
public class HttpUtil {

    /**
     * MIME type definition.
     */
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final MediaType FILE = MediaType.parse("multipart/form-data");

    private static OkHttpClient client = new OkHttpClient();

    static {
        Long connectTimeout = null;
        Integer maxIdleConnections = null;
        Long keepAliveDuration = null;
        Boolean trustAllHttps = null;
        Boolean enableHttpLogging = null;

        /**
         * try to load configuration for OkHttp.
         */
        try {
            InputStream inputStream = ClassLoader.getSystemResourceAsStream("http.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            try {
                connectTimeout = Long.valueOf(properties.getProperty("connectTimeout"));
            } catch (Exception e) {
                connectTimeout = null;
            }
            try {
                maxIdleConnections = Integer.valueOf(properties.getProperty("maxIdleConnections"));
            } catch (Exception e) {
                maxIdleConnections = null;
            }
            try {
                keepAliveDuration = Long.valueOf(properties.getProperty("keepAliveDuration"));
            } catch (Exception e) {
                keepAliveDuration = null;
            }
            try {
                trustAllHttps = Boolean.valueOf(properties.getProperty("trustAllHttps"));
            } catch (Exception e) {
                trustAllHttps = null;
            }
            try {
                enableHttpLogging = Boolean.valueOf(properties.getProperty("enableHttpLogging"));
            } catch (Exception e) {
                enableHttpLogging = null;
            }
        } catch (Exception e) {
            log.info("OkHttp使用默认配置。",e);
        }
        ConnectionPool connectionPool;
        // using default connection pool config unless maxIdleConnections and keepAliveDuration are both configured.
        if (!ObjectUtils.isEmpty(maxIdleConnections) && !ObjectUtils.isEmpty(keepAliveDuration)) {
            connectionPool = new ConnectionPool(maxIdleConnections, keepAliveDuration, TimeUnit.MINUTES);
            client = client.newBuilder().connectionPool(connectionPool).build();
        }
        // timeout config.
        if (!ObjectUtils.isEmpty(connectTimeout)) {
            client = client.newBuilder().connectTimeout(connectTimeout, TimeUnit.MINUTES).build();
        }
        // trust all cert if trustAllHttps is true.
        if (!ObjectUtils.isEmpty(trustAllHttps) && trustAllHttps) {
            SSLSocketFactory sslSocketFactory = createTrustAllSSLSocketFactory();
            if (!ObjectUtils.isEmpty(sslSocketFactory)) {
                client = client.newBuilder().sslSocketFactory(sslSocketFactory).build();
            } else {
                log.info("创建自定义SSL socket失败，回到默认设置。");
            }
            client = client.newBuilder().hostnameVerifier((s, sslSession) -> true).build();
        }
        // disable http logging if enableHttpLogging is false.
        if(ObjectUtils.isEmpty(enableHttpLogging) || !enableHttpLogging){
            client = client.newBuilder().addInterceptor(new OkHttpLogInterceptor()).build();
        }
    }

    private static SSLSocketFactory createTrustAllSSLSocketFactory() {
        SSLSocketFactory sslSocketFactory = null;
        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(
                    null,
                    new TrustManager[]{new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                        }

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[0];
                        }
                    }},
                    new SecureRandom()
            );
            sslSocketFactory = sslContext.getSocketFactory();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        return sslSocketFactory;
    }

    private static String paramsMapToStr(Map<String, Object> params) {
        StringBuilder paramBuilder = new StringBuilder();
        if (params != null && params.size() > 0) {
            params.forEach((k, v) -> paramBuilder.append("&").append(k).append("=").append(v));
        }
        return paramBuilder.toString();
    }


    public static String doGet(String url) {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Cache-Control", "no-cache")
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            log.error("【请求:{} 时出现网络异常】", url);
        }
        if (response.isSuccessful()) {
            try {
                return response.body().string();
            } catch (IOException e) {
                log.error("【解析:{} 的responseBody失败】", url);
            }
        }
        return "";
    }

    public static String doGet(String url, Map<String, Object> params) {
        String paramStr = paramsMapToStr(params);
        String okUrl = url + ((url.indexOf("?") != -1) ? paramStr : ("?" + paramStr));

        Request request = new Request.Builder()
                .url(okUrl)
                .addHeader("Cache-Control", "no-cache")
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            log.error("【请求:{} 时出现网络异常】", url);
        }
        if (response.isSuccessful()) {
            try {
                return response.body().string();
            } catch (IOException e) {
                log.error("【解析:{} 的responseBody失败】", url);
            }
        }
        return "";
    }

    public static String doPost(String url, Map<String, Object> form) {
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        if (form != null) {
            form.forEach((name, value) -> {
                if (StringUtils.isEmpty(name) || StringUtils.isEmpty(value)) {
                    return;
                }
                formBodyBuilder.add(name, value.toString());
            });
        }
        FormBody formBody = formBodyBuilder.build();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Cache-Control", "no-cache")
                .post(formBody)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            log.error("【请求:{} 时出现网络异常】", url);
        }
        if (response.isSuccessful()) {
            try {
                return response.body().string();
            } catch (IOException e) {
                log.error("【解析:{} 的responseBody失败】", url);
            }
        }
        return "";
    }

    public static String doPost(String url, String json) {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Cache-Control", "no-cache")
                .post(body)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            log.error("【请求:{} 时出现网络异常】", url);
        }
        if (response.isSuccessful()) {
            try {
                return response.body().string();
            } catch (IOException e) {
                log.error("【解析:{} 的responseBody失败】", url);
            }
        }
        return "";
    }

    public static void doAsyncGet(String url, Callback callback) {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Cache-Control", "no-cache")
                .build();
        client.newCall(request).enqueue(callback);
    }

    public static void doAsyncGet(String url, Map<String, Object> params, Callback callback) {
        String paramStr = paramsMapToStr(params);
        String okUrl = url + ((url.indexOf("?") != -1) ? paramStr : ("?" + paramStr));

        Request request = new Request.Builder()
                .url(okUrl)
                .build();
        client.newCall(request).enqueue(callback);
    }

    public static void doAsyncPost(String url, String json, Callback callback) {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Cache-Control", "no-cache")
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }
}
