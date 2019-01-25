package com.tomcat360.atm.service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.tomcat360.atm.model.TbWithdrawCurrency;
import com.tomcat360.atm.model.TbWithdrawCurrencyExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomcat360.atm.mapper.TbWithdrawCurrencyMapper;
import com.tomcat360.atm.service.WithdrawCurrencyService;
import org.springframework.util.CollectionUtils;

@Service
public class WithdrawCurrencyServiceImpl implements WithdrawCurrencyService{

	@Autowired
	private TbWithdrawCurrencyMapper tbWithdrawCurrencyMapper;
	
	@Override
	public List<Integer> getDrawMoneyListByCurrency(String drawCurrency) {
		List<Integer> list = new ArrayList<Integer>();
		TbWithdrawCurrencyExample example = new TbWithdrawCurrencyExample();
		example.createCriteria().andCurrencyNameEqualTo(drawCurrency);

		List<TbWithdrawCurrency> tmplist = tbWithdrawCurrencyMapper.selectByExample(example);
		if(CollectionUtils.isEmpty(tmplist)){
			list.add(50);
			list.add(100);
			list.add(200);
			list.add(300);
			list.add(500);
			list.add(1000);
			return list;
		}
		TbWithdrawCurrency tbWithdrawCurrency = tmplist.get(0);
		list.add(tbWithdrawCurrency.getWithdrawMoney1());
		list.add(tbWithdrawCurrency.getWithdrawMoney2());
		list.add(tbWithdrawCurrency.getWithdrawMoney3());
		list.add(tbWithdrawCurrency.getWithdrawMoney4());
		list.add(tbWithdrawCurrency.getWithdrawMoney5());
		list.add(tbWithdrawCurrency.getWithdrawMoney6());
		return list;
	}
	
}
