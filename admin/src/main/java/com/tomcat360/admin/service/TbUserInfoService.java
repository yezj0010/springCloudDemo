package com.tomcat360.admin.service;

import com.tomcat360.admin.model.TbUserInfo;

public interface TbUserInfoService {

	TbUserInfo findByUserId(String userId);

}
