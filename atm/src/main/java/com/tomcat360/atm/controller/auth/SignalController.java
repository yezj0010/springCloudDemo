package com.tomcat360.atm.controller.auth;

import com.tomcat360.atm.aspect.UserLog;
import com.tomcat360.atm.constant.AtmConstant;
import com.tomcat360.atm.enums.EnumResponseMsg;
import com.tomcat360.atm.model.*;
import com.tomcat360.atm.properties.AppProperties;
import com.tomcat360.atm.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/api")
public class SignalController {
	
	@Autowired
	private TbEquipmentSettingsService tbEquipmentSettingsService;

	@Autowired
	private TbEquipmentFaulLogService tbEquipmentFaulLogService;

	@Autowired
	private TbEquipmentStatusService tbEquipmentStatusService;
	
	@Autowired
	private WithdrawCurrencyService withdrawCurrencyService;

	@Autowired
	private TbSettingsService tbSettingsService;

	@Autowired
	private TbEquipmentService tbEquipmentService;

	@Autowired
	private TbAreaService tbAreaService;

	@Autowired
	private AppProperties appProperties;

	@Transactional
	@UserLog(interfaceCode = "/api/signalchecked", interfaceDesc = "通讯检测，获取C端设备状态")
	@RequestMapping("/signalchecked")
	public JSONData signalchecked(HttpServletRequest request) {
		String id = (String)request.getAttribute("termNo");//设备编号
		String runningStatus = (String)request.getAttribute("runningStatus");//【用来确定维护状态】 ATM整机设备状态 0-正常服务 1-暂停服务 2-维护
		String prrStatus = (String)request.getAttribute("prrStatus");//【不一致】 凭条状态 0-设备正常在线 1-设备离线 2-设备存在不能做交易 3-忙碌/未知状态/有疑问
		String cimStatus = (String)request.getAttribute("cimStatus");//【不一致】 存款状态 0-设备正常在线 1-设备离线 2-设备存在不能做交易 3-忙碌/未知状态/有疑问
		String cdmStatus = (String)request.getAttribute("cdmStatus");//【不一致】 取款状态 0-设备正常在线 1-设备离线 2-设备存在不能做交易 3-忙碌/未知状态/有疑问
		String prrPagerStatus = (String)request.getAttribute("prrPagerStatus");//【与数据库一致】 凭条纸状态 0-纸满 1-纸低 2-纸尽 3-未知
		String cdmCuInfo = (String)request.getAttribute("cdmCuInfo");//【不一致】钞箱纸状态 0--满  1-多  2-正常  3-少 4-空 5-未知
		String dor = (String)request.getAttribute("dor");//【不一致】 安全门 0-无 1-出错 2-开 3-关

		if (StringUtils.isEmpty(id) || StringUtils.isEmpty(runningStatus) || StringUtils.isEmpty(prrStatus)
				|| StringUtils.isEmpty(cimStatus) || StringUtils.isEmpty(cdmStatus)
				|| StringUtils.isEmpty(prrPagerStatus) || StringUtils.isEmpty(cdmCuInfo) || StringUtils.isEmpty(dor)) {
			
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getMsg()).build();
		}

		//获取最新atm终端传送过来的状态数据

		//本地设备运行状态 0设备正常  ,1未激活 , 2-停用 3-异常|||根据其他状态确定
		String localRunningStatus = runningStatus;

		//本地凭条打印机状态 0-正常 1-异常 3-未知 4-停用 9-初始化
		String localPrrStatus = "0".equals(prrStatus)?"0":("3".equals(prrStatus)?"3":"1");
		
		//本地存款状态  0-正常 1-异常 3-未知 4-停用 9-初始化
		String localCimStatus = "0".equals(cimStatus)?"0":("3".equals(cimStatus)?"3":"1");
		
		//本地取款状态 0-设备正常在线 1-设备异常 3-未知状态  4-停用  9-初始化
		String localCdmStatus = "0".equals(cdmStatus)?"0":("3".equals(cdmStatus)?"3":"1");
		
		//本地钞箱纸状态  0--正常  1-缺钞  2-空 4-未知 5-停用  9-初始化
		String localCdmCuInfo = getLocalCdmCuInfo(cdmCuInfo);
		
		//本地安全门状态 0-开 1-关 3-未知  4-停用  9-初始化
		String localDor = "2".equals(dor)?"0":("3".equals(dor)?"1":"3");
		
		//本地维护状态 0-未维护  1-维护中
		String maintainStatus = runningStatus.equals("2")?"1":"0";

