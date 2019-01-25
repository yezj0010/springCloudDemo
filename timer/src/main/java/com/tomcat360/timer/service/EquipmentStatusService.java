package com.tomcat360.timer.service;

import java.util.List;
import java.util.Map;

import com.tomcat360.timer.model.TbEquipmentStatus;

public interface EquipmentStatusService {
	
	List<TbEquipmentStatus> selectByCondition(Map<String,Object> params);
	
	void update(TbEquipmentStatus tbEquipmentStatus);
}
