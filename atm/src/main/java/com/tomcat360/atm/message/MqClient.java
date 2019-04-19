package com.tomcat360.atm.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * Created by jin.Deng on 2019/4/18.
 */
public interface MqClient {

	String OUTPUT_A = "testAaaQueue";

	String OUTPUT_A2 = "testAaaQueue2";

	@Output(OUTPUT_A)
	MessageChannel outputa();  //用于发送消息

	@Output(OUTPUT_A2)
	MessageChannel outputa2();  //用于发送消息
}
