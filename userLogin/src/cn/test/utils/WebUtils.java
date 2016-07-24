package cn.test.utils;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.commons.beanutils.BeanUtils;
import com.sun.org.apache.commons.beanutils.ConvertUtils;
import com.sun.org.apache.commons.beanutils.Converter;

public class WebUtils {
 public static <T>  T request2Bean(HttpServletRequest request,Class<T> beanclass){
	
	 //1.创建封装数据的bean
	 try {		
		 
	 T bean=beanclass.newInstance();
	 //2. 把request中的数据整到bean中
	 Enumeration e= request.getParameterNames();
	 while (e.hasMoreElements()) {
		String name= (String) e.nextElement();//接收到客户端提交的 username password email
		String value=request.getParameter(name);//得到username的值   aaa
		BeanUtils.setProperty(bean, name, value);
		
	}
	 return bean;
	 } catch (Exception e) {
			throw new  RuntimeException(e);
		}
	 	 	 
 }
  // 注册日期转换器
  public static void copyBean(Object src,Object dest){
	 
	 ConvertUtils.register( new Converter(){

		public Object convert(Class type, Object value) {
			if (value==null) {
				return null;
			}
			String str=(String) value;
			if (str.trim().equals("")) {
				return null;
			}
			SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd");
			try {
				return df.parse(str);
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
			
		}}
	 , Date.class); 
	  
	  try {
		BeanUtils.copyProperties(dest, src);
	} catch (Exception e) {
		
		throw new RuntimeException(e);
	} 
	  
  }
  
    //产生一个独一无二的ID
       public static String generateID(){
    	   
    	  return UUID.randomUUID().toString();
       }
}
