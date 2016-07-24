package cn.test.service.impl;

import cn.test.damain.User;
import cn.test.dao.UserDao;
import cn.test.dao.impl.UserDaoImpl;
import cn.test.exception.UserExistException;
import cn.test.utils.ServiceUtils;

//对web层提供所有的业务服务
public class BusinessServiceImpl {

	    private UserDao dao=new UserDaoImpl();
	 //对web层提供注册服务
	public void register(User user) throws UserExistException {
		
      boolean b= dao.find(user.getUsername());
      //判断注册用户是否已经存在
      
      if (b) {
		throw new UserExistException();//发现注册的用户已经存在，给web层抛出一个异常，提示注册用户已经存在
	}else {
		user.setPassword(ServiceUtils.md5(user.getPassword()));
		dao.add(user);
	}
      
      
	}
	
	 //对web层提供登录服务
	public  User login(String username,String password){
		
	   password = ServiceUtils.md5(password);
       return dao.find(username,password);
		
		
}
}
