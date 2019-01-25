package com.tomcat360.admin.mapper;

import com.tomcat360.admin.model.TbCCheckTrans;
import com.tomcat360.admin.model.TbCCheckTransExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TbCCheckTransMapper {
    int countByExample(TbCCheckTransExample example);

    int deleteByExample(TbCCheckTransExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbCCheckTrans record);

    int insertSelective(TbCCheckTrans record);

    List<TbCCheckTrans> selectByExample(TbCCheckTransExample example);

    TbCCheckTrans selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbCCheckTrans record, @Param("example") TbCCheckTransExample example);

    int updateByExample(@Param("record") TbCCheckTrans record, @Param("example") TbCCheckTransExample example);

    int updateByPrimaryKeySelective(TbCCheckTrans record);

    int updateByPrimaryKey(TbCCheckTrans record);
    


	List<Map<String,Object>> findCTransInfoList(Map params);

	Map countCStatus(Map params);
}