package com.kudangtang.banking.service;

import java.util.List;

import com.kudangtang.banking.dao.AccountDao;
import com.kudangtang.banking.domain.Account;

	public class AccountServiceImpl implements AccountService {
		
		/**
		 * 싱글톤 기법
			객체가 한번만 생성 되고 이후에 추가로 생성이 불필요한 경우
			해당 객체의 클래스에 private 접근제어자 static 키워드를 붙여
			생성자를 생성하고 생성된 객체를 다시 public 접근제어자 static
			키워드를 붙여 getInstance() 메서드를 생성하여 객체를 return 받는 것
			
			고정된 메모리 영역을 얻으면서 한번의 new 연산으로 인스턴스를 사용하기 때문에
			메모리 낭비를 방지할 수 있다
			
			인스턴스가 절대적으로 한 개만 존재하는 것을 보증하고 싶을 경우 사용한다
		 */	
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
