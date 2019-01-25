package com.tomcat360.atm.mapper;

import com.tomcat360.atm.model.TbCheckResult;
import com.tomcat360.atm.model.TbCheckResultExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
}