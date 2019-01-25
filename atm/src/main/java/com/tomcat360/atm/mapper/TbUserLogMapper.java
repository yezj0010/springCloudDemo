package com.tomcat360.atm.mapper;

import com.tomcat360.atm.model.TbUserLog;
import com.tomcat360.atm.model.TbUserLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserLogMapper {
    int countByExample(TbUserLogExample example);

    int deleteByExample(TbUserLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbUserLog record);

    int insertSelective(TbUserLog record);

    List<TbUserLog> selectByExample(TbUserLogExample example);

    TbUserLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbUserLog record, @Param("example") TbUserLogExample example);

    int updateByExample(@Param("record") TbUserLog record, @Param("example") TbUserLogExample example);

    int updateByPrimaryKeySelective(TbUserLog record);

    int updateByPrimaryKey(TbUserLog record);
}