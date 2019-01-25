package com.tomcat360.admin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tomcat360.admin.enums.EnumResponseMsg;
import com.tomcat360.admin.mapper.TbCheckResultMapper;
import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbCheckResult;
import com.tomcat360.admin.service.TbCheckResultService;
import com.tomcat360.admin.util.MapTrun;
@Service
public class TbCheckResultServiceImpl implements TbCheckResultService {
	@Autowired
	private TbCheckResultMapper tbCheckResultMapper;
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	@Override
	public JSONData checkCResultList(Map params) {
		Integer page = (Integer)params.get("page");
		Integer size = (Integer)params.get("size");
		
		Page<TbCheckResult> list = PageHelper.startPage(page, size);
		tbCheckResultMapper.checkCResultList(params);
		
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
	public JSONData changeCheckResult(TbCheckResult tbCheckResult) {
		tbCheckResultMapper.updateByPrimaryKeySelective(tbCheckResult);
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
	}

	@Override
	public TbCheckResult selectByKey(Long id) {
		return tbCheckResultMapper.selectByPrimaryKey(id);
	}
}
