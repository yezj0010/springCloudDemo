package com.tomcat360.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tomcat360.admin.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tomcat360.admin.aspect.AdminLog;
import com.tomcat360.admin.constant.AdminConstant;
import com.tomcat360.admin.enums.EnumResponseMsg;
import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.LoginUser;
import com.tomcat360.admin.model.TbAdminMenu;
import com.tomcat360.admin.model.TbAdminRole;
import com.tomcat360.admin.model.TbAdminUser;
import com.tomcat360.admin.model.TbCheckResult;
import com.tomcat360.admin.model.TbEquipmentStatus;
import com.tomcat360.admin.model.Token;
import com.tomcat360.admin.model.ValidateCode;
import com.tomcat360.admin.properties.AppProperties;
import com.tomcat360.admin.service.AdminMenuService;
import com.tomcat360.admin.service.AdminRoleService;
import com.tomcat360.admin.service.AdminUserService;
import com.tomcat360.admin.service.ExchangeService;
import com.tomcat360.admin.service.TbCheckResultService;
import com.tomcat360.admin.service.TbEquipmentFaulLogService;
import com.tomcat360.admin.service.TbEquipmentSettingsService;
import com.tomcat360.admin.service.TbEquipmentStatusService;
import com.tomcat360.admin.service.TbTransService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class LoginController {

	@Autowired
	private TbEquipmentStatusService tbEquipmentStatusService;

	@Autowired
	private AdminUserService adminUserService;

	@Autowired
	private AdminRoleService adminRoleService;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private AppProperties appProperties;

	@Autowired
	private AdminMenuService adminMenuService;

	@Autowired
	private TbEquipmentSettingsService tbEquipmentSettingsService;

	@Autowired
	private TbEquipmentFaulLogService tbEquipmentFaulLogService;

	@Autowired
	private TbTransService tbTransService;

	@Autowired
	private ExchangeService exchangeService;
	@Autowired
	private TbCheckResultService tbCheckResultService;


	/**
	 * 登陆
	 * 
	 * @param phone
	 * @param password
	 * @param vcode
	 *            图形验证码
	 * @return
	 */
	@AdminLog(interfaceCode = "/login", interfaceDesc = "登陆")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ApiOperation(value = "登陆接口", httpMethod = "POST")
	@PostMapping("/login")
	public JSONData adminLogin(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String captcha = request.getParameter("captcha");
		String randomId = request.getParameter("randomId");
		log.info("登录");
		// 先创建admin对象，用来记录日志
		TbAdminUser admin = new TbAdminUser();
		admin.setUserName(userName);
		request.setAttribute(AdminConstant.ADMIN, admin);

		// 非空判断
		if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password) || StringUtils.isEmpty(captcha)
				|| StringUtils.isEmpty(randomId)) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg()).build();
		}

		// 判断图形验证码
		JSONData resp = checkCaptcha(randomId, captcha);
		log.info("校验图形验证码返回信息：" + resp.toString());
		if (!EnumResponseMsg.isSuccess(resp.getCode())) {
			return resp;
		}

		// 查询用户信息
		TbAdminUser user = adminUserService.findOneByUserName(userName);
		if (null == user) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_USER_NOT_EXIST.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_USER_NOT_EXIST.getMsg()).build();
		}
		request.setAttribute(AdminConstant.ADMIN, user);

		// 判断用户状态
		if (!"0".equals(user.getStatus())) {// 0 正常 1-停用
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_FORBIDDEN.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_FORBIDDEN.getMsg()).build();
		}

		// 比较密码
		try {
			if (!PasswordUtil.validatePassword(user.getPassword(), password)) {
				return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_WRONG_USERNAME_OR_PWD.getCode())
						.msg(EnumResponseMsg.RESP_ERROR_WRONG_USERNAME_OR_PWD.getMsg()).build();
			}
		} catch (Exception e) {
			log.info("验证密码失败，原因：" + e);
			log.info(String.format("用户username=%s密码加密失败，登录失败，登录结束", userName));
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getMsg()).build();
		}

		// 生成token
		Long now = Calendar.getInstance().getTimeInMillis();
		LoginUser loginUser = new LoginUser();
		loginUser.setId(user.getId());
		loginUser.setLoginTime(now);
		String encryptString = null;
		try {
			encryptString = AesUtils.aesEncryptHexString(JSON.toJSONString(loginUser), appProperties.getTokenKey());
		} catch (Exception e) {
			log.info("用户登陆信息加密失败, 原因:", e);
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_GENERATE_TOKEN.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_GENERATE_TOKEN.getMsg()).build();
		}

		// 查询角色信息
		TbAdminRole role = adminRoleService.findById(user.getRoleId());
		Map result = new HashMap();

		// 返回token等信息
		if(1l != user.getRoleId()){//如果不是超级管理员
			result.put("countryId",user.getCountryId());
		}
		
		result.put("token", encryptString);
		result.put("roleCode", role.getRoleCode());

		// 返回角色菜单列表
		List<Map<String, Object>> menuList = new ArrayList<Map<String, Object>>();
		// 查询一级菜单
		List<TbAdminMenu> topMenuList = adminMenuService.findListByParentIdAndLevelAndRoleId(0L, 1, user.getRoleId());
		if (topMenuList != null && topMenuList.size() > 0) {
			for (TbAdminMenu menu : topMenuList) {
				// 查询二级菜单
				List<TbAdminMenu> subMenuList = adminMenuService.findListByParentIdAndLevelAndRoleId(menu.getId(), 2,
						user.getRoleId());
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", menu.getId());
				map.put("name", menu.getName());// 一级菜单名称
				map.put("icon", menu.getIcon());// 一级菜单图标
				map.put("subMenuList", subMenuList);// 二级菜单列表
				menuList.add(map);
			}
		}

		result.put("menuList", menuList);

		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(result).build();
	}

	/**
	 * 获取图形验证码
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getCaptcha")
	public JSONData getCaptcha(HttpServletRequest request, HttpServletResponse response) {
		// 设置响应的类型格式为图片格式
		response.setContentType("image/jpeg");
		// 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		if (StringUtils.isEmpty(request.getParameter("randomId"))) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg()).build();
		}

		log.info("获取图形验证码，randomId=" + request.getParameter("randomId"));

		ValidateCode vCode = new ValidateCode(120, 40, 5, 70);
		String key = request.getParameter("randomId") + "captcha";
		stringRedisTemplate.opsForValue().set(key, vCode.getCode(), 3 * 60, TimeUnit.SECONDS);

		Map<String, Object> map = new HashMap<>();
		map.put("vCode", vCode.getCode());
		try {
			vCode.write(response.getOutputStream());

		} catch (IOException e) {
			log.error(LogUtils.getExceptionInfo(e));
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getMsg()).build();
		}
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
	}

	/**
	 * 校验图形验证码
	 * 
	 * @param request
	 * @param captcha
	 * @return
	 * @throws Exception
	 */
	// @PostMapping(value="/checkCaptcha")
	public JSONData checkCaptcha(String randomId, String captcha) {
		log.info("校验图形验证码,captcha=" + captcha);
		if (StringUtils.isEmpty(captcha)) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode())
					.msg("captcha" + EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg()).build();
		}
		String key = randomId + "captcha";
		String vCode = stringRedisTemplate.opsForValue().get(key);
		log.info("正确的验证码是" + vCode);
		if (!captcha.equalsIgnoreCase(vCode)) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_CAPTCHA.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_CAPTCHA.getMsg()).build();
		}

		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
	}

	@SuppressWarnings({ "unchecked" })
	@AdminLog(interfaceCode = "/exportMonitorEquipment", interfaceDesc = "导出监控列表")
	@ApiOperation(value = "导出监控列表", httpMethod = "POST")
	@RequestMapping("/exportMonitorEquipment")
	public JSONData exportMonitorEquipment(HttpServletRequest request, HttpServletResponse response) {
		String country = request.getParameter("country");
		String size = request.getParameter("size");
		String transStatus = request.getParameter("transStatus");
		String runningStatus = request.getParameter("runningStatus");
		String moduleStatus = request.getParameter("moduleStatus");
		String banknoteBoxStatus = request.getParameter("banknoteBoxStatus");
		String networkStatus = request.getParameter("networkStatus");
		String prrStatus = request.getParameter("prrStatus");
		String type = request.getParameter("abnormalType");// type 查询状态类型
															// 0:凭条纸状态
															// 1：连接状态2：安全门状态3：钞箱纸状态
															// 4：取款状态
		// 5: 凭条打印状态 6：维护状态
		String id = request.getParameter("id");
		String equipmentType = request.getParameter("equipmentType");// 0
																		// 查询所有闲置设备
																		// 1
																		// 查询所有未激活的设备
																		// 2查询所有正常设备
																		// 3查询所有异常设备
		String maintainStatus = request.getParameter("maintainStatus");
		String connectStatus = request.getParameter("connectStatus");
		// 校验token
		String token = request.getParameter("token");
		if (StringUtils.isEmpty(token)) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg()).build();
		}
		Token checkToken = checkToken(token);
		if (checkToken == null) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_TOKEN_OUT.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_TOKEN_OUT.getMsg()).build();
		}
		TbAdminUser findOneByUserName = null;
		if(checkToken.getId()!=null){
			findOneByUserName = adminUserService.findById(checkToken.getId());
			if(findOneByUserName.getRoleId()!=1l){
				country = findOneByUserName.getCountryName()+"";
			}
		}
		
