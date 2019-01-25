package com.tomcat360.admin.service;

import java.util.List;
import java.util.Map;

import com.tomcat360.admin.model.TbMerchantAccount;
import com.tomcat360.admin.model.TbMerchantAccountExample;

public interface TbMerchantAccountService {

	List<TbMerchantAccount> findOperateAccountInfo(Map params);

	void updateSelective(TbMerchantAccount tbMerchantAccount);

	void update(TbMerchantAccount tbMerchantAccount);

	void insert(TbMerchantAccount tbMerchantAccount);

	List<TbMerchantAccount> findByExample(TbMerchantAccountExample example);

}
