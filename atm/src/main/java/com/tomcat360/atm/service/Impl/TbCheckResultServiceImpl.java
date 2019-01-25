package com.tomcat360.atm.service.Impl;


import com.tomcat360.atm.mapper.TbCheckResultMapper;
import com.tomcat360.atm.model.TbCheckResult;
import com.tomcat360.atm.service.TbCheckResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jin.Deng on 2018/9/19.
 */
@Service
public class TbCheckResultServiceImpl implements TbCheckResultService {

	@Autowired
	private TbCheckResultMapper tbCheckResultMapper;

	@Override
	public void insert(TbCheckResult tbCheckResult) {
		tbCheckResultMapper.insert(tbCheckResult);
	}
}
