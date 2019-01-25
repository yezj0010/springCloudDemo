package com.tomcat360.atm.service.Impl;

import com.tomcat360.atm.mapper.TbTransMapper;
import com.tomcat360.atm.model.TbTrans;
import com.tomcat360.atm.model.TbTransExample;
import com.tomcat360.atm.service.TbTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TbTransServiceImpl implements TbTransService{

	@Autowired
	private TbTransMapper tbTransMapper;
	
	@Override
	public int save(TbTrans tbTrans) {
		return tbTransMapper.insert(tbTrans);
	}

	@Override
	public void update(TbTrans tbTrans) {
		tbTransMapper.updateByPrimaryKey(tbTrans);
	}

	@Override
	public void updateBySelective(TbTrans tbTrans) {
		tbTransMapper.updateByPrimaryKeySelective(tbTrans);
	}

	@Override
	public TbTrans selectByPrimaryKey(String id) {
		return tbTransMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<TbTrans> selectByExample(TbTransExample example) {
		return tbTransMapper.selectByExample(example);
	}

	@Override
	public TbTrans selectByPrimaryTermSeq(String termSeq, Date termDate, String interfaceType, String termNo, Long userId) {
		TbTransExample tbTransExample = new TbTransExample();
		tbTransExample.createCriteria().andEquipmentLogSeqEqualTo(termSeq).andTermDateEqualTo(termDate)
		.andInterfaceTypeEqualTo(interfaceType).andEquipmentIdEqualTo(termNo).andUserIdEqualTo(userId);
		List<TbTrans> selectByExample = tbTransMapper.selectByExample(tbTransExample);
		if(selectByExample == null || selectByExample.size()==0){
			return null;
		}
		
		return selectByExample.get(0);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public BigDecimal getTransAmountByIdAndDate(Map params) {
		return tbTransMapper.getTransAmountByIdAndDate(params);
	}

	@Override
	public Map<String, Object> getDrawCheckTransData(String termNo) {
		return tbTransMapper.getDrawCheckTransData(termNo);
	}

	@Override
	public void updateCToCheckedByEquipmentId(String termNo) {
		tbTransMapper.updateCToCheckedByEquipmentId(termNo);
	}

	@Override
	public List<TbTrans> queryDrawTransByCChecked(String termNo) {
		return tbTransMapper.queryDrawTransByCChecked(termNo);
	}

	@Override
	public TbTrans queryDrawTransByPCheckedFirstRow(String termNo) {
		return tbTransMapper.queryDrawTransByPCheckedFirstRow(termNo);
	}

	@Override
	public void updateDrawTransByCChecekdToPChecked(String termNo) {
		tbTransMapper.updateDrawTransByCCheckedToPChecked(termNo);
	}

	@Override
	public BigDecimal findWithdrawsum(Map map) {
		
		return tbTransMapper.findWithdrawsum(map);
	}
}
