package com.tomcat360.admin.mapper;

import com.tomcat360.admin.model.TbSettings;
import com.tomcat360.admin.model.TbSettingsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbSettingsMapper {
    int countByExample(TbSettingsExample example);

    int deleteByExample(TbSettingsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbSettings record);

    int insertSelective(TbSettings record);

    List<TbSettings> selectByExample(TbSettingsExample example);

    TbSettings selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbSettings record, @Param("example") TbSettingsExample example);

    int updateByExample(@Param("record") TbSettings record, @Param("example") TbSettingsExample example);

    int updateByPrimaryKeySelective(TbSettings record);

    int updateByPrimaryKey(TbSettings record);
}