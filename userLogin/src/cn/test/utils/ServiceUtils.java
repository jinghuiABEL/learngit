package cn.test.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


import sun.misc.BASE64Encoder;



public class ServiceUtils {
     public static  String md5(String message){
    	 //md5��ת����������������룩
    	 try {
    		 System.out.println(message);
			MessageDigest md=MessageDigest.getInstance("md5");
			byte md5[]=md.digest(message.getBytes());
			BASE64Encoder encoder=new BASE64Encoder();
			 return encoder.encode(md5);
			
		} catch (NoSuchAlgorithmException e) {
			
			throw new RuntimeException(e);
			//return "123456";
		}
    	 
     }
}