package com.tomcat360.atm.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomcat360.atm.mapper.TbUserLogMapper;
import com.tomcat360.atm.model.TbUserLog;
import com.tomcat360.atm.service.UserLogService;

@Service
public class UserLogServiceImpl implements UserLogService{
	
	@Autowired
	private TbUserLogMapper tbUserLogMapper;

	@Override
	public int save(TbUserLog userLog) {
		return tbUserLogMapper.insert(userLog);
	}
	
	@Override
	public void update(TbUserLog userLog) {
		tbUserLogMapper.updateByPrimaryKey(userLog);
	}

}
