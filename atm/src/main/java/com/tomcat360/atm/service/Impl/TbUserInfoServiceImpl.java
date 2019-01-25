package com.tomcat360.atm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomcat360.atm.mapper.TbUserInfoMapper;
import com.tomcat360.atm.model.TbUserInfo;
import com.tomcat360.atm.model.TbUserInfoExample;
import com.tomcat360.atm.service.TbUserInfoService;

@Service
public class TbUserInfoServiceImpl implements TbUserInfoService {

	@Autowired
	private TbUserInfoMapper tbUserInfoMapper;

	@Override
	public TbUserInfo findByToken(String token) {
		TbUserInfoExample tbUserInfoExample = new TbUserInfoExample();

		tbUserInfoExample.createCriteria().andUserTokenEqualTo(token);

		List<TbUserInfo> selectByExample = tbUserInfoMapper.selectByExample(tbUserInfoExample);
		
		
		
		return selectByExample.get(0);
	}

}
