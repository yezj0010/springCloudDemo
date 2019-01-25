package com.tomcat360.admin.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.tomcat360.admin.cache.PermissionCache;
import com.tomcat360.admin.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tomcat360.admin.aspect.AdminLog;
import com.tomcat360.admin.constant.AdminConstant;
import com.tomcat360.admin.enums.EnumResponseMsg;
import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbAdminMenuRole;
import com.tomcat360.admin.model.TbAdminRole;
import com.tomcat360.admin.model.TbAdminUser;
import com.tomcat360.admin.model.TbArea;
import com.tomcat360.admin.service.AdminLogService;
import com.tomcat360.admin.service.AdminMenuRoleService;
import com.tomcat360.admin.service.AdminMenuService;
import com.tomcat360.admin.service.AdminPermissionService;
import com.tomcat360.admin.service.AdminRoleService;
import com.tomcat360.admin.service.AdminUserService;
import com.tomcat360.admin.service.TbAreaService;
import com.tomcat360.admin.util.CalendarUtil;
import com.tomcat360.admin.util.PasswordUtil;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AdminUserController {

	@Autowired
	private AdminUserService adminUserService;

	@Autowired
	private AdminRoleService adminRoleService;

	@Autowired
	private AdminMenuService adminMenuService;

	@Autowired
	private AdminLogService adminLogService;

	@Autowired
	private AdminMenuRoleService adminMenuRoleService;

	@Autowired
	private TbAreaService tbAreaService;

	@Autowired
	private AdminPermissionService adminPermissionService;

	@Autowired
	private PermissionCache permissionCache;

	//@AdminLog(interfaceCode = "/auth/adminList", interfaceDesc = "后台用户列表")
	@ApiOperation(value = "后台用户列表")
	@PostMapping("/adminList")
	public JSONData adminList(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size, HttpServletRequest request) {

		String userName = request.getParameter("userName");
		String countryId = request.getParameter("countryId");
		String status = request.getParameter("status");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userName", userName);
		params.put("countryId", countryId);
		params.put("status", status);
		params.put("page", page);
		params.put("size", size);

		return adminUserService.findByCondition(params);
	}

	@AdminLog(interfaceCode = "/auth/addAdmin", interfaceDesc = "添加后台用户")
	@ApiOperation(value = "添加后台用户")
	@PostMapping("/addAdmin")
	public JSONData addAdmin(String userName, String status, String password, String remark, Long roleId,
			String countryId, HttpServletRequest request) {

		if (StringUtils.isEmpty(countryId) || StringUtils.isEmpty(password) || StringUtils.isEmpty(userName)
				|| StringUtils.isEmpty(status) || StringUtils.isEmpty(roleId)) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg()).build();
		}

		TbAdminUser self = (TbAdminUser) request.getAttribute(AdminConstant.ADMIN);

		// 判断用户名是否已经被其他人占用
		TbAdminUser other = adminUserService.findOneByUserName(userName);
		if (other != null) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_ADMINUSER_USERNAME_IS_USED.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_ADMINUSER_USERNAME_IS_USED.getMsg()).build();
		}

		try {
			TbAdminUser adminUser = new TbAdminUser();
			adminUser.setUserName(userName);
			adminUser.setPassword(PasswordUtil.getPassword(password));
			adminUser.setStatus(status);// 0-正常 1-禁用
			adminUser.setRemark(remark);
			adminUser.setRoleId(roleId);
			adminUser.setCreateTime(new Date());
			adminUser.setUpdateAdmin(self.getUserName());
			adminUser.setCountryId(Long.valueOf(countryId));
			TbArea tbArea = tbAreaService.selectByCountry(countryId);
			adminUser.setCountryName(tbArea.getAreaName());

			//更新日志操作描述
			TbAdminRole role = adminRoleService.findById(roleId);
			String operationDesc = "新增"+userName+"为"+tbArea.getAreaName()+role.getRoleNameCn();
			request.setAttribute(AdminConstant.OPERATION_DESC, operationDesc);

			adminUserService.save(adminUser);
		} catch (Exception e) {
			log.error("新增后台用户异常" + e);
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getMsg()).build();
		}

		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
	}

	@AdminLog(interfaceCode = "/auth/updateAdmin", interfaceDesc = "编辑后台用户")
	@ApiOperation(value = "编辑后台用户")
	@PostMapping("/updateAdmin")
	public JSONData updateAdmin(Long id, String userName, String status, String password, String remark, Long roleId,
			String countryId, HttpServletRequest request) {

		if (StringUtils.isEmpty(id) || StringUtils.isEmpty(userName) || StringUtils.isEmpty(status)
				|| StringUtils.isEmpty(roleId)) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg()).build();
		}

		TbAdminUser self = (TbAdminUser) request.getAttribute(AdminConstant.ADMIN);

		// 判断用户名是否已经被其他人占用
		Integer count = adminUserService.findByUserNameExSelf(userName, id);
		if (count > 0) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_ADMINUSER_USERNAME_IS_USED.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_ADMINUSER_USERNAME_IS_USED.getMsg()).build();
		}

		// 如果是自己修改自己，并且自己是超级管理员，只能修改密码
		if (id.equals(self.getId()) && self.getRoleId() == 1l) {
			if (!self.getRoleId().equals(roleId) || !self.getUserName().equals(userName)
					|| !self.getStatus().equals(status)) {
				return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_ADMIN_UPDATE_ERR.getCode())
						.msg(EnumResponseMsg.RESP_ERROR_ADMIN_UPDATE_ERR.getMsg()).build();
			}
		}

		try {
			TbAdminUser adminUser = adminUserService.findById(id);
			TbArea tbArea = null;
			if(!StringUtils.isEmpty(countryId)){
				tbArea = tbAreaService.selectByCountry(countryId);
			}
			TbAdminRole role = adminRoleService.findById(roleId);

			//更新日志操作描述 start
			String operationDesc = "";
			String oldUserName = adminUser.getUserName();
			boolean flag = false;
			if(!oldUserName.equals(userName)){
				operationDesc = operationDesc + "编辑"+oldUserName+"用户名为"+userName+" ";
				flag = true;
			}
			if(!status.equals(adminUser.getStatus())){
				operationDesc = operationDesc + "禁用"+oldUserName+"账户 ";
				flag = true;
			}
			if(!StringUtils.isEmpty(password)){
				operationDesc = operationDesc + "修改"+oldUserName+"密码 ";
				flag = true;
			}
			if(remark!=null && !remark.equals(adminUser.getRemark())){
				operationDesc = operationDesc + "编辑"+oldUserName+"备注为"+remark+" ";
				flag = true;
			}
			if(!roleId.equals(adminUser.getRoleId()) ||
					(!StringUtils.isEmpty(countryId) &&  !countryId.equals(adminUser.getCountryId())) ){
				operationDesc = operationDesc + "编辑"+oldUserName+"为"+tbArea.getAreaName()+role.getRoleNameCn()+" ";
				flag = true;

			}
			if(flag){
				request.setAttribute(AdminConstant.OPERATION_DESC, operationDesc);
			}
			//更新日志操作描述 end

			adminUser.setUserName(userName);
			if (!StringUtils.isEmpty(password)) {
				adminUser.setPassword(PasswordUtil.getPassword(password));
			}
			if (!StringUtils.isEmpty(countryId)) {
				adminUser.setCountryId(Long.valueOf(countryId));
				adminUser.setCountryName(tbArea.getAreaName());
			}
			adminUser.setStatus(status);// 0-正常 1-禁用
			adminUser.setRemark(remark);
			adminUser.setRoleId(roleId);
			adminUser.setUpdateTime(new Date());
			adminUser.setUpdateAdmin(self.getUserName());
			adminUserService.update(adminUser);
		} catch (Exception e) {
			log.error("修改后台用户异常");
			log.error(LogUtils.getExceptionInfo(e));
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getMsg()).build();
		}

		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
	}

	//@AdminLog(interfaceCode = "/auth/roleList", interfaceDesc = "角色列表")
	@ApiOperation(value = "角色列表")
	@PostMapping("/roleList")
	public JSONData roleList(HttpServletRequest request) {
		List<TbAdminRole> list = adminRoleService.findAll();

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("list", list);
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(result).build();
	}

	//@AdminLog(interfaceCode = "/auth/menuList", interfaceDesc = "权限列表")
	@ApiOperation(value = "权限列表")
	@PostMapping("/menuList")
	public JSONData nenuList(HttpServletRequest request) {
		List<Map<String, Object>> list = adminMenuService.queryZTreeList();

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("list", list);
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(result).build();
	}

	//@AdminLog(interfaceCode = "/auth/getMenuListByRoleId", interfaceDesc = "获取角色权限列表")
	@ApiOperation(value = "获取角色权限列表")
	@PostMapping("/getMenuListByRoleId")
	public JSONData getMenuListByRoleId(Long roleId, HttpServletRequest request) {
		if (StringUtils.isEmpty(roleId)) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg()).build();
		}

		List<Long> menuIdList = adminMenuRoleService.findMenuByRoleId(roleId);

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("list", menuIdList);
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(result).build();
	}

	@AdminLog(interfaceCode = "/auth/updateRoleMenu", interfaceDesc = "更新角色权限")
	@ApiOperation(value = "更新角色权限")
	@PostMapping("/updateRoleMenu")
	@Transactional
	public JSONData updateRole(Long roleId, String menuIds, // 多个菜单","隔开
			HttpServletRequest request) {
		if (StringUtils.isEmpty(roleId) || StringUtils.isEmpty(menuIds)) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg()).build();
		}

		String[] menuIdsArr = menuIds.split(",");
		List<Long> menuIdList = new ArrayList<Long>();
		for (String str : menuIdsArr) {
			menuIdList.add(Long.parseLong(str));
		}
		// 删除角色权限关系表数据
		adminMenuRoleService.deleteByRoleId(roleId);

		// 新增角色权限关系数据
		for (Long menuId : menuIdList) {
			TbAdminMenuRole menuRole = new TbAdminMenuRole();
			menuRole.setMenuId(menuId);
			menuRole.setRoleId(roleId);
			Date now = new Date();
			menuRole.setCreateTime(now);
			menuRole.setUpdateTime(now);
			adminMenuRoleService.save(menuRole);
		}

		permissionCache.init();
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
	}

	// @AdminLog(interfaceCode="/auth/adminLogList" , interfaceDesc="后台用户日志列表")
	@ApiOperation(value = "后台用户日志列表")
	@PostMapping("/adminLogList")
	public JSONData adminLogList(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size, String userName, String operation,
			String date, String operateStatus, HttpServletRequest request) {

		TbAdminUser admin = (TbAdminUser) request.getAttribute(AdminConstant.ADMIN);
		String userName2 = admin.getUserName();

		Map<String, Object> params = new HashMap<String, Object>();
		if (userName2 != null && 1l != admin.getRoleId()) {//如果不是超级管理员
			params.put("userName2", userName2);
		}

		if (!StringUtils.isEmpty(date)) {
			Date correctDate = CalendarUtil.correctDate(date + " 00:00:00", "yyyy-MM-dd HH:mm:ss");
			params.put("firstTime", correctDate);// yyyy-MM-dd
			params.put("endTime", CalendarUtil.addDate(correctDate, 1));// yyyy-MM-dd
		}
		params.put("page", page);
		params.put("size", size);
		params.put("userName", userName);
		params.put("operation", operation);
		params.put("operateStatus", operateStatus);

		return adminLogService.findByCondition(params);
	}

	// @AdminLog(interfaceCode="/auth/getLogOperations" ,
	// interfaceDesc="获取后台行为")
	@ApiOperation(value = "获取后台行为")
	@PostMapping("/getLogOperations")
	public JSONData getLogOperations(HttpServletRequest request) {
		List<Map<String, String>> operationsList = adminPermissionService.getAllPermissionList();

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("list", operationsList);
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(data).build();
	}

}
