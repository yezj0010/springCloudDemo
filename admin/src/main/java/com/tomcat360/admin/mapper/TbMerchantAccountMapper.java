package com.tomcat360.admin.mapper;

import com.tomcat360.admin.model.TbMerchantAccount;
import com.tomcat360.admin.model.TbMerchantAccountExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TbMerchantAccountMapper {
    int countByExample(TbMerchantAccountExample example);

    int deleteByExample(TbMerchantAccountExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbMerchantAccount record);

    int insertSelective(TbMerchantAccount record);

    List<TbMerchantAccount> selectByExample(TbMerchantAccountExample example);

    TbMerchantAccount selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbMerchantAccount record, @Param("example") TbMerchantAccountExample example);

    int updateByExample(@Param("record") TbMerchantAccount record, @Param("example") TbMerchantAccountExample example);

    int updateByPrimaryKeySelective(TbMerchantAccount record);

    int updateByPrimaryKey(TbMerchantAccount record);

    List<Map<String,Object>> findAll();
}