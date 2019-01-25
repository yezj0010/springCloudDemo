package com.tomcat360.websocket.controller;

import com.sun.corba.se.impl.protocol.giopmsgheaders.RequestMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jin.Deng on 2019/1/18.
 */
@RestController
public class MessageController {

	@Autowired
	private SimpMessagingTemplate template;

	//@MessageMapping和@RequestMapping功能类似，用于设置URL映射地址，浏览器向服务器发起请求，需要通过该地址。
	@RequestMapping("/welcome")
	public void welcome(HttpServletRequest request) throws Exception {
		String message = request.getParameter("message");
		template.convertAndSend("/topic/aaa", message);
	}

	@RequestMapping("/welcome2")
	public void welcome2(HttpServletRequest request) throws Exception {
		String message = request.getParameter("message");
		template.convertAndSend("/topic2/bbb", message);
	}

	@MessageMapping("/hello")
	@SendTo("/topic2/greetings")
	public String greeting(String message) throws Exception {
		System.out.println("receiving【/hello】 " + message);
		return message;
	}

	//hello2和hello效果一样
	@MessageMapping("/hello2")
	public void greeting2(String message) throws Exception {
		System.out.println("receiving【/hello2】 " + message);
		template.convertAndSend("/topic2/greetings", message.replace("{\"from\":\"","{\"from\":\"77777"));
	}

	@RequestMapping("/messageToUser")
	public void message(String message, String userName) throws Exception {
		System.out.println("receiving【/messageToUser】 " + message);
		template.convertAndSendToUser(userName,"single", message);
	}


	/**
	 * @MessageMapping("/trade") 客户端发送请求路径
	 * @SendTo("/message")       客户端订阅地址
	 *
	 * @param requestMessage 请求数据
	 * @return 响应数据
	 */
	@RequestMapping("/info")
	public void tradeInfo(RequestMessage requestMessage){

	}
}
