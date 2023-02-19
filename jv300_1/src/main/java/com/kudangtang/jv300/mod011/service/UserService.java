package com.kudangtang.jv300.mod011.service;

import java.util.List;

import com.kudangtang.jv300.mod011.domain.User;

public interface UserService {
	
	public void addUser(User user);
	
	public List<User> findUserList();
	
	public User findUser(String userId, String passwd);
	
	public void updateUser(User user);
}
