package com.tomcat360.atm.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * 本应用的自定义参数
 * 
 * 
 *
 */
@Data
@ConfigurationProperties(prefix = "appConfig")
public class AppProperties {
	private String appName;
	private String appNameCn;
	private String tokenKey;
	private String baseUrl;
	private String noauthBaseUrl;
	private String accessKey;
	private String secretKey;

	private String androidUrl;
	private String iosUrl;
}
