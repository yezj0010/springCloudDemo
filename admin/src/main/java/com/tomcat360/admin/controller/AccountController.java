package com.tomcat360.admin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.tomcat360.admin.model.TbCheckResult;
import com.tomcat360.admin.properties.AppProperties;
import com.tomcat360.admin.service.ExchangeService;
import com.tomcat360.admin.service.TbCCheckTransService;
import com.tomcat360.admin.service.TbCheckCCountService;
import com.tomcat360.admin.service.TbCheckResultService;
import com.tomcat360.admin.service.TbExCheckTransService;
import com.tomcat360.admin.service.TbPCheckTransService;
import com.tomcat360.admin.service.TbTransService;
import com.tomcat360.admin.util.CalendarUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/auth")
public class AccountController {
	@Autowired
	private TbTransService tbTransService;
	@Autowired
	private ExchangeService exchangeService;
	@Autowired
	private TbCCheckTransService tbCCheckTransService;
	@Autowired
	private TbPCheckTransService tbPCheckTransService;
	@Autowired
	private TbExCheckTransService tbExCheckTransService;
	@Autowired
	private TbCheckResultService tbCheckResultService;
	@Autowired
	private TbCheckCCountService tbCheckCCountService;
	@Autowired
	private AppProperties appProperties;

	//@AdminLog(interfaceCode = "/auth/findWithdrawInfo", interfaceDesc = "查询取款明细接口")
	@ApiOperation(value = "查询取款明细接口", httpMethod = "POST")
	@PostMapping("/findWithdrawInfo")
	public JSONData findWithdrawInfo(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size, HttpServletRequest request) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("page", page);
		params.put("size", size);
		String id = request.getParameter("id");//ATM P端流水
		String exTransSeq = request.getParameter("exTransSeq");//交易所流水号
		String equipmentNo = request.getParameter("equipmentNo");//设备id
		String equipmentLogSeq = request.getParameter("equipmentLogSeq");//atm流水号
		
		String status = request.getParameter("status");//取款结果0-初始 1-完成 2-失败 3-超时 4-已冲正 5-冲正异常 6-吐钞中，7-状态不明
		String userName = request.getParameter("userName");
		
