package com.tomcat360.atm.model.redis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.Id;
/**
 * Redis中ATM token模型
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "atms")
public class AtmTokenInfo implements TokenInfo {
    @Id
    private String id;
    private UserInfo userInfo;
    @Indexed
    private String token;//本地token
    
    private String exchangeToken;

    @TimeToLive
    private Long expiration;
}
