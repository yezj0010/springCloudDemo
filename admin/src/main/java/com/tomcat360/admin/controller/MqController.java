package com.tomcat360.admin.controller;

import com.tomcat360.admin.config.MqSender;
import com.tomcat360.admin.constant.MqQueueConstant;
import com.tomcat360.admin.enums.EnumResponseMsg;
import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.mq.BaseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jin.Deng on 2018/12/15.
 */
@RestController
@Slf4j
public class MqController {

	@Autowired
	private MqSender mqSender;

	/**
	 * 发送mq消息
	 * @param request
	 * @param message
	 * @return
	 */
	@RequestMapping("/sendMsgToMq")
	public JSONData sendMsgToMq(HttpServletRequest request,String message){
		BaseMessage baseMessage = new BaseMessage();
		baseMessage.setType("normal");
		baseMessage.setMessge(message);
		log.info("正常消息发送");
		mqSender.send(MqQueueConstant.TEST, baseMessage);
		Map data = new HashMap();
		data.put("msg", baseMessage);
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(data).build();
	}

	/**
	 * 发送mq延迟队列
	 * @param request
	 * @param message
	 * @return
	 */
	@RequestMapping("/sendMsgToMqDelay")
	public JSONData sendMsgToMqDelay(HttpServletRequest request, String message){
		BaseMessage baseMessage = new BaseMessage();
		baseMessage.setType("delay");
		baseMessage.setMessge(message);
		log.info("超时消息发送");
		mqSender.send(MqQueueConstant.TEST_DELAY, baseMessage, 60*1000);
		Map data = new HashMap();
		data.put("msg", baseMessage);
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode())
				.msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(data).build();
	}

}