		String transTime = request.getParameter("transTime");//交易时间yyyy-MM-dd
		String userId = request.getParameter("userId");//用户id
		TbAdminUser admin = (TbAdminUser) request.getAttribute(AdminConstant.ADMIN);
		if(1l != admin.getRoleId()){//如果不是超级管理员
			params.put("countryId", admin.getCountryId());
		}
		params.put("id", id);
		params.put("exTransSeq", exTransSeq);
		params.put("userName", userName);
		params.put("equipmentLogSeq", equipmentLogSeq);
		params.put("equipmentNo", equipmentNo);
		params.put("status", status);
		if(!StringUtils.isEmpty(transTime)){
			params.put("transTime", CalendarUtil.correctDateStr(transTime+" 00:00:00", appProperties.getGMTTimeZone(), "yyyy-MM-dd HH:mm:ss"));
			params.put("transTimeEnd", CalendarUtil.correctDateStrNextDay(transTime+" 00:00:00",appProperties.getGMTTimeZone(), "yyyy-MM-dd HH:mm:ss"));
		}
		params.put("userId", userId);
		return tbTransService.findWithdrawInfo(params);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	//@AdminLog(interfaceCode = "/auth/findOperateAccountInfo", interfaceDesc = "查询运营账户信息接口")
	@ApiOperation(value = "查询运营账户信息", httpMethod = "POST")
	@PostMapping("/findOperateAccountInfo")
	public JSONData findOperateAccountInfo(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size,
		   String startTime, String endTime, String currency,HttpServletRequest request) {
		Map params = new HashMap();
		params.put("page", page);
		params.put("size", size);

		params.put("startTime", startTime);//yyyy-MM-dd
		params.put("endTime", endTime);//yyyy-MM-dd
		params.put("currency", currency);//数字货币币种
		return exchangeService.findOperateAccountInfo(params);
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	//@AdminLog(interfaceCode = "/auth/checkResultList", interfaceDesc = "查询对账结果列表接口")
	@ApiOperation(value = "查询对账结果列表接口", httpMethod = "POST")
	@PostMapping("/checkResultList")
	public JSONData checkResultList(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size, HttpServletRequest request) {
		Map params = new HashMap();
		params.put("page", page);
		params.put("size", size);
		String checkBatchNo = request.getParameter("checkBatchNo");//对账批次
		String equipmentId = request.getParameter("equipmentId");//设备编号
		String checkTime = request.getParameter("checkTime");//对账时间
		String checkStatus = request.getParameter("checkStatus");//对账结果（0：差错，1：平账）
		String type = request.getParameter("type");//对账对象（0-与C端，1-与交易所）
		String handleResult = request.getParameter("handleResult");//人工处理结果 （2-未处理 0-未平账，1-平账 ）
		if(StringUtils.isEmpty(type)){
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg()).build();
		}
		
		TbAdminUser admin = (TbAdminUser) request.getAttribute(AdminConstant.ADMIN);
		if(1l != admin.getRoleId()){//如果不是超级管理员
			params.put("countryId", admin.getCountryId());
		}
		
		params.put("type", type);
		params.put("checkBatchNo", checkBatchNo);
		params.put("equipmentId", equipmentId);
		if(!StringUtils.isEmpty(checkTime)){
			params.put("checkTime", CalendarUtil.correctDateStr(checkTime+" 00:00:00",appProperties.getGMTTimeZone(),"yyyy-MM-dd HH:mm:ss"));
			params.put("checkTimeEnd", CalendarUtil.correctDateStrNextDay(checkTime+" 00:00:00",appProperties.getGMTTimeZone(),"yyyy-MM-dd HH:mm:ss"));
		}
		params.put("checkStatus", checkStatus);
		params.put("handleResult",handleResult);
		return tbCheckResultService.checkCResultList(params);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	//@AdminLog(interfaceCode = "/auth/findlocCTransInfoList", interfaceDesc = "本地对账查账接口")
	@ApiOperation(value = "本地对账C端查询未知数据接口", httpMethod = "POST")
	@PostMapping("/findlocCTransInfoList")
	public JSONData findlocCTransInfoList(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size, HttpServletRequest request) {
		Map params = new HashMap();
		params.put("page", page);
		params.put("size", size);
		String equipmentId = request.getParameter("equipmentNo");
		String checkBatchNo = request.getParameter("checkBatchNo");
		if(StringUtils.isEmpty(checkBatchNo) || StringUtils.isEmpty(equipmentId)){
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg()).build();
		}
		params.put("equipmentId", equipmentId);
		params.put("checkBatchNo", checkBatchNo);
		return tbCCheckTransService.findlocCTransInfoList(params);
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	//@AdminLog(interfaceCode = "/auth/findlocPTransInfoList", interfaceDesc = "本地对账查账接口")
	@ApiOperation(value = "本地对账P端查询异常数据接口", httpMethod = "POST")
	@PostMapping("/findlocPTransInfoList")
	public JSONData findlocPTransInfoList(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size, HttpServletRequest request) {
		Map params = new HashMap();
		params.put("page", page);
		params.put("size", size);
		String equipmentId = request.getParameter("equipmentNo");
		String checkBatchNo = request.getParameter("checkBatchNo");
		String transStatus = request.getParameter("transStatus");//交易状态取款结果：1-完成 2-失败 4-已冲正 7-状态不明
		String withExDiff = request.getParameter("withExDiff");//与交易所是否有差异，0-无差异，1-有差异
		if(StringUtils.isEmpty(checkBatchNo) || StringUtils.isEmpty(equipmentId)){
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg()).build();
		}
		params.put("equipmentId", equipmentId);
		params.put("checkBatchNo", checkBatchNo);
		params.put("transStatus", transStatus);
		params.put("withExDiff", withExDiff);
		return tbPCheckTransService.findlocPTransInfoList(params);
	}
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	//@AdminLog(interfaceCode = "/auth/countCStatus", interfaceDesc = "对账统计接口")
	@ApiOperation(value = "对账统计", httpMethod = "POST")
	@PostMapping("/countCStatus")
	public JSONData countCStatus(HttpServletRequest request) {
		Map params = new HashMap();
		String equipmentId = request.getParameter("equipmentNo");
		String checkBatchNo = request.getParameter("checkBatchNo");
		String type = request.getParameter("type");
		if(StringUtils.isEmpty(checkBatchNo) || StringUtils.isEmpty(equipmentId) ||
				StringUtils.isEmpty(type)){
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg()).build();
		}
		params.put("equipmentId", equipmentId);
		params.put("checkBatchNo", checkBatchNo);
		params.put("type",type);
		return tbCheckCCountService.countCStatus(params);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	//@AdminLog(interfaceCode = "/auth/pTransInfoList", interfaceDesc = "P端对账交易明细列表接口")
	@ApiOperation(value = "交易所对账P端交易明细列表", httpMethod = "POST")
	@PostMapping("/pTransInfoList")
	public JSONData pTransInfoList(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size,
			String transStatus, String withExDiff, HttpServletRequest request) {
		Map params = new HashMap();
		params.put("page", page);
		params.put("size", size);
		String equipmentId = request.getParameter("equipmentNo");
		String checkBatchNo = request.getParameter("checkBatchNo");
		if(StringUtils.isEmpty(checkBatchNo) || StringUtils.isEmpty(equipmentId)){
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg()).build();
		}
		params.put("equipmentId", equipmentId);
		params.put("checkBatchNo", checkBatchNo);
		params.put("transStatus", transStatus);
		params.put("withExDiff", withExDiff);
		return tbPCheckTransService.findlocTransInfoList(params);
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	//@AdminLog(interfaceCode = "/auth/exTransInfoList", interfaceDesc = "交易所对账交易明细列表接口")
	@ApiOperation(value = "交易所对账交易明细列表", httpMethod = "POST")
	@PostMapping("/exTransInfoList")
	public JSONData exTransInfoList(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size, HttpServletRequest request) {
		Map params = new HashMap();
		params.put("page", page);
		params.put("size", size);
		String equipmentId = request.getParameter("equipmentNo");
		String checkBatchNo = request.getParameter("checkBatchNo");
		String withPDiff = request.getParameter("withPDiff");//与P端是否有差异，0-无差异，1-有差异
		if(StringUtils.isEmpty(checkBatchNo) || StringUtils.isEmpty(equipmentId)){
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg()).build();
		}
		params.put("equipmentId", equipmentId);
		params.put("checkBatchNo", checkBatchNo);
		params.put("withPDiff", withPDiff);
		return tbExCheckTransService.findExTransInfoList(params);
	}
	
	
	
	@AdminLog(interfaceCode = "/auth/changeCheckResult", interfaceDesc = "修改对账结果")
	@ApiOperation(value = "修改对账结果", httpMethod = "POST")
	@PostMapping("/changeCheckResult")
	public JSONData changeCheckResult(HttpServletRequest request) {
		String id = request.getParameter("id");
		String operateStatus = request.getParameter("operateStatus");//处理状态（0-未平账，1-平账）
		String remark = request.getParameter("remark");
		TbAdminUser admin = (TbAdminUser) request.getAttribute(AdminConstant.ADMIN);
		if(StringUtils.isEmpty(id)||StringUtils.isEmpty(operateStatus)){
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg()).build();
		}
		
		TbCheckResult tbCheckResult = tbCheckResultService.selectByKey(Long.valueOf(id));
		tbCheckResult.setOperateStatus(operateStatus);
		tbCheckResult.setRemark(remark);
		tbCheckResult.setOperateAdmin(admin.getUserName());
		tbCheckResult.setOperateAdminId(admin.getId());

		//更新日志操作描述
		String operationDesc = "";
		if(tbCheckResult.getType().equals("0")){//与c端对账
			operationDesc = "在本地对账中对账号批次"+tbCheckResult.getCheckBatchNo()+"完成对账";
		}else if(tbCheckResult.getType().equals("1")){//与交易所
			operationDesc = "在交易所对账中对账号批次"+tbCheckResult.getCheckBatchNo()+"完成对账";
		}
		request.setAttribute(AdminConstant.OPERATION_DESC, operationDesc);

		return tbCheckResultService.changeCheckResult(tbCheckResult);
	}
	
}
