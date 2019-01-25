package com.tomcat360.admin.service;

import java.util.List;

import com.tomcat360.admin.model.TbAdminRole;

public interface AdminRoleService {
	
	List<TbAdminRole> findAll();
	
	TbAdminRole findById(Long roleId);
}
