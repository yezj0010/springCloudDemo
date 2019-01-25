package com.tomcat360.atm.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.tomcat360.atm.model.TbTrans;
import com.tomcat360.atm.model.TbTransExample;

public interface TbTransService {
	
	public int save(TbTrans tbTrans);
	
	public void update(TbTrans tbTrans);

	public void updateBySelective(TbTrans tbTrans);
	
	public TbTrans selectByPrimaryKey(String id);
	
	public List<TbTrans> selectByExample(TbTransExample example);

	public TbTrans selectByPrimaryTermSeq(String termSeq, Date termDate, String interfaceType, String termNo, Long userId);

	@SuppressWarnings("rawtypes")
	public BigDecimal getTransAmountByIdAndDate(Map params);

	/**
	 * 根据设备编号，获取取款对账交易汇总信息
	 * @param termNo
	 * @return
	 */
	public Map<String,Object> getDrawCheckTransData(String termNo);

	public void updateCToCheckedByEquipmentId(String termNo);

	/**
	 * 根据c端已对账和设备编号，查询取款交易，按交易所交易时间排序
	 * @param termNo
	 */
	public List<TbTrans> queryDrawTransByCChecked(String termNo);

	/**
	 * 根据c端已对账和设备编号，查询取款交易，按交易所交易时间排序,查询出第一条
	 * @param termNo
	 */
	public TbTrans queryDrawTransByPCheckedFirstRow(String termNo);

	public void updateDrawTransByCChecekdToPChecked(String termNo);

	public BigDecimal findWithdrawsum(Map map);
	
}
