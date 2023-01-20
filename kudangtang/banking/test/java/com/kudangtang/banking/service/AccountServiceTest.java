package com.kudangtang.banking.service;

import java.util.List;

import com.kudangtang.banking.domain.Account;
import com.kudangtang.banking.domain.Customer;

public class AccountServiceTest {
	public static void main(String[] args) {
		Customer[] customers = initCustomers();
		CustomerService custService = new  CustomerServiceImpl();
		AccountService service = new AccountServiceImpl();
		
		double balance = 1000.0, overdraft = 1000.0;
		for(Customer customer : custService.getAllCustomers()) {
			Account sa = service.createSavingsAccount(balance, 0.02);
			sa.setCustomer(customer);
			service.addAccount(sa);
			
			Account ca = service.createCheckingAccount(balance, overdraft);
			ca.setCustomer(customer);
			service.addAccount(ca);
			balance += 1000.0;
			overdraft += 1000.0;
		}
		
		//전체목록
		System.out.println("\n[전체목록]-----------------------------");
		for(Account act : service.getAllAccountList()) {
			System.out.println(act);
		}
		//특정 고객의 계좌목록
		System.out.println("\n[특정 고객의 계좌목록]-----------------------------");
		System.out.println(customers[3].getName() + "님의 계좌목록");
		List<Account> accounts = service.getAccountBySsn(customers[3].getSsn());
		for(Account act : accounts) {
			System.out.println("\t" + act);
		}
		//특정 계좌
		System.out.println("\n[특정 계좌]-----------------------------");
		Account[] allAccounts = service.getAllAccountList()
						.toArray(new Account[service.getNumOfAccounts()]);
		Account testAccount = service.getAccountByAccountNum(
						allAccounts[0].getAccountNum());
		System.out.println(testAccount);
	}
	
	public static Customer[] initCustomers() {
		CustomerService service = new CustomerServiceImpl();
		service.addCustomer("유비", "901212-9012121", "010-1234-1234");
		service.addCustomer("관우", "911212-911212", "010-2345-2345");
		service.addCustomer("장비", "921212-921212", "010-3456-3456");
		service.addCustomer("조조", "801212-801212", "010-4567-4567");
		return service.getAllCustomers().toArray(new Customer[4]);
	}
}
