package com.tomcat360.admin.controller;

import com.tomcat360.admin.aspect.AdminLog;
import com.tomcat360.admin.cache.DrawCurrencyCache;
import com.tomcat360.admin.constant.AdminConstant;
import com.tomcat360.admin.enums.EnumResponseMsg;
import com.tomcat360.admin.model.*;
import com.tomcat360.admin.properties.AppProperties;
import com.tomcat360.admin.service.*;
import com.tomcat360.admin.util.*;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/auth")
@Slf4j
public class EquipmentController {
	@Autowired
	private TbEquipmentStatusService tbEquipmentStatusService;
	@Autowired
	private TbAreaService tbAreaService;
	@Autowired
	private TbEquipmentService tbEquipmentService;
	@Autowired
	private TbEquipmentSettingsService tbEquipmentSettingsService;
	@Autowired
	private TbEquipmentFaulLogService tbEquipmentFaulLogService;
	@Autowired
	private TbEquipmentRunningStatusService tbEqipmentRunningStatusService;
	@Autowired
	private AppProperties appProperties;
	@Autowired
	private TbWithdrawCurrencyService tbWithdrawCurrencyService;

	/**
	 * 监控机器列表
	 * 
	 * @param phone
	 * @param password
	 * @param vcode
	 * 
	 * @return
	 */
	//@AdminLog(interfaceCode = "/auth/monitorEquipmentList", interfaceDesc = "监控机器列表")
	@ApiOperation(value = "监控机器列表接口", httpMethod = "POST")
	@PostMapping("/monitorEquipmentList")
	public JSONData monitorEquipmentList(HttpServletRequest request) {
		String country = request.getParameter("country");
		String page = request.getParameter("page");
		String size = request.getParameter("size");
		String transStatus = request.getParameter("transStatus");
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
		String runningStatus = request.getParameter("runningStatus");// 0
																		// 查询所有闲置设备
																		// 1
																		// 查询所有未激活的设备
																		// 2查询所有正常设备
																		// 3查询所有异常设备
		String maintainStatus = request.getParameter("maintainStatus");
		String connectStatus = request.getParameter("connectStatus");
		TbAdminUser admin = (TbAdminUser) request.getAttribute(AdminConstant.ADMIN);

		if (1l != admin.getRoleId()) {//如果不是超级管理员
			if (admin.getCountryId() != null) {
				country = admin.getCountryName().toString();
			}
		}

		if (!StringUtils.isEmpty(runningStatus) && "0".equals(runningStatus) && StringUtils.isEmpty(type)) {
			return tbEquipmentStatusService.findByNormalEquiment(country, page, size, type, id);
		}

		if (!StringUtils.isEmpty(runningStatus) && "1".equals(runningStatus) && StringUtils.isEmpty(type)) {
			return tbEquipmentStatusService.findByNotActive(country, page, size, type, id);
		}

		if (!StringUtils.isEmpty(runningStatus) && "2".equals(runningStatus) && StringUtils.isEmpty(type)) {
			return tbEquipmentStatusService.findByIdleEquipment(country, page, size, type, id);
		}

		if (!StringUtils.isEmpty(runningStatus) && "3".equals(runningStatus) && StringUtils.isEmpty(type)) {
			return tbEquipmentStatusService.findByAbnormal(country, page, size, type, id);
		}

		TbEquipmentStatus tbEquipmentStatus = new TbEquipmentStatus();
		tbEquipmentStatus.setTransStatus(transStatus);
		tbEquipmentStatus.setRunningStatus(runningStatus);
		tbEquipmentStatus.setModuleStatus(moduleStatus);
		tbEquipmentStatus.setBanknoteBoxStatus(banknoteBoxStatus);
		tbEquipmentStatus.setNetworkStatus(networkStatus);
		tbEquipmentStatus.setPrrStatus(prrStatus);
		tbEquipmentStatus.setId(id);
		tbEquipmentStatus.setConnectStatus(connectStatus);
		tbEquipmentStatus.setMaintainStatus(maintainStatus);
		JSONData jsonData = JSONData.builder().build();

		jsonData = tbEquipmentStatusService.findByList(tbEquipmentStatus, country, page, size, type);
		log.info("监控设备列表数据：" + jsonData.getData());
		// jsonData = tbEquipmentStatusService.test(tbEquipmentStatus, country,
		// page, size, type,equipmentType);

		return jsonData;
	}

