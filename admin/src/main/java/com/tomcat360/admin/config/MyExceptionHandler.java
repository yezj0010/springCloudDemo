package com.tomcat360.admin.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tomcat360.admin.constant.AdminConstant;
import com.tomcat360.admin.enums.EnumResponseMsg;
import com.tomcat360.admin.enums.LogStatusEnum;
import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbAdminLog;
import com.tomcat360.admin.model.TbAdminUser;
import com.tomcat360.admin.service.AdminLogService;
import com.tomcat360.admin.util.LogUtils;

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
	
	@Autowired
	private AdminLogService adminLogService;

    @ExceptionHandler(value = Throwable.class)
    @ResponseBody
    public JSONData handle(Throwable e,HttpServletRequest request) {
    	log.error("统一异常处理打印日志"+e);
    	log.error(LogUtils.getExceptionInfo(e));
    	
    	//如果异常，更新日志状态
    	TbAdminLog adminLog = (TbAdminLog)request.getAttribute(AdminConstant.LOG);
    	if(adminLog != null){
			TbAdminLog newAdminLog = new TbAdminLog();
			newAdminLog.setId(adminLog.getId());
    		TbAdminUser admin = (TbAdminUser) request.getAttribute(AdminConstant.ADMIN);
    		if(admin != null){
				newAdminLog.setAdminId(admin.getId());
				newAdminLog.setUserName(admin.getUserName());
    		}
			newAdminLog.setOperateStatus(LogStatusEnum.FAIL.getStatus());
			newAdminLog.setRespCode(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getCode());
			newAdminLog.setRespMsg(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getMsg());
    		adminLogService.updateSelective(newAdminLog);
    	}
		
    	return JSONData.builder().code(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getCode())
				.msg(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getMsg()).build();
    }
}
