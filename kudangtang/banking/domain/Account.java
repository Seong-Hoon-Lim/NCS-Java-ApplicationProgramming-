package com.kudangtang.banking.domain;

import com.kudangtang.banking.exception.InsufficientBalanceException;

public class Account {
	protected String accountNum;
	protected double balance;
	protected Customer customer;
	
	public Account(double balance) {
		this(null, balance);
	}
	
	public Account(String accountNum, double balance) {
		this.accountNum = accountNum;
		this.balance = balance;
	}
	
	/**
	 * 잔고조회
	 * @return
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * 입금하기
	 * @param amount
	 */
	public void deposite(double amount) {
		this.balance = amount;
	}
	
	/**
	 * 출금하기
	 * @param amount
	 */
	public void withdraw(double amount) throws InsufficientBalanceException{
		if(balance >= amount) {
			this.balance -= amount;
			System.out.println("잔고 : " + this.balance);
		}else {
			//System.out.println("잔고부족합니다. 현재잔고는 " + balance + "입니다.");
			throw new InsufficientBalanceException("잔액이 부족합니다. 현재 잔고는 " 
						+ balance + "입니다.");
		}
	}
	
	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Account [accountNum=" + accountNum + ", balance=" + balance + "]";
	}
	
	

}
