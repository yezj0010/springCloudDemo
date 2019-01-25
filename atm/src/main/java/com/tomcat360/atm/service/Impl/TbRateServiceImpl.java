package com.tomcat360.atm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomcat360.atm.constant.AtmConstant;
import com.tomcat360.atm.mapper.TbRateMapper;
import com.tomcat360.atm.model.TbRate;
import com.tomcat360.atm.model.TbRateExample;
import com.tomcat360.atm.service.TbRateService;

@Service
public class TbRateServiceImpl implements TbRateService{

	@Autowired
	private TbRateMapper tbRateMapper;
	
	@Override
	public TbRate selectByCurrencyCode(String curencyCode) {
		TbRateExample example = new TbRateExample();
		example.createCriteria().andCurrencyCodeEqualTo(curencyCode.toUpperCase());
		List<TbRate> list = tbRateMapper.selectByExample(example);
		if(list==null || list.size()==0){
			TbRateExample example2 = new TbRateExample();
			example2.createCriteria().andCurrencyCodeEqualTo(AtmConstant.DEFAULT_CURRENCY);
			list = tbRateMapper.selectByExample(example2);
		}
		return list.get(0);
	}

}
