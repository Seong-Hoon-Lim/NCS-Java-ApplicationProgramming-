package com.kudangtang.banking.exception;

/**
 * CheckingAccount 클래스의 withdraw 메소드에서 
 * overdraftProtection 의 한도 금액이 초과 되었을 때 발생하도록 하는 예외
 * @author "SeongHoon"
 *
 */
public class OverdraftException extends InsufficientBalanceException {
	
	
	public OverdraftException(String message) {
		super(message);
	}

}
