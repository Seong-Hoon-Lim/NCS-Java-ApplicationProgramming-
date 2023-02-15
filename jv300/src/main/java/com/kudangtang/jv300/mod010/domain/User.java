package com.kudangtang.jv300.mod010.domain;

public class User {
	private String userId;
	private String passwd;
	private String userName;
	private String birthDate;
	private String email;
	
	public User() {
		
	}
	
	public User(String userId, String passwd, String userName, String birthDate, String email) {
		super();
		this.userId = userId;
		this.passwd = passwd;
		this.userName = userName;
		this.birthDate = birthDate;
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	

}
