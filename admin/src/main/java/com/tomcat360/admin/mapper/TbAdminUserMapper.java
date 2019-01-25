package com.tomcat360.admin.mapper;

import com.tomcat360.admin.model.TbAdminUser;
import com.tomcat360.admin.model.TbAdminUserExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TbAdminUserMapper {
    int countByExample(TbAdminUserExample example);

    int deleteByExample(TbAdminUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbAdminUser record);

    int insertSelective(TbAdminUser record);

    List<TbAdminUser> selectByExample(TbAdminUserExample example);

    TbAdminUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbAdminUser record, @Param("example") TbAdminUserExample example);

    int updateByExample(@Param("record") TbAdminUser record, @Param("example") TbAdminUserExample example);

    int updateByPrimaryKeySelective(TbAdminUser record);

    int updateByPrimaryKey(TbAdminUser record);

	List<Map<String,Object>> selectByCondition(Map<String, Object> params);

	List<TbAdminUser> findAll();
}