		//获取设备类型0-取款，1-存取款
		TbEquipmentSettings tbEquipmentSettings = (TbEquipmentSettings)request.getAttribute(AtmConstant.EQUIPMENT_SETTINGS);
		String equipmentType = tbEquipmentSettings.getEquipmentType();//设备类型 0-取款，1-存取款

		if("0".equals(equipmentType)){
			localCimStatus="0";//如果是取款，则强制将存款状态改成正常
		}
		log.info(localPrrStatus+","+localCimStatus+","+localCdmStatus+","+prrPagerStatus+","+localCdmCuInfo);

		if (!localPrrStatus.equals("0") || !localCimStatus.equals("0")|| !localCdmStatus.equals("0") 
				|| !prrPagerStatus.equals("0") || !localCdmCuInfo.equals("0")
//				|| !localDor.equals("0")//这个设备异常，不影响整机设备，也暂时不记录故障表
				) {
			localRunningStatus = "3";//0设备正常  ,1未激活 , 2-闲置 3-异常
		}else{
			localRunningStatus = "0";//0设备正常  ,1未激活 , 2-闲置 3-异常
		}


		//将最新的状态数据和上一次的状态作比较。（有变化,且是从正常到异常，则记录到故障表中）
		TbEquipmentStatus lastTbEquipmentStatus = (TbEquipmentStatus)request.getAttribute(AtmConstant.EQUIPMENT_STATUS);
		//安全门
		if(!localDor.equals(lastTbEquipmentStatus.getModuleStatus())&&
				!"0".equals(localDor)&&!"1".equals(localDor)){//有变化,且最新的变化不是正常，则记录一次故障
			TbEquipmentFaulLog tbEquipmentFaulLog = new TbEquipmentFaulLog();
			tbEquipmentFaulLog.setEquipmentId(id);
			tbEquipmentFaulLog.setCreateTime(new Date());
			tbEquipmentFaulLog.setModuleStatus(localDor);//安全门
			tbEquipmentFaulLog.setIfDown("0");//是否关机
			tbEquipmentFaulLogService.insert(tbEquipmentFaulLog);
		}
		//钞箱
		if(!localCdmCuInfo.equals(lastTbEquipmentStatus.getBanknoteBoxStatus())&&
				!"0".equals(localCdmCuInfo)){
			TbEquipmentFaulLog tbEquipmentFaulLog = new TbEquipmentFaulLog();
			tbEquipmentFaulLog.setEquipmentId(id);
			tbEquipmentFaulLog.setCreateTime(new Date());
			tbEquipmentFaulLog.setBanknoteBoxStatus(localCdmCuInfo);//钞箱纸
			tbEquipmentFaulLog.setIfDown("0");//是否关机
			tbEquipmentFaulLogService.insert(tbEquipmentFaulLog);
		}
		//取款模块
		if(localCdmStatus.equals(lastTbEquipmentStatus.getNetworkStatus())&&
				!"0".equals(localCdmStatus)){
			TbEquipmentFaulLog tbEquipmentFaulLog = new TbEquipmentFaulLog();
			tbEquipmentFaulLog.setEquipmentId(id);
			tbEquipmentFaulLog.setCreateTime(new Date());
			tbEquipmentFaulLog.setNetworkStatus(localCdmStatus);//取款状态
			tbEquipmentFaulLog.setIfDown("0");//是否关机
			tbEquipmentFaulLogService.insert(tbEquipmentFaulLog);
		}
		//凭条模块
		if(!localPrrStatus.equals(lastTbEquipmentStatus.getPrrStatus())&&
				!"0".equals(localPrrStatus)){
			TbEquipmentFaulLog tbEquipmentFaulLog = new TbEquipmentFaulLog();
			tbEquipmentFaulLog.setEquipmentId(id);
			tbEquipmentFaulLog.setCreateTime(new Date());
			tbEquipmentFaulLog.setPrrStatus(localPrrStatus);//凭条状态
			tbEquipmentFaulLog.setIfDown("0");//是否关机
			tbEquipmentFaulLogService.insert(tbEquipmentFaulLog);
		}
		//凭条纸
		if(!prrPagerStatus.equals(lastTbEquipmentStatus.getTransStatus())&&
				!"0".equals(prrPagerStatus)){
			TbEquipmentFaulLog tbEquipmentFaulLog = new TbEquipmentFaulLog();
			tbEquipmentFaulLog.setEquipmentId(id);
			tbEquipmentFaulLog.setCreateTime(new Date());
			tbEquipmentFaulLog.setTransStatus(prrPagerStatus);//凭条纸状态
			tbEquipmentFaulLog.setIfDown("0");//是否关机
			tbEquipmentFaulLogService.insert(tbEquipmentFaulLog);
		}
		//维护状态
		if(maintainStatus.equals(lastTbEquipmentStatus.getMaintainStatus())&&
				!"0".equals(maintainStatus)) {
			TbEquipmentFaulLog tbEquipmentFaulLog = new TbEquipmentFaulLog();
			tbEquipmentFaulLog.setEquipmentId(id);
			tbEquipmentFaulLog.setCreateTime(new Date());
			tbEquipmentFaulLog.setMaintainStatus(maintainStatus);
			tbEquipmentFaulLog.setIfDown("0");//是否关机
			tbEquipmentFaulLogService.insert(tbEquipmentFaulLog);
		}
		
