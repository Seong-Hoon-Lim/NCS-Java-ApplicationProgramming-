package com.kudangtang.banking.domain;

import java.util.Arrays;

public class Customer_Old {
	private String name;
	private String ssn;
	private String phone;
	private String userId;
	private String passwd;
	private Account[] accounts = new Account[3];
	
	public Customer_Old(String name, String ssn, String phone, String userId, String passwd) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
		this.userId = userId;
		this.passwd = passwd;
	}
	
	public void addAccount(Account account) {
		for(int i = 0; i < accounts.length; i++) {
			if(accounts[i] == null) {
				accounts[i] = account;
				break;
			}
		}
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

	@Override
	public String toString() {
		return "Customer [name=" + name + ", ssn=" + ssn + ", phone=" + phone 
				+ ", userId=" + userId + ", passwd="+ passwd 
				+ ", accounts=" + Arrays.toString(accounts) + "]";
	}
	
	
}
