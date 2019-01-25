package com.tomcat360.admin.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tomcat360.admin.model.TbAdminRole;
import com.tomcat360.admin.service.AdminMenuPermissionService;
import com.tomcat360.admin.service.AdminRoleService;

/**
 * 需要刷新权限，则调用init方法即可，由于admin就部署一台，所以数据存储到内存中。
 * @author Administrator
 *
 */
@Component
@Slf4j
public class PermissionCache{
	
	@Autowired
	private AdminMenuPermissionService adminMenuPermissionService;
	
	@Autowired
	private AdminRoleService adminRoleService;
	
	public static Map<String,List<String>> permission = new HashMap<String,List<String>>();
	
	@PostConstruct
	public void init(){
		log.info("初始化权限信息到缓存中 start");
		List<TbAdminRole> roleList = adminRoleService.findAll();
		for(TbAdminRole role : roleList){
			List<String> permissionList = adminMenuPermissionService.getPermissionListByRoleId(role.getId());
			permission.put(role.getId()+"", permissionList);
		}
		log.info("初始化权限信息到缓存中 end");
	}
	
	public static boolean checkPermission(Long roleId, String perssmission){
		List<String> permissionList = permission.get(roleId+"");
		if(permissionList.contains(perssmission)){
			return true;
		}
		return false;
	}
	
	
	
}
