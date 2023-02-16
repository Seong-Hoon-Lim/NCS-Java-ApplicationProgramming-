package com.kudangtang.jv300.mod010.service;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.kudangtang.jv300.mod010.dao.DataSource;
import com.kudangtang.jv300.mod010.dao.UserDao;
import com.kudangtang.jv300.mod010.domain.User;

public class UserService {
	private UserDao userDao;
	
	public UserService(DataSource dataSource) {
		userDao = new UserDao(dataSource);
	}
	
	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}


	public void addUser(String userId, String passwd, String userName,
				Date birthDate, String email, String[] concerns ) {
		User user = new User();
		user.setUserId(userId);
		user.setPasswd(passwd);
		user.setUserName(userName);
		user.setBirthDate(birthDate);
		user.setEmail(email);				
		user.setConcerns(concerns);
		addUser(user);
	}
	
	public void addUser(User user) {
		
	}

	public List<User> getUserList() {
		List<User> list = new ArrayList<>();
		
		return list;
	}
	
}
