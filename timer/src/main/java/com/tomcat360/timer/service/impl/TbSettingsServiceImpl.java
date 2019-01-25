package com.tomcat360.timer.service.impl;

import com.tomcat360.timer.mapper.TbSettingsMapper;
import com.tomcat360.timer.model.TbSettings;
import com.tomcat360.timer.model.TbSettingsExample;
import com.tomcat360.timer.service.TbSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by jin.Deng on 2018/9/21.
 */
@Service
public class TbSettingsServiceImpl implements TbSettingsService {

	@Autowired
	private TbSettingsMapper tbSettingsMapper;

	@Override
	public TbSettings queryBySettingsCode(String settingsCode) {
		TbSettingsExample exa = new TbSettingsExample();
		exa.createCriteria().andSettingsCodeEqualTo(settingsCode);
		List<TbSettings> settingsList = tbSettingsMapper.selectByExample(exa);
		if(!CollectionUtils.isEmpty(settingsList)){
			return settingsList.get(0);
		}else{
			return null;
		}
	}
}
