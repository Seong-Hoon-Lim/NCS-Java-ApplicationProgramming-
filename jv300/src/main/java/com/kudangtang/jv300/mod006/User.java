package com.kudangtang.jv300.mod006;

public class User {
	private String userId;
	private String passwd;
	private String userName;
	private String ssn1;
	private String ssn2;
	private String email1;
	
	private String[] concerns;

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

	public String getSsn1() {
		return ssn1;
	}

	public void setSsn1(String ssn1) {
		this.ssn1 = ssn1;
	}

	public String getSsn2() {
		return ssn2;
	}

	public void setSsn2(String ssn2) {
		this.ssn2 = ssn2;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String[] getConcerns() {
		return concerns;
	}

	public void setConcerns(String[] concerns) {
		this.concerns = concerns;
	}
	
	
}
