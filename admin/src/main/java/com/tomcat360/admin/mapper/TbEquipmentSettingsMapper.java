package com.tomcat360.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.tomcat360.admin.model.TbEquipmentSettings;
import com.tomcat360.admin.model.TbEquipmentSettingsExample;

public interface TbEquipmentSettingsMapper {
    int countByExample(TbEquipmentSettingsExample example);

    int deleteByExample(TbEquipmentSettingsExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbEquipmentSettings record);

    int insertSelective(TbEquipmentSettings record);

    List<Map<String,Object>> selectByExample(TbEquipmentSettingsExample example);

    TbEquipmentSettings selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbEquipmentSettings record, @Param("example") TbEquipmentSettingsExample example);

    int updateByExample(@Param("record") TbEquipmentSettings record, @Param("example") TbEquipmentSettingsExample example);

    int updateByPrimaryKeySelective(TbEquipmentSettings record);

    int updateByPrimaryKey(TbEquipmentSettings record);

	List<Map<String,Object>> getEquipmentNum(Map<String,Object> map);

	List<Map<String, Object>> selectByPrimaryKeyDetails(String id);

	List<Map<String,Object>> selectByList(Map<String, Object> params);

	List<TbEquipmentSettings> findSoftVersion();

	List<TbEquipmentSettings> findEquipmentVersion();

	List<TbEquipmentSettings> findBrand();

	List<TbEquipmentSettings> findAll();
	
}