package com.tomcat360.admin.service;

import java.util.List;

public interface AdminMenuPermissionService {
	
	List<String> getPermissionListByRoleId(Long roleId);
}
