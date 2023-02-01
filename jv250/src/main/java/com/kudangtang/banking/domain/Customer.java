package com.kudangtang.banking.domain;

public class Customer {
	private String name;
	private String ssn;
	private String phone;
	private Long cid;
	
	public Customer() {
		
	}
	
	public Customer(long cid) {
		this.cid = cid;
	}
	
	public Customer(String ssn) {
		
	}
	
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
	
	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", ssn=" + ssn + ", phone=" + phone + "]";
	}
	
	
}
