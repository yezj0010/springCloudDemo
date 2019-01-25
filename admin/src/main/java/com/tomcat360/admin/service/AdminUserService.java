package com.tomcat360.admin.service;

import java.util.Map;

import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbAdminUser;

public interface AdminUserService {
	
	public TbAdminUser findById(Long id);
	
	public TbAdminUser findOneByUserName(String userName);
	
	public Integer findByUserNameExSelf(String userName, Long selfId);
	
	public JSONData findByCondition(Map<String,Object> params);
	
	public void update(TbAdminUser adminUser);
	
	public void save(TbAdminUser adminUser);
}
