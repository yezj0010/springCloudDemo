package com.tomcat360.admin.controller;

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
		log.info("1111");
		return dingDingService.send(message);
	}
}
