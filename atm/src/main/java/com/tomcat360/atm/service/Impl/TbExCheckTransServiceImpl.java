package com.tomcat360.atm.service.Impl;

import com.tomcat360.atm.mapper.TbExCheckTransMapper;
import com.tomcat360.atm.model.TbExCheckTrans;
import com.tomcat360.atm.service.TbExCheckTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jin.Deng on 2018/9/20.
 */
@Service
public class TbExCheckTransServiceImpl implements TbExCheckTransService {

	@Autowired
	private TbExCheckTransMapper tbExCheckTransMapper;

	@Override
	public void insert(TbExCheckTrans tbExCheckTrans) {
		tbExCheckTransMapper.insert(tbExCheckTrans);
	}

	@Override
	public void update(TbExCheckTrans tbExCheckTrans) {
		tbExCheckTransMapper.updateByPrimaryKey(tbExCheckTrans);
	}
}
