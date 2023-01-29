package com.kudangtang.banking.dao;

import java.util.List;

import com.kudangtang.banking.domain.Account;
import com.kudangtang.banking.domain.Customer;

public class AccountDaoTest {
	public static void main(String[] args) {
		addAccount();
		updateAccount();
		findAllAccountList();
		findAccountByCustomer();		
		
	}

	public static void addAccount() {
		AccountDao dao = new AccountDao();
		Account account = new Account("7799-1122", 3000.0, 0.02, 0, (byte)'S', 
							new Customer("홍길동", "930001-1901111", "01012433412"));
		dao.addAccount(account);
		System.out.println("Account Inserted.... \n");
		
	}
	
	public static void findAllAccountList() {
		AccountDao dao = new AccountDao();
		List<Account> list = dao.findAllAccountList();
		for (Account a : list) {
			System.out.println(a);
		}
	}
	
	public static void findAccountByCustomer() {
		AccountDao dao = new AccountDao();
		Account account = dao.findAccountByCustomer(new Customer("홍길동", "930001-1901111", "01012433412"));
		System.out.println(account);
	}
	
	public static void updateAccount() {
		AccountDao dao = new AccountDao();
		Account account = dao.findAccountByCustomer(new Customer("홍길동", "930001-1901111", "01012433412"));
		account.setAccountNum("7788-1133");
		account.setBalance(5000.0);
		account.setInterestRate(0.0);
		account.setOverdraft(5000.0);
		account.setAccountType((byte)'C');
		dao.updateAccount(account);
	}
	
}
