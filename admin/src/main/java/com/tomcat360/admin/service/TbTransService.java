package com.tomcat360.admin.service;

import java.util.List;
import java.util.Map;

import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbTrans;
import com.tomcat360.admin.model.TbTransExample;

public interface TbTransService {

	JSONData findWithdrawInfo(Map<String, Object> params);

	List<TbTrans> selectExample(TbTransExample tbTransExample);

	TbTrans selectNumCurrency(String settingsValue);

	Map getTransSum(Map requestMap);

	JSONData getProfitSum(Map map);

}
