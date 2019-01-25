package com.tomcat360.atm.mapper;

import com.tomcat360.atm.model.TbExCheckTrans;
import com.tomcat360.atm.model.TbExCheckTransExample;
import java.util.List;
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
}