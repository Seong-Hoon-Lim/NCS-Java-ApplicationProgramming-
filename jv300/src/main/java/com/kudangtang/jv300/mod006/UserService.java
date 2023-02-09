package com.kudangtang.jv300.mod006;

public class UserService {
	public void addUser(String userId, String passwd, String passwdcheck,
			String userName, String ssn1, String ss2, String email1, String email2, String[] concerns) {
		System.out.println("신규 User 등록되었습니다.");
		
	}
	
	public void addUser(User user) {
		System.out.println("신규 User 등록되었습니다.");
	}
}
