package com.tomcat360.atm.service.Impl;

import com.tomcat360.atm.mapper.TbPCheckTransMapper;
import com.tomcat360.atm.model.TbPCheckTrans;
import com.tomcat360.atm.model.TbPCheckTransExample;
import com.tomcat360.atm.service.TbPCheckTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jin.Deng on 2018/9/19.
 */
@Service
public class TbPCheckTransServiceImpl implements TbPCheckTransService {

	@Autowired
	private TbPCheckTransMapper tbPCheckTransMapper;

	@Override
	public void insert(TbPCheckTrans tbPCheckTrans) {
		tbPCheckTransMapper.insert(tbPCheckTrans);
	}

	@Override
	public List<TbPCheckTrans> findByExample(TbPCheckTransExample tbPCheckTransExample) {
		return tbPCheckTransMapper.selectByExample(tbPCheckTransExample);
	}

	@Override
	public void update(TbPCheckTrans tbPCheckTrans) {
		tbPCheckTransMapper.updateByPrimaryKey(tbPCheckTrans);
	}
}
