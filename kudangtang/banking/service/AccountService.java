package com.kudangtang.banking.service;

import java.util.Collection;
import java.util.List;

import com.kudangtang.banking.domain.Account;

public interface AccountService {
	
	Account createSavingsAccount(double balance, double interestRate);
	
	Account createCheckingAccount(double balance, double overdraft);
	
	Account addAccount(Account account);
	
	Collection<Account> getAllAccountList();
	
	List<Account> getAccountBySsn(String ssn);
	
	Account getAccountByAccountNum(String accountNum);

	int getNumOfAccounts();
}
