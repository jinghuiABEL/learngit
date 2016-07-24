package cn.test.web.formbean;

import java.util.HashMap;
import java.util.Map;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class RegisterForm {
private String username;
private String password;
private String email;
private String birthday;
private Map errors=new HashMap();

public Map getErrors() {
	return errors;
}
public void setErrors(Map errors) {
	this.errors = errors;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getBirthday() {
	return birthday;
}
public void setBirthday(String birthday) {
	this.birthday = birthday;
}

   //�û�������Ϊ��
     
public boolean validate(){
	boolean isok=true;
	if (this.username==null || this.username.trim().equals("")) {
		isok=false;
		errors.put("username", "�Բ����û�������Ϊ�գ�");
		
	}
	 //���벻��Ϊ��
	if (this.password==null || this.password.trim().equals("")) {
		isok=false;
		errors.put("password", "�Բ������벻��Ϊ�գ�");
		
	}
	//���䲻��Ϊ�գ������ǺϷ��� ��ʽ
	if (this.email==null || this.email.trim().equals("")) {
		isok=false;
		errors.put("email", "�Բ������䲻��Ϊ�գ�");		
	}else {
		if(!this.email.matches("\\w+@\\w+(\\.\\w+)+")){
			isok=false;
			errors.put("email", "�Բ��������ʽ����ȷ");
			
		}
	}
	 //���տ���Ϊ�գ���Ϊ��ʱ������д����
	if (this.birthday!=null && !this.birthday.trim().equals("")) {
		
		try {			
		
			DateLocaleConverter dlc= new DateLocaleConverter();
		dlc.convert("this.birthday","yyyy-MM-dd");
		} catch (Exception e) {
			isok=false;
			errors.put("birthday", "�Բ�������д�����ڸ�ʽ����ȷ");
		}
	}
	
	return isok;
}
}
