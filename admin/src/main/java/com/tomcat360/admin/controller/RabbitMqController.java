package com.tomcat360.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.rabbitmq.client.*;

/**
 * Created by jin.Deng on 2018/12/13.
 */
public class RabbitMqController {

//	private final static String QUEUE_NAME = "111";
//
//	public static void main(String[] args) throws Exception {
//		batchSend();
////		receiveMsg();
//	}
//
//	public static void batchSend() throws Exception{
//		while(true){
//			sendMsg();
//			Thread.sleep(100);
//		}
//	}
//
//
//	public static void sendMsg()  throws IOException{
//		// AMQP的连接其实是对Socket做的封装, 注意以下AMQP协议的版本号，不同版本的协议用法可能不同。
//		ConnectionFactory factory = new ConnectionFactory();
//		factory.setHost("192.168.159.131");
//		factory.setPort(5672);
//		factory.setVirtualHost("jys");
//		factory.setUsername("admin");
//		factory.setPassword("123456");
//		Connection connection = factory.newConnection();
//		// 下一步我们创建一个channel, 通过这个channel就可以完成API中的大部分工作了。
//		Channel channel = connection.createChannel();
//
//		// 为了发送消息, 我们必须声明一个队列，来表示我们的消息最终要发往的目的地。
//		channel.queueDeclare(QUEUE_NAME, true, false, false, null);
//		String message = "this a big news 1111";
//		// 然后我们将一个消息发往这个队列。
//		channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_BASIC , message.getBytes());
//
//		System.out.println("[" + message + "]");
//
//		// 最后，我们关闭channel和连接，释放资源。
//		channel.close();
//		connection.close();
//	}
//
//	public static void receiveMsg() throws Exception{
//		ConnectionFactory factory = new ConnectionFactory();
//		factory.setHost("192.168.159.133");
//		factory.setPort(5672);
//		factory.setVirtualHost("jys");
//		factory.setUsername("admin");
//		factory.setPassword("123456");
//		Connection connection = factory.newConnection();
//		Channel channel = connection.createChannel();
//
//		// 注意我们也在这里声明了一个queue，因为我们有可能在发送者启动前先启动接收者。
//		// 我们要确保当从这个queue消费消息时，这个queue是存在的。
//		channel.queueDeclare(QUEUE_NAME, true, false, false, null);
//		System.out.println("CRTL+C");
//
//		// 这个另外的QueueingConsumer类用来缓存服务端推送给我们的消息。
//		// 下面我们准备告诉服务端给我们传递存放在queue里的消息，因为消息是由服务端推送过来的。
//		QueueingConsumer consumer = new QueueingConsumer(channel);
//		channel.basicConsume(QUEUE_NAME, true, consumer);
//
//		while (true) {
//			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
//			String message = new String(delivery.getBody());
//			System.out.println("receive:[" + message + "]");
//			Thread.sleep(50);
//		}
//	}
}
