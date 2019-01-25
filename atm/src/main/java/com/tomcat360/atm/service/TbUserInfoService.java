package com.tomcat360.atm.service;

import com.tomcat360.atm.model.TbUserInfo;

public interface TbUserInfoService {

	TbUserInfo findByToken(String token);

}
