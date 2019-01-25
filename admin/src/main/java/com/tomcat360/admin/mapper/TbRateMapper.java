package com.tomcat360.admin.mapper;

import com.tomcat360.admin.model.TbRate;
import com.tomcat360.admin.model.TbRateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbRateMapper {
    int countByExample(TbRateExample example);

    int deleteByExample(TbRateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbRate record);

    int insertSelective(TbRate record);

    List<TbRate> selectByExample(TbRateExample example);

    TbRate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbRate record, @Param("example") TbRateExample example);

    int updateByExample(@Param("record") TbRate record, @Param("example") TbRateExample example);

    int updateByPrimaryKeySelective(TbRate record);

    int updateByPrimaryKey(TbRate record);
}