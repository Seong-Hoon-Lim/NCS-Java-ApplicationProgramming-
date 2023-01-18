package com.kudangtang.banking.domain;

import com.kudangtang.banking.exception.InsufficientBalanceException;
import com.kudangtang.banking.exception.OverdraftException;
import com.kudangtang.banking.service.*;


public class AccountTest {
	public static void main(String[] args) {
		
		System.out.println("고객 생성하기");
		//홍길동 고객 생성
		Customer customer = new Customer("홍길동", "123456-7890123"
				, "010-1234-4321", "hoonggildong", "gildong123");
		System.out.println(customer.toString());
		
		Customer customer2 = new Customer("이순신", "123456-7890123"
				, "010-1234-4321", "hoonggildong", "gildong123");
		System.out.println(customer2.toString());
		
		Account account = new Account(0.0);
		SavingsAccount sa = new SavingsAccount(5000.0);
		customer.addAccount(account);
		
		//계좌생성
		System.out.println("\n계좌1 생성");
		AccountNumberGenerator an = new AccountNumberGenerator();
		System.out.println("생성된 계좌번호는: " + an.generateAccountNum() + " 입니다\n");
	
		
		try {
			sa.bearInterest();
		}
		catch (InsufficientBalanceException e) {
			e.printStackTrace();
		}
			
		System.out.println("\n남은 잔고는: " + account.getBalance()+"원 입니다\n");
		
		//마이너스 계좌 생성
		CheckingAccount check = new CheckingAccount(0.0);
		check.setBalance(account);
		check.getBalance();

		
		try {
			//출금하기
			check.withdraw(5000.0);

		}
		catch (OverdraftException e) {
			e.printStackTrace();
		}
		
		//계좌2 생성
		System.out.println("\n계좌2 생성");
		AccountNumberGenerator an3 = new AccountNumberGenerator();
		System.out.println("생성된 계좌번호는: " + an3.generateAccountNum() + " 입니다\n");
		Account account2 = new Account(6000.0);
		try {
			account2.withdraw(5000.0);
			account2.withdraw(5000.0);
		} 
		catch (OverdraftException e) {
			e.printStackTrace();
		}		
		catch (InsufficientBalanceException e) {
			e.printStackTrace();
		} 	
	}	
}
