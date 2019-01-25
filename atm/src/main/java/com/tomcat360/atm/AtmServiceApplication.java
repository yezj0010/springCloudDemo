package com.tomcat360.atm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * app子服务
 */

@EnableScheduling
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHystrix
@SpringBootApplication
@EnableFeignClients
@EnableSwagger2
@MapperScan("com.tomcat360.atm.mapper")
public class AtmServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtmServiceApplication.class, args);
	}
}
