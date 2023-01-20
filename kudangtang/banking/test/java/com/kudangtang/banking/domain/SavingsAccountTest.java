package com.kudangtang.banking.domain;

import com.kudangtang.banking.exception.InsufficientBalanceException;
import com.kudangtang.banking.exception.OverdraftException;
import com.kudangtang.banking.service.AccountNumGenerator;

public class SavingsAccountTest {
	public static void main(String[] args) {
		SavingsAccount sa = new SavingsAccount(
				AccountNumGenerator.generateAccountNum(), 3000.0, 1000.0);
		System.out.println("잔고: " +  sa.getBalance() +"\n");
		
		double amount = 1000.0;
		for(int i = 0; i < 10; i++) {
			System.out.print("출금: " + amount +"\t");
			try {
				sa.withdraw(amount);
			} catch (InsufficientBalanceException e) {
				System.err.println(e.getMessage());
				break;
			}
		}
	}
}
