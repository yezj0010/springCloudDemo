package com.tomcat360.admin.mapper;

import com.tomcat360.admin.model.TbArea;
import com.tomcat360.admin.model.TbAreaExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TbAreaMapper {
    int countByExample(TbAreaExample example);

    int deleteByExample(TbAreaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbArea record);

    int insertSelective(TbArea record);

    List<TbArea> selectByExample(TbAreaExample example);

    TbArea selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbArea record, @Param("example") TbAreaExample example);

    int updateByExample(@Param("record") TbArea record, @Param("example") TbAreaExample example);

    int updateByPrimaryKeySelective(TbArea record);

    int updateByPrimaryKey(TbArea record);

	List<TbArea> selectByParentId(String id);

	Integer findOrderNum();

	List<TbArea> findAll(Map<String, Object> params);

	List<Map> findAllNotSubPage(Map<String, Object> params);
}