package com.tomcat360.gateway.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * 本应用的自定义参数
 * 
 * @author 秦瑞华
 *
 */
@Data
@ConfigurationProperties(prefix = "appConfig")
public class AppProperties {
	private String appName;
	private String appNameCn;
	
	private String tokenKey;	//Token加解密秘钥
	private Integer tokenDay;	//Token有效期，单位：天
}

