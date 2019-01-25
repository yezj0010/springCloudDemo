package com.tomcat360.atm.service;

import com.tomcat360.atm.model.TbSettings;
import com.tomcat360.atm.model.TbSettingsExample;

import java.util.List;

/**
 * Created by jin.Deng on 2018/9/21.
 */
public interface TbSettingsService {

	TbSettings selectBySettingsCode(String settingsCode);

	List<TbSettings> selectByExample(TbSettingsExample example);
}
