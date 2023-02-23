package vo;

import exceptions.InsufficientException;
import exceptions.OverdraftException;

public class Account {
	protected long aid;
	protected String accountNum;
	protected double balance; // 잔액
	protected double interestRate;
	protected double overdraft;
	protected char accountType;
	protected String userId;
	protected String regdate;
	protected User user; // 고객 인스턴스변수..필요한가? 일단 둠

	public Account() {

	}
	
	public Account(String accountNum, double balance) {
		this.accountNum = accountNum;
		this.balance = balance;
	}
	
	public Account(double balance) {
		this(null, balance);
	}
	

	public long getAid() {
		return aid;
	}


	public void setAid(long aid) {
		this.aid = aid;
	}

	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public double getInterestRate() {
		return interestRate;
	}


	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}


	public double getOverdraft() {
		return overdraft;
	}


	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}


	public char getAccountType() {
		return accountType;
	}


	public void setAccountType(char accountType) {
		this.accountType = accountType;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getRegdate() {
		return regdate;
	}


	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}


	public String getAccountNum() {
		// TODO Auto-generated method stub
		return accountNum;
	}
	
	public void deposit(double amount) {
		this.balance += amount;
	}

	public void withdraw(double amount) throws InsufficientException, OverdraftException {
		if (balance >= amount) {
			this.balance -= amount;
		} else {
			throw new InsufficientException("잔고 부족. 현재 잔고는 " + balance + "입니다. ");
		}
	}
	
	
}
