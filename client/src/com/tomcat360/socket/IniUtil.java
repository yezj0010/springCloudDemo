package com.tomcat360.socket;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IniUtil {
	private static String propertyName = "TERM_NO";
	// ini文件的存放位置
	private static String filepath = "C:/eastcom/abwoa/conf/config.ini";
	public static Logger logger = LoggerFactory.getLogger(IniUtil.class);
	
	public static String getEquipmentNo() {
		String property = null;
		try {
			// 创建文件输入流
			FileInputStream fis = new FileInputStream(filepath);
			// 创建Properties属性对象用来接收ini文件中的属性
			Properties pps = new Properties();
			// 从文件流中加载属性
			pps.load(fis);
			// 通过getProperty("属性名")获取key对应的值
			property = pps.getProperty(propertyName);
			// 关闭资源
			fis.close();
		} catch (Exception e) {
			logger.info("读取ini文件错误");
			e.printStackTrace();
		}
		return property;

	}
	public String getPropertyName() {
		return propertyName;
	}
	@SuppressWarnings("static-access")
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	
	
	public String getConfigPer(String propertiesName) {
		String property = null;
		try {
			// 创建文件输入流
			//InputStream fis = new FileInputStream(new File("/resource/config.properties"));  
			InputStream fis = this.getClass().getClassLoader().getResourceAsStream("resource/config.properties");
			
			// 创建Properties属性对象用来接收ini文件中的属性
			Properties pps = new Properties();
			// 从文件流中加载属性
			pps.load(fis);
			// 通过getProperty("属性名")获取key对应的值
			property = pps.getProperty(propertiesName);
			// 关闭资源
			fis.close();
		} catch (Exception e) {
			logger.info("读取ini文件错误");
			e.printStackTrace();
		}
		return property;

	}
	
}
