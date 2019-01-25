package com.tomcat360.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tomcat360.admin.enums.EnumResponseMsg;
import com.tomcat360.admin.mapper.TbEquipmentFaulLogMapper;
import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbEquipmentFaulLog;
import com.tomcat360.admin.service.TbEquipmentFaulLogService;
import com.tomcat360.admin.service.TbEquipmentService;
import com.tomcat360.admin.util.MapUtil;

@Service
public class TbEquipmentFaulLogServiceImpl implements TbEquipmentFaulLogService {
	@Autowired
	private TbEquipmentFaulLogMapper tbEquipmentFaulLogMapper;
	@Autowired
	private TbEquipmentService tbEquipmentService;

	@Override
	public TbEquipmentFaulLog findDowntimeEquipment(TbEquipmentFaulLog tbEquipmentFaulLog) {
		// TODO Auto-generated method stub

		return tbEquipmentFaulLogMapper.findDowntimeEquipment(tbEquipmentFaulLog);
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	@Override
	public JSONData findFaultEquipment(Map<String, Object> params) {

		Integer page = params.get("page") == null?1:Integer.valueOf(params.get("page").toString());
		Integer size = Integer.valueOf(params.get("size").toString());
		Page<Map<String, Object>> listPage = PageHelper.startPage(page, size);
		//List<Map<String, Object>> findAll = tbEquipmentService.findAll(params);
		
		
		List<Map<String, Object>> findFaultEquipment = tbEquipmentFaulLogMapper.findFaultEquipment(params);
		
		Map map = new HashMap();
		map.put("list", findFaultEquipment);
		map.put("pageSize", listPage.getPageSize());
		map.put("totalPages", listPage.getPages());
		map.put("totalNumber", listPage.getTotal());
		map.put("page", listPage.getPageNum());
		return JSONData.builder().msg(EnumResponseMsg.RESP_SUCCESS.getMsg())
				.code(EnumResponseMsg.RESP_SUCCESS.getCode()).data(map).build();
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JSONData lackMoneyEquipment(Map<String, Object> params) {

		Integer page = (Integer) params.get("page");
		Integer size = (Integer) params.get("size");
		Page<Map<String, Object>> listPage = PageHelper.startPage(page, size);

		tbEquipmentFaulLogMapper.lackMoneyEquipment();
		for (Map<String, Object> map : listPage) {
			map = MapUtil.joinDataFaultEquipment(map);
		}

		Map map = new HashMap();
		map.put("list", listPage.getResult());
		map.put("pageSize", listPage.getPageSize());
		map.put("totalPages", listPage.getPages());
		map.put("totalNumber", listPage.getTotal());
		map.put("page", listPage.getPageNum());
		return JSONData.builder().msg(EnumResponseMsg.RESP_SUCCESS.getMsg())
				.code(EnumResponseMsg.RESP_SUCCESS.getCode()).data(map).build();
	}

}
