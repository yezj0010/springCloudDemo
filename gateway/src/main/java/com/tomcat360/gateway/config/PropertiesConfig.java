package com.tomcat360.gateway.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义Properties配置
 * 
 * @author 秦瑞华
 *
 */
@EnableConfigurationProperties({com.tomcat360.gateway.properties.AppProperties.class})
@Configuration
public class PropertiesConfig {
	
}
