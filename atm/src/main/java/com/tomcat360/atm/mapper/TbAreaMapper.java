package com.tomcat360.atm.mapper;

import com.tomcat360.atm.model.TbArea;
import com.tomcat360.atm.model.TbAreaExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

	TbArea findWithdrawsum(String id);
}