package com.tomcat360.admin.mapper;

import com.tomcat360.admin.model.TbAdminLog;
import com.tomcat360.admin.model.TbAdminLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbAdminLogMapper {
    int countByExample(TbAdminLogExample example);

    int deleteByExample(TbAdminLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbAdminLog record);

    int insertSelective(TbAdminLog record);

    List<TbAdminLog> selectByExample(TbAdminLogExample example);

    TbAdminLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbAdminLog record, @Param("example") TbAdminLogExample example);

    int updateByExample(@Param("record") TbAdminLog record, @Param("example") TbAdminLogExample example);

    int updateByPrimaryKeySelective(TbAdminLog record);

    int updateByPrimaryKey(TbAdminLog record);
}