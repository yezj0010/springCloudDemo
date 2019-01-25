package com.tomcat360.admin.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tomcat360.admin.aspect.AdminLog;
import com.tomcat360.admin.enums.EnumResponseMsg;
import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.service.TbTransService;
import com.tomcat360.admin.util.CalendarUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/auth")
public class OperateDataController {
	@Autowired
	private TbTransService tbTransService;
	// 返回的时间点数量
	private Integer dayNum = 7;
	/**
	 * @param request
	 * @param countryId 地区id
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	//@AdminLog(interfaceCode = "/auth/getTransSum", interfaceDesc = "获取ATM交易统计接口")
	@ApiOperation(value = "获取ATM交易统计", httpMethod = "POST")
	@PostMapping("/getTransSum")
	public JSONData getTransSum(HttpServletRequest request) {
		String date = request.getParameter("date");// yyyy-MM-dd
		String countryId = request.getParameter("countryId");// 地区ID
		if (StringUtils.isEmpty(date)) {
			date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			date = CalendarUtil.correctDateStr(date, "GMT", "yyyy-MM-dd");
		}
		if (StringUtils.isEmpty(countryId)) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode()).build();
		}

		Map requestMap = new HashMap();
		requestMap.put("date", date);
		requestMap.put("countryId", countryId);

		// 参数0代表查询取款信息，1代表查询存款信息
		Map data = tbTransService.getTransSum(requestMap);
		return JSONData.builder().msg(EnumResponseMsg.RESP_SUCCESS.getMsg())
				.code(EnumResponseMsg.RESP_SUCCESS.getCode()).data(data).build();
	}
	/**
	 * @param request
	 * @param countryId 地区id
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	//@AdminLog(interfaceCode = "/auth/getProfitSum", interfaceDesc = "获取ATM盈利统计接口")
	@ApiOperation(value = "获取ATM盈利统计", httpMethod = "POST")
	@PostMapping("/getProfitSum")
	public JSONData getProfitSum(HttpServletRequest request) {
		String countryId = request.getParameter("countryId");
		if (StringUtils.isEmpty(countryId)) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_PARAM_EMPTY.getCode()).build();
		}
		Map map = new HashMap();
		map.put("countryId", countryId);
		return tbTransService.getProfitSum(map);
		

	}

}
