package com.tomcat360.admin.service;

import java.util.List;

import com.tomcat360.admin.model.TbAdminMenuRole;

public interface AdminMenuRoleService {
	
	void deleteByRoleId(Long roleId);
	
	void save(TbAdminMenuRole menuRole);
	
	List<Long> findMenuByRoleId(Long roleId);
}
