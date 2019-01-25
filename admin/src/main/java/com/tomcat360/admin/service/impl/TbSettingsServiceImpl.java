package com.tomcat360.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomcat360.admin.enums.EnumResponseMsg;
import com.tomcat360.admin.mapper.TbSettingsMapper;
import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbSettings;
import com.tomcat360.admin.model.TbSettingsExample;
import com.tomcat360.admin.service.TbSettingsService;

@Service
public class TbSettingsServiceImpl implements TbSettingsService {
	@Autowired
	private TbSettingsMapper tbSettingsMapper;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public JSONData getParameterType(Map<String, Object> params) {

		TbSettingsExample example = new TbSettingsExample();
		example.createCriteria().andSettingsTypeEqualTo("0");
		List<TbSettings> selectByExample = tbSettingsMapper.selectByExample(example);
		Map map = new HashMap();
		map.put("list", selectByExample);
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(map).build();
	}

	@Override
	public List<TbSettings> selectExample(TbSettingsExample example) {
		// TODO Auto-generated method stub
		return tbSettingsMapper.selectByExample(example);
	}

}
