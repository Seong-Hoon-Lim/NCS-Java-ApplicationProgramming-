package com.kudangtang.banking.domain;

public class SavingsAccount extends Account {
	
	private double interestRate;

	public SavingsAccount(double balance) {
		super(balance);
		super.balance = balance;
		
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}	
	
	
	//이자 붙이기
	public void bearInterest() {
			if (super.count >= 5) {
				super.balance *= interestRate;
				System.out.println("이자율은 " + interestRate + "입니다");
				System.out.println("현재 잔고는 " + super.balance + "원 입니다");
		}
	}
	
	

}
