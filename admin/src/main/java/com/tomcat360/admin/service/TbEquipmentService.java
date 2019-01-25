package com.tomcat360.admin.service;

import java.util.List;
import java.util.Map;

import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbEquipment;
import com.tomcat360.admin.model.TbEquipmentExample;

public interface TbEquipmentService {

	void insert(TbEquipment tbEquipment);

	TbEquipment selectByKey(String equipmentId);

	JSONData cashFlowEquipment(Map<String, Object> params);

	JSONData equipmentVrsionList(Map<String, Object> params);

	void update(TbEquipment tbEquipment);

	TbEquipment selectByEquipmentNo(String equipmentNo);

	JSONData equipmentAreaNum(String countryId);

	void insertInfo(TbEquipment tbEquipment);

	void updateId(Map<String,String> map);

	List<Map<String, Object>> findAll(Map<String, Object> params);

	/**
	 * 根据设备编号列表，查询远程控制设备列表信息
	 * @param params
	 * @return
	 */
	JSONData findAllByEquipmentIds(Map<String, Object> params);

	List<TbEquipment> findEquipmentByArea(String areaName);

	List<TbEquipment> select(TbEquipmentExample example);

	List<Map<String,Object>> getAllEquipmentLocation(Map<String,Object> params);

}
