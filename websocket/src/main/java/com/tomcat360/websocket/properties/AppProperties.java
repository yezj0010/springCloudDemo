package com.tomcat360.websocket.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * 自定义参数
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

