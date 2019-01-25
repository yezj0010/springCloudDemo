package com.tomcat360.admin.mapper;

import com.tomcat360.admin.model.TbEquipmentRunningStatus;
import com.tomcat360.admin.model.TbEquipmentRunningStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbEquipmentRunningStatusMapper {
    int countByExample(TbEquipmentRunningStatusExample example);

    int deleteByExample(TbEquipmentRunningStatusExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbEquipmentRunningStatus record);

    int insertSelective(TbEquipmentRunningStatus record);

    List<TbEquipmentRunningStatus> selectByExample(TbEquipmentRunningStatusExample example);

    TbEquipmentRunningStatus selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbEquipmentRunningStatus record, @Param("example") TbEquipmentRunningStatusExample example);

    int updateByExample(@Param("record") TbEquipmentRunningStatus record, @Param("example") TbEquipmentRunningStatusExample example);

    int updateByPrimaryKeySelective(TbEquipmentRunningStatus record);

    int updateByPrimaryKey(TbEquipmentRunningStatus record);

	List<TbEquipmentRunningStatus> findAll();
}