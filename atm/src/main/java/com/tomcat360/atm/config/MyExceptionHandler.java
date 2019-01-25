package com.tomcat360.atm.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tomcat360.atm.enums.EnumResponseMsg;
import com.tomcat360.atm.model.JSONData;
import com.tomcat360.atm.util.LogUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @description 
 * @author jin.Deng
 * @date 2018年6月16日
 * @copyright 浙江雄猫软件开发有限公司
 */
@Slf4j
@ControllerAdvice
public class MyExceptionHandler {
	
    @ExceptionHandler(value = Throwable.class)
    @ResponseBody
    public JSONData handle(Throwable e) {
    	log.error("统一异常处理打印日志"+e);
    	log.error(LogUtils.getExceptionInfo(e));
    			
    	
    	String code = EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getCode();
		String msg = EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getMsg();
//		String plainContent = "{}";//json字符串明文
		String content = "{}";
		String signature = "75yjx10Kh86DE7C4473259C1FACC9F898FC1C6C080";
		return JSONData.builder().code(code).msg(msg).content(content).signature(signature).build();
    }
    
}
