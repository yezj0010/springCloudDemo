package com.tomcat360.admin;

import java.util.Properties;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.github.pagehelper.PageHelper;

/**
 * 后台管理子服务
 */

@EnableScheduling
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHystrix
@SpringBootApplication
@EnableFeignClients
@MapperScan("com.tomcat360.admin.mapper")
public class AdminServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminServiceApplication.class, args);
	}
	
	 @Bean
	 public PageHelper pageHelper(){
	     PageHelper pageHelper = new PageHelper();
	     Properties properties = new Properties();
	     properties.setProperty("offsetAsPageNum","true");
	     properties.setProperty("rowBoundsWithCount","true");
	     properties.setProperty("reasonable","true");
	     properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
	     pageHelper.setProperties(properties);
	     return pageHelper;
	 }
	
}
