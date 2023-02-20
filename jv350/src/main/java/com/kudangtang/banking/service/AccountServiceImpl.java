package com.kudangtang.banking.service;

import java.util.List;


import com.kudangtang.banking.dao.AccountDao;
import com.kudangtang.banking.domain.Account;
import com.kudangtang.banking.domain.AccountNumGenerator;
import com.kudangtang.banking.domain.CheckingAccount;
import com.kudangtang.banking.domain.SavingsAccount;

public class AccountServiceImpl implements AccountService {
	
	private static AccountService as = new AccountServiceImpl();
	private AccountDao accountDao;	
	
	public AccountServiceImpl() {
		accountDao = new AccountDao();
	}
	
	public AccountServiceImpl(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	public static AccountService getInstance() {
		return as;
	}
	
	/**
	 * 예금 계좌 생성 기능
	 * @param balance
	 * @param interestRate
	 * @return
	 */
	@Override
	public Account createSavingsAccount(double balance, double interestRate) {
		// TODO Auto-generated method stub
		return new SavingsAccount(AccountNumGenerator.generateAccountNum(), 
				balance, interestRate);
	}

	/**
	 * 마이너스 계좌 생성 기능
	 * @param balance
	 * @param overdraft
	 * @return
	 */
	@Override
	public Account createCheckingAccount(double balance, double overdraft) {
		// TODO Auto-generated method stub
		return new CheckingAccount(AccountNumGenerator.generateAccountNum(), 
				balance, overdraft);
	}

	/**
	 * 계좌 등록 기능
	 * @param account
	 */	
	@Override
	public void addAccount(Account account) {
		accountDao.addAccount(account);
	}

	/**
	 * 모든 계좌 리스트 조회 기능
	 * @return
	 */
	@Override
	public List<Account> getAllAccountList() {
		// TODO Auto-generated method stub
		return accountDao.findAllAccountList();
	}

	/**
	 * 특정 계좌 번호 조회 기능
	 * @param accountNum
	 * @return
	 */
	@Override
	public Account getAccountByAccountNum(String accountNum) {
		// TODO Auto-generated method stub
		return accountDao.findAccountsByAccountNum(accountNum);
	}

	/**
	 * 계좌 이체 기능
	 * @param balance
	 */
	@Override
	public void accountTransfer(double balance) {
		// TODO Auto-generated method stub		

	}

}
