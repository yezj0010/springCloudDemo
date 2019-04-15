package com.tomcat360.admin.controller;

import com.tomcat360.admin.enums.EnumResponseMsg;
import com.tomcat360.admin.microservice.DingDingService;
import com.tomcat360.admin.model.JSONData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jin.Deng on 2019/1/6.
 */
@RestController
@Slf4j
public class Test {

	@Autowired
	private DingDingService dingDingService;

	@PostMapping("/sendToDing")
	public JSONData test(String message){
		return dingDingService.send(message);
	}

	@PostMapping("/testError")
	public JSONData testError(){
		if(1==1){
			int a=0;
			double b = 10/a;
		}

		return JSONData.builder().msg(EnumResponseMsg.RESP_SUCCESS.getMsg())
				.code(EnumResponseMsg.RESP_SUCCESS.getCode()).build();
	}

}
