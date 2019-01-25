package com.tomcat360.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.tomcat360.admin.model.TbAllCurrency;
import com.tomcat360.admin.model.TbAllCurrencyExample;

public interface TbAllCurrencyMapper {
    int countByExample(TbAllCurrencyExample example);

    int deleteByExample(TbAllCurrencyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbAllCurrency record);

    int insertSelective(TbAllCurrency record);

    List<TbAllCurrency> selectByExample(TbAllCurrencyExample example);

    TbAllCurrency selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbAllCurrency record, @Param("example") TbAllCurrencyExample example);

    int updateByExample(@Param("record") TbAllCurrency record, @Param("example") TbAllCurrencyExample example);

    int updateByPrimaryKeySelective(TbAllCurrency record);

    int updateByPrimaryKey(TbAllCurrency record);

	List<Map<String,Object>> findAllCurrency();
}