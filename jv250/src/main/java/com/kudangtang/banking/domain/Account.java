package com.kudangtang.banking.domain;

public class Account {
	protected String accountNum;
	protected double balance;
	protected double interestRate;
	protected double overdraft;
	protected char accountType;
	private Customer customer;
	protected Long customerId;
	private Long aid;
	
	public Account() {
		
	}
	
	public Account(double balance) {
		
	}
	
	public Account(String accountNum, double balance) {
		
	}
	
	public Account(String accountNum, double balance, double interestRate, double overdraft, char accountType, Long customerId) {
		super();
		this.accountNum = accountNum;
		this.balance = balance;
		this.interestRate = interestRate;
		this.overdraft = overdraft;
		this.accountType = accountType;
		this.customerId = customerId;
		
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

	public char getAccountType() {
		return accountType;
	}

	public void setAccountType(char accountType) {
		this.accountType = accountType;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}
	
	
	@Override
	public String toString() {
		return "Account [accountNum=" + accountNum + ", balance=" + balance + 
							 "interestRate=" + interestRate + " overdraft=" + overdraft + 
								" accountType=" + accountType +"]";
	}		
	
//	public static void main(String[] args) {
//		Account account = new Account();
//		System.out.println(account.getCustomer().getCid().toString());
//	}
}
