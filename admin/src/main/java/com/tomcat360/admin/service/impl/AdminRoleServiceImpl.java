package com.tomcat360.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomcat360.admin.mapper.TbAdminRoleMapper;
import com.tomcat360.admin.model.TbAdminRole;
import com.tomcat360.admin.model.TbAdminRoleExample;
import com.tomcat360.admin.service.AdminRoleService;

@Service
public class AdminRoleServiceImpl implements AdminRoleService{

	@Autowired
	private TbAdminRoleMapper tbAdminRoleMapper;
	
	@Override
	public List<TbAdminRole> findAll() {
		TbAdminRoleExample example = new TbAdminRoleExample();
		//example.createCriteria().andRoleCodeNotEqualTo("superAdmin");
		return tbAdminRoleMapper.selectByExample(example);
	}

	@Override
	public TbAdminRole findById(Long roleId) {
		return tbAdminRoleMapper.selectByPrimaryKey(roleId);
	}

}
