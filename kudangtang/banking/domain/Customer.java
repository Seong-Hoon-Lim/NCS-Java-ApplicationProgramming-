package com.kudangtang.banking.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private String ssn;
	private String phone;
	private String userId;
	private String passwd;
	private List<Account> accountList = new ArrayList<>();
	
	public Customer(String name, String ssn, String phone) {
		this(name, ssn, phone, null, null);
		
	}
	public Customer(String name, String ssn, String phone, String userId, String passwd) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
		this.userId = userId;
		this.passwd = passwd;
	}
	
	public void addAccount(Account account) {
		boolean duplicated = false;
		for(Account act : accountList) {
			if(account.getAccountNum().equals(act.getAccountNum())) {
				duplicated = true;
				break;
			}
		}
		if(!duplicated) {
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
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", ssn=" + ssn + ", phone=" + phone 
				+ ", userId=" + userId + ", passwd="+ passwd 
				+ ", accountList=" + accountList + "]";
	}
	
	
}
