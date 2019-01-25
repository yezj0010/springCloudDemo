package com.tomcat360.atm.service;

import com.tomcat360.atm.model.JSONData;
import com.tomcat360.atm.model.TbEquipmentSettings;

public interface TbEquipmentSettingsService {

	TbEquipmentSettings find(String id);

	JSONData addMoney(String id, String amount);

	void updateDate(TbEquipmentSettings tbEquipmentSettings);
	
	TbEquipmentSettings findByIP(String ip);

}
