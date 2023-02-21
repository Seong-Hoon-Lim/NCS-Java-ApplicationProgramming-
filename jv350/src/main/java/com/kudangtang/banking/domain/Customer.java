package com.kudangtang.banking.domain;

public class Customer {
	private long id;
	private String name;
	private String ssn;
	private String phone;
	private String tel;
	private String userId;
	private String passwd;
	private String email;
	private String regDate;
	
	public Customer() {
		
	}
	
	public Customer(long id, String name, String ssn, String phone, String tel, 
			String userId, String passwd, String email) {
		super();
		this.id = id;
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
		this.tel = tel;
		this.userId = userId;
		this.passwd = passwd;
		this.email = email;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}		

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", ssn=" + ssn + ", phone=" + phone +
					", userId=" + userId + ", passwd" + passwd + "]";
	}

}
