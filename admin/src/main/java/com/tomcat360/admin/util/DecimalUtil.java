package com.tomcat360.admin.util;

import java.text.DecimalFormat;

public class DecimalUtil {
	/**
	 * 保留小数位，支持的范围是1-13
	 * @param num  需要转换的数字字符串
	 * @param deci 保留的位数
	 * @return
	 */
	public static String getRounding(String num,int deci) {
		String str = "#.00";
		if(deci == 1){
			str = "#.0";
		}else if(deci == 2){
			str = "#.00";
		}else if(deci == 3){
			str = "#.000";
		}else if(deci == 4){
			str = "#.0000";
		}else if(deci == 5){
			str = "#.00000";
		}else if(deci == 6){
			str = "#.000000";
		}else if(deci == 7){
			str = "#.0000000";
		}else if(deci == 8){
			str = "#.00000000";
		}else if(deci == 9){
			str = "#.000000000";
		}else if(deci == 10){
			str = "#.0000000000";
		}else if(deci == 11){
			str = "#.00000000000";
		}else if(deci == 12){
			str = "#.000000000000";
		}else if(deci == 13){
			str = "#.0000000000000";
		}
		DecimalFormat df = new DecimalFormat(str);
		double d = Double.valueOf(num);
		num = df.format(d);
		
		if(num.indexOf(".") == 0){
			num = "0"+num;
		}
		if(num.indexOf("-") == 0 && num.indexOf(".") == 1){
			num = num.substring(1);
			num = "-0"+num;
		}
		
		return num;
		
	}
}
