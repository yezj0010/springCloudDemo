package com.tomcat360.admin.util;

public class GeneratIdUtil {
	public static String getGeneratIdUtil(Long equipmentNo){
		String equipmentId = "HAYEK";
		if(equipmentNo<10){
			equipmentId=equipmentId+"0000000"+equipmentNo;
			return equipmentId;
		}else if(equipmentNo<100){
			equipmentId=equipmentId+"000000"+equipmentNo;
			return equipmentId;
		}else if(equipmentNo<1000){
			equipmentId=equipmentId+"00000"+equipmentNo;
			return equipmentId;
		}else if(equipmentNo<10000){
			equipmentId=equipmentId+"0000"+equipmentNo;
			return equipmentId;
		}else if(equipmentNo<100000){
			equipmentId=equipmentId+"000"+equipmentNo;
			return equipmentId;
		}else if(equipmentNo<1000000){
			equipmentId=equipmentId+"00"+equipmentNo;
			return equipmentId;
		}else if(equipmentNo<10000000){
			equipmentId=equipmentId+"0"+equipmentNo;
			return equipmentId;
		}else{
			equipmentId=equipmentId+equipmentNo;
			return equipmentId;
		}
	}
}
