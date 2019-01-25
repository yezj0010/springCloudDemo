package com.tomcat360.timer.mapper;

import com.tomcat360.timer.model.TbEquipmentFaulLog;
import com.tomcat360.timer.model.TbEquipmentFaulLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
}