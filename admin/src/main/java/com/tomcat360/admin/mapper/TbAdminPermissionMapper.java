package com.tomcat360.admin.mapper;

import com.tomcat360.admin.model.TbAdminPermission;
import com.tomcat360.admin.model.TbAdminPermissionExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TbAdminPermissionMapper {
    int countByExample(TbAdminPermissionExample example);

    int deleteByExample(TbAdminPermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbAdminPermission record);

    int insertSelective(TbAdminPermission record);

    List<TbAdminPermission> selectByExample(TbAdminPermissionExample example);

    TbAdminPermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbAdminPermission record, @Param("example") TbAdminPermissionExample example);

    int updateByExample(@Param("record") TbAdminPermission record, @Param("example") TbAdminPermissionExample example);

    int updateByPrimaryKeySelective(TbAdminPermission record);

    int updateByPrimaryKey(TbAdminPermission record);
    
    //extends
    
    List<Map<String,String>> getAllPermissionList();
}