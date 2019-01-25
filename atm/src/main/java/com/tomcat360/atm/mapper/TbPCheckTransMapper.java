package com.tomcat360.atm.mapper;

import com.tomcat360.atm.model.TbPCheckTrans;
import com.tomcat360.atm.model.TbPCheckTransExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPCheckTransMapper {
    int countByExample(TbPCheckTransExample example);

    int deleteByExample(TbPCheckTransExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbPCheckTrans record);

    int insertSelective(TbPCheckTrans record);

    List<TbPCheckTrans> selectByExample(TbPCheckTransExample example);

    TbPCheckTrans selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbPCheckTrans record, @Param("example") TbPCheckTransExample example);

    int updateByExample(@Param("record") TbPCheckTrans record, @Param("example") TbPCheckTransExample example);

    int updateByPrimaryKeySelective(TbPCheckTrans record);

    int updateByPrimaryKey(TbPCheckTrans record);
}