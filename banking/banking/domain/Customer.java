package com.kudangtang.banking.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private String ssn;
	private String phone;
	private String userId;
	private String passWd;
	private List<Account> accountList = new ArrayList<>();
	
	public Customer(String name, String ssn, String phone) {
		
	}

	public Customer(String name, String ssn, String phone, String userId, String passWd) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
		this.userId = userId;
		this.passWd = passWd;
	}

	//고객 계좌 배열 리스트에 담기
	public void addAccount(Account account) {
		boolean duplicated = false;
		for (Account act : accountList) {
			//계좌 중복검사
			if (account.getAccountNum().equals(act.getAccountNum()));
			duplicated = true;
			break;
		}
		if (!duplicated) {
			accountList.add(account);
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
	
	
	public String toString() {

		return "이름: " + name + "/" + "주민번호: " + ssn + 
				"/" + "폰번호: " + phone + "/" + "ID: " + userId + 
				"/" + "PW: " + passWd;
	}
	
}
