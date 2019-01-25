package com.tomcat360.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tomcat360.admin.enums.EnumResponseMsg;
import com.tomcat360.admin.mapper.TbEquipmentMapper;
import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbEquipment;
import com.tomcat360.admin.model.TbEquipmentExample;
import com.tomcat360.admin.model.TbEquipmentFaulLog;
import com.tomcat360.admin.service.TbEquipmentService;
import com.tomcat360.admin.util.MapUtil;

@Service
public class TbEquipmentServiceImpl implements TbEquipmentService {
	@Autowired
	private TbEquipmentMapper tbEquipmentMapper;

	@Override
	public void insert(TbEquipment tbEquipment) {
		tbEquipmentMapper.insert(tbEquipment);
	}

	@Override
	public TbEquipment selectByKey(String equipmentId) {
		// TODO Auto-generated method stub
		return tbEquipmentMapper.selectByPrimaryKey(equipmentId);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public JSONData cashFlowEquipment(Map<String, Object> params) {
		Integer page = (Integer) params.get("page");
		Integer size = (Integer) params.get("size");
		Page<TbEquipmentFaulLog> listPage = PageHelper.startPage(page, size);

		TbEquipmentExample tbEquipmentExample = new TbEquipmentExample();

		List<TbEquipment> list = tbEquipmentMapper.selectByExample(tbEquipmentExample);

		HashMap data = new HashMap();
		data.put("list", list);
		data.put("pageSize", listPage.getPageSize());
		data.put("totalPages", listPage.getPages());
		data.put("totalNumber", listPage.getTotal());
		data.put("page", listPage.getPageNum());
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(data).build();
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JSONData equipmentVrsionList(Map<String, Object> params) {
		Integer page = (Integer) params.get("page");
		Integer size = (Integer) params.get("size");
		Page<Map> listPage = PageHelper.startPage(page, size);
		
		
		List<Map> equipmentVrsionList = tbEquipmentMapper.equipmentVrsionList();
		for (Map map : equipmentVrsionList) {
			map = MapUtil.joinDataVrsionEquipment(map);
		}
		
		HashMap data = new HashMap();
		data.put("list", equipmentVrsionList);
		data.put("pageSize", listPage.getPageSize());
		data.put("totalPages", listPage.getPages());
		data.put("page", listPage.getPageNum());
		data.put("totalNumber", listPage.getTotal());

		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(data).build();
	}

	@Override
	public void update(TbEquipment tbEquipment) {
		// TODO Auto-generated method stub
		tbEquipmentMapper.updateByPrimaryKeySelective(tbEquipment);
		
	}

	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public JSONData equipmentAreaNum(String country) {
		Map list = tbEquipmentMapper.equipmentAreaNum(country);
		Long monitorNum = Long.valueOf(list.get("monitorNum")==null?"0":list.get("monitorNum").toString());
		
		list.put("voucherPaperNum",list.get("voucherPaperNum")==null?"0":list.get("voucherPaperNum"));
		list.put("doorNum",list.get("doorNum")==null?"0":list.get("doorNum"));
		list.put("banknoteBoxNum",list.get("banknoteBoxNum")==null?"0":list.get("banknoteBoxNum"));
		list.put("drawMoneyNum",list.get("drawMoneyNum")==null?"0":list.get("drawMoneyNum"));
		list.put("printNum",list.get("printNum")==null?"0":list.get("printNum"));
		list.put("maintainNum",list.get("maintainNum")==null?"0":list.get("maintainNum"));
		list.put("connectNum",list.get("connectNum")==null?"0":list.get("connectNum"));
		list.put("normalEquipment",list.get("normalEquipment")==null?"0":list.get("normalEquipment"));
		list.put("country", country);
		
		if(StringUtils.isEmpty(country)){
			list.put("country", "全部");
		}
		
		
		Long normalEquipment = Long.valueOf(list.get("normalEquipment").toString());
		
		Long faultEquipment = monitorNum - normalEquipment;
		list.put("faultEquipment", faultEquipment);
		
		HashMap data = new HashMap();
		data.put("equipmentAreaNum", list);
		
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(data).build();
		
	}

	@Override
	public void insertInfo(TbEquipment tbEquipment) {
		tbEquipmentMapper.insert(tbEquipment);
	}

	@Override
	public TbEquipment selectByEquipmentNo(String equipmentNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateId(Map<String,String> map) {
		// TODO Auto-generated method stub
		tbEquipmentMapper.updateId(map);
	}

	@Override
	public List<Map<String, Object>> findAll(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return tbEquipmentMapper.findAll(params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONData findAllByEquipmentIds(Map<String, Object> params) {
		Set<String> termNoList = (Set<String>)params.get("termNoList");
		if(CollectionUtils.isEmpty(termNoList)){
			Map<String, Object> data = new HashMap<String,Object>();
			data.put("list", null);
			data.put("pageSize", (Integer)params.get("size"));
			data.put("totalPages", 0);
			data.put("totalNumber", 0);
			data.put("page", 0);
			return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
					.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(data).build();
		}

		Integer page = (Integer)params.get("page");
		Integer size = (Integer)params.get("size");
		Page<Map<String,Object>> list = PageHelper.startPage(page, size);
		tbEquipmentMapper.findAllByEquipmentIds(params);

		Map<String, Object> data = new HashMap<String,Object>();
		data.put("list", list.getResult());
		data.put("pageSize", list.getPageSize());
		data.put("totalPages", list.getPages());
		data.put("totalNumber", list.getTotal());
		data.put("page", list.getPageNum());

		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(data).build();
	}

	@Override
	public List<TbEquipment> findEquipmentByArea(String areaName) {
		TbEquipmentExample example = new TbEquipmentExample();
		example.createCriteria().andCountryEqualTo(areaName);
		
		return tbEquipmentMapper.selectByExample(example);
	}

	@Override
	public List<TbEquipment> select(TbEquipmentExample example) {
		
		return tbEquipmentMapper.selectByExample(example);
	}

	@Override
	public List<Map<String,Object>> getAllEquipmentLocation(Map<String,Object> params) {
		List<Map<String,Object>> list = tbEquipmentMapper.getAllEquipmentLocation(params);

		return list;
	}
}
