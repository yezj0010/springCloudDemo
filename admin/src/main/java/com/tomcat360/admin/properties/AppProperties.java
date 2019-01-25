package com.tomcat360.admin.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * 自定义参数
 *
 */
@Data
@ConfigurationProperties(prefix = "appConfig")
public class AppProperties {
	private String appName;
	private String appNameCn;
	
	private String tokenKey;    //加密秘钥
	private Integer tokenDay;	//Token有效期，单位：天
	private String logPath;
	private String snapPath;

	private String noauthBaseUrl;
	private String merchantNo;
	private String accessKey;
	private String secretKey;
	private String versionFilePath;
	private String resourcePath;
	private String timeZone;
	private String GMTTimeZone;
}

