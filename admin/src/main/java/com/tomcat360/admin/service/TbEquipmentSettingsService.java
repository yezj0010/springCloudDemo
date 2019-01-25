package com.tomcat360.admin.service;

import java.util.List;
import java.util.Map;

import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbEquipmentSettings;

public interface TbEquipmentSettingsService {

	JSONData findByCondition(Map<String, Object> params);

	JSONData addTbEquipmentSettings(TbEquipmentSettings tbEquipmentSettings);

	TbEquipmentSettings selectByKey(String id);

	Map<String,Object> selectByKey1(String id);
	
	
	JSONData updateTbEquipmentSettings(TbEquipmentSettings tbEquipmentSettings);

	JSONData equipmentNum(Map<String, Object> params);

	JSONData findSoftVersion();

	JSONData findEquipmentVersion();

	JSONData findBrand();

	List<Map<String,Object>> findEquipmentByCurrencyCode(String currencyCode);

	void updateSelectTbEquipmentSettings(TbEquipmentSettings tbEquipmentSettings);

	List<TbEquipmentSettings> findAll();

}
