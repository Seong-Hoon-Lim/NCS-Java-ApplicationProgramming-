package com.kudangtang.banking.domain;

import com.kudangtang.banking.exception.InsufficientBalanceException;
import com.kudangtang.banking.exception.OverdraftException;

public class Account {
	private String accountNum;
	protected double balance;
	private Customer customer;	
	protected String generateAccountNum;
	
	public Account(String generateAccountNum) {
		this.generateAccountNum = generateAccountNum;
	}
	
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
	public void withdraw(double amount) throws OverdraftException, InsufficientBalanceException {
		if (balance <= amount) {
			throw new InsufficientBalanceException("잔고가 부족합니다.");
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
