package com.tomcat360.admin.aspect;

import com.tomcat360.admin.constant.AdminConstant;
import com.tomcat360.admin.enums.EnumResponseMsg;
import com.tomcat360.admin.enums.LogStatusEnum;
import com.tomcat360.admin.model.JSONData;
import com.tomcat360.admin.model.TbAdminLog;
import com.tomcat360.admin.model.TbAdminUser;
import com.tomcat360.admin.service.AdminLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 切面
 * 
 * @author Deng.Jin
 * @date 2018/8/10
 */
@Aspect // 使用@Aspect注解声明一个切面
@Component
@Slf4j
public class AdminLogAspect {

	@Autowired
	private AdminLogService adminLogService;


	/**
	 * 这里我们使用注解的形式 当然，我们也可以通过切点表达式直接指定需要拦截的package,需要拦截的class 以及 method 切点表达式:
	 * execution(...)
	 */
	@Pointcut("@annotation(com.tomcat360.admin.aspect.AdminLog)")
	public void userlogPointCut() {
	}

	/**
	 * 环绕通知 @Around ， 当然也可以使用 @Before (前置通知) @After (后置通知)
	 * 
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("userlogPointCut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();

		/**
		 * 记录用户日志
		 */
		TbAdminLog log = saveLog(joinPoint,request);
		request.setAttribute(AdminConstant.LOG, log);
		/**
		 * 执行业务逻辑
		 */
		Object result = joinPoint.proceed();
		
		/**
		 * 更新用户日志
		 */
		if (result instanceof JSONData) {
			updateLog(joinPoint, log, (JSONData) result);
		} else {
			JSONData data = JSONData.builder().msg(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getMsg())
					.code(EnumResponseMsg.RESP_ERROR_SYSTEM_FAILURE.getCode()).build();
			updateLog(joinPoint, log, data);
		}
		
		return result;

	}

	/**
	 * 保存日志
	 * 
	 * @param joinPoint
	 * @param request
	 */
	private TbAdminLog saveLog(ProceedingJoinPoint joinPoint,HttpServletRequest request) {
		//测试提交svn
		Method method = getMethod(joinPoint);
		// 获取注解对象
		AdminLog annotation = method.getAnnotation(AdminLog.class);

		TbAdminLog adminLog = new TbAdminLog();
		adminLog.setOperation(annotation.interfaceDesc());
		adminLog.setInterfaceCode(annotation.interfaceCode());
		adminLog.setCreateTime(new Date());
		adminLog.setOperateStatus(LogStatusEnum.INITIAL.getStatus());
		adminLogService.insert(adminLog);
		return adminLog;
	}

	/**
	 * 修改日志状态
	 * 
	 * @param joinPoint
	 * @param adminLog
	 * @param data
	 */
	private void updateLog(ProceedingJoinPoint joinPoint, TbAdminLog adminLog, JSONData data) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		TbAdminUser admin = (TbAdminUser) request.getAttribute(AdminConstant.ADMIN);
		if(admin != null){
			adminLog.setAdminId(admin.getId());
			adminLog.setUserName(admin.getUserName());
		}
		if(EnumResponseMsg.isSuccess(data.getCode())){
			adminLog.setOperateStatus(LogStatusEnum.SUCCESS.getStatus());
		}else{
			adminLog.setOperateStatus(LogStatusEnum.FAIL.getStatus());			
		}

		//判断是否需要替换掉默认的操作描述
		String operationDesc = (String)request.getAttribute(AdminConstant.OPERATION_DESC);
		if(!StringUtils.isEmpty(operationDesc)){
			adminLog.setOperation(operationDesc);
		}
		adminLog.setRespCode(data.getCode());
		adminLog.setRespMsg(data.getMsg());
		adminLogService.update(adminLog);
	}

	private Method getMethod(JoinPoint joinPoint) {
		Object target = joinPoint.getTarget();
		Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
		try {
			method = target.getClass().getMethod(method.getName(), method.getParameterTypes());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return method;
	}
}
