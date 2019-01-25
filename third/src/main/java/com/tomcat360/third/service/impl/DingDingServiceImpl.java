package com.tomcat360.third.service.impl;

import com.tomcat360.third.model.DingMessage;
import com.tomcat360.third.properties.AppProperties;
import com.tomcat360.third.service.DingDingService;
import com.tomcat360.third.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by jin.Deng on 2019/1/25.
 */
@Service
@Slf4j
public class DingDingServiceImpl implements DingDingService {

	@Autowired
	private AppProperties appProperties;

	@Override
	@Async
	public void send(StringBuilder message) {
		try {
			message.insert(0, "===【异常警告】===\n");
			DingMessage warnMessage = new DingMessage(message.toString());
			HttpUtil.doPost(appProperties.getDingDingUrl(), warnMessage.toJsonString());
		} catch (Exception e) {
			log.error("钉钉发送异常",e);
		}
	}
}
