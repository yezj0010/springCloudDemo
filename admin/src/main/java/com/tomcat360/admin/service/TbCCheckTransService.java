package com.tomcat360.admin.service;

import java.util.Map;

import com.tomcat360.admin.model.JSONData;

public interface TbCCheckTransService {


	JSONData findCTransInfoList(Map params);


	JSONData findlocCTransInfoList(Map params);

}
