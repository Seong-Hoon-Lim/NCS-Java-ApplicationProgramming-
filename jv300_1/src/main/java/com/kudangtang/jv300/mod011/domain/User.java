package com.kudangtang.jv300.mod011.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private long id;
	private String userId;
	private String userPw;
	private String userName;
	private Date userBirthDay;
	private String userEmail;
	private String regDate;
//	private String[] concerns;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
//	public String[] getConcerns() {
//		return concerns;
//	}
//	public void setConcerns(String[] concerns) {
//		this.concerns = concerns;
//	}
	public Date getUserBirthDay() {
		return userBirthDay;
	}
	public void setUserBirthDay(Date userBirthDay) {
		this.userBirthDay = userBirthDay;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
}
