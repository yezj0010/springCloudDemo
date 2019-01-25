package com.tomcat360.admin.service;

import java.util.Map;

import com.tomcat360.admin.model.JSONData;

public interface TbPCheckTransService {

	JSONData findlocTransInfoList(Map params);

	JSONData findlocPTransInfoList(Map params);

}
