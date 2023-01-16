package com.kudangtang.banking.domain;

import com.kudangtang.banking.exception.InsufficientBalanceException;

public class SavingsAccount extends Account {
	
	private double interestRate;
	
	public SavingsAccount(double balance) {
		super(balance);
		super.balance = balance;
		
	}
	
	public double getBalance() {
		return super.balance;
	}

	public void setBalance(Account ac) {
		super.balance = balance;
		balance = ac.getBalance();
		System.out.println("현재 잔고는 " + balance + "입니다");
	}
	
	public int getCount(int count) {
		return super.count;
	}
	
	public void getCount() {
		super.count = count;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}	
	
	
	//이자 붙이기
	public void bearInterest() throws InsufficientBalanceException {
		if (balance < 0 && count == 0 ) {
			throw new InsufficientBalanceException("잔고가 부족합니다.");
		}
		else {
			if (count >= 2) {
				balance *= interestRate;
				System.out.println("이자율은 " + interestRate + "입니다");
				System.out.println("현재 잔고는 " + balance + "원 입니다");
			}
		}
	}
	

}
