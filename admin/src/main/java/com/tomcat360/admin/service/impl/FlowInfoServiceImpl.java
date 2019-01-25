package com.tomcat360.admin.service.impl;

import com.tomcat360.admin.model.mongodb.FlowInfo;
import com.tomcat360.admin.repository.FlowInfoRepository;
import com.tomcat360.admin.service.FlowInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jin.Deng on 2019/1/25.
 */
@Service
public class FlowInfoServiceImpl implements FlowInfoService {

	@Autowired
	private FlowInfoRepository flowInfoRepository;

	@Override
	public void save(FlowInfo flowInfo) {
		flowInfoRepository.save(flowInfo);
	}

	@Override
	public FlowInfo findById(Long id) {
		return flowInfoRepository.findById(id);
	}
}
