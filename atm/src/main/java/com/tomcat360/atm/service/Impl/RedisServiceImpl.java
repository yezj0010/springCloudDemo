package com.tomcat360.atm.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tomcat360.atm.model.redis.AtmTokenInfo;
import com.tomcat360.atm.repository.AtmTokenRepository;
import com.tomcat360.atm.service.RedisService;

@Service
public class RedisServiceImpl implements RedisService{

	@Autowired
	private AtmTokenRepository atmTokenRepository;
	
	/**
	 * 保存token等信息到redis中
	 * @param atmTokenInfo
	 */
	public void saveAtmTokenInfo(AtmTokenInfo atmTokenInfo) {
		atmTokenRepository.save(atmTokenInfo);
	}

	/**
	 * 根据本地token，查询出用户token等信息
	 * @param token
	 * @return
	 */
	public AtmTokenInfo findByToken(String token) {
		return atmTokenRepository.findByToken(token);
	}

	@Override
	public boolean deleteToken(String token) {
		if (StringUtils.isEmpty(token)) {
            return false;
        }
        AtmTokenInfo atmTokenInfo = atmTokenRepository.findByToken(token);
        if(atmTokenInfo==null){
        	return true;//已经退出
        }
        atmTokenRepository.delete(atmTokenInfo);
        return true;
	}
	
}
