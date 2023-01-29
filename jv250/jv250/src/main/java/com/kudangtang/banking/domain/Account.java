package com.kudangtang.banking.domain;

public class Account {
	private String accountNum;
	private double balance;
	private double interestRate;
	private double overdraft;
	private byte accountType;
	protected Customer customer;
	
	public Account() {
		
	}
	
	public Account(String accountNum, double balance, double interestRate, double overdraft, byte accountType,
			Customer customer) {
		super();
		this.accountNum = accountNum;
		this.balance = balance;
		this.interestRate = interestRate;
		this.overdraft = overdraft;
		this.accountType = accountType;
		this.customer = customer;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}

	public byte getAccountType() {
		return accountType;
	}

	public void setAccountType(byte accountType) {
		this.accountType = accountType;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@Override
	public String toString() {
		return "Account [accountNum=" + accountNum + ", balance=" + balance + 
							"interestRate" + interestRate + "overdraft" + overdraft + 
								"accountType" + accountType +"]";
	}

}