package com.tomcat360.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.tomcat360.admin.model.TbAdminMenu;
import com.tomcat360.admin.model.TbAdminMenuExample;

public interface TbAdminMenuMapper {
    int countByExample(TbAdminMenuExample example);

    int deleteByExample(TbAdminMenuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbAdminMenu record);

    int insertSelective(TbAdminMenu record);

    List<TbAdminMenu> selectByExample(TbAdminMenuExample example);

    TbAdminMenu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbAdminMenu record, @Param("example") TbAdminMenuExample example);

    int updateByExample(@Param("record") TbAdminMenu record, @Param("example") TbAdminMenuExample example);

    int updateByPrimaryKeySelective(TbAdminMenu record);

    int updateByPrimaryKey(TbAdminMenu record);
    
    //extend
    
    List<TbAdminMenu> selectAllrelByMenuIds(Map<String,Object> params);
    
    List<TbAdminMenu> findListByParentIdAndLevelAndRoleId(Map<String,Object> params);
    
    List<Map<String,Object>> queryZTreeList();
}