	//@AdminLog(interfaceCode = "/auth/equipmentList", interfaceDesc = "设备列表")
	@ApiOperation(value = "设备列表接口", httpMethod = "POST")
	@PostMapping("/equipmentList")
	public JSONData equipmentList(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size, HttpServletRequest request) {
		TbAdminUser admin = (TbAdminUser) request.getAttribute(AdminConstant.ADMIN);
		
		String id = request.getParameter("id");
		String verifyStatus = request.getParameter("verifyStatus");
		String equipmentSubType = request.getParameter("equipmentSubType");
		String countryId = request.getParameter("countryId");
		String onlineTime = request.getParameter("onlineTime");
		String runningStatus = request.getParameter("runningStatus");

		if (1l != admin.getRoleId()) {//如果不是超级管理员
			if (admin.getCountryId() != null) {
				countryId = admin.getCountryId().toString();
			}

		}
		Map<String, Object> params = new HashMap<String, Object>();

		if (!StringUtils.isEmpty(onlineTime)) {
			Date firstTime = CalendarUtil.correctDate(onlineTime + " 00:00:00", "yyyy-MM-dd HH:mm:ss");
			Date endTime = CalendarUtil.addDate(firstTime, 1);
			params.put("firstTime", firstTime);
			params.put("endTime", endTime);
		}

		params.put("page", page);
		params.put("size", size);
		params.put("id", id);
		params.put("verifyStatus", verifyStatus);
		params.put("equipmentSubType", equipmentSubType);
		params.put("countryId", countryId);
		params.put("runningStatus", runningStatus);
		return tbEquipmentSettingsService.findByCondition(params);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	@AdminLog(interfaceCode = "/auth/addEquipment", interfaceDesc = "添加设备")
	@ApiOperation(value = "添加设备接口", httpMethod = "POST")
	@PostMapping("/addEquipment")
	public JSONData addEquipment(HttpServletRequest request) {
		TbAdminUser admin = (TbAdminUser) request.getAttribute(AdminConstant.ADMIN);
		String id = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
		String onlineTime = request.getParameter("onlineTime");// yyyy-MM-dd
																// HH:mm
		String equipmentType = request.getParameter("equipmentType");
		String equipmentSubType = request.getParameter("equipmentSubType");// 币种
		String installLocation = request.getParameter("installLocation");
		String limitPerDay = request.getParameter("limitPerDay");// 每日取款限额

		String countryId = request.getParameter("countryId");
		String secondRegionId = request.getParameter("secondRegionId");// 二级区域
		String thirdRegionId = request.getParameter("thirdRegionId");// 三级区域
		String detailAddress = request.getParameter("detailAddress");

		String longitude = request.getParameter("longitude");//经度
		String latitude = request.getParameter("latitude");//纬度

		// String masterKey = request.getParameter("masterKey"); 待确定加密方法后加入

		if (StringUtils.isEmpty(detailAddress) || StringUtils.isEmpty(countryId) || StringUtils.isEmpty(id)
				|| StringUtils.isEmpty(onlineTime) || StringUtils.isEmpty(equipmentType)
				|| StringUtils.isEmpty(equipmentSubType) || StringUtils.isEmpty(installLocation)
				|| StringUtils.isEmpty(limitPerDay)) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode()).build();
		}

		// 算出零时区时间
		Date correctDate = CalendarUtil.correctDate(onlineTime, "yyyy-MM-dd HH:mm");

