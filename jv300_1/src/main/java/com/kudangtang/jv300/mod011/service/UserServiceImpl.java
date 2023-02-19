package com.kudangtang.jv300.mod011.service;

import java.util.List;

import com.kudangtang.jv300.mod011.dao.UserDao;
import com.kudangtang.jv300.mod011.domain.User;

public class UserServiceImpl implements UserService{
	private static UserServiceImpl us = new UserServiceImpl();
	private UserDao userDao;
	
	private UserServiceImpl() {
		userDao = new UserDao();
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}
	
	@Override
	public List<User> findUserList(){
		return userDao.findUserList();
	}
	
	@Override
	public User findUser(String userId, String passwd) {
		return userDao.findUser(userId, passwd);
	}
	
	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}
	
	public static UserServiceImpl getUserService() {
		return us;
	}


}
