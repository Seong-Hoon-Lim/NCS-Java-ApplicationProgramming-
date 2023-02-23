package service;

import java.util.ArrayList;

import dao.UserDao;
import vo.User;

public class UserService {
	UserDao uDao = new UserDao();
	
	public void signupUser(User user) {
		uDao.addUser(user);
	}
	
	public User loginUser(String id, String pw) {
		User user = new User();
		user = uDao.findUser(id, pw);
		
		return user;
	}
	
	public User myPage(String id) {
		User user = new User();
		user = uDao.findUserbyId(id);
		
		return user;
	}
	
	public ArrayList<User> userListSearch(){
		ArrayList<User> userList = new ArrayList<>();
		userList = uDao.findUserList();

		return userList;
	}
}
