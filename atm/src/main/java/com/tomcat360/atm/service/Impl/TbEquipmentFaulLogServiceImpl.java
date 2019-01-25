package com.tomcat360.atm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomcat360.atm.mapper.TbEquipmentFaulLogMapper;
import com.tomcat360.atm.model.TbEquipmentFaulLog;
import com.tomcat360.atm.model.TbEquipmentFaulLogExample;
import com.tomcat360.atm.service.TbEquipmentFaulLogService;
@Service
public class TbEquipmentFaulLogServiceImpl implements TbEquipmentFaulLogService {
	
	@Autowired
	private TbEquipmentFaulLogMapper tbEquipmentFaulLogMapper;

	@Override
	public void insert(TbEquipmentFaulLog tbEquipmentFaulLog) {
		// TODO Auto-generated method stub
		tbEquipmentFaulLogMapper.insert(tbEquipmentFaulLog);
	}

	@Override
	public List<TbEquipmentFaulLog> selectByEquipmentId(String id) {
		// TODO Auto-generated method stub
		TbEquipmentFaulLogExample example = new TbEquipmentFaulLogExample();
		example.createCriteria().andEquipmentIdEqualTo(id);
		example.setOrderByClause("createTime desc");
		List<TbEquipmentFaulLog> selectByExample = tbEquipmentFaulLogMapper.selectByExample(example);
		return selectByExample;
	}

	@Override
	public void update(TbEquipmentFaulLog tbEquipmentFaulLog) {
		tbEquipmentFaulLogMapper.updateByPrimaryKeySelective(tbEquipmentFaulLog);

	}

	
	
	
}
