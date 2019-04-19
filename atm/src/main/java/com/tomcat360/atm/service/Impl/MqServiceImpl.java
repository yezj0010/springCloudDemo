package com.tomcat360.atm.service.Impl;

import com.tomcat360.atm.message.MqClient;
import com.tomcat360.atm.service.MqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * Created by jin.Deng on 2019/4/18.
 */
@Service
@EnableBinding({MqClient.class})
public class MqServiceImpl implements MqService {

	@Autowired
	private MqClient mqClient;

	@Override
	public void sendToA(Object message) {
		mqClient.outputa().send(MessageBuilder.withPayload(message).build());
	}

	@Override
	public void sendToA2(Object message) {
		mqClient.outputa2().send(MessageBuilder.withPayload(message).build());
	}
}
