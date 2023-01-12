package com.kudangtang.banking.domain;

import java.util.Random;

public class Customer {
	private String name;
	private String ssn;
	private String phone;
	private String userId;
	private String passWd;
	private Account[] accounts;
	
	public Customer(String name, String ssn, String phone, String userId, String passWd) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
		this.userId = userId;
		this.passWd = passWd;
	}
	
	//고객 계좌 추가 (한 고객이 사용할 수 있는 계좌 max 3개)
	public void addAccount(Account a) {
		accounts = new Account[3];
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] == null) {
				accounts[i] = a;
				System.out.println("계좌가 " + a + "개 생성되었습니다");
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
	public String getPassWd() {
		return passWd;
	}
	public void setPassWd(String passWd) {
		this.passWd = passWd;
	}
	
	
}
