package com.tomcat360.admin.service;

import java.util.List;
import java.util.Map;

import com.tomcat360.admin.model.TbAdminMenu;

public interface AdminMenuService {
	
	List<TbAdminMenu> findListByParentIdAndLevelAndRoleId(Long parentMenuId, Integer level, Long roleId);
	
	List<TbAdminMenu> findListByLevel(Integer level);
	
	List<TbAdminMenu> selectAllByMenuIds(List<Long> menuIdList);
	
	List<Map<String,Object>> queryZTreeList();
} 
