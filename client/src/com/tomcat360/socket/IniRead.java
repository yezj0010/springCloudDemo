package com.tomcat360.socket;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class IniRead {
	 public static void main(String[] args) {
	        try {
	            //ini文件的存放位置 
	            String filepath = "C:/Users/admin/Desktop/c.ini";
	            //创建文件输入流 
	            FileInputStream fis = new FileInputStream(filepath);
	            //创建文件输出流 
	            OutputStream opt = null;
	            //创建Properties属性对象用来接收ini文件中的属性 
	            Properties pps = new Properties();
	            //从文件流中加载属性 
	            pps.load(fis);
	            //通过getProperty("属性名")获取key对应的值 
	            System.out.println(pps.getProperty("equipmentId"));
	            System.out.println(pps.getProperty("url11"));
	            //加载读取文件流 
	            opt = new FileOutputStream(filepath);
	            //通过setProperty(key,value)赋值，会覆盖相同key的值 
	            pps.setProperty("equipmentNo", "v2");
	            pps.setProperty("url1", "v1");
	            //修改值 (必不可少) 
	            pps.store(opt, null);
	            opt.close();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
