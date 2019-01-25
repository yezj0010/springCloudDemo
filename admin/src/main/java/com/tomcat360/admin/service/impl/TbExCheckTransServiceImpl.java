package com.tomcat360.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tomcat360.admin.enums.EnumResponseMsg;
import com.tomcat360.admin.mapper.TbExCheckTransMapper;
import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbCheckResult;
import com.tomcat360.admin.model.TbExCheckTrans;
import com.tomcat360.admin.service.TbExCheckTransService;
@Service
public class TbExCheckTransServiceImpl implements TbExCheckTransService {
	@Autowired
	private TbExCheckTransMapper tbExCheckTransMapper;

	@Override
	public JSONData findExTransInfoList(Map params) {
		Integer page = (Integer)params.get("page");
		Integer size = (Integer)params.get("size");
		
		
		//Page<TbExCheckTrans> list = PageHelper.startPage(page, size);
		
		List<Map<String,Object>> list = tbExCheckTransMapper.findExTransInfoList(params);
		
		Map<String, Object> data = new HashMap<String,Object>();
		data.put("list", list);
//		data.put("pageSize", list.getPageSize());
//		data.put("totalPages", list.getPages());
//		data.put("totalNumber", list.getTotal());
//		data.put("page", list.getPageNum());
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(data).build();
	}

}
