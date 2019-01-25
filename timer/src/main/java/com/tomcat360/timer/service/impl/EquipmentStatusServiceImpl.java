package com.tomcat360.timer.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.StringUtil;
import com.tomcat360.timer.mapper.TbEquipmentStatusMapper;
import com.tomcat360.timer.model.TbEquipmentStatus;
import com.tomcat360.timer.model.TbEquipmentStatusExample;
import com.tomcat360.timer.model.TbEquipmentStatusExample.Criteria;
import com.tomcat360.timer.service.EquipmentStatusService;

@Service
public class EquipmentStatusServiceImpl implements EquipmentStatusService{

	@Autowired
	private TbEquipmentStatusMapper tbEquipmentStatusMapper;
	
	@Override
	public List<TbEquipmentStatus> selectByCondition(Map<String, Object> params) {
		String connectStatus = (String)params.get("connectStatus");
		
		TbEquipmentStatusExample example = new TbEquipmentStatusExample();
		Criteria criteria = example.createCriteria();
		if(!StringUtil.isEmpty(connectStatus)){
			criteria.andConnectStatusEqualTo(connectStatus);
		}
		return tbEquipmentStatusMapper.selectByExample(example);
	}

	@Override
	public void update(TbEquipmentStatus tbEquipmentStatus) {
		tbEquipmentStatusMapper.updateByPrimaryKey(tbEquipmentStatus);
	}

}
