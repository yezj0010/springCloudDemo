package com.tomcat360.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomcat360.admin.enums.EnumResponseMsg;
import com.tomcat360.admin.mapper.TbEquipmentRunningStatusMapper;
import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbEquipmentRunningStatus;
import com.tomcat360.admin.service.TbEquipmentRunningStatusService;

@Service
public class TbEquipmentRunningStatusServiceImpl implements TbEquipmentRunningStatusService {
	@Autowired
	private TbEquipmentRunningStatusMapper tbEquipmentRunningStatusMapper;

	@Override
	public JSONData findAll() {
		List<TbEquipmentRunningStatus> list = tbEquipmentRunningStatusMapper.findAll();
		Map map = new HashMap<String,Object>();
		map.put("list", list);
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(map).build();
	}
}
