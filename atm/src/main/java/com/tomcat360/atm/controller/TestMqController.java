package com.tomcat360.atm.controller;

import com.tomcat360.atm.enums.EnumResponseMsg;
import com.tomcat360.atm.model.JSONData;
import com.tomcat360.atm.service.MqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jin.Deng on 2019/4/18.
 */
@Slf4j
@RestController
public class TestMqController {

	@Autowired
	private MqService mqService;

	@PostMapping("sendToA")
	public JSONData sendToA(String message){
		log.info("sendToA");
		mqService.sendToA("a:"+message);
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode()).
				msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
	}

	@PostMapping("sendToA2")
	public JSONData sendTo2(String message){
		log.info("sendToA2");
		mqService.sendToA2("a2:"+message);
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode()).
				msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
	}

}
