package com.kudangtang.banking.domain;

import com.kudangtang.banking.service.AccountNumGenerator;

public class AccountTest {
	public static void main(String[] args) {
		Customer customer = new Customer("유비", "881212-1111111", "010-5599-1111", "java", "1111");
		Account account = new Account(1000.0);
		account.setAccountNum(AccountNumGenerator.generateAccountNum());
		account.setCustomer(customer);
		customer.addAccount(account);
		
		System.out.println(account);
		System.out.println(customer);
	}
}
