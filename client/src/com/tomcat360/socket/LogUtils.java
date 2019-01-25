package com.tomcat360.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @description
 * @author hetao
 * @date 2018年6月28日
 * @copyright 浙江雄猫软件开发有限公司
 */
public class LogUtils {

	private static final Logger logger = LoggerFactory.getLogger(LogUtils.class);
	
	public static String getExceptionInfo(Throwable e){
		StringWriter s = new StringWriter();
		e.printStackTrace(new PrintWriter(s));
		try {
			s.close();
		} catch (IOException e1) {
			logger.info("StringWriter流关闭异常");
		}
		return s.toString();
	}
}
