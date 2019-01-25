package com.tomcat360.admin.util;

import java.security.MessageDigest;

public class MD5Util {
	
    public static void main(String[] args) {
        String pwd = getMD5("password");
        System.out.println(pwd);
    }
 
   //生成MD5
    public static String getMD5(String message) {
        String md5 = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");  // 创建一个md5算法对象
            byte[] messageByte = message.getBytes("UTF-8");
            byte[] md5Byte = md.digest(messageByte);              // 获得MD5字节数组,16*8=128位
            md5 = bytesToHex(md5Byte);                            // 转换为16进制字符串
        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5;
    }
    
    public static String getMD5Code(String strObj) throws Exception{
        MessageDigest md = MessageDigest.getInstance("MD5");
        // md.digest() 该函数返回值为存放哈希值结果的byte数组
        return byteToString(md.digest(strObj.getBytes()));
    }
    
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }
    
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }
    
    private static final String[] strDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
 
     // 二进制转十六进制
    public static String bytesToHex(byte[] bytes) {
        StringBuffer hexStr = new StringBuffer();
        int num;
        for (int i = 0; i < bytes.length; i++) {
        	num = bytes[i];
             if(num < 0) {
            	 num += 256;
            }
            if(num < 16){
            	hexStr.append("0");
            }
            hexStr.append(Integer.toHexString(num));
        }
        return hexStr.toString();
    }
}

