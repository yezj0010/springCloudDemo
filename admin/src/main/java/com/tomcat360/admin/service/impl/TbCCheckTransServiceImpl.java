package com.tomcat360.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tomcat360.admin.enums.EnumResponseMsg;
import com.tomcat360.admin.mapper.TbCCheckTransMapper;
import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbCCheckTrans;
import com.tomcat360.admin.service.TbCCheckTransService;
@Service
public class TbCCheckTransServiceImpl implements TbCCheckTransService {
	@Autowired
	TbCCheckTransMapper tbCCheckTransMapper;

	@SuppressWarnings({ "rawtypes" })
	@Override
	public JSONData findCTransInfoList(Map params) {
		Integer page = (Integer)params.get("page");
		Integer size = (Integer)params.get("size");
		
		
		Page<TbCCheckTrans> list = PageHelper.startPage(page, size);
		
		tbCCheckTransMapper.findCTransInfoList(params);
		
		Map<String, Object> data = new HashMap<String,Object>();
		data.put("list", list.getResult());
		data.put("pageSize", list.getPageSize());
		data.put("totalPages", list.getPages());
		data.put("totalNumber", list.getTotal());
		data.put("page", list.getPageNum());
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(data).build();
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public JSONData findlocCTransInfoList(Map params) {
		
		
		params.put("transStatus", "7");
		List<Map<String,Object>> list = tbCCheckTransMapper.findCTransInfoList(params);
		
		Map<String, Object> data = new HashMap<String,Object>();
		data.put("list", list);
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(data).build();
	}


	
}
