package com.tomcat360.admin.service;

import com.tomcat360.admin.model.mongodb.FlowInfo;

/**
 * Created by jin.Deng on 2019/1/25.
 */
public interface FlowInfoService {

	void save(FlowInfo flowInfo);

	FlowInfo findById(Long id);
}
