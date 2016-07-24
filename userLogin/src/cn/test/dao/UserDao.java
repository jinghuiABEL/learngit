package cn.test.dao;

import cn.test.damain.User;

public interface UserDao {

	void add(User user);

	User find(String username, String password);

	//查找注册的用户是否在数据库中存在
	boolean find(String username);

}