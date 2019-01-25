package com.tomcat360.atm.service;

import java.util.List;

public interface WithdrawCurrencyService {
	
	List<Integer> getDrawMoneyListByCurrency(String drawCurrency);
}
