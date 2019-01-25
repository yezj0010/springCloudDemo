package com.tomcat360.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tomcat360.admin.enums.EnumResponseMsg;
import com.tomcat360.admin.mapper.TbWithdrawCurrencyMapper;
import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbWithdrawCurrency;
import com.tomcat360.admin.model.TbWithdrawCurrencyExample;
import com.tomcat360.admin.service.TbEquipmentSettingsService;
import com.tomcat360.admin.service.TbWithdrawCurrencyService;

@Service
public class TbWithdrawCurrencyServiceImpl implements TbWithdrawCurrencyService {

	@Autowired
	private TbEquipmentSettingsService tbEquipmentSettingsService;
	@Autowired
	private TbWithdrawCurrencyMapper tbWithdrawCurrencyMapper;

	@Override
	public List<Map<String,Object>> currencyList() {
		List<Map<String,Object>> list = tbWithdrawCurrencyMapper.selectCurrencyName();
		return list;
	}

	
	@Override
	public List<String> selectAllDrawCurrency() {
		return tbWithdrawCurrencyMapper.selectAllDrawCurrency();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public JSONData withdrawCurrencyInfo(Map params) {
		Integer page = Integer.valueOf(params.get("page").toString());
		Integer size = Integer.valueOf(params.get("size").toString());
		Page<TbWithdrawCurrency> pages = PageHelper.startPage(page, size);
		List<TbWithdrawCurrency> list = tbWithdrawCurrencyMapper.findAll();
		
		
		Map result = new HashMap();
		result.put("list", list);
		result.put("totalNumber", pages.getTotal() );
		result.put("totalNum", pages.getTotal());
		result.put("page", pages.getPageNum());
		result.put("pageSize", pages.getPageSize());
		result.put("totalPages", pages.getPages());
		return JSONData.builder().msg(EnumResponseMsg.RESP_SUCCESS.getMsg())
				.code(EnumResponseMsg.RESP_SUCCESS.getCode()).data(result).build();
	}

	@Override
	public void insert(TbWithdrawCurrency withdrawCurrency) {
		tbWithdrawCurrencyMapper.insert(withdrawCurrency);
	}

	@Override
	public void deleteByCurrencyCode(String currencyCode) {
		TbWithdrawCurrencyExample example = new TbWithdrawCurrencyExample();
		example.createCriteria().andCurrencyNameEqualTo(currencyCode);
		tbWithdrawCurrencyMapper.deleteByExample(example);
	}

	@Override
	public List<Map<String, Object>> findAllCurrencyName() {
		return tbWithdrawCurrencyMapper.findAllCurrencyName();

	}

	@Override
	public JSONData delete(String currencyCode) {
		List<Map<String, Object>> list = tbEquipmentSettingsService.findEquipmentByCurrencyCode(currencyCode);
		if (list != null && list.size() > 0) {
			return JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_CURRENCY_EQUIPMENT.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_CURRENCY_EQUIPMENT.getCode()).build();
		}
		TbWithdrawCurrencyExample example = new TbWithdrawCurrencyExample();
		example.createCriteria().andCurrencyNameEqualTo(currencyCode);
		List<TbWithdrawCurrency> list2 = tbWithdrawCurrencyMapper.selectByExample(example);
		
		//修改币种状态 存入数据库
		TbWithdrawCurrency tbWithdrawCurrency = list2.get(0);
		tbWithdrawCurrency.setStatus("1");
		tbWithdrawCurrencyMapper.updateByPrimaryKeySelective(tbWithdrawCurrency);
		return JSONData.builder().msg(EnumResponseMsg.RESP_SUCCESS.getMsg())
				.code(EnumResponseMsg.RESP_SUCCESS.getCode()).build();
	}

	@Override
	public JSONData start(String currencyCode) {
		TbWithdrawCurrencyExample example = new TbWithdrawCurrencyExample();
		example.createCriteria().andCurrencyNameEqualTo(currencyCode);
		List<TbWithdrawCurrency> list2 = tbWithdrawCurrencyMapper.selectByExample(example);
		
		//修改币种状态 存入数据库
		TbWithdrawCurrency tbWithdrawCurrency = list2.get(0);
		tbWithdrawCurrency.setStatus("0");
		tbWithdrawCurrencyMapper.updateByPrimaryKeySelective(tbWithdrawCurrency);
		return JSONData.builder().msg(EnumResponseMsg.RESP_SUCCESS.getMsg())
				.code(EnumResponseMsg.RESP_SUCCESS.getCode()).build();
	}

	@Override
	public List<TbWithdrawCurrency> findByCurrencyName(String currencyCode) {
		TbWithdrawCurrencyExample example = new TbWithdrawCurrencyExample();
		example.createCriteria().andCurrencyNameEqualTo(currencyCode);
		
		return tbWithdrawCurrencyMapper.selectByExample(example);
	}

	@Override
	public List<TbWithdrawCurrency> findByDescCny(String descCny) {
		TbWithdrawCurrencyExample example = new TbWithdrawCurrencyExample();
		example.createCriteria().andDescCnyEqualTo(descCny);
		
		return tbWithdrawCurrencyMapper.selectByExample(example);
	}

	@Override
	public TbWithdrawCurrency findById(Long valueOf) {
		// TODO Auto-generated method stub
		return tbWithdrawCurrencyMapper.selectByPrimaryKey(valueOf);
	}

	@Override
	public void update(TbWithdrawCurrency withdrawCurrency) {
		tbWithdrawCurrencyMapper.updateByPrimaryKeySelective(withdrawCurrency);
		
	}

}
