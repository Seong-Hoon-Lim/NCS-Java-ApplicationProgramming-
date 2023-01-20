package com.kudangtang.banking.domain;

import com.kudangtang.banking.exception.OverdraftException;
import com.kudangtang.banking.service.AccountNumGenerator;

public class CheckingAccountTest {
	public static void main(String[] args) {
		CheckingAccount ca = new CheckingAccount(
				AccountNumGenerator.generateAccountNum(), 3000.0, 1000.0);
		System.out.println("잔고: " +  ca.getBalance());
		System.out.println("추가한도: " +  ca.getOverdraftProtection());
		System.out.println("총 출금 가능액: " +  (ca.getBalance() 
				+ ca.getOverdraftProtection())+"\n");
		
		double amount = 1000.0;
		for(int i = 0; i < 10; i++) {
			System.out.print("출금: " + amount +"\t");
			try {
				ca.withdraw(amount);
			} catch (OverdraftException e) {
				System.err.println(e.getMessage());
				break;
			}
		}
	}
}
