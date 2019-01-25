package com.tomcat360.atm.service.Impl;

import com.tomcat360.atm.mapper.TbCCheckTransMapper;
import com.tomcat360.atm.model.TbCCheckTrans;
import com.tomcat360.atm.service.TbCCheckTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jin.Deng on 2018/9/19.
 */
@Service
public class TbCCheckTransServiceImpl implements TbCCheckTransService {

	@Autowired
	private TbCCheckTransMapper tbCCheckTransMapper;

	@Override
	public void insert(TbCCheckTrans tbCCheckTrans) {
		tbCCheckTransMapper.insert(tbCCheckTrans);
	}
}
