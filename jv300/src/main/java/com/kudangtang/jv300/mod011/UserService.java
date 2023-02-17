package com.kudangtang.jv300.mod011;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class UserService {
	private UserDao userDao;
	
	public UserService(DataSource dataSource) {		
		userDao = new UserDao(dataSource);
	}			

	public User getUser(String userId, String passwd) {				
		return userDao.findUser(userId, passwd);
	}	
	
	public void addUser(String userId, String passwd, String userName,
			Date birthDate, String email, String[] concerns) {
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
		userDao.saveUser(user);
	}
	
	public List<User> getUserList() {
		
		List<User> list = new ArrayList<>();
		list = userDao.findAllUserList();
		
		return list;
	}
	
	public void modifyUser(String userId, String passwd, String userName,
			Date birthDate, String email, String[] concerns) {
		User user = new User();
		user.setUserId(userId);
		user.setPasswd(passwd);
		user.setUserName(userName);
		user.setBirthDate(birthDate);
		user.setEmail(email);				
		user.setConcerns(concerns);
		modifyUser(user);
	}
	
	public void modifyUser(User user) {
		userDao.userInfoModify(user);
	}
	
	

}
