package com.tomcat360.admin.service;

import java.util.Map;

import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbEquipmentFaulLog;

public interface TbEquipmentFaulLogService {

	TbEquipmentFaulLog findDowntimeEquipment(TbEquipmentFaulLog id);

	JSONData findFaultEquipment(Map<String, Object> params);

	JSONData lackMoneyEquipment(Map<String, Object> params);


}
