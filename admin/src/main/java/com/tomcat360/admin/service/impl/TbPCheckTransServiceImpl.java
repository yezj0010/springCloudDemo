package com.tomcat360.admin.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tomcat360.admin.enums.EnumResponseMsg;
import com.tomcat360.admin.mapper.TbCCheckTransMapper;
import com.tomcat360.admin.mapper.TbPCheckTransMapper;
import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbCCheckTrans;
import com.tomcat360.admin.model.TbExCheckTrans;
import com.tomcat360.admin.model.TbPCheckTrans;
import com.tomcat360.admin.service.TbPCheckTransService;
@Service
public class TbPCheckTransServiceImpl implements TbPCheckTransService {
	@Autowired
	private TbPCheckTransMapper tbPCheckTransMapper;
	@Autowired
	private TbCCheckTransMapper tbCCheckTransMapper;
	@SuppressWarnings({ "rawtypes" })
	@Override
	public JSONData findlocTransInfoList(Map params) {
		Integer page = (Integer)params.get("page");
		Integer size = (Integer)params.get("size");
		//Page<TbPCheckTrans> list = PageHelper.startPage(page, size);
		List<Map<String,Object>> list = tbPCheckTransMapper.findPTransInfoList(params);
		
		Map<String, Object> data = new HashMap<String,Object>();
		data.put("list", list);
//		data.put("pageSize", list.getPageSize());
//		data.put("totalPages", list.getPages());
//		data.put("totalNumber", list.getTotal());
//		data.put("page", list.getPageNum());
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(data).build();
	}
	@SuppressWarnings("unchecked")
	@Override
	public JSONData findlocPTransInfoList(Map params) {
		Integer page = (Integer)params.get("page");
		Integer size = (Integer)params.get("size");

		List<Map<String,Object>> list = tbPCheckTransMapper.findPTransInfoList(params);
		
		Map<String, Object> data = new HashMap<String,Object>();
		data.put("list", list);
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(data).build();
	}
}
