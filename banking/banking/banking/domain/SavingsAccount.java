package com.kudangtang.banking.domain;

import com.kudangtang.banking.exception.InsufficientBalanceException;

public class SavingsAccount extends Account {
	
	private double interestRate;
	
	public SavingsAccount(double balance) {
		super(balance);
		super.balance = balance;
		
	}
	
	public SavingsAccount(String generateAccountNum, double balance, double interestRate) {
		super(balance);
		super.generateAccountNum = generateAccountNum;
	}

	public SavingsAccount(String generateAccountNum) {
		super(generateAccountNum);
	}

	public double getBalance() {
		return super.balance;
	}

	public void setBalance(Account ac) {
		super.balance = balance;
		balance = ac.getBalance();
		System.out.println("현재 잔고는 " + balance + "입니다");
	}
	

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}	
	
	
	//이자 붙이기
	public void bearInterest() throws InsufficientBalanceException {
		
	}
	

}
