package com.kudangtang.banking.service;

import java.util.List;

import com.kudangtang.banking.domain.Account;

public interface AccountService {
	
	/**
	 * 계좌 등록기능
	 * @param aid
	 * @param accountNum
	 * @param balance
	 * @param interestRate
	 * @param overdraft
	 * @param accountType
	 * @param customerId
	 */
	void addAccount(long aid, String accountNum, double balance, double interestRate, 
			double overdraft, char accountType, long customerId);
	
	/**
	 * 예금 계좌 생성 기능
	 * @param balance
	 * @param interestRate
	 * @return
	 */
	void createSavingsAccount(double balance, double interestRate);
	
	/**
	 * 마이너스 계좌 생성 기능
	 * @param balance
	 * @param overdraft
	 * @return
	 */
	void createCheckingAccount(double balance, double overdraft);
	
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
