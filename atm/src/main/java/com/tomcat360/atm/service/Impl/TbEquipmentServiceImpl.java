package com.tomcat360.atm.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomcat360.atm.mapper.TbEquipmentMapper;
import com.tomcat360.atm.model.TbEquipment;
import com.tomcat360.atm.service.TbEquipmentService;
@Service
public class TbEquipmentServiceImpl implements TbEquipmentService {
	@Autowired
	private TbEquipmentMapper tbEquipmentMapper;

	@Override
	public TbEquipment find(String id) {
		TbEquipment selectByPrimaryKey = tbEquipmentMapper.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}

	@Override
	public void update(TbEquipment tbEquipment) {
		tbEquipmentMapper.updateByPrimaryKey(tbEquipment);
	}

	@Override
	public TbEquipment selectByKey(String id) {
		// TODO Auto-generated method stub
		return tbEquipmentMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateBySelective(TbEquipment selectiveRecord) {
		tbEquipmentMapper.updateByPrimaryKeySelective(selectiveRecord);
	}
	
}
