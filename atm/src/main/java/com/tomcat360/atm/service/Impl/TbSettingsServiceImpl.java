package com.tomcat360.atm.service.Impl;

import com.tomcat360.atm.mapper.TbSettingsMapper;
import com.tomcat360.atm.model.TbSettings;
import com.tomcat360.atm.model.TbSettingsExample;
import com.tomcat360.atm.service.TbSettingsService;
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
	public TbSettings selectBySettingsCode(String settingsCode) {
		TbSettingsExample example = new TbSettingsExample();
		example.createCriteria().andSettingsCodeEqualTo(settingsCode);
		List<TbSettings> list = tbSettingsMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(list)){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<TbSettings> selectByExample(TbSettingsExample example) {
		return tbSettingsMapper.selectByExample(example);
	}
}
