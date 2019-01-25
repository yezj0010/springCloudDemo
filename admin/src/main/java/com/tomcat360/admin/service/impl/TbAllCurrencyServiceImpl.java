package com.tomcat360.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomcat360.admin.enums.EnumResponseMsg;
import com.tomcat360.admin.mapper.TbAllCurrencyMapper;
import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.service.TbAllCurrencyService;
import com.tomcat360.admin.service.TbWithdrawCurrencyService;
@Service
public class TbAllCurrencyServiceImpl implements TbAllCurrencyService {
	@Autowired
	private TbAllCurrencyMapper tbAllCurrencyMapper;
	@Autowired
	private TbWithdrawCurrencyService tbWithdrawCurrencyService;
	@SuppressWarnings({ "unchecked", "rawtypes"})
	@Override
	public JSONData findAllCurrency(String type) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> findAllCurrency = tbAllCurrencyMapper.findAllCurrency();
		if(type!=null && type.equals("1")){
			List<Map<String, Object>> listm = tbWithdrawCurrencyService.findAllCurrencyName();
			for (int i = findAllCurrency.size()-1; i >=0 ; i--) {
				boolean flag = true;
				Map<String, Object> map = findAllCurrency.get(i);
				String currencyCode = map.get("currencyCode")==null?"":map.get("currencyCode").toString();
				for (int j = 0; j < listm.size(); j++) {
					String currencyName = listm.get(j)==null?null:listm.get(j).get("currencyName").toString();
					if(currencyCode.equalsIgnoreCase(currencyName)){
						flag = false;
					}
				}
				if(!flag){
					findAllCurrency.remove(i);
				}
			}
		}
		
		Map map = new HashMap<String,Object>();
		map.put("list", findAllCurrency);
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(map).build();
	}
}
