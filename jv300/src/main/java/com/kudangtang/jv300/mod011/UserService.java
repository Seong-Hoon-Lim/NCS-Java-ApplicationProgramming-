package com.kudangtang.jv300.mod011;

public class UserService {
	private UserDao userDao;
	
	public UserService(DataSource dataSource) {		
		userDao = new UserDao(dataSource);
	}

	public User getUser(String userId, String passwd) {				
		return userDao.findUser(userId, passwd);
	}	

}
