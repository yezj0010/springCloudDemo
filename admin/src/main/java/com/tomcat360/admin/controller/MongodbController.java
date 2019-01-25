package com.tomcat360.admin.controller;

import com.tomcat360.admin.enums.EnumResponseMsg;
import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.mongodb.FlowInfo;
import com.tomcat360.admin.service.FlowInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jin.Deng on 2019/1/25.
 */
@RestController
@RequestMapping("/mongodb")
public class MongodbController {
	@Autowired
	private FlowInfoService flowInfoService;

	@PostMapping("/save")
	public JSONData save(){
		FlowInfo flowInfo = new FlowInfo();
		flowInfo.setId(System.currentTimeMillis());
		flowInfo.setOperation("save");
		flowInfo.setTime(System.currentTimeMillis());
		flowInfoService.save(flowInfo);
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode()).
				msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).build();
	}

	@PostMapping("/query")
	public JSONData query(Long id){
		FlowInfo flowInfo = flowInfoService.findById(id);
		Map result = new HashMap();
		result.put("flowInfo", flowInfo);
		return JSONData.builder().code(EnumResponseMsg.RESP_SUCCESS.getCode()).
				msg(EnumResponseMsg.RESP_SUCCESS.getMsg()).data(result).build();
	}



}
