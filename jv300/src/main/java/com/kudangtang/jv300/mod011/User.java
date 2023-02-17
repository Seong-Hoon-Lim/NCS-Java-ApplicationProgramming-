package com.kudangtang.jv300.mod011;

import java.util.Date;

public class User {
	private Long id;
	private String userId;
	private String passwd;
	private String userName;
	private Date birthDate;
	private String email;
	private String[] concerns;
//	private Timestamp regDate;
	
	public User() {
		
	}
	
//	public User(String userId, String passwd, String userName,
//			Date birthDate, String email, String[] concerns, Timestamp regDate) {
//		super();
//		this.userId = userId;
//		this.passwd = passwd;
//		this.userName = userName;
//		this.birthDate = birthDate;
//		this.email = email;
//		this.concerns = concerns;
//		this.regDate = regDate;
//	}
	
	public User(String userId, String passwd, String userName,
			Date birthDate, String email, String[] concerns) {
		super();
		this.userId = userId;
		this.passwd = passwd;
		this.userName = userName;
		this.birthDate = birthDate;
		this.email = email;
		this.concerns = concerns;

	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String[] getConcerns() {
		return concerns;
	}

	public void setConcerns(String[] concerns) {
		this.concerns = concerns;
	}

//	public Timestamp getRegDate() {
//		return regDate;
//	}
//
//	public void setRegDate(Timestamp regDate) {
//		this.regDate = regDate;
//	}	


}
