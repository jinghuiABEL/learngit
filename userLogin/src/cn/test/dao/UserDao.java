package cn.test.dao;

import cn.test.damain.User;

public interface UserDao {

	void add(User user);

	User find(String username, String password);

	//����ע����û��Ƿ������ݿ��д���
	boolean find(String username);

}