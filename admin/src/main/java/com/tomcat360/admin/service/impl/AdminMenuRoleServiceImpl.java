package com.tomcat360.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomcat360.admin.mapper.TbAdminMenuRoleMapper;
import com.tomcat360.admin.model.TbAdminMenuRole;
import com.tomcat360.admin.model.TbAdminMenuRoleExample;
import com.tomcat360.admin.service.AdminMenuRoleService;

@Service
public class AdminMenuRoleServiceImpl implements AdminMenuRoleService{

	@Autowired
	private TbAdminMenuRoleMapper tbAdminMenuRoleMapper;
	
	@Override
	public void deleteByRoleId(Long roleId) {
		TbAdminMenuRoleExample example = new TbAdminMenuRoleExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		tbAdminMenuRoleMapper.deleteByExample(example);
		
	}

	@Override
	public void save(TbAdminMenuRole menuRole) {
		tbAdminMenuRoleMapper.insert(menuRole);
	}

	@Override
	public List<Long> findMenuByRoleId(Long roleId) {
		return tbAdminMenuRoleMapper.findMenuByRoleId(roleId);
	}

}
