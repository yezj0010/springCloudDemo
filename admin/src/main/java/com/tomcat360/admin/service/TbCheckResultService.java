package com.tomcat360.admin.service;

import java.util.Map;

import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbCheckResult;

public interface TbCheckResultService {

	JSONData checkCResultList(Map params);

	JSONData changeCheckResult(TbCheckResult tbCheckResult);

	TbCheckResult selectByKey(Long id);

}
