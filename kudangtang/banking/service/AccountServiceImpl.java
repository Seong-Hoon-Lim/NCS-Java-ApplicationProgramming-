package com.kudangtang.banking.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kudangtang.banking.domain.Account;
import com.kudangtang.banking.domain.CheckingAccount;
import com.kudangtang.banking.domain.SavingsAccount;
import com.kudangtang.banking.exception.AccountNotFoundException;




public class AccountServiceImpl implements AccountService {
	private static final Map<String, Account> BANK_ACCOUNTS = new HashMap<>();
	private static final Map<String, List<Account>> CUSTOMERS_ACCOUNTS = new HashMap<>();
	
	public AccountServiceImpl() {
	
	}
	
	@Override
	public Account addAccount(Account account) {
		if(BANK_ACCOUNTS.containsKey(account.getAccountNum())) {
			return BANK_ACCOUNTS.get(account.getAccountNum());
		}
		BANK_ACCOUNTS.put(account.getAccountNum(), account);
		if(CUSTOMERS_ACCOUNTS.containsKey(account.getCustomer().getSsn())) {
			List<Account> list = CUSTOMERS_ACCOUNTS.get(account.getCustomer().getSsn());
			list.add(account);
		}else {
			List<Account> list = new ArrayList<>();
			list.add(account);
			CUSTOMERS_ACCOUNTS.put(account.getCustomer().getSsn(),list);
		}
		return account;
	}

	@Override
	public Account createSavingsAccount(double balance, double interestRate) {
		return new SavingsAccount(AccountNumGenerator.generateAccountNum(), 
				balance, interestRate);
	}

	@Override
	public Account createCheckingAccount(double balance, double overdraft) {
		return new CheckingAccount(AccountNumGenerator.generateAccountNum(), 
				balance, overdraft);
	}
	
	@Override
	public Account getAccountByAccountNum(String accountNum) {
		if(BANK_ACCOUNTS.containsKey(accountNum)) {
			return BANK_ACCOUNTS.get(accountNum);
		}
		throw new AccountNotFoundException(accountNum + " : does not exist.");
	}
	
	@Override
	public Collection<Account> getAllAccountList() {
		return BANK_ACCOUNTS.values();
	}

	@Override
	public List<Account> getAccountBySsn(String ssn) {
		if(CUSTOMERS_ACCOUNTS.containsKey(ssn)) {
			return CUSTOMERS_ACCOUNTS.get(ssn);
		}
		throw new AccountNotFoundException(ssn + " : No Accounts exist.");
	}

	@Override
	public int getNumOfAccounts() {
		return BANK_ACCOUNTS.size();
	}
}
