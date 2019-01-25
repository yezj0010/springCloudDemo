package com.tomcat360.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.tomcat360.admin.model.TbTrans;
import com.tomcat360.admin.model.TbTransExample;

public interface TbTransMapper {
    int countByExample(TbTransExample example);

    int deleteByExample(TbTransExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbTrans record);

    int insertSelective(TbTrans record);

    List<TbTrans> selectByExample(TbTransExample example);

    TbTrans selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbTrans record, @Param("example") TbTransExample example);

    int updateByExample(@Param("record") TbTrans record, @Param("example") TbTransExample example);

    int updateByPrimaryKeySelective(TbTrans record);

    int updateByPrimaryKey(TbTrans record);

	List<Map<String,Object>> findWithdrawInfo(Map<String, Object> params);

	TbTrans selectNumCurrency(String settingsValue);

	List<Map> getTransSum(Map map);

	List<Map> getProfitSum(Map map);
}