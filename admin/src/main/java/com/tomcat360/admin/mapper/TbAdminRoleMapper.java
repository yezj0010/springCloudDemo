package com.tomcat360.admin.mapper;

import com.tomcat360.admin.model.TbAdminRole;
import com.tomcat360.admin.model.TbAdminRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbAdminRoleMapper {
    int countByExample(TbAdminRoleExample example);

    int deleteByExample(TbAdminRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbAdminRole record);

    int insertSelective(TbAdminRole record);

    List<TbAdminRole> selectByExample(TbAdminRoleExample example);

    TbAdminRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbAdminRole record, @Param("example") TbAdminRoleExample example);

    int updateByExample(@Param("record") TbAdminRole record, @Param("example") TbAdminRoleExample example);

    int updateByPrimaryKeySelective(TbAdminRole record);

    int updateByPrimaryKey(TbAdminRole record);
}