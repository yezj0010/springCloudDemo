package com.tomcat360.admin.service;

import java.util.Map;

import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbCheckResult;

public interface TbExCheckTransService {

	JSONData findExTransInfoList(Map params);


}
