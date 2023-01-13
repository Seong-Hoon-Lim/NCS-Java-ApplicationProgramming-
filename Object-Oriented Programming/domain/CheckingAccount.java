package com.kudangtang.banking.domain;

public class CheckingAccount extends Account {
	
	private double overdraftProtection;

	public CheckingAccount(double balance) {
		super(balance);
		super.balance = this.balance;
		this.balance = balance;
		
	}
	
	public double getBalance() {
		return super.balance;
	}

	public void setBalance(Account ac) {
		super.balance = balance;
		balance = ac.getBalance();
		System.out.println("현재 잔고는 " + balance + "입니다");
	}

	public double getOverdraftProtection() {
		return overdraftProtection;
	}

	public void setOverdraftProtection(double overdraftProtection) {
		this.overdraftProtection = overdraftProtection;
		System.out.println("마이너스 계좌 생성! 잔고는: " + overdraftProtection + "원입니다");
		
	}
	
	@Override
	public void withdraw(double amount) {
		
		if (balance <= 0) {
			if (overdraftProtection + balance < 0) {
				System.out.println("마이너스 잔고가 부족합니다");
				System.out.println("현재 잔고는 " + balance + "원 입니다");
			}
			else {
				balance -= amount;
				System.out.println("출금된 금액은 " + amount + "원 입니다");
				System.out.println("현재 잔고는 " + balance + "원 입니다");
				overdraftProtection -= amount;
				System.out.println("현재 마이너스 잔고는 " + overdraftProtection + "원 입니다");
			}
		}
		else {
			balance -= amount;
			System.out.println("출금된 금액은 " + amount + "원 입니다");
			System.out.println("현재 잔고는 " + balance + "원 입니다");
			}
		}

}
