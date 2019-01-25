package com.tomcat360.atm.mapper;

import com.tomcat360.atm.model.TbEquipmentFaulLog;
import com.tomcat360.atm.model.TbEquipmentFaulLogExample;
import java.util.List;
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
}