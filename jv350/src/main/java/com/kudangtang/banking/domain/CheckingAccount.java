package com.kudangtang.banking.domain;

public class CheckingAccount extends Account{
	private double overdraftProtection;

	public CheckingAccount() {
		
	}
	
	public CheckingAccount(String accountNum, double balance, double interestRate, double overdraft, char accountType, Long customerId) {
		super();
		this.accountNum = accountNum;
		this.balance = balance;
		this.interestRate = interestRate;
		this.overdraft = overdraft;
		this.accountType = accountType;
		this.customerId = customerId;
	}
	
	public CheckingAccount(String accountNum, double initBalance, double protect){
		super(accountNum, initBalance);
		this.overdraftProtection = protect;
	}
	
	public void withdraw(double amount) {

		if(balance - amount < 0){
			double overdraftNeeded = amount - balance;
			
			if (overdraftProtection < overdraftNeeded) {
				
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
