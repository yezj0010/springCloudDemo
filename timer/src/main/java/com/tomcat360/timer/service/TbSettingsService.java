package com.tomcat360.timer.service;

import com.tomcat360.timer.model.TbSettings;

/**
 * Created by jin.Deng on 2018/9/21.
 */
public interface TbSettingsService {

	TbSettings queryBySettingsCode(String settingsCode);
}
