package com.tomcat360.timer.service.impl;

import com.tomcat360.timer.mapper.TbEquipmentFaulLogMapper;
import com.tomcat360.timer.model.TbEquipmentFaulLog;
import com.tomcat360.timer.service.EquipmentFaulLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jin.Deng on 2018/9/17.
 */
@Service
public class EquipmentFaulLogServiceImpl implements EquipmentFaulLogService {

	@Autowired
	private TbEquipmentFaulLogMapper equipmentFaulLogMapper;

	@Override
	public void insert(TbEquipmentFaulLog tbEquipmentFaulLog) {
		equipmentFaulLogMapper.insert(tbEquipmentFaulLog);
	}
}
