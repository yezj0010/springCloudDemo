package com.tomcat360.atm.mapper;

import com.tomcat360.atm.model.TbEquipmentStatus;
import com.tomcat360.atm.model.TbEquipmentStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbEquipmentStatusMapper {
    int countByExample(TbEquipmentStatusExample example);

    int deleteByExample(TbEquipmentStatusExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbEquipmentStatus record);

    int insertSelective(TbEquipmentStatus record);

    List<TbEquipmentStatus> selectByExample(TbEquipmentStatusExample example);

    TbEquipmentStatus selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbEquipmentStatus record, @Param("example") TbEquipmentStatusExample example);

    int updateByExample(@Param("record") TbEquipmentStatus record, @Param("example") TbEquipmentStatusExample example);

    int updateByPrimaryKeySelective(TbEquipmentStatus record);

    int updateByPrimaryKey(TbEquipmentStatus record);
}