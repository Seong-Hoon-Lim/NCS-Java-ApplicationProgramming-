package com.kudangtang.banking.domain;

import com.kudangtang.banking.service.AccountNumberGenerator;

public class CustomerTest {

	public static void main(String[] args) {
		Customer customer = new Customer("유비", "881212-1111111" ,"010-5599-1111", "java", "1111" );
		
		//ver 1.0 :배열
		/* Account account = new Account(1000.0);
		account.setAccountNum(AccountNumberGenerator.generateAccountNum(), 1000, 0.03);
		account.setCustomer(customer); */
		
		//ver 2.0 : ArrayList
		Account account = new SavingsAccount(AccountNumberGenerator.generateAccountNum(), 1000.0, 0.03);
		customer.addAccount(account);
		
		account = new CheckingAccount(AccountNumberGenerator.generateAccountNum(), 1000.0, 1000.0);
		customer.addAccount(account);
		
		for (Account act : customer.getAoccountList()) {
			System.out.println(act);
		}
		
	}

}
