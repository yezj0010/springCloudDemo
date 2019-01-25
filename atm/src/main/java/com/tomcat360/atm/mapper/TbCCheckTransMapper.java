package com.tomcat360.atm.mapper;

import com.tomcat360.atm.model.TbCCheckTrans;
import com.tomcat360.atm.model.TbCCheckTransExample;
import java.util.List;
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
}