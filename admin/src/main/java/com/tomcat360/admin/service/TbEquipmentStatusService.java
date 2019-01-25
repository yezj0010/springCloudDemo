package com.tomcat360.admin.service;

import java.util.List;
import java.util.Map;

import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbEquipmentStatus;
import com.tomcat360.admin.model.TbEquipmentStatusExample;

public interface TbEquipmentStatusService {


	JSONData findByList(TbEquipmentStatus tbEquipmentStatus, String country, String page, String size, String type);

	void insert(TbEquipmentStatus tbEquipmentStatus);

	JSONData findDowntimeEquipment(Map<String, Object> params);

	TbEquipmentStatus selectById(String id);

	void update(TbEquipmentStatus tbEquipmentStatus);

	JSONData findByIdleEquipment(String country, String page, String size, String type, String id);

	JSONData findByNotActive(String country, String page, String size, String type, String id);

	JSONData findByNormalEquiment(String country, String page, String size, String type, String id);

	JSONData findByAbnormal(String country, String page, String size, String type, String id);

	JSONData test(TbEquipmentStatus tbEquipmentStatus, String country, String page, String size, String type,
			String equipmentType);

	JSONData findEquipmentStatus();

	List<TbEquipmentStatus> selectByExample(TbEquipmentStatusExample example);


}
