package com.kudangtang.banking.domain;

import com.kudangtang.banking.service.*;


public class AccountTest {
	public static void main(String[] args) {
		AccountTest test = new AccountTest();
		
		Account account = new Account(5000.0);
		System.out.println("계좌 생성하기");
		//계좌생성		
		AccountNumberGenerator an = new AccountNumberGenerator();
		System.out.println("생성된 계좌번호는: " + an.accountNumberGenerate() + "입니다\n");

		account.deposit(3000.0);
		account.deposit(3000.0);
		
		System.out.println("\n남은 잔고는: " + account.getBalance()+"원 입니다\n");
		
		//마이너스 계좌 생성
		CheckingAccount check = new CheckingAccount(5000.0);
		
		check.setBalance(account);
		check.getBalance();
		
		check.setOverdraftProtection(6000.0);
		check.getOverdraftProtection();
		
		//출금하기
		check.withdraw(1000.0);
		check.withdraw(1000.0);
		check.withdraw(1000.0);
		check.withdraw(1000.0);
		check.withdraw(1000.0);
		check.withdraw(1000.0);
		check.withdraw(1000.0);
		check.withdraw(1000.0);
		check.withdraw(1000.0);
		check.withdraw(1000.0);
		check.withdraw(1000.0);//11번 0원
		System.out.println();
		check.withdraw(1000.0);
		check.withdraw(1000.0);
		check.withdraw(1000.0);
		check.withdraw(1000.0);
		check.withdraw(1000.0);
		check.withdraw(1000.0);



		
//		System.out.println("\n고객 생성하기");
//		//고객생성
//		Customer customer = new Customer();
//		customer.setName("홍길동");
//		customer.getName();
//		customer.setSsn("123456-7890123");
//		customer.getSsn();
//		customer.setPhone("010-1234-4321");
//		customer.getPhone();
//		customer.setUserId("hoonggildong");
//		customer.getUserId();
//		customer.setPassWd("gildong123");
//		customer.getPassWd();		
//		customer.addAccount(account);
		
	}
}
