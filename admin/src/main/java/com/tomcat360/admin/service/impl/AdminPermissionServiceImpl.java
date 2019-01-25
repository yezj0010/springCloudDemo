package com.tomcat360.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomcat360.admin.mapper.TbAdminPermissionMapper;
import com.tomcat360.admin.service.AdminPermissionService;

@Service
public class AdminPermissionServiceImpl implements AdminPermissionService{

	@Autowired
	private TbAdminPermissionMapper tbAdminPermissionMapper;
	
	@Override
	public List<Map<String, String>> getAllPermissionList() {
		return tbAdminPermissionMapper.getAllPermissionList();
	}
}
