package com.tomcat360.admin.mapper;

import com.tomcat360.admin.model.TbCheckResult;
import com.tomcat360.admin.model.TbCheckResultExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TbCheckResultMapper {
    int countByExample(TbCheckResultExample example);

    int deleteByExample(TbCheckResultExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbCheckResult record);

    int insertSelective(TbCheckResult record);

    List<TbCheckResult> selectByExample(TbCheckResultExample example);

    TbCheckResult selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbCheckResult record, @Param("example") TbCheckResultExample example);

    int updateByExample(@Param("record") TbCheckResult record, @Param("example") TbCheckResultExample example);

    int updateByPrimaryKeySelective(TbCheckResult record);

    int updateByPrimaryKey(TbCheckResult record);

	List<TbCheckResult> checkCResultList(Map<String,Object> params);
}