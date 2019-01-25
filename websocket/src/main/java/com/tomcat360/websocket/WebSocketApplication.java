package com.tomcat360.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author  on 2018/4/17 0017.
 * @EnableWebSocketMessageBroker
 * 该注解用于开启使用STOMP协议来传输基于代理（MessageBroker）的消息，这时候控制器（controller）
 * 开始支持@MessageMapping,就像是使用@requestMapping一样。
 */
@EnableCircuitBreaker
@EnableHystrix
@EnableSwagger2
@SpringBootApplication
@EnableWebSocketMessageBroker
@EnableDiscoveryClient
@EnableScheduling
public class WebSocketApplication {

    public static void  main(String[] args){
        SpringApplication.run(WebSocketApplication.class,args);
    }
}
