package com.kudangtang.banking.service;

import java.util.List;

import com.kudangtang.banking.dao.AccountDao;
import com.kudangtang.banking.domain.Account;

public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;
	
	public AccountServiceImpl(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	//계좌 추가하기
	@Override
	public void addAccount(Account account) {
		accountDao.addAccount(account);
		
	}

	//모든 계좌 리스트 가져오기
	@Override
	public List<Account> getAllAccountList() {
		
		return accountDao.findAllAccountList();
	}

	//계좌 번호를 가져오기
	@Override
	public Account getAccountByAccountNum(String accountNum) {
		
		return accountDao.findAccountsByAccountNum(accountNum);
	}
	
}
