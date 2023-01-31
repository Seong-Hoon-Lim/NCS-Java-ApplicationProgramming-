package com.kudangtang.banking.service;

import java.util.List;

import com.kudangtang.banking.domain.Account;

public interface AccountService {
	
	//계좌 추가하기
	void addAccount(Account account);
	
	//모든 계좌 추가하기
	List<Account> getAllAccountList();
	
	//계좌 번호를 가져오기
	Account getAccountByAccountNum(String accountNum);
	
}
