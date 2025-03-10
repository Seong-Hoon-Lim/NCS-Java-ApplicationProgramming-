package com.kudangtang.banking.domain;

import com.kudangtang.banking.exception.OverdraftException;

public class CheckingAccount extends Account{
	private double overdraftProtection;
	
	public CheckingAccount(String accountNum, double initBalance, double protect){
		super(accountNum, initBalance);
		this.overdraftProtection = protect;
	}
	
	@Override
	public void withdraw(double amount) throws OverdraftException{

		if(balance - amount < 0){
			double overdraftNeeded = amount - balance;
			
			if (overdraftProtection < overdraftNeeded) {
				//System.out.println("(에러-한도액초과)잔고 : " + balance);
				throw new OverdraftException("(한도액 초과) 잔고 : " + balance);
			} else {
				balance = overdraftNeeded * -1.0;
				overdraftProtection = overdraftProtection - overdraftNeeded;
				System.out.println("잔여 대월액 : " + (overdraftProtection));
			}
		}else{
			balance -= amount;
			System.out.println("잔고 : " + balance);
		}
	}

	public double getOverdraftProtection() {
		return overdraftProtection;
	}

	public void setOverdraftProtection(double overdraftProtection) {
		this.overdraftProtection = overdraftProtection;
	}

	@Override
	public String toString() {
		return "CheckingAccount [accountNum=" + accountNum + ", balance=" 
				+ balance + ", overdraftProtection=" + overdraftProtection + "]";
	}
	
	
}
