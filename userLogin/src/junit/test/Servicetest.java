package junit.test;

import java.util.Date;

import org.junit.Test;

import cn.test.damain.User;
import cn.test.dao.UserDao;
import cn.test.dao.impl.UserDaoImpl;
import cn.test.exception.UserExistException;
import cn.test.service.impl.BusinessServiceImpl;

public class Servicetest {
	@Test
public void testRegister(){
	User user=new User();
	 user.setBirthday(new Date());
	 user.setEmail("111@qq.com");
	 user.setId("123789");
	 user.setUsername("李畅");
	 user.setPassword("123");
	 
	 BusinessServiceImpl service=new BusinessServiceImpl();
	 try {
		service.register(user);
		System.out.println("注册成功");
	} catch (UserExistException e) {
		System.out.println("用户已经存在");
	}
	
	
}
	@Test
public void testLogin(){
	 BusinessServiceImpl service=new BusinessServiceImpl();
	 User user=service.login("李畅","123");
	 System.out.println(user);
	
}

}
