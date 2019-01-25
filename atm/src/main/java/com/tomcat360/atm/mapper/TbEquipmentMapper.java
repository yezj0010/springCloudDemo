package com.tomcat360.atm.mapper;

import com.tomcat360.atm.model.TbEquipment;
import com.tomcat360.atm.model.TbEquipmentExample;
import java.util.List;
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
}