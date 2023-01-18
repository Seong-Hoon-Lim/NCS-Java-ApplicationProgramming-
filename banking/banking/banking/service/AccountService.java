package com.kudangtang.banking.service;

import java.util.Collection;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import com.kudangtang.banking.domain.Account;

public interface AccountService {
	
	/**
	 * 전달된 인자로 구성된 Account 정보 추가
	 * @param account
	 * @return
	 */
	
	Account addAccount(Account account);

	Account creatSavingsAccount(double balance, double interestRate);
	
	Account creatCheckingAccount(double balance, double overdraft);
	
	Account getAccountByAccountNum(String accountNum) throws AccountNotFoundException;
	
	Collection<Account> getAllAccountList();
	
	List<Account> getAccountBySsn(String ssn);
	
	int getNumOfAccounts();

}