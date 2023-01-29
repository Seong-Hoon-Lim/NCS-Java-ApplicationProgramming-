package com.kudangtang.banking.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private String ssn;
	private String phone;
	
	public Customer(String name, String ssn, String phone) {
		this(name, ssn, phone, null, null);
		
	}
	public Customer(String name, String ssn, String phone, String userId, String passwd) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;

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

	@Override
	public String toString() {
		return "Customer [name=" + name + ", ssn=" + ssn + ", phone=" + phone + "]";
	}
	
	
}
