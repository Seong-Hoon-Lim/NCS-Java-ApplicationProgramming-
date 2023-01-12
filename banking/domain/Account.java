package com.kudangtang.banking.domain;

public class Account {
	private String accountNum;
	private double balance;
	private Customer customer;
	
	public Account(double balance) {
		this.balance = balance;
	}
	
	//입금하기
	public void deposit(double amount) {
		this.balance += amount;
		System.out.println("입금된 금액은 " + amount + "원 입니다");
		System.out.println("현재 잔고는 " + balance + "원 입니다");
	}
	
	//출금하기
	public void withdraw(double amount) {
		if (balance <= amount) {
			System.out.println("잔고가 부족합니다");
			System.out.println("현재 잔고는 " + balance + "원 입니다");
		}
		else {
			this.balance -= amount;
			System.out.println("출금된 금액은 " + amount + "원 입니다");
			System.out.println("현재 잔고는 " + balance + "원 입니다");
		}
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
