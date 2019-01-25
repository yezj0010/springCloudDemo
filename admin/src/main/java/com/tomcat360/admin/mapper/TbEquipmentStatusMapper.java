package com.tomcat360.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.tomcat360.admin.model.TbEquipmentStatus;
import com.tomcat360.admin.model.TbEquipmentStatusExample;

public interface TbEquipmentStatusMapper {
	int countByExample(TbEquipmentStatusExample example);

	int deleteByExample(TbEquipmentStatusExample example);

	int deleteByPrimaryKey(String id);

	int insert(TbEquipmentStatus record);

	int insertSelective(TbEquipmentStatus record);

	List<TbEquipmentStatus> selectByExample(TbEquipmentStatusExample example);

	TbEquipmentStatus selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") TbEquipmentStatus record,
			@Param("example") TbEquipmentStatusExample example);

	int updateByExample(@Param("record") TbEquipmentStatus record, @Param("example") TbEquipmentStatusExample example);

	int updateByPrimaryKeySelective(TbEquipmentStatus record);

	int updateByPrimaryKey(TbEquipmentStatus record);

	List<TbEquipmentStatus> monitorEquipmentList(Map map);

	List<Map<String, Object>> findDowntimeEquipment();

	List<Map<String, Object>> monitorEquipmentList0(Map map);

	List<Map<String, Object>> monitorEquipmentList1(Map map);

	List<Map<String, Object>> monitorEquipmentList2(Map map);

	List<Map<String, Object>> monitorEquipmentList3(Map map);

	List<Map<String, Object>> monitorEquipmentList4(Map map);

	List<Map<String, Object>> monitorEquipmentList5(Map map);

	List<TbEquipmentStatus> monitorEquipmentList6(Map map);

	List<TbEquipmentStatus> findByIdleEquipment(Map map);

	List<TbEquipmentStatus> findByNotActive(Map map);

	List<TbEquipmentStatus> findByNormalEquiment(Map map);

	List<TbEquipmentStatus> findByAbnormal(Map map);

	List<Map<String, Object>> test(Map map);

	List<Map<String, Object>> findEquipmentStatus();

}