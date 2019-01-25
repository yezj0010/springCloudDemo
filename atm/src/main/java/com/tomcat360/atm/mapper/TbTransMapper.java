package com.tomcat360.atm.mapper;

import com.tomcat360.atm.model.TbTrans;
import com.tomcat360.atm.model.TbTransExample;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

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

	//extends

    @SuppressWarnings("rawtypes")
    BigDecimal getTransAmountByIdAndDate(Map params);

    Map<String,Object> getDrawCheckTransData(String termNo);

    void updateCToCheckedByEquipmentId(String termNo);

    List<TbTrans> queryDrawTransByCChecked(String termNo);

    TbTrans queryDrawTransByPCheckedFirstRow(String termNo);

    void updateDrawTransByCCheckedToPChecked(String termNo);

	BigDecimal findWithdrawsum(Map map);
}