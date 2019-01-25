package com.tomcat360.admin.mapper;

import com.tomcat360.admin.model.TbEquipment;
import com.tomcat360.admin.model.TbEquipmentExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TbEquipmentMapper {
    int countByExample(TbEquipmentExample example);

    int deleteByExample(TbEquipmentExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbEquipment record);

    int insertSelective(TbEquipment record);

    List<TbEquipment> selectByExample(TbEquipmentExample example);

    TbEquipment selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbEquipment record, @Param("example") TbEquipmentExample example);

    int updateByExample(@Param("record") TbEquipment record, @Param("example") TbEquipmentExample example);

    int updateByPrimaryKeySelective(TbEquipment record);

    int updateByPrimaryKey(TbEquipment record);

	Map equipmentAreaNum(String country);

	List<Map> equipmentVrsionList();

	void updateId(Map<String,String> map);

	List<Map<String, Object>> findAll(Map<String, Object> params);

	List<Map<String, Object>> findAllByEquipmentIds(Map<String, Object> params);

	List<Map<String, Object>> getAllEquipmentLocation(Map<String,Object> params);
}