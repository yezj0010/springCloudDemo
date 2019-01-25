package com.tomcat360.admin.service;

import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbSettings;

import java.util.List;
import java.util.Map;

/**
 * Created by jin.Deng on 2018/9/17.
 */
public interface SettingsService {

	JSONData findByCondition(Map<String,Object> param);

	void insert(TbSettings settings);

	void update(TbSettings settings);

	JSONData queryCoinsList();

	List<TbSettings> findByTypeAndValue(String settingsType, String settingsValue);

	public List<TbSettings> findByTypeAndValueExcpSelf(String settingsType, String settingsValue,Long id);
}
