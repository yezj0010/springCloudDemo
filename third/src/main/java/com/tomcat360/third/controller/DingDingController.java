package com.tomcat360.third.controller;

import com.tomcat360.third.enums.response.EnumResponseMsg;
import com.tomcat360.third.model.JSONData;
import com.tomcat360.third.service.DingDingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jin.Deng on 2019/1/25.
 */
@RestController
@RequestMapping("dingding")
public class DingDingController {
	@Autowired
	private DingDingService dingDingService;


	/**
	 * 报错，会总全局异常通知，然后发送钉钉消息
	 * @return
	 */
	@PostMapping("/test")
	public JSONData test(){
		int i = 0;
		double a = 5/i;

		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode()).
				msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
	}

	@PostMapping("/send")
	public JSONData send(String message){

		dingDingService.send(new StringBuilder(message));

		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode()).
				msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
	}


}
