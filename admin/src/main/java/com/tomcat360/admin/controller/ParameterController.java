package com.tomcat360.admin.controller;

import java.math.BigDecimal;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tomcat360.admin.aspect.AdminLog;
import com.tomcat360.admin.constant.AdminConstant;
import com.tomcat360.admin.enums.EnumResponseMsg;
import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbAdminUser;
import com.tomcat360.admin.model.TbArea;
import com.tomcat360.admin.model.TbEquipment;
import com.tomcat360.admin.model.TbEquipmentExample;
import com.tomcat360.admin.model.TbMerchantAccount;
import com.tomcat360.admin.model.TbMerchantAccountExample;
import com.tomcat360.admin.model.TbSettings;
import com.tomcat360.admin.model.TbSettingsExample;
import com.tomcat360.admin.model.TbTrans;
import com.tomcat360.admin.model.TbWithdrawCurrency;
import com.tomcat360.admin.properties.AppProperties;
import com.tomcat360.admin.service.SettingsService;
import com.tomcat360.admin.service.TbAllCurrencyService;
import com.tomcat360.admin.service.TbAreaService;
import com.tomcat360.admin.service.TbEquipmentService;
import com.tomcat360.admin.service.TbEquipmentSettingsService;
import com.tomcat360.admin.service.TbMerchantAccountService;
import com.tomcat360.admin.service.TbSettingsService;
import com.tomcat360.admin.service.TbTransService;
import com.tomcat360.admin.service.TbWithdrawCurrencyService;
import com.tomcat360.admin.util.FileUtil;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/auth")
@Slf4j
public class ParameterController {
	@Autowired
	private TbTransService tbTransService;
	@Autowired
	private TbWithdrawCurrencyService tbWithdrawCurrencyService;
	@Autowired
	private TbAreaService tbAreaService;
	@Autowired
	private SettingsService settingsService;
	@Autowired
	private TbAllCurrencyService tbAllCurrencyService;
	@Autowired
	private TbSettingsService tbSettingsService;
	@Autowired
	private TbEquipmentService tbEquipmentService;
	@Autowired
	private TbEquipmentSettingsService tbEquipmentSettingsService;
	@Autowired
	private AppProperties appProperties;
	@Autowired
	private TbMerchantAccountService tbMerchantAccountService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	//@AdminLog(interfaceCode = "/auth/currencyList", interfaceDesc = "查询币种接口")
	@ApiOperation(value = "查询币种接口", httpMethod = "POST")
	@PostMapping("/currencyList")
	public JSONData currencyList(HttpServletRequest request) {
		List<Map<String,Object>> list = tbWithdrawCurrencyService.currencyList();
		log.info("币种信息：" + list);

		if(!CollectionUtils.isEmpty(list)){
			for(int i=0;i<list.size();i++){
				Map map = list.get(i);
				map.put("color", AdminConstant.colorArr[i]);
			}
		}

		Map map = new HashMap();
		map.put("list", list);

		return JSONData.builder().msg(EnumResponseMsg.RESP_SUCCESS.getMsg())
				.code(EnumResponseMsg.RESP_SUCCESS.getCode()).data(map).build();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	//@AdminLog(interfaceCode = "/auth/findArea", interfaceDesc = "地区信息列表接口")
	@ApiOperation(value = "查询地区信息列表", httpMethod = "POST")
	@PostMapping("/findArea")
	public JSONData findArea(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size, HttpServletRequest request) {
		TbAdminUser admin = (TbAdminUser) request.getAttribute(AdminConstant.ADMIN);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("page", page);
		params.put("size", size);
		params.put("areaLevel", 1);
		if (1l != admin.getRoleId()) {//如果不是超级管理员
			params.put("countryId", admin.getCountryId());
		}
		JSONData findAll = tbAreaService.findAll(params);
		Map data = findAll.getData();
		List<TbArea> list = data.get("list") == null ? null : (List<TbArea>) data.get("list");
		for (TbArea tbArea : list) {
			BigDecimal serviceCharge = tbArea.getServiceCharge() == null ? null : tbArea.getServiceCharge();
			tbArea.setServiceCharge(serviceCharge.multiply(new BigDecimal("100")));
		}
		return findAll;
	}

	@AdminLog(interfaceCode = "/auth/addArea", interfaceDesc = "新增地区信息接口")
	@ApiOperation(value = "新增地区信息", httpMethod = "POST")
	@PostMapping("/addArea")
	public JSONData addArea(HttpServletRequest request) {
		String areaName = request.getParameter("areaName");
		String serviceCharge = request.getParameter("serviceCharge");
		String servicePhone = request.getParameter("servicePhone");
		String withdrawSum = request.getParameter("withdrawSum");
		if (StringUtils.isEmpty(areaName) || StringUtils.isEmpty(serviceCharge) || StringUtils.isEmpty(servicePhone)
				|| StringUtils.isEmpty(withdrawSum)) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode()).build();
		}
		// 判断区域名称是否存在
		List<TbArea> list = tbAreaService.selectByAreaName(areaName);
		if (list != null && list.size() > 0) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_AREA.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_AREA.getCode()).build();
		}
		Integer orderNum = tbAreaService.findOrderNum();
		TbArea tbArea = new TbArea();
		tbArea.setAreaName(areaName);
		tbArea.setServiceCharge(new BigDecimal(Double.valueOf(serviceCharge) * 0.01));
		tbArea.setServicePhone(servicePhone);
		tbArea.setCreateTime(new Date());
		tbArea.setUpdateTime(new Date());
		tbArea.setStatus("0");
		tbArea.setAreaLevel(1);
		tbArea.setWithdrawSum(new BigDecimal(withdrawSum));
		tbArea.setParentId(0l);
		tbArea.setOrderNum(++orderNum);
		tbAreaService.insert(tbArea);

		// 更新日志操作描述 start
		String operationDesc = "新增地区(" + areaName + ")";
		boolean logFlag = true;// 如果没有找到，则默认为false

		if (logFlag) {
			request.setAttribute(AdminConstant.OPERATION_DESC, operationDesc);
		}

		return JSONData.builder().msg(EnumResponseMsg.RESP_SUCCESS.getMsg())
				.code(EnumResponseMsg.RESP_SUCCESS.getCode()).build();
	}

	@AdminLog(interfaceCode = "/auth/updateArea", interfaceDesc = "修改地区信息接口")
	@ApiOperation(value = "修改地区信息", httpMethod = "POST")
	@PostMapping("/updateArea")
	public JSONData updateArea(HttpServletRequest request) {
		String id = request.getParameter("id");
		String areaName = request.getParameter("areaName");
		String serviceCharge = request.getParameter("serviceCharge");
		String servicePhone = request.getParameter("servicePhone");
		String withdrawSum = request.getParameter("withdrawSum");
		String type = request.getParameter("type");
		if (StringUtils.isEmpty(areaName) || StringUtils.isEmpty(id)) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode()).build();
		}
		TbEquipmentExample example1 = new TbEquipmentExample();
		example1.createCriteria().andCountryIdEqualTo(Long.valueOf(id));
		List<TbEquipment> select = tbEquipmentService.select(example1);
		if (select != null && select.size() > 0) {
			TbArea selectByCountry = tbAreaService.selectByCountry(id);
			if (!selectByCountry.getAreaName().equals(areaName)) {
				return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_AREA_EQUIPMENT.getMsg() + "，无法修改区域名称")
						.code(EnumResponseMsg.RESP_ERROR_AREA_EQUIPMENT.getCode()).build();
			}
		}

		TbArea tbArea = new TbArea();
		tbArea.setId(Long.valueOf(id));
		if (!StringUtils.isEmpty(type) && type.equals("0")) {
			// 判断该区域下是否已有设备
			TbEquipmentExample example = new TbEquipmentExample();
			example.createCriteria().andCountryIdEqualTo(Long.valueOf(id));
			List<TbEquipment> liste = tbEquipmentService.select(example);
			if (liste != null && liste.size() > 0) {
				for (TbEquipment tbEquipment : liste) {
					String id2 = tbEquipment.getId();
					if (id2 != id) {
						return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_AREA_EQUIPMENT.getMsg())
								.code(EnumResponseMsg.RESP_ERROR_AREA_EQUIPMENT.getCode()).build();
					}
				}
			}

			tbArea.setStatus("1");
		} else if (!StringUtils.isEmpty(type) && type.equals("1")) {
			tbArea.setStatus("0");
		}

		tbArea.setAreaName(areaName);
		if (!StringUtils.isEmpty(serviceCharge)) {
			tbArea.setServiceCharge(new BigDecimal(Double.valueOf(serviceCharge) * 0.01));
		}
		if (!StringUtils.isEmpty(withdrawSum)) {
			tbArea.setWithdrawSum(new BigDecimal(withdrawSum));
		}
		tbArea.setServicePhone(servicePhone);
		tbArea.setUpdateTime(new Date());

		List<TbArea> selectByExample = tbAreaService.selectByAreaName(areaName);
		for (TbArea tbArea2 : selectByExample) {
			Long id2 = tbArea2.getId();
			if (id2 != Long.valueOf(id)) {
				return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_AREANAME.getMsg())
						.code(EnumResponseMsg.RESP_ERROR_AREANAME.getCode()).build();
			}
		}

		// 更新日志操作描述 start
		TbArea ta = tbAreaService.selectByCountry(id);// 获取数据库修改之前的信息
		String areaName2 = ta.getAreaName();
		BigDecimal serviceCharge2 = ta.getServiceCharge();
		String servicePhone2 = ta.getServicePhone();
		BigDecimal withdrawSum2 = ta.getWithdrawSum();

		String operationDesc = "修改地区(" + areaName2 + ")";
		boolean logFlag = false;// 如果没有找到，则默认为false

		if (StringUtils.isEmpty(areaName) && !areaName.equals(areaName2)) {
			operationDesc = operationDesc + "为:" + areaName;
			logFlag = true;
		}
		if (!StringUtils.isEmpty(servicePhone) && !servicePhone.equals(servicePhone2)) {
			operationDesc = operationDesc + ",将服务电话改为:" + servicePhone;
			logFlag = true;
		}
		if (!StringUtils.isEmpty(serviceCharge)) {
			BigDecimal sc = new BigDecimal(serviceCharge);
			sc = sc.multiply(new BigDecimal("0.01"));
			if (sc.compareTo(serviceCharge2) != 0) {
				operationDesc = operationDesc + ",将手续费改为:" + serviceCharge;
				logFlag = true;
			}
		}
		if (!StringUtils.isEmpty(withdrawSum)) {
			BigDecimal ws = new BigDecimal(withdrawSum);
			if (ws.compareTo(withdrawSum2) != 0) {
				operationDesc = operationDesc + ",将每日限额改为:" + withdrawSum;
				logFlag = true;
			}
		}

		if (logFlag) {
			request.setAttribute(AdminConstant.OPERATION_DESC, operationDesc);
		}
		JSONData jsonData = tbAreaService.updateByAreaName(tbArea);
		return jsonData;
	}

	/**
	 * 停用启用地区
	 *
	 * @param request
	 * @return
	 */
	@AdminLog(interfaceCode = "/auth/disArea", interfaceDesc = "停用启用地区接口")
	@ApiOperation(value = "停用启用地区接口", httpMethod = "POST")
	@PostMapping("/disArea")
	public JSONData disArea(HttpServletRequest request) {
		String id = request.getParameter("id");// 区域id
		String status = request.getParameter("status");
		if (StringUtils.isEmpty(id) || StringUtils.isEmpty(status)) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode()).build();
		}

		TbArea tbArea = new TbArea();
		tbArea.setId(Long.valueOf(id));
		// 记录日志
		TbArea selectByCountry = tbAreaService.selectByCountry(id);
		boolean logFlag = true;//
		String operationDesc = "";

		if (!StringUtils.isEmpty(status) && status.equals("0")) {
			// 判断该区域下是否已有设备
			TbEquipmentExample example = new TbEquipmentExample();
			example.createCriteria().andCountryIdEqualTo(Long.valueOf(id));
			List<TbEquipment> liste = tbEquipmentService.select(example);
			if (liste != null && liste.size() > 0) {
				for (TbEquipment tbEquipment : liste) {
					String id2 = tbEquipment.getId();
					if (id2 != id) {
						return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_AREA_EQUIPMENT.getMsg())
								.code(EnumResponseMsg.RESP_ERROR_AREA_EQUIPMENT.getCode()).build();
					}
				}
			}
			operationDesc = operationDesc + "停用地区 ";
			tbArea.setStatus("1");
		} else if (!StringUtils.isEmpty(status) && status.equals("1")) {
			operationDesc = operationDesc + "启用地区 ";
			tbArea.setStatus("0");
		}
		operationDesc = operationDesc + "(" + selectByCountry.getAreaName() + ")";

		if (logFlag) {
			request.setAttribute(AdminConstant.OPERATION_DESC, operationDesc);
		}

		tbAreaService.update(tbArea);
		return JSONData.builder().msg(EnumResponseMsg.RESP_SUCCESS.getMsg())
				.code(EnumResponseMsg.RESP_SUCCESS.getCode()).build();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	//@AdminLog(interfaceCode = "/auth/withdrawCurrencyInfo", interfaceDesc = "取款币种信息列表接口")
	@ApiOperation(value = "取款币种信息列表", httpMethod = "POST")
	@PostMapping("/withdrawCurrencyInfo")
	public JSONData withdrawCurrencyInfo(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size, HttpServletRequest request) {
		Map params = new HashMap();
		params.put("page", page);
		params.put("size", size);
		return tbWithdrawCurrencyService.withdrawCurrencyInfo(params);
	}

	@Transactional
	@AdminLog(interfaceCode = "/auth/addCurrencyInfo", interfaceDesc = "新增币种信息")
	@ApiOperation(value = "新增币种信息", httpMethod = "POST")
	@PostMapping("/addCurrencyInfo")
	public JSONData addCurrencyInfo(String descCny, String currencyCode, String withdrawMoney1, String withdrawMoney2,
			String withdrawMoney3, String withdrawMoney4, String withdrawMoney5, String withdrawMoney6,
			HttpServletRequest request) {
		// 判断不能为空的参数
		if (StringUtils.isEmpty(descCny) || StringUtils.isEmpty(currencyCode) || StringUtils.isEmpty(withdrawMoney1)
				|| StringUtils.isEmpty(withdrawMoney2) || StringUtils.isEmpty(withdrawMoney3)
				|| StringUtils.isEmpty(withdrawMoney4) || StringUtils.isEmpty(withdrawMoney5)
				|| StringUtils.isEmpty(withdrawMoney6)) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg()).build();
		}

		List<TbWithdrawCurrency> list = tbWithdrawCurrencyService.findByCurrencyName(currencyCode);
		if (list != null && list.size() > 0) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_CURRENCY_EQUIPMENT.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_CURRENCY_EQUIPMENT.getMsg()).build();
		}

		// 新增记录
		Date now = new Date();
		TbWithdrawCurrency withdrawCurrency = new TbWithdrawCurrency();
		withdrawCurrency.setCurrencyName(currencyCode);
		withdrawCurrency.setDescCny(descCny);
		withdrawCurrency.setCreateTime(now);
		withdrawCurrency.setUpdateTime(now);
		withdrawCurrency.setStatus("0");
		withdrawCurrency.setWithdrawMoney1(Integer.parseInt(withdrawMoney1));
		withdrawCurrency.setWithdrawMoney2(Integer.parseInt(withdrawMoney2));
		withdrawCurrency.setWithdrawMoney3(Integer.parseInt(withdrawMoney3));
		withdrawCurrency.setWithdrawMoney4(Integer.parseInt(withdrawMoney4));
		withdrawCurrency.setWithdrawMoney5(Integer.parseInt(withdrawMoney5));
		withdrawCurrency.setWithdrawMoney6(Integer.parseInt(withdrawMoney6));
		tbWithdrawCurrencyService.insert(withdrawCurrency);

		// 记录日志
		String operationDesc = "新增币种：(" + descCny + "|" + currencyCode + ")";
		boolean logFlag = true;//

		if (logFlag) {
			request.setAttribute(AdminConstant.OPERATION_DESC, operationDesc);
		}

		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
	}

	@Transactional
	@AdminLog(interfaceCode = "/auth/updateCurrencyInfo", interfaceDesc = "修改币种信息")
	@ApiOperation(value = "修改币种信息", httpMethod = "POST")
	@PostMapping("/updateCurrencyInfo")
	public JSONData updateCurrencyInfo(String descCny, String currencyCode, String withdrawMoney1,
			String withdrawMoney2, String withdrawMoney3, String withdrawMoney4, String withdrawMoney5,
			String withdrawMoney6, String type, String id, HttpServletRequest request) {
		if (StringUtils.isEmpty(currencyCode) || StringUtils.isEmpty(id)) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg()).build();
		}
		TbWithdrawCurrency tbWithdrawCurrencyId = tbWithdrawCurrencyService.findById(Long.valueOf(id));
		List<Map<String, Object>> list = tbEquipmentSettingsService
				.findEquipmentByCurrencyCode(tbWithdrawCurrencyId.getCurrencyName());
		// 记录日志
		String logCurrencyName = tbWithdrawCurrencyId.getCurrencyName();
		String logDescCny = tbWithdrawCurrencyId.getDescCny();
		String operationDesc = "";
		boolean logFlag = false;//

		// 如果type不为null 则是调用的启用停用功能
		if (!StringUtils.isEmpty(type) && type.equals("0")) {
			if (list != null && list.size() > 0) {
				return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_CURRENCY_EQUIPMENT.getMsg())
						.code(EnumResponseMsg.RESP_ERROR_CURRENCY_EQUIPMENT.getCode()).build();
			}

			operationDesc = operationDesc + "停用币种(" + logDescCny + "|" + logCurrencyName + ")";
			request.setAttribute(AdminConstant.OPERATION_DESC, operationDesc);
			return tbWithdrawCurrencyService.delete(currencyCode);
		} else if (!StringUtils.isEmpty(type) && type.equals("1")) {

			operationDesc = operationDesc + "启用币种(" + logDescCny + "|" + logCurrencyName + ")";
			request.setAttribute(AdminConstant.OPERATION_DESC, operationDesc);
			return tbWithdrawCurrencyService.start(currencyCode);
		}

		// 判断不能为空的参数
		if (StringUtils.isEmpty(descCny) || StringUtils.isEmpty(currencyCode) || StringUtils.isEmpty(withdrawMoney1)
				|| StringUtils.isEmpty(withdrawMoney2) || StringUtils.isEmpty(withdrawMoney3)
				|| StringUtils.isEmpty(withdrawMoney4) || StringUtils.isEmpty(withdrawMoney5)
				|| StringUtils.isEmpty(withdrawMoney6)) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg()).build();
		}
		// 取款面额不能重复
		Set<String> set = new HashSet<String>();
		set.add(withdrawMoney1.trim());
		set.add(withdrawMoney2.trim());
		set.add(withdrawMoney3.trim());
		set.add(withdrawMoney4.trim());
		set.add(withdrawMoney5.trim());
		set.add(withdrawMoney6.trim());
		if (set.size() != 6) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_WITHDRAWMONEY.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_WITHDRAWMONEY.getMsg()).build();
		}

		if (list != null && list.size() > 0 && (!tbWithdrawCurrencyId.getCurrencyName().equals(currencyCode)
				|| !tbWithdrawCurrencyId.getDescCny().equals(descCny))) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_CURRENCY_EQUIPMENT.getMsg() + ",无法修改币种符号或币种中文名称")
					.code(EnumResponseMsg.RESP_ERROR_CURRENCY_EQUIPMENT.getCode()).build();
		}

		// 判断该币种名称是否已有设备使用
		List<TbWithdrawCurrency> listWith = tbWithdrawCurrencyService.findByCurrencyName(currencyCode);
		for (TbWithdrawCurrency tbWithdrawCurrency : listWith) {
			String currencyCode2 = tbWithdrawCurrency.getCurrencyName();
			Long id2 = tbWithdrawCurrency.getId();
			if (currencyCode2.equals(currencyCode) && Long.valueOf(id) != id2) {
				return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_CURRENCY_CODE.getMsg())
						.code(EnumResponseMsg.RESP_ERROR_CURRENCY_CODE.getCode()).build();
			}
		}
		// 判断该币种中文名称是否已被使用
		List<TbWithdrawCurrency> listCny = tbWithdrawCurrencyService.findByDescCny(descCny);
		for (TbWithdrawCurrency tbWithdrawCurrency : listCny) {
			String descCny2 = tbWithdrawCurrency.getDescCny();
			Long id2 = tbWithdrawCurrency.getId();
			if (descCny2.equals(descCny) && Long.valueOf(id) != id2) {
				return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_CURRENCY_CNY.getMsg())
						.code(EnumResponseMsg.RESP_ERROR_CURRENCY_CNY.getCode()).build();
			}
		}

		// 修改数据
		Date now = new Date();
		TbWithdrawCurrency withdrawCurrency = new TbWithdrawCurrency();
		withdrawCurrency.setId(Long.valueOf(id));
		withdrawCurrency.setCurrencyName(currencyCode);
		withdrawCurrency.setDescCny(descCny);
		withdrawCurrency.setUpdateTime(now);
		Integer w1 = Integer.parseInt(withdrawMoney1);
		Integer w2 = Integer.parseInt(withdrawMoney2);
		Integer w3 = Integer.parseInt(withdrawMoney3);
		Integer w4 = Integer.parseInt(withdrawMoney4);
		Integer w5 = Integer.parseInt(withdrawMoney5);
		Integer w6 = Integer.parseInt(withdrawMoney6);
		withdrawCurrency.setWithdrawMoney1(w1);
		withdrawCurrency.setWithdrawMoney2(w2);
		withdrawCurrency.setWithdrawMoney3(w3);
		withdrawCurrency.setWithdrawMoney4(w4);
		withdrawCurrency.setWithdrawMoney5(w5);
		withdrawCurrency.setWithdrawMoney6(w6);
		withdrawCurrency.setStatus(type);
		withdrawCurrency.setDescEn(currencyCode);
		tbWithdrawCurrencyService.update(withdrawCurrency);
		
		
		String currencyName2 = tbWithdrawCurrencyId.getCurrencyName();
		String descCny2 = tbWithdrawCurrencyId.getDescCny();
		Integer withdrawMoney12 = tbWithdrawCurrencyId.getWithdrawMoney1();
		Integer withdrawMoney22 = tbWithdrawCurrencyId.getWithdrawMoney2();
		Integer withdrawMoney32 = tbWithdrawCurrencyId.getWithdrawMoney3();
		Integer withdrawMoney42 = tbWithdrawCurrencyId.getWithdrawMoney4();
		Integer withdrawMoney52 = tbWithdrawCurrencyId.getWithdrawMoney5();
		Integer withdrawMoney62 = tbWithdrawCurrencyId.getWithdrawMoney6();
		if (!withdrawMoney12.equals(w1) || !withdrawMoney22.equals(w2) || !withdrawMoney32.equals(w3)
				|| !withdrawMoney42.equals(w4) || !withdrawMoney52.equals(w5) || !withdrawMoney62.equals(w6)) {
			logFlag = true;
			operationDesc = operationDesc + "修改币种(" + logDescCny + "|" + logCurrencyName + ")的取款面额："+w1+","+w2+","+w3+","+w4+","+w5+","+w6+".";
		}
		
		if(!currencyName2.equals(currencyCode)){
			logFlag = true;
			operationDesc = operationDesc + "修改币种(" + logDescCny + "|" + logCurrencyName + ")的名称为："+currencyCode;
		}
		
		if(descCny2.equals(descCny)){
			logFlag = true;
			operationDesc = operationDesc + "修改币种(" + logDescCny + "|" + logCurrencyName + ")的中文名称为："+descCny;
		}
		
		if(logFlag){
			request.setAttribute(AdminConstant.OPERATION_DESC, operationDesc);
		}
		
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
	}

	/**
	 * 停用启用币种
	 * 
	 * @param request
	 * @return
	 */
	@AdminLog(interfaceCode = "/auth/disCurrency", interfaceDesc = "停用启用币种接口")
	@ApiOperation(value = "停用启用币种", httpMethod = "POST")
	@PostMapping("/disCurrency")
	public JSONData disCurrency(HttpServletRequest request, String type, String currencyCode) {
		if (StringUtils.isEmpty(type) || StringUtils.isEmpty(currencyCode)) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg()).build();
		}

		if (type.equals("0")) {
			return tbWithdrawCurrencyService.delete(currencyCode);
		}
		return tbWithdrawCurrencyService.start(currencyCode);
	}

	//@AdminLog(interfaceCode = "/auth/querySettingsList", interfaceDesc = "查询参数列表")
	@ApiOperation(value = "查询参数列表", httpMethod = "POST")
	@PostMapping("/querySettingsList")
	public JSONData querySettingsList(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size, HttpServletRequest request) {
		String settingsType = (String) request.getParameter("settingsType");
		String settingsCode = (String) request.getParameter("settingsCode");
		String settingsName = (String) request.getParameter("settingsName");

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("settingsType", settingsType);
		params.put("settingsCode", settingsCode);
		params.put("settingsName", settingsName);
		params.put("page", page);
		params.put("size", size);

		return settingsService.findByCondition(params);
	}

	@AdminLog(interfaceCode = "/auth/addSettings", interfaceDesc = "新增参数")
	@ApiOperation(value = "新增参数", httpMethod = "POST")
	@PostMapping("/addSettings")
	public JSONData addSettings(String settingsType, String settingsCode, String settingsName, String settingsValue,
			String settingsValueType, String remark, HttpServletRequest request) {
		// 记录日志
		String operationDesc = "";
		boolean logFlag = false;//
		
		
		
		if (StringUtils.isEmpty(settingsCode) || StringUtils.isEmpty(settingsName) || StringUtils.isEmpty(settingsValue)
				|| StringUtils.isEmpty(settingsType) || StringUtils.isEmpty(settingsValueType)) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg()).build();
		}
		if (settingsType.equals("1")) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_SYSTEM_SETTINGS.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_SYSTEM_SETTINGS.getMsg()).build();
		}

		// 判断是否是新增数字货币币种，如果是，则判断是否重复新增，增加商户表中币种的数据
		if ("2".equals(settingsType)) {
			String merchantNo = appProperties.getMerchantNo();
			List<TbSettings> list = settingsService.findByTypeAndValue(settingsType, settingsValue);
			if (!CollectionUtils.isEmpty(list)) {
				return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_CURRENCY.getCode())
						.msg(EnumResponseMsg.RESP_ERROR_CURRENCY.getMsg()).build();
			}
			TbMerchantAccountExample merchantExample = new TbMerchantAccountExample();
			merchantExample.createCriteria().andMerchantNoEqualTo(merchantNo).andCurrencyEqualTo(settingsValue);
			List<TbMerchantAccount> accList = tbMerchantAccountService.findByExample(merchantExample);
			if (CollectionUtils.isEmpty(accList)) {// 如果商户表中还没有记录，则新增
				TbMerchantAccount tbMerchantAccount = new TbMerchantAccount();
				tbMerchantAccount.setMerchantNo(merchantNo);// 商户号
				tbMerchantAccount.setCurrency(settingsValue);// 数字货币币种简写
				tbMerchantAccountService.insert(tbMerchantAccount);
			}
		}

		// 新增版本参数，去查询版本文件是否存在
		if (settingsType != null && settingsType.equals("3")) {
			String versionFilePath = appProperties.getVersionFilePath();
			boolean fileExist = FileUtil.getFileExist(versionFilePath, settingsValue + "txt");
			if (!fileExist) {
				return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_VERSION_NOT.getCode())
						.msg(EnumResponseMsg.RESP_ERROR_VERSION_NOT.getMsg()).build();

			}
		}

		TbSettings settings = new TbSettings();
		settings.setSettingsCode(settingsCode);
		settings.setSettingsNameCn(settingsName);
		settings.setSettingsType(settingsType);
		settings.setSettingsValue(settingsValue);
		settings.setSettingsValueType(settingsValueType);
		settings.setRemark(remark);
		settings.setCreateTime(new Date());
		settings.setUpdateTime(new Date());
		settings.setStatus("0");// 状态 0-正常 1-禁用
		settingsService.insert(settings);
		//参数类型(0-参数分类，1-系统参数，2-数字货币币种，3-atm版本)
		if(settingsType.equals("1")){
			operationDesc = operationDesc+"新增系统参数";
		}else if(settingsType.equals("2")){
			operationDesc = operationDesc+"新增数字货币币种参数";
		}else if(settingsType.equals("3")){
			operationDesc = operationDesc+"新增atm版本参数";
		}
		operationDesc = operationDesc+":"+settingsName;
		
		
		if(logFlag){
			request.setAttribute(AdminConstant.OPERATION_DESC, operationDesc);
		}
		
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
	}

	@AdminLog(interfaceCode = "/auth/updateSettings", interfaceDesc = "修改参数")
	@ApiOperation(value = "修改参数", httpMethod = "POST")
	@PostMapping("/updateSettings")
	public JSONData updateSettings(String id, String settingsType, String settingsCode, String settingsName,
			String settingsValue, String settingsValueType, String remark, String status, HttpServletRequest request) {
		if (StringUtils.isEmpty(id) || StringUtils.isEmpty(status)) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg()).build();
		}
		TbSettingsExample example = new TbSettingsExample();
		example.createCriteria().andIdEqualTo(Long.valueOf(id));
		List<TbSettings> list = tbSettingsService.selectExample(example);

		if (!StringUtils.isEmpty(settingsValue)) {
			// 判断修改的参数是否符合参数值类型
			for (TbSettings tbSettings : list) {
				String settingsValueType2 = tbSettings.getSettingsValueType();
				if (settingsValueType2.equals("int")) {
					try {
						Integer.valueOf(settingsValue);

					} catch (Exception e) {
						return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_TYPE_CHANGGE.getCode())
								.msg(EnumResponseMsg.RESP_ERROR_TYPE_CHANGGE.getMsg()).build();
					}
				} else if (settingsValueType2.equals("double")) {
					try {
						Double.valueOf(settingsValue);

					} catch (Exception e) {
						return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_TYPE_CHANGGE.getCode())
								.msg(EnumResponseMsg.RESP_ERROR_TYPE_CHANGGE.getMsg()).build();
					}
				}
			}
		}
		//判断修改的数据是否是系统参数，如果是择不让修改参数代码 settingsCode
		if(!StringUtils.isEmpty(settingsType) && settingsType.equals("1") && !StringUtils.isEmpty(settingsCode)){
			TbSettings tbSettings = list.get(0);
			if(!settingsCode.equals(tbSettings.getSettingsCode())){
				return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_SYSTEM_CODE.getCode())
						.msg(EnumResponseMsg.RESP_ERROR_SYSTEM_CODE.getMsg()).build();
			}
		}
		
		// 判断数字货币是否已经使用过了，如果使用过 则不能更改数字货币名称
		for (TbSettings tbSettings : list) {
			if (settingsType != null && settingsType.equals("2") && !StringUtils.isEmpty(settingsValue)
					&& !settingsValue.equals(tbSettings.getSettingsValue())) {
				TbTrans trans = tbTransService.selectNumCurrency(tbSettings.getSettingsValue());
				if (trans != null) {
					return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_DEDUCT_CURRENCY.getCode())
							.msg(EnumResponseMsg.RESP_ERROR_DEDUCT_CURRENCY.getMsg()).build();
				}

			}
		}
		// 修改版本参数，去查询版本文件是否存在
		if (settingsType != null && settingsType.equals("3")) {
			String versionFilePath = appProperties.getVersionFilePath();
			boolean fileExist = FileUtil.getFileExist(versionFilePath, settingsValue + "txt");
			if (!fileExist) {
				return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_VERSION_NOT.getCode())
						.msg(EnumResponseMsg.RESP_ERROR_VERSION_NOT.getMsg()).build();
			}
		}

		// 如果是修改币种，则判断是否修改了值，如果修改了值，要判断是否已经存在，不存在，则要更新对应的商户账户表
		if ("2".equals(settingsType)) {
			TbSettings settings = list.get(0);
			if (!settings.getSettingsValue().equals(settingsValue)) {
				String merchantNo = appProperties.getMerchantNo();
				List<TbSettings> otherList = settingsService.findByTypeAndValueExcpSelf(settingsType, settingsValue,
						Long.parseLong(id));
				if (!CollectionUtils.isEmpty(otherList)) {
					return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_CURRENCY.getCode())
							.msg(EnumResponseMsg.RESP_ERROR_CURRENCY.getMsg()).build();
				}
				TbMerchantAccountExample merchantExample = new TbMerchantAccountExample();
				merchantExample.createCriteria().andMerchantNoEqualTo(merchantNo)
						.andCurrencyEqualTo(settings.getSettingsValue());
				List<TbMerchantAccount> accList = tbMerchantAccountService.findByExample(merchantExample);
				if (CollectionUtils.isEmpty(accList)) {// 如果商户表中没有记录，则新增
					TbMerchantAccount tbMerchantAccount = new TbMerchantAccount();
					tbMerchantAccount.setMerchantNo(merchantNo);// 商户号
					tbMerchantAccount.setCurrency(settingsValue);// 数字货币币种简写
					tbMerchantAccountService.insert(tbMerchantAccount);
				} else {// 有记录则修改
					TbMerchantAccount tbMerchantAccount = accList.get(0);
					tbMerchantAccount.setCurrency(settingsValue);
					tbMerchantAccountService.update(tbMerchantAccount);
				}
			}
		}

		TbSettings settings = new TbSettings();
		settings.setId(Long.parseLong(id));
		settings.setStatus(status);// 状态 0-正常 1-禁用
		settings.setSettingsCode(settingsCode);
		settings.setSettingsNameCn(settingsName);
		settings.setSettingsType(settingsType);
		settings.setSettingsValue(settingsValue);
		settings.setSettingsValueType(settingsValueType);
		settings.setRemark(remark);
		settings.setUpdateTime(new Date());
		settingsService.update(settings);

		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
	}

	//@AdminLog(interfaceCode = "/auth/findAllCurrency", interfaceDesc = "全币种信息接口")
	@ApiOperation(value = "查询全币种信息", httpMethod = "POST")
	@PostMapping("/findAllCurrency")
	public JSONData findAllCurrency(HttpServletRequest request) {
		String type = request.getParameter("type");
		return tbAllCurrencyService.findAllCurrency(type);
	}

	//@AdminLog(interfaceCode = "/auth/findAllCurrency", interfaceDesc = "查询参数分类信息接口")
	@ApiOperation(value = "查询参数分类信息", httpMethod = "POST")
	@PostMapping("/getParameterType")
	public JSONData getParameterType(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size, HttpServletRequest request) {
		Map<String, Object> params = new HashMap<String, Object>();

		return tbSettingsService.getParameterType(params);
	}

	//@AdminLog(interfaceCode = "/auth/queryCoinsList", interfaceDesc = "查询数字货币列表")
	@ApiOperation(value = "查询数字货币列表", httpMethod = "POST")
	@PostMapping("/queryCoinsList")
	public JSONData queryCoinsList(HttpServletRequest request) {
		return settingsService.queryCoinsList();
	}

}
