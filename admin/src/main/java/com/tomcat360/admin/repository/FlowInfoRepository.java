package com.tomcat360.admin.repository;

import com.tomcat360.admin.model.mongodb.FlowInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by jin.Deng on 2019/1/25.
 */
public interface FlowInfoRepository extends MongoRepository<FlowInfo, Long> {

	FlowInfo findById(Long id);
}
