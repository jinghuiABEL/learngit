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

   //用户名不能为空
     
public boolean validate(){
	boolean isok=true;
	if (this.username==null || this.username.trim().equals("")) {
		isok=false;
		errors.put("username", "对不起，用户名不能为空！");
		
	}
	 //密码不能为空
	if (this.password==null || this.password.trim().equals("")) {
		isok=false;
		errors.put("password", "对不起，密码不能为空！");
		
	}
	//邮箱不能为空，并且是合法的 格式
	if (this.email==null || this.email.trim().equals("")) {
		isok=false;
		errors.put("email", "对不起，邮箱不能为空！");		
	}else {
		if(!this.email.matches("\\w+@\\w+(\\.\\w+)+")){
			isok=false;
			errors.put("email", "对不起，邮箱格式不正确");
			
		}
	}
	 //生日可以为空，不为空时必须填写日期
	if (this.birthday!=null && !this.birthday.trim().equals("")) {
		
		try {			
		
			DateLocaleConverter dlc= new DateLocaleConverter();
		dlc.convert("this.birthday","yyyy-MM-dd");
		} catch (Exception e) {
			isok=false;
			errors.put("birthday", "对不起，你填写的日期格式不正确");
		}
	}
	
	return isok;
}
}
