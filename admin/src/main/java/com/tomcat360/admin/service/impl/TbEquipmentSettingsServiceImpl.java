package com.tomcat360.admin.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tomcat360.admin.enums.EnumResponseMsg;
import com.tomcat360.admin.mapper.TbEquipmentSettingsMapper;
import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbEquipmentSettings;
import com.tomcat360.admin.model.TbEquipmentSettingsExample;
import com.tomcat360.admin.model.TbEquipmentStatus;
import com.tomcat360.admin.model.TbEquipmentStatusExample;
import com.tomcat360.admin.service.TbEquipmentSettingsService;
import com.tomcat360.admin.service.TbEquipmentStatusService;
import com.tomcat360.admin.util.CalendarUtil;
import com.tomcat360.admin.util.MapUtil;

@Service
public class TbEquipmentSettingsServiceImpl implements TbEquipmentSettingsService {
	@Autowired
	private TbEquipmentSettingsMapper tbEquipmentSettingsMapper;

	@Autowired
	private TbEquipmentStatusService tbEquipmentStatusService;

	@SuppressWarnings("unchecked")
	@Override
	public JSONData findByCondition(Map<String, Object> params) {
		// TODO Auto-generated method stub
		Integer page = (Integer) params.get("page");
		Integer size = (Integer) params.get("size");
		Page<Map<String, Object>> list = PageHelper.startPage(page, size);

		tbEquipmentSettingsMapper.selectByList(params);

		Map<String, Object> data = new HashMap<String, Object>();

		for (Map<String, Object> map : list.getResult()) {
			map = MapUtil.joinDataEquipment(map);
		}

		data.put("list", list.getResult());
		data.put("pageSize", list.getPageSize());
		data.put("totalPages", list.getPages());
		data.put("page", list.getPageNum());
		data.put("totalNumber", list.getTotal());
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(data).build();
	}

	@Override
	public JSONData addTbEquipmentSettings(TbEquipmentSettings tbEquipmentSettings) {
		int insert = tbEquipmentSettingsMapper.insert(tbEquipmentSettings);
		if (insert != 1) {
			return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getCode())
					.msg(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getMsg()).build();
		}
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
	}

	@Override
	public TbEquipmentSettings selectByKey(String id) {
		// TODO Auto-generated method stub
		return tbEquipmentSettingsMapper.selectByPrimaryKey(id);
	}

	@Override
	public JSONData updateTbEquipmentSettings(TbEquipmentSettings tbEquipmentSettings) {
		tbEquipmentSettingsMapper.updateByPrimaryKeySelective(tbEquipmentSettings);
		return JSONData.builder().msg(EnumResponseMsg.RESP_SUCCESS.getMsg())
				.code(EnumResponseMsg.RESP_SUCCESS.getCode()).build();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public JSONData equipmentNum(Map<String, Object> params) {

		Integer page = params.get("page") == null ? 1 : Integer.valueOf(params.get("page").toString());
		Integer size = params.get("size") == null ? 10 : Integer.valueOf(params.get("size").toString());
		Page<Map<String, Object>> pages = PageHelper.startPage(page, size);

		tbEquipmentSettingsMapper.getEquipmentNum(params);
		List<Map<String, Object>> result = pages.getResult() == null ? new ArrayList<Map<String, Object>>()
				: pages.getResult();

		Map data = new HashMap();
		data.put("list", result);
		data.put("pageSize", pages.getPageSize());
		data.put("totalPages", pages.getPages());
		data.put("page", pages.getPageNum());
		data.put("totalNumber", pages.getTotal());
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(data).build();
	}

	@Override
	public Map<String, Object> selectByKey1(String id) {
		// TODO Auto-generated method stub

		List<Map<String, Object>> list = tbEquipmentSettingsMapper.selectByPrimaryKeyDetails(id);
		Map<String, Object> map = list.get(0);
		TbEquipmentStatusExample example = new TbEquipmentStatusExample();
		example.createCriteria().andIdEqualTo(id);

		TbEquipmentStatus tbEquipmentStatus = tbEquipmentStatusService.selectByExample(example).get(0);
		map.put("transTime", tbEquipmentStatus.getTransTime());

		return map;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public JSONData findSoftVersion() {
		List<TbEquipmentSettings> list = tbEquipmentSettingsMapper.findSoftVersion();
		Map data = new HashMap();
		data.put("list", list);
		return JSONData.builder().msg(EnumResponseMsg.RESP_SUCCESS.getMsg())
				.code(EnumResponseMsg.RESP_SUCCESS.getCode()).data(data).build();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public JSONData findEquipmentVersion() {
		List<TbEquipmentSettings> list = tbEquipmentSettingsMapper.findEquipmentVersion();
		Map data = new HashMap();
		data.put("list", list);
		return JSONData.builder().msg(EnumResponseMsg.RESP_SUCCESS.getMsg())
				.code(EnumResponseMsg.RESP_SUCCESS.getCode()).data(data).build();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public JSONData findBrand() {
		List<TbEquipmentSettings> list = tbEquipmentSettingsMapper.findBrand();
		Map data = new HashMap();
		data.put("list", list);
		return JSONData.builder().msg(EnumResponseMsg.RESP_SUCCESS.getMsg())
				.code(EnumResponseMsg.RESP_SUCCESS.getCode()).data(data).build();
	}

	@Override
	public List<Map<String, Object>> findEquipmentByCurrencyCode(String currencyCode) {
		TbEquipmentSettingsExample example = new TbEquipmentSettingsExample();
		example.createCriteria().andEquipmentSubTypeEqualTo(currencyCode);

		return tbEquipmentSettingsMapper.selectByExample(example);
	}

	@Override
	public void updateSelectTbEquipmentSettings(TbEquipmentSettings tbEquipmentSettings) {
		tbEquipmentSettingsMapper.updateByPrimaryKeySelective(tbEquipmentSettings);

	}

	@Override
	public List<TbEquipmentSettings> findAll() {
		// TODO Auto-generated method stub
		return tbEquipmentSettingsMapper.findAll();
	}

}
