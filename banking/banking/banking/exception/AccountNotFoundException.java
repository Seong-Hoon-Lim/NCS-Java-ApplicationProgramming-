package com.kudangtang.banking.exception;

@SuppressWarnings("serial")
public class AccountNotFoundException extends RuntimeException {
	
	public AccountNotFoundException(String message) {
		super(message);
	}

}
