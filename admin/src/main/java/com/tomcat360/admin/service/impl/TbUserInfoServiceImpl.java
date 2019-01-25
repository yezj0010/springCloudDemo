package com.tomcat360.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomcat360.admin.mapper.TbUserInfoMapper;
import com.tomcat360.admin.model.TbUserInfo;
import com.tomcat360.admin.model.TbUserInfoExample;
import com.tomcat360.admin.service.TbUserInfoService;
@Service
public class TbUserInfoServiceImpl implements TbUserInfoService {
	@Autowired
	private TbUserInfoMapper tbUserInfoMapper;

	@Override
	public TbUserInfo findByUserId(String userId) {
		
		return tbUserInfoMapper.selectByPrimaryKey(Long.valueOf(userId));
	}
	
	
}
