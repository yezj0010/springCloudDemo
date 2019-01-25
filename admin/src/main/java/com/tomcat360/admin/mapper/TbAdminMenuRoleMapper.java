package com.tomcat360.admin.mapper;

import com.tomcat360.admin.model.TbAdminMenuRole;
import com.tomcat360.admin.model.TbAdminMenuRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbAdminMenuRoleMapper {
    int countByExample(TbAdminMenuRoleExample example);

    int deleteByExample(TbAdminMenuRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbAdminMenuRole record);

    int insertSelective(TbAdminMenuRole record);

    List<TbAdminMenuRole> selectByExample(TbAdminMenuRoleExample example);

    TbAdminMenuRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbAdminMenuRole record, @Param("example") TbAdminMenuRoleExample example);

    int updateByExample(@Param("record") TbAdminMenuRole record, @Param("example") TbAdminMenuRoleExample example);

    int updateByPrimaryKeySelective(TbAdminMenuRole record);

    int updateByPrimaryKey(TbAdminMenuRole record);
    
    //extends
    
    List<Long> findMenuByRoleId(Long roleId);
}