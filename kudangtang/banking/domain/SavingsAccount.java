package com.kudangtang.banking.domain;

public class SavingsAccount extends Account {

	private double interestRate;
	
	public SavingsAccount(String accountNum, double balance, double rate) {
		super(accountNum, balance);
		setInterestRate(rate);
	}
	
	public SavingsAccount(double balance, double rate) {
		super(balance);
		setInterestRate(rate);
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}
	
	@Override
	public String toString() {
		return "SavingsAccount [accountNum=" + accountNum + ", balance=" + balance
				+", interestRate=" + interestRate + "]";
	}

}
