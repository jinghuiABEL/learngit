package junit.test;

import java.util.Date;

import org.junit.Test;

import cn.test.damain.User;
import cn.test.dao.UserDao;
import cn.test.dao.impl.UserDaoImpl;

public class userDaotest {
	
	@Test
 public void testAdd(){	 
	 User user=new User();
	 user.setBirthday(new Date());
	 user.setEmail("111@qq.com");
	 user.setId("123789");
	 user.setUsername("…ŸÀß");
	 user.setPassword("123");
	 
	 UserDao dao=new UserDaoImpl();
	 dao.add(user);
 }
	@Test
	public void testFind(){
		UserDao dao=new UserDaoImpl();
		User user=dao.find("aaa","123");
		System.out.println(user.getEmail());
		System.out.println(user.getUsername());
		System.out.println(user.getBirthday().toLocaleString());
		
	}
	
}
