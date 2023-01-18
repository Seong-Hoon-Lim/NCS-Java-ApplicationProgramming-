package com.kudangtang.banking.exception;

@SuppressWarnings("serial")
public class CustomerNotFoundException extends RuntimeException {
	
	public CustomerNotFoundException(String message) {
		super(message);
	}

}
