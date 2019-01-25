package com.tomcat360.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tomcat360.admin.enums.EnumResponseMsg;
import com.tomcat360.admin.mapper.TbSettingsMapper;
import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbSettings;
import com.tomcat360.admin.model.TbSettingsExample;
import com.tomcat360.admin.service.SettingsService;

/**
 * Created by jin.Deng on 2018/9/17.
 */
@Service
public class SettingsServiceImpl implements SettingsService {

	@Autowired
	private TbSettingsMapper tbSettingsMapper;

	@Override
	public JSONData findByCondition(Map<String, Object> params) {
		Integer page = (Integer)params.get("page");
		Integer size = (Integer)params.get("size");
		String settingsType = (String)params.get("settingsType");
		String settingsCode = (String)params.get("settingsCode");
		String settingsName = (String)params.get("settingsName");

		TbSettingsExample example = new TbSettingsExample();
		TbSettingsExample.Criteria criteria = example.createCriteria();
		if(!StringUtils.isEmpty(settingsType)){
			criteria.andSettingsTypeEqualTo(settingsType);
		}
		if(!StringUtils.isEmpty(settingsCode)){
			criteria.andSettingsCodeEqualTo(settingsCode);
		}
		if(!StringUtils.isEmpty(settingsName)){
			int asc = (int)settingsName.substring(0,1).toCharArray()[0];
			if(asc>128){
				criteria.andSettingsNameCnLike("%"+settingsName+"%");
			}else{
				criteria.andSettingsNameEnLike("%"+settingsName+"%");
			}
		}
		criteria.andSettingsTypeNotEqualTo("0");
		Page<TbSettings> list = PageHelper.startPage(page, size);
		example.setOrderByClause("settings_type");
		tbSettingsMapper.selectByExample(example);

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
	public void insert(TbSettings settings) {
		tbSettingsMapper.insert(settings);
	}

	@Override
	public void update(TbSettings settings) {
		tbSettingsMapper.updateByPrimaryKeySelective(settings);
	}

	@Override
	public JSONData queryCoinsList() {
		TbSettingsExample example = new TbSettingsExample();
		example.createCriteria().andSettingsTypeEqualTo("2");
		List<TbSettings> list = tbSettingsMapper.selectByExample(example);
		Map<String, Object> data = new HashMap<String,Object>();
		data.put("list",list);
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(data).build();
	}

	@Override
	public List<TbSettings> findByTypeAndValue(String settingsType, String settingsValue) {
		TbSettingsExample example = new TbSettingsExample();
		example.createCriteria().andSettingsTypeEqualTo(settingsType).andSettingsValueEqualTo(settingsValue);
		return tbSettingsMapper.selectByExample(example);
	}

	@Override
	public List<TbSettings> findByTypeAndValueExcpSelf(String settingsType, String settingsValue,Long id) {
		TbSettingsExample example = new TbSettingsExample();
		example.createCriteria().andSettingsTypeEqualTo(settingsType).andSettingsValueEqualTo(settingsValue)
		.andIdNotEqualTo(id);
		return tbSettingsMapper.selectByExample(example);
	}
}
