package com.tomcat360.atm.mapper;

import com.tomcat360.atm.model.TbEquipmentSettings;
import com.tomcat360.atm.model.TbEquipmentSettingsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbEquipmentSettingsMapper {
    int countByExample(TbEquipmentSettingsExample example);

    int deleteByExample(TbEquipmentSettingsExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbEquipmentSettings record);

    int insertSelective(TbEquipmentSettings record);

    List<TbEquipmentSettings> selectByExample(TbEquipmentSettingsExample example);

    TbEquipmentSettings selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbEquipmentSettings record, @Param("example") TbEquipmentSettingsExample example);

    int updateByExample(@Param("record") TbEquipmentSettings record, @Param("example") TbEquipmentSettingsExample example);

    int updateByPrimaryKeySelective(TbEquipmentSettings record);

    int updateByPrimaryKey(TbEquipmentSettings record);
}