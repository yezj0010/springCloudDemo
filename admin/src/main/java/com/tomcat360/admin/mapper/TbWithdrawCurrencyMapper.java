package com.tomcat360.admin.mapper;

import com.tomcat360.admin.model.TbWithdrawCurrency;
import com.tomcat360.admin.model.TbWithdrawCurrencyExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TbWithdrawCurrencyMapper {
    int countByExample(TbWithdrawCurrencyExample example);

    int deleteByExample(TbWithdrawCurrencyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbWithdrawCurrency record);

    int insertSelective(TbWithdrawCurrency record);

    List<TbWithdrawCurrency> selectByExample(TbWithdrawCurrencyExample example);

    TbWithdrawCurrency selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbWithdrawCurrency record, @Param("example") TbWithdrawCurrencyExample example);

    int updateByExample(@Param("record") TbWithdrawCurrency record, @Param("example") TbWithdrawCurrencyExample example);

    int updateByPrimaryKeySelective(TbWithdrawCurrency record);

    int updateByPrimaryKey(TbWithdrawCurrency record);

	List<Map<String,Object>> selectCurrencyName();
	
	List<String> selectAllDrawCurrency();

	List<TbWithdrawCurrency> findAll();

	List<Map<String, Object>> findAllCurrencyName();
}