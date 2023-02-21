package com.kudangtang.banking.service;

import java.util.List;

import com.kudangtang.banking.domain.Account;

public interface AccountService {
	
	/**
	 * 계좌 등록 기능
	 * @param account
	 */
	Account addAccount(Account account);
	
	/**
	 * 예금 계좌 생성 기능
	 * @param balance
	 * @param interestRate
	 * @return
	 */
	Account createSavingsAccount(double balance, double interestRate);
	
	/**
	 * 마이너스 계좌 생성 기능
	 * @param balance
	 * @param overdraft
	 * @return
	 */
	Account createCheckingAccount(double balance, double overdraft);
	
	/**
	 * 모든 계좌 리스트 조회 기능
	 * @return
	 */
	List<Account> getAllAccountList();	
	
	/**
	 * 특정 계좌 번호 조회 기능
	 * @param accountNum
	 * @return
	 */
	Account getAccountByAccountNum(String accountNum);
	
	/**
	 * 계좌 이체 기능
	 * @param balance
	 */
	void accountTransfer(double balance);
	
}
