package com.tomcat360.admin.microservice.impl;

import com.tomcat360.admin.enums.EnumResponseMsg;
import com.tomcat360.admin.microservice.DingDingService;
import com.tomcat360.admin.model.JSONData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by jin.Deng on 2019/4/12.
 */
@Slf4j
@Component
public class DingDingServiceBack implements DingDingService {

	@Override
	public JSONData send(@RequestParam("message") String message) {
		log.error("调用微服务超时");
		return JSONData.builder().code(EnumResponseMsg.RESP_SERVICE_TIME_OUT.getCode()).
				msg(EnumResponseMsg.RESP_SERVICE_TIME_OUT.getMsg()).build();
	}
}
