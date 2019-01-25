package com.tomcat360.admin.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomcat360.admin.enums.EnumResponseMsg;
import com.tomcat360.admin.mapper.TbCheckCCountMapper;
import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbCheckCCount;
import com.tomcat360.admin.service.TbCheckCCountService;
@Service
public class TbCheckCCountServiceImpl implements TbCheckCCountService {
	@Autowired
	private TbCheckCCountMapper tbCheckCCountMapper;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public JSONData countCStatus(Map params) {
		TbCheckCCount tbCheckCCount= tbCheckCCountMapper.countCStatus(params);
		Map data = new HashMap();
		data.put("tbCheckCCount", tbCheckCCount);
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(data).build();
	}
}
