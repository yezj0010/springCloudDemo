package com.tomcat360.third.config;


import com.tomcat360.third.enums.response.EnumResponseMsg;
import com.tomcat360.third.model.JSONData;
import com.tomcat360.third.service.DingDingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @description 
 * @author jin.Deng
 * @date 2018年6月16日
 * @copyright 浙江雄猫软件开发有限公司
 */
@Slf4j
@ControllerAdvice
public class MyExceptionHandler {

	@Autowired
	private DingDingService dingDingService;

    @ExceptionHandler(value = Throwable.class)
    @ResponseBody
    public JSONData handle(Throwable e,HttpServletRequest request) {
    	log.error("统一异常处理打印日志",e);
    	try{
			dingDingService.send(new StringBuilder(e.getMessage()));
		}catch (Exception e2){
			log.error("发送钉钉消息失败",e2);
		}
		
    	return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getCode())
				.msg(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getMsg()).build();
    }
}
