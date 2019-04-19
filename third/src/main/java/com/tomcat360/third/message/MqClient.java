package com.tomcat360.third.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by jin.Deng on 2019/4/18.
 */
public interface MqClient {

	String INPUT_A = "testAaaQueue";

	String INPUT_A2 = "testAaaQueue2";

	@Input(INPUT_A)
	SubscribableChannel inputa();  //用于接受消息

	@Input(INPUT_A2)
	SubscribableChannel inputa2();  //用于接受消息



}
