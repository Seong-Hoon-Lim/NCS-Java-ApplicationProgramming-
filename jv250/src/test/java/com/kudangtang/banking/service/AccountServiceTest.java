package com.kudangtang.banking.service;

import com.kudangtang.banking.dao.AccountDao;
import com.kudangtang.banking.domain.Account;
import com.kudangtang.banking.domain.Customer;
import com.kudangtang.banking.domain.SavingsAccount;

public class AccountServiceTest {
	private static AccountService accountService = AccountServiceImpl.getInstance();
	private static CustomerService customerService = CustomerServiceImpl.getInstance();
	
	public static void main(String[] args) {
		addAccount();
		
	}
	
	public static void addAccount() {
		AccountService accountService = new AccountServiceImpl(new AccountDao());
		Account saccount2 = new SavingsAccount("7782-5582", 10000.0, 0.05, 0.0, 'S', 1005L);
		saccount2.setCustomer(new Customer(1005));
		accountService.addAccount(saccount2);
		System.out.println("Account Inserted.... \n");	
	}

}
