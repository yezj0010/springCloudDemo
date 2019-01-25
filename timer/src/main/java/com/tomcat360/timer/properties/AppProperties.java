package com.tomcat360.timer.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * 自定义配置
 * 
 * @author 秦瑞华
 *
 */
@Data
@ConfigurationProperties(prefix = "appConfig")
public class AppProperties {
	private String appName;
	private String appNameCn;
}

