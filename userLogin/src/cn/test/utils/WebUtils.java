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
	
	 //1.������װ���ݵ�bean
	 try {		
		 
	 T bean=beanclass.newInstance();
	 //2. ��request�е���������bean��
	 Enumeration e= request.getParameterNames();
	 while (e.hasMoreElements()) {
		String name= (String) e.nextElement();//���յ��ͻ����ύ�� username password email
		String value=request.getParameter(name);//�õ�username��ֵ   aaa
		BeanUtils.setProperty(bean, name, value);
		
	}
	 return bean;
	 } catch (Exception e) {
			throw new  RuntimeException(e);
		}
	 	 	 
 }
  // ע������ת����
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
  
    //����һ����һ�޶���ID
       public static String generateID(){
    	   
    	  return UUID.randomUUID().toString();
       }
}
