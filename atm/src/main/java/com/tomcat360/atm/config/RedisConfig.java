package com.tomcat360.atm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

/**
 * Redis相关配置
 */
@Configuration
@EnableRedisRepositories
public class RedisConfig {
}