		DrawCurrencyCache.drawCurrencyList = tbWithdrawCurrencyService.selectAllDrawCurrency();
		// 判断币种是否符合配置
		if (!DrawCurrencyCache.ifExist(equipmentSubType)) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_CURRENCY_IS_ERROR.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_CURRENCY_IS_ERROR.getCode()).build();
		}

		TbEquipmentSettings tbEquipmentSettings = new TbEquipmentSettings();
		tbEquipmentSettings.setId(id);
		tbEquipmentSettings.setOnlineTime(correctDate);
		tbEquipmentSettings.setEquipmentType(equipmentType);
		tbEquipmentSettings.setEquipmentSubType(equipmentSubType);
		tbEquipmentSettings.setInstallLocation(installLocation);
		tbEquipmentSettings.setLimitPerDay(new BigDecimal(limitPerDay));
		tbEquipmentSettings.setCreateTime(new Date());
		tbEquipmentSettings.setCreateAdminId(admin.getId());
		tbEquipmentSettings.setCreateAdminName(admin.getUserName());
		
		if(!StringUtils.isEmpty(latitude)){
			tbEquipmentSettings.setLatitude(new BigDecimal(latitude));
		}
		if(!StringUtils.isEmpty(longitude)){
			tbEquipmentSettings.setLongitude(new BigDecimal(longitude));
		}
		
		// 生成rsa公钥和私钥
		try {
			Map<String, Object> keyPair = RSAUtil.generateKeyPair();
			tbEquipmentSettings.setPrivateKey((String) keyPair.get("privateKey"));// 私钥
			tbEquipmentSettings.setMasterKey((String) keyPair.get("publicKey"));// 公钥
		} catch (Exception e) {
			log.info(LogUtils.getExceptionInfo(e));
			// 尚未插入数据，发生异常可以直接返回
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getCode()).build();
		}

		TbEquipment tbEquipment = new TbEquipment();
		tbEquipment.setId(id);
		tbEquipment.setEquipmentStatus("0");// 设备状态 0-正常 1-故障
		tbEquipment.setUseStatus("0");// 使用状态 0-正常 1-闲置
		tbEquipment.setVerifyStatus("0");// 验证反馈 0：未激活，1：成功
		tbEquipment.setTransAmount(new BigDecimal(0));
		tbEquipment.setTransNum(0);
		tbEquipment.setCountry(tbAreaService.selectByCountry(countryId).getAreaName());
		tbEquipment.setCountryId(Long.valueOf(countryId));
		tbEquipment.setCreateTime(new Date());

		tbEquipment.setSecondRegionId(StringUtils.isEmpty(secondRegionId) ? null : Long.valueOf(secondRegionId));
		tbEquipment.setThirdRegionId(StringUtils.isEmpty(thirdRegionId) ? null : Long.valueOf(thirdRegionId));
		tbEquipment.setDetailAddress(detailAddress);
		tbEquipmentService.insert(tbEquipment);

		TbEquipment selectByKey = tbEquipmentService.selectByKey(id);
		Long equipmentNo = selectByKey.getEquipmentNo();
		String generatId = GeneratIdUtil.getGeneratIdUtil(equipmentNo);

		tbEquipmentSettings.setId(generatId);

		TbEquipmentStatus tbEquipmentStatus = new TbEquipmentStatus();
		tbEquipmentStatus.setId(generatId);
		tbEquipmentStatus.setTransStatus("9");// 凭条纸状态 0-纸满 1-纸少 2-无纸 3-未知
												// 4-暂停服务 9-初始化

		tbEquipmentStatus.setRunningStatus("1");// 整机状态 0设备正常 ,1未激活 , 2-闲置 3-异常
		tbEquipmentStatus.setModuleStatus("9");// 安全门 0-正常 1-出错 2-开 3-关 4-暂停服务
												// 9-初始化

		tbEquipmentStatus.setBanknoteBoxStatus("9");// 钞箱纸状态 0--正常 1-缺钞 2-空 4-未知
													// 5-暂停服务 9-初始化
		tbEquipmentStatus.setNetworkStatus("9");// 取款状态 0-设备正常在线 1-设备离线 2-无法交易
												// 3-未知状态 4-暂停服务 9-初始化

		tbEquipmentStatus.setUpdateTime(new Date());
		tbEquipmentStatus.setPrrStatus("9");// 凭条打印状态：0正常，1离线，2无法交易 ，3未知 4-暂停服务
											// 9-初始化
		tbEquipmentStatus.setMaintainStatus("0");// 初始维护状态 0-未维护 1-维护中
		tbEquipmentStatus.setConnectStatus("9");// 连接状态 0-正常 1-断网 9-初始化
		tbEquipmentStatus.setCimStatus("9");
		Map map = new HashMap<String, String>();
		map.put("id", id);
		map.put("generatId", generatId);
		tbEquipmentService.updateId(map);
		tbEquipmentStatusService.insert(tbEquipmentStatus);

		//更新日志操作描述
		String operationDesc = "添加设备"+generatId;
		request.setAttribute(AdminConstant.OPERATION_DESC,operationDesc);

		return tbEquipmentSettingsService.addTbEquipmentSettings(tbEquipmentSettings);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	//@AdminLog(interfaceCode = "/auth/findEquipment", interfaceDesc = "查询设备详情")
	@ApiOperation(value = "查询设备详情接口", httpMethod = "POST")
	@PostMapping("/findEquipment")
	public JSONData findEquipment(HttpServletRequest request) {
		String id = request.getParameter("id");
		if (StringUtils.isEmpty(id)) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode()).build();
		}

		Map map = tbEquipmentSettingsService.selectByKey1(id);
		map = MapUtil.joinDataEquipment(map);

		Map result = new HashMap();
		//过滤掉私钥，截取24位公钥返回
		map.remove("privateKey");
		String masterKey = map.get("masterKey")==null?"":map.get("masterKey").toString();
		masterKey = masterKey.substring(0,32);
		map.put("masterKey", masterKey);
		
		result.put("tbEquipmentSettings", map);
		return JSONData.builder().msg(EnumResponseMsg.RESP_SUCCESS.getMsg())
				.code(EnumResponseMsg.RESP_SUCCESS.getCode()).data(result).build();
	}

	@AdminLog(interfaceCode = "/auth/updateEquipment", interfaceDesc = "修改设备参数")
	@ApiOperation(value = "修改设备参数接口", httpMethod = "POST")
	@PostMapping("/updateEquipment")
	public JSONData updateEquipment(HttpServletRequest request) {
		String id = request.getParameter("id");
		String equipmentType = request.getParameter("equipmentType");
		String equipmentSubType = request.getParameter("equipmentSubType");
		String installLocation = request.getParameter("installLocation");
		String limitPerDay = request.getParameter("limitPerDay");// 每日取款限额
		// String masterKey = request.getParameter("masterKey"); 待确定加密方法后加入
		String countryId = request.getParameter("countryId");
		String secondRegionId = request.getParameter("secondRegionId");
		String thirdRegionId = request.getParameter("thirdRegionId");
		String detailAddress = request.getParameter("detailAddress");
		String longitude = request.getParameter("longitude");//经度
		String latitude = request.getParameter("latitude");//纬度

		if (StringUtils.isEmpty(detailAddress) || StringUtils.isEmpty(countryId) || StringUtils.isEmpty(id)
				|| StringUtils.isEmpty(equipmentType) || StringUtils.isEmpty(equipmentSubType)
				|| StringUtils.isEmpty(installLocation) || StringUtils.isEmpty(limitPerDay)) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode()).build();
		}

		// 判断币种是否符合配置
		DrawCurrencyCache.drawCurrencyList = tbWithdrawCurrencyService.selectAllDrawCurrency();
		if (!DrawCurrencyCache.ifExist(equipmentSubType)) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_CURRENCY_IS_ERROR.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_CURRENCY_IS_ERROR.getCode()).build();
		}

		TbEquipmentSettings tbEquipmentSettings = tbEquipmentSettingsService.selectByKey(id);
		TbEquipment tbEquipment = tbEquipmentService.selectByKey(id);
		String countryName = tbAreaService.selectByCountry(countryId).getAreaName();

		//更新日志操作描述 start
		String operationDesc ="编辑设备"+id+"的";
		boolean flag = false;//如果没有修改，则默认为false
		if(!equipmentType.equals(tbEquipmentSettings.getEquipmentType())){//设备类型
			if(equipmentType.equals("0")){
				operationDesc = operationDesc+"设备类型为取款 ";
			}else{
				operationDesc = operationDesc+"设备类型为存取款 ";
			}
			flag = true;
		}
		if(!countryId.equals(tbEquipment.getCountryId()+"")){//所在地区
			operationDesc = operationDesc+"设备地区为"+countryName+" ";
			flag = true;
		}
		if(!detailAddress.equals(tbEquipment.getDetailAddress())){//详细地址
			operationDesc = operationDesc+"设备详细地址为"+detailAddress+" ";
			flag = true;
		}
		if(!installLocation.equals(tbEquipmentSettings.getInstallLocation())){//安装位置
			operationDesc = operationDesc+"设备安装位置为"+installLocation+" ";
			flag = true;
		}
		if(new BigDecimal(limitPerDay).compareTo(tbEquipmentSettings.getLimitPerDay())!=0){//限额
			operationDesc = operationDesc+"设备每日取款限额为"+new BigDecimal(limitPerDay).intValue()+" ";
			flag = true;
		}
		if(flag){
			request.setAttribute(AdminConstant.OPERATION_DESC, operationDesc);
		}
		//更新日志操作描述 end
		
		tbEquipmentSettings.setId(id);
		
		tbEquipmentSettings.setEquipmentType(equipmentType);
		tbEquipmentSettings.setEquipmentSubType(equipmentSubType);
		tbEquipmentSettings.setInstallLocation(installLocation);
		tbEquipmentSettings.setLimitPerDay(new BigDecimal(limitPerDay));


		tbEquipment.setCountry(countryName);
		tbEquipment.setCountryId(Long.valueOf(countryId));
		tbEquipment.setSecondRegionId(StringUtils.isEmpty(secondRegionId) ? null : Long.valueOf(secondRegionId));
		tbEquipment.setThirdRegionId(StringUtils.isEmpty(thirdRegionId) ? null : Long.valueOf(thirdRegionId));
		tbEquipment.setDetailAddress(detailAddress);
		if(!StringUtils.isEmpty(latitude)){
			tbEquipmentSettings.setLatitude(new BigDecimal(latitude));
		}
		if(!StringUtils.isEmpty(longitude)){
			tbEquipmentSettings.setLongitude(new BigDecimal(longitude));
		}
		
		tbEquipmentService.update(tbEquipment);

		return tbEquipmentSettingsService.updateTbEquipmentSettings(tbEquipmentSettings);
	}

	//@AdminLog(interfaceCode = "/auth/findDowntimeEquipment", interfaceDesc = "查询停机设备")
	@ApiOperation(value = "查询停机设备接口", httpMethod = "POST")
	@PostMapping("/findDowntimeEquipment")
	public JSONData findDowntimeEquipment(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size, HttpServletRequest request) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("page", page);
		params.put("size", size);

		return tbEquipmentStatusService.findDowntimeEquipment(params);
	}

	//@AdminLog(interfaceCode = "/auth/equipmentNum", interfaceDesc = "查询设备数量")
	@ApiOperation(value = "查询设备数量接口", httpMethod = "POST")
	@PostMapping("/equipmentNum")
	public JSONData equipmentNum(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size, HttpServletRequest request) {
		Map<String, Object> params = new HashMap<String, Object>();
		String id = request.getParameter("id");
		String countryId = request.getParameter("countryId");// 地区
		String equipmentSubType = request.getParameter("equipmentSubType");// 币种(USD-美元
																			// EUR-欧元
																			// ，AUD-澳元，SGD-新加坡元
																			// )',
		String equipmentType = request.getParameter("equipmentType");
		String runningStatus = request.getParameter("runningStatus");

		TbAdminUser admin = (TbAdminUser) request.getAttribute(AdminConstant.ADMIN);
		if (1l != admin.getRoleId()) {//如果不是超级管理员
			if (admin.getCountryId() != null) {
				countryId = admin.getCountryId().toString();
			}
		}

		params.put("id", id);
		params.put("equipmentType", equipmentType);
		params.put("countryId", countryId);
		params.put("equipmentSubType", equipmentSubType);
		params.put("runningStatus", runningStatus);
		params.put("page", page);
		params.put("size", size);

		return tbEquipmentSettingsService.equipmentNum(params);
	}

	//@AdminLog(interfaceCode = "/auth/findFaultEquipment", interfaceDesc = "查询故障设备")
	@ApiOperation(value = "查询故障设备接口", httpMethod = "POST")
	@PostMapping("/findFaultEquipment")
	public JSONData findFaultEquipment(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size, HttpServletRequest request) {
		Map<String, Object> params = new HashMap<String, Object>();
		TbAdminUser admin = (TbAdminUser) request.getAttribute(AdminConstant.ADMIN);
		params.put("page", page);
		params.put("size", size);
		String id = request.getParameter("id");
		String countryId = request.getParameter("countryId");
		String firstTime = request.getParameter("firstTime");
		String endTime = request.getParameter("endTime");
		if (1l != admin.getRoleId()) {//如果不是超级管理员
			if (admin.getCountryId() != null) {
				countryId = admin.getCountryId().toString();
			}
		}
		if (!StringUtils.isEmpty(firstTime)) {
			String firstTimedate = CalendarUtil.correctDateStr(firstTime, appProperties.getGMTTimeZone(),
					"yyyy-MM-dd");
			params.put("firstTime", firstTimedate);
		}
		if (!StringUtils.isEmpty(endTime)) {
			String endTimedate = CalendarUtil.correctDateStr(endTime, appProperties.getGMTTimeZone(),
					"yyyy-MM-dd");
			params.put("endTime", endTimedate);
		}
		params.put("id", id);
		params.put("countryId", countryId);
		return tbEquipmentFaulLogService.findFaultEquipment(params);
	}

	//@AdminLog(interfaceCode = "/auth/lackMoneyEquipment", interfaceDesc = "查询缺纸缺钞设备列表")
	@ApiOperation(value = "查询缺纸缺钞设备列表接口", httpMethod = "POST")
	@PostMapping("/lackMoneyEquipment")
	public JSONData lackMoneyEquipment(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size, HttpServletRequest request) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("page", page);
		params.put("size", size);

		return tbEquipmentFaulLogService.lackMoneyEquipment(params);
	}

	//@AdminLog(interfaceCode = "/auth/cashFlowEquipment", interfaceDesc = "查询设备现金流量列表")
	@ApiOperation(value = "查询设备现金流量列表接口", httpMethod = "POST")
	@PostMapping("/cashFlowEquipment")
	public JSONData cashFlowEquipment(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size, HttpServletRequest request) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("page", page);
		params.put("size", size);

		return tbEquipmentService.cashFlowEquipment(params);
	}

	//@AdminLog(interfaceCode = "/auth/equipmentVrsionList", interfaceDesc = "查询设备版本列表")
	@ApiOperation(value = "查询设备版本列表接口", httpMethod = "POST")
	@PostMapping("/equipmentVrsionList")
	public JSONData equipmentVrsionList(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size, HttpServletRequest request) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("page", page);
		params.put("size", size);

		return tbEquipmentService.equipmentVrsionList(params);
	}

	//@AdminLog(interfaceCode = "/auth/equipmentAreaList", interfaceDesc = "查询设备区域列表接口")
	@ApiOperation(value = "查询设备区域列表接口", httpMethod = "POST")
	@PostMapping("/equipmentAreaList")
	public JSONData equipmentAreaList(HttpServletRequest request) {
		String id = request.getParameter("id");
		JSONData jsonData = JSONData.builder().build();
		jsonData = tbAreaService.selectByFristArea(request, id);
		return jsonData;
	}

	//@AdminLog(interfaceCode = "/auth/equipmentAreaNum", interfaceDesc = "查询区域设备数量接口")
	@ApiOperation(value = "查询区域设备数量", httpMethod = "POST")
	@PostMapping("/equipmentAreaNum")
	public JSONData equipmentAreaNum(HttpServletRequest request) {
		String country = request.getParameter("country");

		TbAdminUser admin = (TbAdminUser) request.getAttribute(AdminConstant.ADMIN);

		if (1l != admin.getRoleId()) {//如果不是超级管理员
			if (admin.getCountryId() != null) {
				country = admin.getCountryName().toString();
			}
		}

		JSONData jsonData = JSONData.builder().build();
		jsonData = tbEquipmentService.equipmentAreaNum(country);
		return jsonData;
	}

	@AdminLog(interfaceCode = "/auth/idleEquipment", interfaceDesc = "设备是否闲置处理接口")
	@ApiOperation(value = "设备是否闲置处理", httpMethod = "POST")
	@PostMapping("/idleEquipment")
	public JSONData idleEquipment(HttpServletRequest request) {
		String id = request.getParameter("id");
		String type = request.getParameter("type");// type 0设备正常 ,1未激活 , 2-闲置
													// 3-异常
		if (StringUtils.isEmpty(id) || StringUtils.isEmpty(type)) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode()).build();
		}
		TbEquipmentStatus tbEquipmentStatus = tbEquipmentStatusService.selectById(id);
		if ("2".equals(type)) {
			tbEquipmentStatus.setRunningStatus("1");// 1未激活
			tbEquipmentStatus.setPrrStatus("9");
			tbEquipmentStatus.setBanknoteBoxStatus("9");
			tbEquipmentStatus.setTransStatus("9");
			tbEquipmentStatus.setModuleStatus("9");
			tbEquipmentStatus.setNetworkStatus("9");
			tbEquipmentStatus.setConnectStatus("9");

			//更新日志操作描述
			String operationDesc = "启用设备"+id;
			request.setAttribute(AdminConstant.OPERATION_DESC, operationDesc);
		} else {
			tbEquipmentStatus.setRunningStatus("2");// 2-闲置
			tbEquipmentStatus.setPrrStatus("4");
			tbEquipmentStatus.setBanknoteBoxStatus("5");
			tbEquipmentStatus.setTransStatus("4");
			tbEquipmentStatus.setModuleStatus("4");
			tbEquipmentStatus.setNetworkStatus("4");
			tbEquipmentStatus.setConnectStatus("4");
			TbEquipment tbEquipment = new TbEquipment();
			tbEquipment.setId(id);
			tbEquipment.setDownTime(new Date());
			tbEquipmentService.update(tbEquipment);

			//更新日志操作描述
			String operationDesc = "停用设备"+id;
			request.setAttribute(AdminConstant.OPERATION_DESC, operationDesc);
		}

		tbEquipmentStatusService.update(tbEquipmentStatus);

		return JSONData.builder().msg(EnumResponseMsg.RESP_SUCCESS.getMsg())
				.code(EnumResponseMsg.RESP_SUCCESS.getCode()).build();
	}

	//@AdminLog(interfaceCode = "/auth/findEquipmentStatus", interfaceDesc = "查询设备整机状态接口")
	@ApiOperation(value = "查询设备整机状态", httpMethod = "POST")
	@PostMapping("/findEquipmentStatus")
	public JSONData findEquipmentStatus(HttpServletRequest request) {

		return tbEqipmentRunningStatusService.findAll();
	}

	//@AdminLog(interfaceCode = "/auth/getAllEquipmentLocation", interfaceDesc = "查询已在使用设备的位置信息")
	@ApiOperation(value = "查询已在使用设备的位置信息", httpMethod = "POST")
	@PostMapping("/getAllEquipmentLocation")
	public JSONData getAllEquipmentLocation(HttpServletRequest request){
		String type = request.getParameter("types");//机器类型，0-取款 1-存取款 0,1
		String drawCurrency = request.getParameter("drawCurrencys");//法币金额 CNY,USD

		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> data = new HashMap<String,Object>();
		if(StringUtils.isEmpty(type) || StringUtils.isEmpty(drawCurrency)){
			data.put("list", list);
			return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
					.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(data).build();
		}

		List<String> types = null;
		if(!StringUtils.isEmpty(type)){
			types = Arrays.asList(type.split(","));
		}
		List<String> drawCurrencys = null;
		if(!StringUtils.isEmpty(drawCurrency)){
			drawCurrencys = Arrays.asList(drawCurrency.split(","));
		}

		Map<String,Object> params = new HashMap<String,Object>();
		params.put("types", types);
		params.put("drawCurrencys" , drawCurrencys);
		list = tbEquipmentService.getAllEquipmentLocation(params);

		//获取币种和颜色对应列表
		List<Map<String,Object>> currencyList = tbWithdrawCurrencyService.currencyList();
		Map<String,Object> currencyColorMap = new HashMap<String,Object>();
		if(!CollectionUtils.isEmpty(currencyList)){
			for(int i=0;i<currencyList.size();i++){
				Map map = currencyList.get(i);
				currencyColorMap.put((String)map.get("currencyName"), AdminConstant.colorArr[i]);
			}
		}

		for(Map<String,Object> equipment : list){
			equipment.put("color", currencyColorMap.get(equipment.get("currency")));
		}

		data.put("list", list);
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(data).build();
	}
	
}
