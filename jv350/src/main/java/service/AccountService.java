package service;

import java.util.ArrayList;

import dao.AccountDao;
import vo.Account;

public class AccountService {

	AccountDao aDao = new AccountDao();
	
	public void newAccount(Account acc) {
		aDao.addAccount(acc);
	}
	
	public void withDraw(Account acc, double money) {
		aDao.withdraw(acc, money);
	}
	
	public ArrayList<Account> findAllAccounts() {
		ArrayList<Account> accountAllList = new ArrayList<>();
		accountAllList = aDao.findAllAccounts();
		
		return accountAllList;
	}
	
	public ArrayList<Account> findmyAccount(String userId){
		return aDao.findAccountByUserId(userId);
	}
	
	public ArrayList<Account> findmyAccountNum(String accountNum) {
		Account account = new Account();
		return aDao.findAccountByAccountNum(accountNum);
	}
	
	/**
	 * 현재 로그인 된 userId의 계좌 삭제 기능
	 */
	public void removeAccount(String userId) {
		aDao.deleteAccountByUserId(userId);
	}
	
}
