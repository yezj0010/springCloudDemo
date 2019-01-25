package com.tomcat360.atm.aspect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 
/**
 * 用户日志注解
 * @author Deng.Jin
 * @date 2018/8/10
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UserLog {
	
	/**
	 * 调用的接口
	 * @return
	 */
	String interfaceCode() default "";

	/**
	 * 接口描述
	 * @return
	 */
	String interfaceDesc() default "";
}
