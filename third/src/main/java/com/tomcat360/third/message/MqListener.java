package com.tomcat360.third.message;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Created by jin.Deng on 2019/4/18.
 *
 * 订阅给定destination的所有group会接收到发布消息的一个副本，
 * 但是在每个group中，只有一个成员会从destination接收到这个消息。
 * 默认情况下，没有指定group的时候，Spring Cloud Stream会将应用程序分配到一个匿名、独立且单一的消费者组，
 * 这个消费者组与所有其他消费者组都出于同一个发布-订阅关系中。
 *
 * 要模拟同一个group中多个成员，只需要多启动几个third即可。
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
