package com.tomcat360.admin.mapper;

import com.tomcat360.admin.model.TbEquipmentFaulLog;
import com.tomcat360.admin.model.TbEquipmentFaulLogExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TbEquipmentFaulLogMapper {
    int countByExample(TbEquipmentFaulLogExample example);

    int deleteByExample(TbEquipmentFaulLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbEquipmentFaulLog record);

    int insertSelective(TbEquipmentFaulLog record);

    List<TbEquipmentFaulLog> selectByExample(TbEquipmentFaulLogExample example);

    TbEquipmentFaulLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbEquipmentFaulLog record, @Param("example") TbEquipmentFaulLogExample example);

    int updateByExample(@Param("record") TbEquipmentFaulLog record, @Param("example") TbEquipmentFaulLogExample example);

    int updateByPrimaryKeySelective(TbEquipmentFaulLog record);

    int updateByPrimaryKey(TbEquipmentFaulLog record);

	TbEquipmentFaulLog findDowntimeEquipment(TbEquipmentFaulLog tbEquipmentFaulLog);

	List<Map<String,Object>> findFaultEquipment(Map<String, Object> map);

	List<Map<String,Object>> lackMoneyEquipment();
}