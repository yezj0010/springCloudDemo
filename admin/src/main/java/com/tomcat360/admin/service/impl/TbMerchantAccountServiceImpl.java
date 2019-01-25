package com.tomcat360.admin.service.impl;

import java.util.List;
import java.util.Map;

import com.tomcat360.admin.model.TbMerchantAccountExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomcat360.admin.mapper.TbMerchantAccountMapper;
import com.tomcat360.admin.model.TbMerchantAccount;
import com.tomcat360.admin.service.TbMerchantAccountService;
import org.springframework.util.StringUtils;

@Service
public class TbMerchantAccountServiceImpl implements TbMerchantAccountService {
	@Autowired
	private TbMerchantAccountMapper tbMerchantAccountMapper;
	
	
	@Override
	public List<TbMerchantAccount> findOperateAccountInfo(Map params) {
		String currency = (String)params.get("currency");
		TbMerchantAccountExample example = new TbMerchantAccountExample();
		TbMerchantAccountExample.Criteria criteria = example.createCriteria();
		if(!StringUtils.isEmpty(currency)){
			criteria.andCurrencyEqualTo(currency);
		}
		return tbMerchantAccountMapper.selectByExample(example);
	}


	@Override
	public void updateSelective(TbMerchantAccount tbMerchantAccount) {
		tbMerchantAccountMapper.updateByPrimaryKeySelective(tbMerchantAccount);  
		
	}


	@Override
	public void update(TbMerchantAccount tbMerchantAccount) {
		tbMerchantAccountMapper.updateByPrimaryKey(tbMerchantAccount);

	}

	@Override
	public void insert(TbMerchantAccount tbMerchantAccount) {
		tbMerchantAccountMapper.insert(tbMerchantAccount);
	}

	@Override
	public List<TbMerchantAccount> findByExample(TbMerchantAccountExample example) {
		return tbMerchantAccountMapper.selectByExample(example);
	}
}
