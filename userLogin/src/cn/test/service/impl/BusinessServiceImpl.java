package cn.test.service.impl;

import cn.test.damain.User;
import cn.test.dao.UserDao;
import cn.test.dao.impl.UserDaoImpl;
import cn.test.exception.UserExistException;
import cn.test.utils.ServiceUtils;

//��web���ṩ���е�ҵ�����
public class BusinessServiceImpl {

	    private UserDao dao=new UserDaoImpl();
	 //��web���ṩע�����
	public void register(User user) throws UserExistException {
		
      boolean b= dao.find(user.getUsername());
      //�ж�ע���û��Ƿ��Ѿ�����
      
      if (b) {
		throw new UserExistException();//����ע����û��Ѿ����ڣ���web���׳�һ���쳣����ʾע���û��Ѿ�����
	}else {
		user.setPassword(ServiceUtils.md5(user.getPassword()));
		dao.add(user);
	}
      
      
	}
	
	 //��web���ṩ��¼����
	public  User login(String username,String password){
		
	   password = ServiceUtils.md5(password);
       return dao.find(username,password);
		
		
}
}
