package com.tomcat360.atm.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomcat360.atm.mapper.TbUserInfoMapper;
import com.tomcat360.atm.model.TbUserInfo;
import com.tomcat360.atm.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService{
	@Autowired
	private TbUserInfoMapper tBUserInfoMapper;
	
	
	@Override
	public void update(TbUserInfo userInfo) {
		tBUserInfoMapper.updateByPrimaryKey(userInfo);
	}


	@Override
	public void save(TbUserInfo userInfo) {
		tBUserInfoMapper.insert(userInfo);
	}


	@Override
	public TbUserInfo selectByPrimaryKey(Long userId) {
		return tBUserInfoMapper.selectByPrimaryKey(userId);
	}

}
