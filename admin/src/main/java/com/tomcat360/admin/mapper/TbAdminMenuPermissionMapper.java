package com.tomcat360.admin.mapper;

import com.tomcat360.admin.model.TbAdminMenuPermission;
import com.tomcat360.admin.model.TbAdminMenuPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbAdminMenuPermissionMapper {
    int countByExample(TbAdminMenuPermissionExample example);

    int deleteByExample(TbAdminMenuPermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbAdminMenuPermission record);

    int insertSelective(TbAdminMenuPermission record);

    List<TbAdminMenuPermission> selectByExample(TbAdminMenuPermissionExample example);

    TbAdminMenuPermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbAdminMenuPermission record, @Param("example") TbAdminMenuPermissionExample example);

    int updateByExample(@Param("record") TbAdminMenuPermission record, @Param("example") TbAdminMenuPermissionExample example);

    int updateByPrimaryKeySelective(TbAdminMenuPermission record);

    int updateByPrimaryKey(TbAdminMenuPermission record);
    
    // extends 
    
    List<String> getPermissionListByRoleId(Long roleId);
}