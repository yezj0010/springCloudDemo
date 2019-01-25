package com.tomcat360.atm.service;

import com.tomcat360.atm.model.TbArea;

/**
 * Created by jin.Deng on 2018/9/21.
 */
public interface TbAreaService {

	TbArea selectById(Long countryId);

	TbArea findWithdrawsum(String id);
}