		TbEquipmentStatus tbEquipmentStatus = new TbEquipmentStatus();
		tbEquipmentStatus.setId(id);
		tbEquipmentStatus.setRunningStatus(localRunningStatus);//整机状态 0设备正常  ,1未激活 , 2-闲置 3-异常
		tbEquipmentStatus.setPrrStatus(localPrrStatus);//凭条打印状态：0-设备正常在线 1-设备异常 3-未知状态  4-暂停服务  9-初始化
		tbEquipmentStatus.setCimStatus(localCimStatus);//存款状态：0-设备正常在线 1-设备异常 3-未知状态  4-暂停服务  9-初始化（备用）
		tbEquipmentStatus.setNetworkStatus(localCdmStatus);//取款状态 0-设备正常在线 1-设备异常 3-未知状态  4-暂停服务  9-初始化
		tbEquipmentStatus.setTransStatus(prrPagerStatus);//凭条纸状态 0-纸满 1-纸少 2-无纸 3-未知  4-暂停服务  9-初始化
		tbEquipmentStatus.setBanknoteBoxStatus(localCdmCuInfo);//钞箱纸状态 0--正常  1-缺钞  2-空 4-未知 5-暂停服务  9-初始化
		tbEquipmentStatus.setModuleStatus(localDor);//安全门  0-开 1-关 3-未知  4-停用  9-初始化
		tbEquipmentStatus.setMaintainStatus(maintainStatus);//维护状态；0-未维护  1-维护中
		tbEquipmentStatus.setUpdateTime(new Date());
		tbEquipmentStatus.setConnectStatus("0");//连接状态 0-正常 1-断网 9-初始化
		tbEquipmentStatusService.updateByPrimaryKeySelective(tbEquipmentStatus);

		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
	}
	
	public String getLocalCdmCuInfo(String cdmCuInfo){
		//atm 钞箱纸状态 0--满  1-多  2-正常  3-少 4-空 5-未知
		//本地 钞箱纸状态 0--正常  1-缺钞  2-空 4-未知 5-暂停服务  9-初始化
		String localCdmCuInfo = "";
		if("0".equals(cdmCuInfo)||"1".equals(cdmCuInfo)||"2".equals(cdmCuInfo)){
			localCdmCuInfo = "0";
		}else if("3".equals(cdmCuInfo)){
			localCdmCuInfo = "1";
		}else if("4".equals(cdmCuInfo)){
			localCdmCuInfo = "2";
		}else if("5".equals(cdmCuInfo)){
			localCdmCuInfo = "4";
		}
		return localCdmCuInfo;
	}
	
	@UserLog(interfaceCode = "/api/getMasterKey", interfaceDesc = "获取主密钥，第一条请求")
	@RequestMapping("/getMasterKey")
	public JSONData getMasterKey(HttpServletRequest request) {
		String id = (String)request.getAttribute("termNo");//设备编号
		if (StringUtils.isEmpty(id)) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getMsg()).build();
		}

		//更新设备验证反馈状态为成功
		TbEquipmentStatus tbEquipmentStatus = new TbEquipmentStatus();
		tbEquipmentStatus.setId(id);
		tbEquipmentStatus.setConnectStatus("0");//连接状态 0-正常 1-断网 9-初始化
		tbEquipmentStatusService.updateByPrimaryKeySelective(tbEquipmentStatus);
		
		TbEquipmentSettings tbEquipmentSettings = tbEquipmentSettingsService.find(id);
		
		if (tbEquipmentSettings == null || StringUtils.isEmpty(tbEquipmentSettings.getMasterKey())) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_EQUIPMENT_NULL.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_EQUIPMENT_NULL.getMsg()).build();
		}

		TbEquipment equipment = tbEquipmentService.selectByKey(id);
		TbArea area = tbAreaService.selectById(equipment.getCountryId());

		String pollInterval = "2";//二维码轮询间隔时间（单位：秒）
		String pingInterval = "3";//通信检测间隔时间（单位：分）
		String servicePhone = area.getServicePhone();//客服电话

		TbSettings pollIntervalSet = tbSettingsService.selectBySettingsCode("pollInterval");
		if(pollIntervalSet!=null&&!StringUtils.isEmpty(pollIntervalSet.getSettingsValue())){
			pollInterval = pollIntervalSet.getSettingsValue();
		}
		TbSettings pingIntervalSet = tbSettingsService.selectBySettingsCode("pingInterval");
		if(pingIntervalSet!=null&&!StringUtils.isEmpty(pingIntervalSet.getSettingsValue())){
			pingInterval = pingIntervalSet.getSettingsValue();
		}

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("masterKey", tbEquipmentSettings.getMasterKey());
		result.put("batchNo", System.currentTimeMillis()+"");
		result.put("pollInterval", pollInterval);//单位：秒
		result.put("pingInterval", pingInterval);//单位： 分
		result.put("servicePhone", servicePhone);//客服电话
		result.put("drawCurrency", tbEquipmentSettings.getEquipmentSubType());//取款币种
		result.put("androidUrl",appProperties.getAndroidUrl());
		result.put("iosUrl",appProperties.getIosUrl());
		List<Integer> drawList = withdrawCurrencyService.getDrawMoneyListByCurrency(tbEquipmentSettings.getEquipmentSubType());
		result.put("drawList", drawList);//取款选项列表
		
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(result).build();
	}
	
	@SuppressWarnings("unused")
	@Transactional
	@UserLog(interfaceCode = "/api/addMoney", interfaceDesc = "加钞")
	@RequestMapping("/addMoney")
	public JSONData addMoney(HttpServletRequest request) {
		String id = (String)request.getAttribute("termNo");//设备编号
		String amount = (String)request.getAttribute("amount");//实际总金额
		String currencyCode = (String)request.getAttribute("currencyCode");//加钞币种
		String batchNo = (String)request.getAttribute("batchNo");
		//待处理字段 TODO
		String cas1Amt = (String)request.getAttribute("cas1Amt");//第一钞箱金额
		String cas1Ccy = (String)request.getAttribute("cas1Ccy");//第一钞箱币种
		String cas1Value = (String)request.getAttribute("cas1Value");//第一钞箱面额
		String cas1Count = (String)request.getAttribute("cas1Count");//第一钞箱加钞数
		
		String cas2Amt = (String)request.getAttribute("cas2Amt");//第二钞箱金额
		String cas2Ccy = (String)request.getAttribute("cas2Ccy");//第二钞箱币种
		String cas2Value = (String)request.getAttribute("cas2Value");//第二钞箱面额
		String cas2Count = (String)request.getAttribute("cas2Count");//第二钞箱加钞数
		
		String cas3Amt = (String)request.getAttribute("cas3Amt");//第三钞箱金额
		String cas3Ccy = (String)request.getAttribute("cas3Ccy");//第三钞箱币种
		String cas3Value = (String)request.getAttribute("cas3Value");//第三钞箱面额
		String cas3Count = (String)request.getAttribute("cas3Count");//第三钞箱加钞数
		
		String cas4Amt = (String)request.getAttribute("cas4Amt");//第四钞箱金额
		String cas4Ccy = (String)request.getAttribute("cas4Ccy");//第四钞箱币种
		String cas4Value = (String)request.getAttribute("cas4Value");//第四钞箱面额
		String cas4Count = (String)request.getAttribute("cas4Count");//第四钞箱加钞数
		
		if (StringUtils.isEmpty(id) || StringUtils.isEmpty(amount)||StringUtils.isEmpty(currencyCode)
				||StringUtils.isEmpty(batchNo)) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAMETER_NULL.getMsg()).build();
		}
		
		//校验取款币种是否是该设备支持的币种
		TbEquipmentSettings tbEquipmentSettings = (TbEquipmentSettings)request.getAttribute(AtmConstant.EQUIPMENT_SETTINGS);
		if(!currencyCode.equals(tbEquipmentSettings.getEquipmentSubType())){
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_CURRENCY_IS_ERROR.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_CURRENCY_IS_ERROR.getMsg()).build();
		}
		
		JSONData jsonData = tbEquipmentSettingsService.addMoney(id, amount);
		return jsonData;
	}
	
	

}
