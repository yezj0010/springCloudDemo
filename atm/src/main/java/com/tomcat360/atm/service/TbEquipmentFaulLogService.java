package com.tomcat360.atm.service;

import java.util.List;

import com.tomcat360.atm.model.TbEquipmentFaulLog;

public interface TbEquipmentFaulLogService {

	void insert(TbEquipmentFaulLog tbEquipmentFaulLog);

	List<TbEquipmentFaulLog> selectByEquipmentId(String id);

	void update(TbEquipmentFaulLog tbEquipmentFaulLog);


}
