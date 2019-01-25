package com.tomcat360.atm.service;

import com.tomcat360.atm.model.TbUserInfo;

public interface UserInfoService {

	void update(TbUserInfo userInfo);
	
	void save(TbUserInfo userInfo);

	TbUserInfo selectByPrimaryKey(Long userId);
}
