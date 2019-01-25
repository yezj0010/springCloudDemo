package com.tomcat360.admin.service;

import java.util.List;
import java.util.Map;

import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbSettings;
import com.tomcat360.admin.model.TbSettingsExample;

public interface TbSettingsService {

	JSONData getParameterType(Map<String, Object> params);

	List<TbSettings> selectExample(TbSettingsExample example);
	
}
