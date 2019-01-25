package com.tomcat360.admin.mapper;

import com.tomcat360.admin.model.TbExCheckTrans;
import com.tomcat360.admin.model.TbExCheckTransExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TbExCheckTransMapper {
    int countByExample(TbExCheckTransExample example);

    int deleteByExample(TbExCheckTransExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbExCheckTrans record);

    int insertSelective(TbExCheckTrans record);

    List<TbExCheckTrans> selectByExample(TbExCheckTransExample example);

    TbExCheckTrans selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbExCheckTrans record, @Param("example") TbExCheckTransExample example);

    int updateByExample(@Param("record") TbExCheckTrans record, @Param("example") TbExCheckTransExample example);

    int updateByPrimaryKeySelective(TbExCheckTrans record);

    int updateByPrimaryKey(TbExCheckTrans record);
    
	List<Map<String,Object>> findExTransInfoList(Map params);
}