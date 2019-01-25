package com.tomcat360.atm.util;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
 
/**
 * RSA加密工具
 */
public class RSAUtil {
	
	public static Map<String,Object> generateKeyPair() throws Exception{
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
	      //密钥位数
	      keyPairGen.initialize(1024);
	      //密钥对
	      KeyPair keyPair = keyPairGen.generateKeyPair();
	
	      // 公钥
	      PublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
	   
	      // 私钥
	      PrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
	      
	      Map<String,Object> result = new HashMap<String,Object>();
	      
	      result.put("privateKey", getKeyString(privateKey));
	      result.put("publicKey", getKeyString(publicKey));
	      
	      return result;
	}
 
  /**
   * 使用公钥对数据进行加密
   * @param data
   * @param publicKey
   * @return
   * @throws Exception
   */
  public static byte[] encrypt(byte[] data, PublicKey publicKey) throws Exception{
    Cipher cipher = Cipher.getInstance("RSA");
    cipher.init(Cipher.ENCRYPT_MODE,publicKey);
    return cipher.doFinal(data);
  }
 
  /**
   * 使用私钥解密
   * @param data
   * @param privateKey
   * @return
   * @throws Exception
   */
  public static byte[] decrypt(byte[] data, PrivateKey privateKey) throws Exception{
    Cipher cipher = Cipher.getInstance("RSA");
    cipher.init(Cipher.DECRYPT_MODE,privateKey);
    return cipher.doFinal(data);
  }
  
  /**
   * 使用公钥对数据进行加密  (传入需要加密的字符串utf-8明文，转出加密后经过base64编码的数据。)
   * @param data
   * @param publicKey
   * @return
   * @throws Exception
   */
  public static String encryptPlainToBase64(String data, PublicKey publicKey) throws Exception{
	  Cipher cipher = Cipher.getInstance("RSA");
	  cipher.init(Cipher.ENCRYPT_MODE,publicKey);
	  byte[] bytes = cipher.doFinal(data.getBytes());
	  return Base64Util.byte2Base64StringFun(bytes);
  }
  
  /**
   * 使用私钥解密 （传入经过base编码的密文，返回解密的utf-8明文）
   * @param data
   * @param privateKey
   * @return
   * @throws Exception
   */
  public static String decryptBase64ToPlain(String data, PrivateKey privateKey) throws Exception{
	  Cipher cipher = Cipher.getInstance("RSA");
	  cipher.init(Cipher.DECRYPT_MODE,privateKey);
	  return new String(cipher.doFinal(Base64Util.base64String2ByteFun(data)),"utf-8");
  }
  
  /**
   * 使用getPublicKey得到公钥,返回类型为PublicKey
   * @param base64 String to PublicKey
   * @throws Exception
   */
  public static PublicKey getPublicKey(String key) throws Exception {
        byte[] keyBytes;
        keyBytes = Base64Util.base64String2ByteFun(key);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
  }
  /**
   * 转换私钥
   * @param base64 String to PrivateKey
   * @throws Exception
   */
  public static PrivateKey getPrivateKey(String key) throws Exception {
        byte[] keyBytes;
        keyBytes = Base64Util.base64String2ByteFun(key);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
  }
  
  /**
   * 得到密钥字符串（经过base64编码）
   * @return
   */
  public static String getKeyString(Key key) throws Exception {
	  byte[] keyBytes = key.getEncoded();
	  String s = Base64Util.byte2Base64StringFun(keyBytes);
	  return s;
  }
  
  public static void main(String[] args) {
	try {
		System.out.println(generateKeyPair());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
  
}
