package com.tomcat360.atm.util;

import java.security.Security;  
  
import javax.crypto.Cipher;  
import javax.crypto.spec.SecretKeySpec;  
  
import org.bouncycastle.jce.provider.BouncyCastleProvider;  
  
public class AesUtils {  
  
    public static boolean initialized = false;  
      
    public static final String ALGORITHM = "AES/ECB/PKCS7Padding";  
      
    /** 
     * @param  String str  要被加密的字符串 
     * @param  byte[] key  加/解密要用的长度为32的字节数组（256位）密钥 
     * @return byte[]  加密后的字节数组 
     */  
    public static byte[] Aes256Encode(String str, byte[] key){  
        initialize();  
        byte[] result = null;  
        try{  
            Cipher cipher = Cipher.getInstance(ALGORITHM, "BC");  
            SecretKeySpec keySpec = new SecretKeySpec(key, "AES"); //生成加密解密需要的Key  
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);  
            result = cipher.doFinal(str.getBytes("UTF-8"));  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
        return result;  
    }  
      
    /** 
     * @param  byte[] bytes  要被解密的字节数组 
     * @param  byte[] key    加/解密要用的长度为32的字节数组（256位）密钥 
     * @return String  解密后的字符串 
     */  
    public static String Aes256Decode(byte[] bytes, byte[] key){  
        initialize();  
        String result = null;  
        try{  
            Cipher cipher = Cipher.getInstance(ALGORITHM, "BC");  
            SecretKeySpec keySpec = new SecretKeySpec(key, "AES"); //生成加密解密需要的Key  
            cipher.init(Cipher.DECRYPT_MODE, keySpec);  
            byte[] decoded = cipher.doFinal(bytes);  
            result = new String(decoded, "UTF-8");  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
        return result;  
    }
    
    /**
     * 获取AES加密后经过base64编码的字符串（传入明文(utf-8)和密钥（utf-8），返回经过base64编码的密文）
     *
     * @param content
     * @param encryptKey
     * @return
     * @throws Exception
     */
    public static String aesEncryptToBase64String(String content, String encryptKey) throws Exception {
        return Base64Util.byte2Base64StringFun(Aes256Encode(content, encryptKey.getBytes()));
    }


    /**
     * 解密AES加密后的base64编码字符串（传入base64编码的密文字符串和密钥（utf-8），返回明文）
     *
     * @param hexContent
     * @param encryptKey
     * @return
     * @throws Exception
     */
    public static String aesDecryptBaseString(String hexContent, String encryptKey) throws Exception {
        return Aes256Decode(Base64Util.base64String2ByteFun(hexContent), encryptKey.getBytes());
    }
      
    public static void initialize(){  
        if (initialized) return;  
        Security.addProvider(new BouncyCastleProvider());  
        initialized = true;  
    }  
    
    public static void main(String[] args) {
		
    	String content ="HHmu5xwPzyIjWTe9o/2g98NeQBLMNeJEudVfMvnWcfEN9oZChCoUvXF7+xXkFOFGkoZBZYX5eFcyT9LIAtiKiAgn1K9lUlDThTnWIYgJrvH4XKCzssGE/bXVB9DGOQiXuKuZRU5hk3Qnn+Eu0x8VvgGxcbFAwHZgC2vdwyr3BTHoj9SdUczO8loymBZX6E4UJMA06eROO36Zl/A44bRiDPrVi+JNVZ4OmKBW96KyS+tYGTrOMKXV1Jz6KLeXFfzi";
    	String plain = "{\"phoneCode\":\"284829\",\"phoneToken\":\"458992E3BFEB17AEA77E63FF2B1681C23149C0D281C65A19ACF79643D50DB9A81288825ED34626B31AAD4F9B8A3169D67937403E0A0DCE594659126C75E41465\",\"userId\":\"7449\"}";

    	String key = "1234567890abcdef";
    	try {
    		System.out.println(aesDecryptBaseString(content,key));
			System.out.println(aesEncryptToBase64String(plain, key));
			System.out.println();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}
} 