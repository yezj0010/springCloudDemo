package com.tomcat360.atm.repository;

import org.springframework.data.repository.CrudRepository;

import com.tomcat360.atm.model.redis.AtmTokenInfo;

public interface AtmTokenRepository extends CrudRepository<AtmTokenInfo, String> {

	AtmTokenInfo findByToken(String token);
}
