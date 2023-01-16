package com.kudangtang.banking.exception;

/**
 * SavingsAccount 클래스의 bearInterest 메소드에서 
 * super.balance 의 금액이 0일 경우에 발생하도록 하는 예외
 * 
 * @author "SeongHoon"
 *
 */

public class InsufficientBalanceException extends Exception {

	public InsufficientBalanceException(String message) {
		super(message);
	}
	
	
}
