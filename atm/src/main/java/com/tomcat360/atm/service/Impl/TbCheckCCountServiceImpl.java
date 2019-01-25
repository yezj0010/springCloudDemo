package com.tomcat360.atm.service.Impl;

import com.tomcat360.atm.mapper.TbCheckCCountMapper;
import com.tomcat360.atm.model.TbCheckCCount;
import com.tomcat360.atm.service.TbCheckCCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jin.Deng on 2018/9/21.
 */
@Service
public class TbCheckCCountServiceImpl implements TbCheckCCountService {

	@Autowired
	private TbCheckCCountMapper tbCheckCCountMapper;

	@Override
	public void insert(TbCheckCCount tbCheckCCount) {
		tbCheckCCountMapper.insert(tbCheckCCount);
	}
}
