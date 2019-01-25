package com.tomcat360.atm.service;

import com.tomcat360.atm.model.redis.AtmTokenInfo;

public interface RedisService {

	/**
	 * 保存token等信息到redis中
	 * @param atmTokenInfo
	 */
	public void saveAtmTokenInfo(AtmTokenInfo atmTokenInfo);

	/**
	 * 根据
	 * @param token
	 * @return
	 */
	public AtmTokenInfo findByToken(String token);
	
	/**
	 * 删除redis中的token
	 * @param token
	 * @return
	 */
	public boolean deleteToken(String token);
}
