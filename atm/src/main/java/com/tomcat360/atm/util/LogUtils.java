package com.tomcat360.atm.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import lombok.extern.slf4j.Slf4j;

/**
 * @description
 * @author hetao
 * @date 2018年6月28日
 * @copyright 浙江雄猫软件开发有限公司
 */
@Slf4j
public class LogUtils {
	
	public static String getExceptionInfo(Throwable e){
		StringWriter s = new StringWriter();
		e.printStackTrace(new PrintWriter(s));
		try {
			s.close();
		} catch (IOException e1) {
			log.info("StringWriter流关闭异常");
		}
		return s.toString();
	}
}
