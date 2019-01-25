package com.tomcat360.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomcat360.admin.mapper.TbAdminMenuPermissionMapper;
import com.tomcat360.admin.service.AdminMenuPermissionService;

@Service
public class AdminMenuPermissionServiceImpl implements AdminMenuPermissionService{
	
	@Autowired
	private TbAdminMenuPermissionMapper tbAdminMenuPermissionMapper;

	@Override
	public List<String> getPermissionListByRoleId(Long roleId) {
		return tbAdminMenuPermissionMapper.getPermissionListByRoleId(roleId);
	}
}
