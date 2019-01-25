package com.tomcat360.admin.service;

import java.util.List;
import java.util.Map;

import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbWithdrawCurrency;

public interface TbWithdrawCurrencyService {

	List<Map<String,Object>> currencyList();

	List<String> selectAllDrawCurrency();

	JSONData withdrawCurrencyInfo(Map params);

	void insert(TbWithdrawCurrency withdrawCurrency);

	void deleteByCurrencyCode(String currencyCode);

	List<Map<String,Object>> findAllCurrencyName();

	JSONData delete(String currencyCode);

	JSONData start(String currencyCode);

	List<TbWithdrawCurrency> findByCurrencyName(String currencyCode);

	List<TbWithdrawCurrency> findByDescCny(String descCny);

	TbWithdrawCurrency findById(Long valueOf);

	void update(TbWithdrawCurrency withdrawCurrency);
}
