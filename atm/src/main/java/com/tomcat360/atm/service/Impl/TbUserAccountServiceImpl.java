package com.tomcat360.atm.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomcat360.atm.mapper.TbUserAccountMapper;
import com.tomcat360.atm.model.TbUserAccount;
import com.tomcat360.atm.service.TbUserAccountService;

@Service
public class TbUserAccountServiceImpl implements TbUserAccountService {
	@Autowired
	private TbUserAccountMapper tbUserAccountMapper;

	@Override
	public void update(TbUserAccount tbUserAccount) {
		tbUserAccountMapper.updateByPrimaryKey(tbUserAccount);
		
	}

	@Override
	public void save(TbUserAccount tbUserAccount) {
		tbUserAccountMapper.insert(tbUserAccount);
	}
	
	
	
	
}
