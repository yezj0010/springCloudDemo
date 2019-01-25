package com.tomcat360.atm.aspect;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.tomcat360.atm.constant.AtmConstant;
import com.tomcat360.atm.enums.EnumResponseMsg;
import com.tomcat360.atm.enums.TransStatusEnum;
import com.tomcat360.atm.model.JSONData;
import com.tomcat360.atm.model.TbUserLog;
import com.tomcat360.atm.model.redis.UserInfo;
import com.tomcat360.atm.service.UserLogService;

import lombok.extern.slf4j.Slf4j;

/**
 * 切面
 * 
 * @author Deng.Jin
 * @date 2018/8/10
 */
@Aspect // 使用@Aspect注解声明一个切面
@Component
@Slf4j
public class UserLogAspect {

	@Autowired
	private UserLogService userLogService;

	@Autowired
	private SecurityRule signature;


	/**
	 * 这里我们使用注解的形式 当然，我们也可以通过切点表达式直接指定需要拦截的package,需要拦截的class 以及 method 切点表达式:
	 * execution(...)
	 */
	@Pointcut("@annotation(com.tomcat360.atm.aspect.UserLog)")
	public void userlogPointCut() {
	}

	/**
	 * 环绕通知 @Around ， 当然也可以使用 @Before (前置通知) @After (后置通知)
	 * 
	 * @param point
	 * @return
	 * @throws Throwable
	 */
	@Around("userlogPointCut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();

		/**
		 * 请求数据：验签，解密，校验token，request赋值
		 */
		JSONData preHandle = signature.tokenCheck(request);
		if (!EnumResponseMsg.isSuccess(preHandle.getCode())) {
			return preHandle;
		}

		/**
		 * 记录用户日志
		 */
		TbUserLog log = saveLog(joinPoint,request);
		
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
		/**
		 * 返回数据：加密，加签
		 */
		if (result instanceof JSONData) {
			return signature.encryption((JSONData) result,request);
		} else {
			return signature.err();
		}

	}

	/**
	 * 保存日志
	 * 
	 * @param joinPoint
	 * @param time
	 */
	private TbUserLog saveLog(ProceedingJoinPoint joinPoint,HttpServletRequest request) {
		String termNo = (String)request.getAttribute("termNo");
		Method method = getMethod(joinPoint);
		// 获取注解对象
		UserLog userLogAno = method.getAnnotation(UserLog.class);

		TbUserLog tbUserLog = new TbUserLog();
		tbUserLog.setEquipmentId(termNo);
		tbUserLog.setOperateInterface(userLogAno.interfaceCode());
		tbUserLog.setOperateDesc(userLogAno.interfaceDesc());
		tbUserLog.setOperateStatus(TransStatusEnum.INITIAL.getStatus());
		tbUserLog.setCreateTime(new Date());

		userLogService.save(tbUserLog);
		// 请求的参数
		// Object[] args = joinPoint.getArgs();
		// try{
		// List<String> list = new ArrayList<String>();
		// for (Object o : args) {
		// list.add(new Gson().toJson(o));
		// }
		// }catch (Exception e){ }

		return tbUserLog;
	}

	/**
	 * 修改日志状态
	 * 
	 * @param joinPoint
	 * @param time
	 */
	private void updateLog(ProceedingJoinPoint joinPoint, TbUserLog tbUserLog, JSONData data) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		UserInfo userInfo = (UserInfo) request.getAttribute(AtmConstant.USER);
		Long userId = null;
		if (userInfo != null) {
			userId = userInfo.getId();
		}

		if (EnumResponseMsg.isSuccess(data.getCode())) {
			tbUserLog.setOperateStatus(TransStatusEnum.SUCCESS.getStatus());
		} else {
			tbUserLog.setOperateStatus(TransStatusEnum.FAIL.getStatus());
		}
		tbUserLog.setUserId(userId);// 用户id，交易所用户id
		tbUserLog.setUserToken((String) request.getAttribute(AtmConstant.LOCAL_TOKEN));// 本地token
		tbUserLog.setUserLocalToken((String) request.getAttribute(AtmConstant.EXCHANGE_TOKEN));// 交易所token
		tbUserLog.setRespCode(data.getCode());
		tbUserLog.setRespMsg(data.getMsg());
		tbUserLog.setUpdateTime(new Date());
		userLogService.update(tbUserLog);

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
