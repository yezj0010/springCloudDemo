package com.tomcat360.atm.service.Impl;

import com.tomcat360.atm.mapper.TbAreaMapper;
import com.tomcat360.atm.model.TbArea;
import com.tomcat360.atm.service.TbAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jin.Deng on 2018/9/21.
 */
@Service
public class TbAreaServiceImpl implements TbAreaService {

	@Autowired
	private TbAreaMapper tbAreaMapper;

	@Override
	public TbArea selectById(Long countryId) {
		return tbAreaMapper.selectByPrimaryKey(countryId);
	}

	@Override
	public TbArea findWithdrawsum(String id) {
		// TODO Auto-generated method stub
		return tbAreaMapper.findWithdrawsum(id);
	}
}
