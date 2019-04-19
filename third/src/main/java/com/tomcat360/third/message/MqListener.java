package com.tomcat360.third.message;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Created by jin.Deng on 2019/4/18.
 */
@Component
@EnableBinding({MqClient.class})
public class MqListener {  //消息接受类

	@StreamListener(MqClient.INPUT_A)  //监听testMessage这个消息队列, StreamClient类中必须定义相应的Input。
//	@SendTo("testBbbQueue")  //该注解会在消息处理完成后，向responseMessage这个队列发送消息。消息内容就是该方法的返回值。
	public void receiver(@Payload Object message){
		System.out.println(MqClient.INPUT_A+"接收到消息："+message);
		//return "处理消息完成"; //当消息处理完成之后，会将该返回值发送到@SendTo指定的responseMesssage消息队列中。
	}

	@StreamListener(MqClient.INPUT_A2)
	public void receiver2(@Payload Object message){
		System.out.println(MqClient.INPUT_A2+"接收到消息："+message);
	}
}