//		TbAdminUser admin = (TbAdminUser) request.getAttribute(AdminConstant.ADMIN);
//		if (admin != null && !"admin".equals(admin.getUserName())) {
//			if (admin.getCountryId() != null) {
//				country = admin.getCountryName().toString();
//			}
//		}

		TbEquipmentStatus tbEquipmentStatus = new TbEquipmentStatus();
		tbEquipmentStatus.setTransStatus(transStatus);
		tbEquipmentStatus.setRunningStatus(runningStatus);
		tbEquipmentStatus.setModuleStatus(moduleStatus);
		tbEquipmentStatus.setBanknoteBoxStatus(banknoteBoxStatus);
		tbEquipmentStatus.setNetworkStatus(networkStatus);
		tbEquipmentStatus.setPrrStatus(prrStatus);
		tbEquipmentStatus.setConnectStatus(connectStatus);
		tbEquipmentStatus.setMaintainStatus(maintainStatus);
		tbEquipmentStatus.setId(id);
		JSONData list = tbEquipmentStatusService.findByList(tbEquipmentStatus, country, "1", "10", type);
		String pageSize = list.getData().get("totalNumber").toString();
		JSONData list1 = tbEquipmentStatusService.findByList(tbEquipmentStatus, country, "1", pageSize, type);

		if (!StringUtils.isEmpty(equipmentType) && "0".equals(equipmentType) && StringUtils.isEmpty(type)) {
			list1 = tbEquipmentStatusService.findByIdleEquipment(country, pageSize, size, type, id);
		}

		if (!StringUtils.isEmpty(equipmentType) && "1".equals(equipmentType) && StringUtils.isEmpty(type)) {
			list1 = tbEquipmentStatusService.findByNotActive(country, pageSize, size, type, id);
		}

		if (!StringUtils.isEmpty(equipmentType) && "2".equals(equipmentType) && StringUtils.isEmpty(type)) {
			list1 = tbEquipmentStatusService.findByNormalEquiment(country, pageSize, size, type, id);
		}

		if (!StringUtils.isEmpty(equipmentType) && "3".equals(equipmentType) && StringUtils.isEmpty(type)) {
			list1 = tbEquipmentStatusService.findByAbnormal(country, pageSize, size, type, id);
		}

		if (!EnumResponseMsg.isSuccess(list1.getCode())) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getCode()).build();
		}

		PoiUtil poi = new PoiUtil(appProperties.getTimeZone());
		try {
			poi.createExcel(response, (List<Map<String, Object>>) list1.getData().get("list"));
		} catch (IOException e) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_POI.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_POI.getCode()).build();
		}
		if(findOneByUserName!=null){
			request.setAttribute(AdminConstant.ADMIN, findOneByUserName);
		}
		request.setAttribute(AdminConstant.OPERATION_DESC, findOneByUserName.getUserName()+":导出监控列表");
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
	}

	@SuppressWarnings({"unchecked" })
	@AdminLog(interfaceCode = "/auth/exportEquipmentNum", interfaceDesc = "导出设备数量列表")
	@ApiOperation(value = "导出设备数量列表接口", httpMethod = "GET")
	@RequestMapping("/exportEquipmentNum")
	public JSONData exportEquipmentNum(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size, HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> params = new HashMap<String, Object>();
		String id = request.getParameter("id");
		String countryId = request.getParameter("countryId");//地区
		String equipmentSubType = request.getParameter("equipmentSubType");//币种(USD-美元 ，CNY-人民币， EUR-欧元 ，AUD-澳元，SGD-新加坡元 )',
		String equipmentType = request.getParameter("equipmentType");
		String runningStatus = request.getParameter("runningStatus");
		
		
		params.put("id", id);
		params.put("equipmentType", equipmentType);
		params.put("countryId", countryId);
		params.put("equipmentSubType", equipmentSubType);
		params.put("runningStatus", runningStatus);
	
		String token = request.getParameter("token");
		if (StringUtils.isEmpty(token)) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg()).build();
		}
		
		// 校验token
		Token checkToken = checkToken(token);
		if (checkToken == null) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_TOKEN_OUT.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_TOKEN_OUT.getMsg()).build();
		}
		TbAdminUser findOneByUserName = null;
		if(checkToken.getId()!=null){
			findOneByUserName = adminUserService.findById(checkToken.getId());
			if(findOneByUserName.getRoleId()!=1l){
				countryId = findOneByUserName.getCountryId()+"";
			}
		}
		
		params.put("countryId", countryId);
		params.put("page", page);
		params.put("size", size);
		JSONData jsonData = tbEquipmentSettingsService.equipmentNum(params);
		String pageSize = jsonData.getData().get("totalNumber").toString();
		params.put("page", 1);
		params.put("size", Integer.valueOf(pageSize));
		jsonData = tbEquipmentSettingsService.equipmentNum(params);

		if (!EnumResponseMsg.isSuccess(jsonData.getCode())) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getCode()).build();
		}

		List<Map<String, Object>> list = (List<Map<String, Object>>) jsonData.getData().get("list");
		PoiUtil poiUtil = new PoiUtil(appProperties.getTimeZone());
		try {
			poiUtil.exportEquipmentNum(response, list);
		} catch (IOException e) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_POI.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_POI.getCode()).build();
		}
		
		if(findOneByUserName!=null){
			request.setAttribute(AdminConstant.ADMIN, findOneByUserName);
		}
		request.setAttribute(AdminConstant.OPERATION_DESC, findOneByUserName.getUserName()+":导出设备数量列表");
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
	}

	@SuppressWarnings("unchecked")
	@AdminLog(interfaceCode = "/auth/exportFindFaultEquipment", interfaceDesc = "导出故障设备列表")
	@ApiOperation(value = "导出故障设备列表接口", httpMethod = "GET")
	@RequestMapping("/exportFindFaultEquipment")
	public JSONData exportFindFaultEquipment(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size, HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("page", page);
		params.put("size", size);
		
		String id = request.getParameter("id");
		String countryId = request.getParameter("countryId");
		String firstTime = request.getParameter("firstTime");
		String endTime = request.getParameter("endTime");
		
		
		String token = request.getParameter("token");
		if (StringUtils.isEmpty(token)) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg()).build();
		}
		
		// 校验token
		Token checkToken = checkToken(token);
		if (checkToken == null) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_TOKEN_OUT.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_TOKEN_OUT.getMsg()).build();
		}
		TbAdminUser findOneByUserName = null;
		if(checkToken.getId()!=null){
			findOneByUserName = adminUserService.findById(checkToken.getId());
			if(findOneByUserName.getRoleId()!=1l){
				countryId = findOneByUserName.getCountryId()+"";
			}
		}
		
		params.put("id", id);
		params.put("countryId", countryId);
		params.put("firstTime", firstTime);
		params.put("endTime", endTime);

		JSONData jsonData = tbEquipmentFaulLogService.findFaultEquipment(params);
		String pageSize = jsonData.getData().get("totalNumber").toString();
		params.put("page", 1);
		params.put("size", Integer.valueOf(pageSize));
		jsonData = tbEquipmentFaulLogService.findFaultEquipment(params);

		if (!EnumResponseMsg.isSuccess(jsonData.getCode())) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getCode()).build();
		}

		List<Map<String, Object>> list = (List<Map<String, Object>>) jsonData.getData().get("list");
		PoiUtil poiUtil = new PoiUtil(appProperties.getTimeZone());
		try {
			poiUtil.exportFindFaultEquipment(response, list);
		} catch (IOException e) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_POI.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_POI.getCode()).build();
		}
		if(findOneByUserName!=null){
			request.setAttribute(AdminConstant.ADMIN, findOneByUserName);
		}
		request.setAttribute(AdminConstant.OPERATION_DESC, findOneByUserName.getUserName()+":导出故障设备列表");
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
	}

	@SuppressWarnings({ "unchecked" })
	@AdminLog(interfaceCode = "/auth/exportWithdrawInfo", interfaceDesc = "导出取款明细接口")
	@ApiOperation(value = "导出取款明细接口", httpMethod = "GET")
	@RequestMapping("/exportWithdrawInfo")
	public JSONData exportWithdrawInfo(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> params = new HashMap<String, Object>();
		String id = request.getParameter("id");//ATM P端流水
		String exTransSeq = request.getParameter("exTransSeq");//交易所流水号
		String equipmentNo = request.getParameter("equipmentNo");//设备id
		String equipmentLogSeq = request.getParameter("equipmentLogSeq");//atm流水号
		
		String status = request.getParameter("status");//取款结果0-初始 1-完成 2-失败 3-超时 4-已冲正 5-冲正异常 6-吐钞中，7-状态不明
		
		String transTime = request.getParameter("transTime");//交易时间yyyy-MM-dd
		String userId = request.getParameter("userId");//用户id
		String countryId = request.getParameter("countryId");
		String userName = request.getParameter("userName");
		String token = request.getParameter("token");
		if (StringUtils.isEmpty(token)) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg()).build();
		}
		// 校验token
		Token checkToken = checkToken(token);
		if (checkToken == null) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_TOKEN_OUT.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_TOKEN_OUT.getMsg()).build();
		}
		TbAdminUser findOneByUserName = null;
		if(checkToken.getId()!=null){
			findOneByUserName = adminUserService.findById(checkToken.getId());
			if(findOneByUserName.getRoleId()!=1l){
				countryId = findOneByUserName.getCountryId()+"";
			}
		}
		
		boolean flag = (countryId == null);
		params.put("countryId", countryId);
		params.put("id", id);
		params.put("exTransSeq", exTransSeq);
		params.put("equipmentLogSeq", equipmentLogSeq);
		params.put("equipmentNo", equipmentNo);
		params.put("status", status);
		params.put("userName", userName);
		if(!StringUtils.isEmpty(transTime)){
			params.put("transTime", CalendarUtil.correctDateStr(transTime+" 00:00:00",appProperties.getGMTTimeZone(), "yyyy-MM-dd HH:mm:ss"));
			params.put("transTimeEnd", CalendarUtil.correctDateStrNextDay(transTime+" 00:00:00",appProperties.getGMTTimeZone(), "yyyy-MM-dd HH:mm:ss"));
		}
		params.put("userId", userId);
		params.put("page", 1);
		params.put("size", 10);
		JSONData exportWithdrawInfo = tbTransService.findWithdrawInfo(params);
		String pageSize = exportWithdrawInfo.getData().get("totalNum").toString();
		params.put("page", 1);
		params.put("size", Integer.valueOf(pageSize));
		exportWithdrawInfo = tbTransService.findWithdrawInfo(params);

		if (!EnumResponseMsg.isSuccess(exportWithdrawInfo.getCode())) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getCode()).build();
		}
		PoiUtil poiUtil = new PoiUtil(appProperties.getTimeZone());
		try {
			poiUtil.exportWithdrawInfo((List<Map<String, Object>>) exportWithdrawInfo.getData().get("list"), response,
					flag);
		} catch (Exception e) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_POI.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_POI.getCode()).build();
		}
		
		if(findOneByUserName!=null){
			request.setAttribute(AdminConstant.ADMIN, findOneByUserName);
		}
		request.setAttribute(AdminConstant.OPERATION_DESC, findOneByUserName.getUserName()+":导出取款明细");
		return exportWithdrawInfo;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@AdminLog(interfaceCode = "/auth/exportOperateAccountInfo", interfaceDesc = "导出运营账户信息接口")
	@ApiOperation(value = "导出运营账户信息接口", httpMethod = "GET")
	@RequestMapping("/exportOperateAccountInfo")
	public JSONData exportOperateAccountInfo(HttpServletRequest request, HttpServletResponse response) {
		Map params = new HashMap();
		
		String token = request.getParameter("token");
		String currency = request.getParameter("currency");
		if (StringUtils.isEmpty(token)) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg()).build();
		}
		
		// 校验token
		Token checkToken = checkToken(token);
		if (checkToken == null) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_TOKEN_OUT.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_TOKEN_OUT.getMsg()).build();
		}
		TbAdminUser findOneByUserName = adminUserService.findById(checkToken.getId());
		params.put("currency",currency);
		params.put("page", 1);
		params.put("size", 10);
		JSONData jsonData = exchangeService.findOperateAccountInfo(params);
		String pageSize = jsonData.getData().get("totalNumber").toString();
		params.put("page", 1);
		params.put("size", Integer.valueOf(pageSize));
		jsonData = exchangeService.findOperateAccountInfo(params);

		if (!EnumResponseMsg.isSuccess(jsonData.getCode())) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getCode()).build();
		}
		PoiUtil poiUtil = new PoiUtil(appProperties.getTimeZone());
		try {
			poiUtil.exportOperateAccountInfo((List<Map<String, Object>>) jsonData.getData().get("list"), response);
		} catch (Exception e) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_POI.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_POI.getCode()).build();
		}
		if(findOneByUserName!=null){
			request.setAttribute(AdminConstant.ADMIN, findOneByUserName);
		}
		request.setAttribute(AdminConstant.OPERATION_DESC, findOneByUserName.getUserName()+":导出运营账户信息");
		return jsonData;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@AdminLog(interfaceCode = "/auth/exportCheckResultList", interfaceDesc = "导出对账结果列表接口")
	@ApiOperation(value = "导出对账结果列表接口", httpMethod = "POST")
	@RequestMapping("/exportCheckResultList")
	public JSONData exportCheckResultList(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size, HttpServletRequest request,
			HttpServletResponse response) {
		Map params = new HashMap();
		String checkBatchNo = request.getParameter("checkBatchNo");//对账批次
		String equipmentId = request.getParameter("equipmentId");//设备编号
		String checkTime = request.getParameter("checkTime");//对账时间
		String checkStatus = request.getParameter("checkStatus");//对账结果（0：差错，1：平账）
		String type = request.getParameter("type");//对账对象（0-与C端，1-与交易所）
		String handleResult = request.getParameter("handleResult");//人工处理结果 （2-未处理 0-未平账，1-平账 ）
		String countryId = request.getParameter("countryId");
		
		String token = request.getParameter("token");
		if (StringUtils.isEmpty(type) || StringUtils.isEmpty(token)) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg()).build();
		}
		// 校验token
		Token checkToken = checkToken(token);
		if (checkToken == null) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_TOKEN_OUT.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_TOKEN_OUT.getMsg()).build();
		}
		TbAdminUser findOneByUserName = null;
		if(checkToken.getId()!=null){
			findOneByUserName = adminUserService.findById(checkToken.getId());
			if(findOneByUserName.getRoleId()!=1l){
				countryId = findOneByUserName.getCountryId()+"";
			}
		}
		
		
		params.put("page", page);
		params.put("size", size);
		params.put("type", type);
		params.put("checkBatchNo", checkBatchNo);
		params.put("equipmentId", equipmentId);
		if(!StringUtils.isEmpty(checkTime)){
			params.put("checkTime", CalendarUtil.correctDateStr(checkTime+" 00:00:00",appProperties.getGMTTimeZone(),"yyyy-MM-dd HH:mm:ss"));
			params.put("checkTimeEnd", CalendarUtil.correctDateStrNextDay(checkTime+" 00:00:00",appProperties.getGMTTimeZone(),"yyyy-MM-dd HH:mm:ss"));
		}
		params.put("checkStatus", checkStatus);
		params.put("countryId", countryId);
		params.put("handleResult",handleResult);
		JSONData jsonData = tbCheckResultService.checkCResultList(params);
		String pageSize = jsonData.getData().get("totalNumber").toString();
		params.put("page", 1);
		params.put("size", Integer.valueOf(pageSize));
		jsonData = tbCheckResultService.checkCResultList(params);

		if (!EnumResponseMsg.isSuccess(jsonData.getCode())) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getCode()).build();
		}
		PoiUtil poiUtil = new PoiUtil(appProperties.getTimeZone());
		try {
			poiUtil.exportCheckResultList((List<TbCheckResult>) jsonData.getData().get("list"), response, type);
		} catch (Exception e) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_POI.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_POI.getCode()).build();
		}
		if(findOneByUserName!=null){
			request.setAttribute(AdminConstant.ADMIN, findOneByUserName);
		}
		request.setAttribute(AdminConstant.OPERATION_DESC, findOneByUserName.getUserName()+"导出对账结果列表");
		return jsonData;
	}

	private Token checkToken(String token) {
		/*
		 * 3.是否登录
		 */
		long now = System.currentTimeMillis();

		// 解密token
		Token tokenOk = decryptToken(token);
		if (tokenOk == null || tokenOk.getId() == null || tokenOk.getId() < 0) {
			log.error("无效token");
			return null;
		}
		// Token有效期验证
		Long loginTime = tokenOk.getLoginTime();
		if (loginTime == null || (now - loginTime) >= appProperties.getTokenDay() * 1L * 24 * 60 * 60 * 1000) {
			log.error("token已失效，请重新登录");
			return null;
		}
		return tokenOk;

	}
	
	/**
	 * 解密Token
	 * 
	 * @param token
	 * @return userId
	 */
	private Token decryptToken(String token) {
		if (StringUtils.isEmpty(token)) {
			return null;
		}

		String tokenKey = appProperties.getTokenKey();
		try {
			String tokenOk = AesUtils.aesDecryptHexString(token, tokenKey);
			Token tk = JSONObject.parseObject(tokenOk, Token.class);
			return tk;
		} catch (Exception e) {
			log.error(String.format("token解密失败：token=%s", token));

			return null;
		}
	}

}
