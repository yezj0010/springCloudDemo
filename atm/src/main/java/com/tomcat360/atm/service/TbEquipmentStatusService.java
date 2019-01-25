package com.tomcat360.atm.service;

import com.tomcat360.atm.model.JSONData;
import com.tomcat360.atm.model.TbEquipmentStatus;

public interface TbEquipmentStatusService {

	JSONData updateByTbEquipmentStatus(TbEquipmentStatus tbEquipmentStatus);

	TbEquipmentStatus findById(String equipmentId);
	
	void updateByPrimaryKeySelective(TbEquipmentStatus tbEquipmentStatus);

}
