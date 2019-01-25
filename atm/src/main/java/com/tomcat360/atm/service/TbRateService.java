package com.tomcat360.atm.service;

import com.tomcat360.atm.model.TbRate;

public interface TbRateService {
	/**
	 * 根据币种查询费率
	 * @param example
	 * @return
	 */
	TbRate selectByCurrencyCode(String curencyCode);
}
