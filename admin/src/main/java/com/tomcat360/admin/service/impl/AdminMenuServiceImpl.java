package com.tomcat360.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomcat360.admin.mapper.TbAdminMenuMapper;
import com.tomcat360.admin.model.TbAdminMenu;
import com.tomcat360.admin.model.TbAdminMenuExample;
import com.tomcat360.admin.service.AdminMenuService;

@Service
public class AdminMenuServiceImpl implements AdminMenuService{

	@Autowired
	private TbAdminMenuMapper tbAdminMenuMapper;

	@Override
	public List<TbAdminMenu> findListByParentIdAndLevelAndRoleId(Long parentMenuId, Integer level, Long roleId) {
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("parentMenuId", parentMenuId);
		params.put("level", level);
		params.put("roleId", roleId);
		
		return tbAdminMenuMapper.findListByParentIdAndLevelAndRoleId(params);
	}

	@Override
	public List<TbAdminMenu> findListByLevel(Integer level) {
		TbAdminMenuExample example = new TbAdminMenuExample();
		example.createCriteria().andMenuLevelEqualTo(level);
		return tbAdminMenuMapper.selectByExample(example);
	}

	@Override
	public List<TbAdminMenu> selectAllByMenuIds(List<Long> menuIdList) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("menuIdList", menuIdList);
		return tbAdminMenuMapper.selectAllrelByMenuIds(params);
	}

	@Override
	public List<Map<String, Object>> queryZTreeList() {
		return tbAdminMenuMapper.queryZTreeList();
	}
}
