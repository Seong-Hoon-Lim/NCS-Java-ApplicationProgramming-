package com.kudangtang.banking.exception;

public class InsufficientBalanceException extends Exception{
	private static final long serialVersionUID = 6968351825481954463L;
	
	public InsufficientBalanceException(String msg) {
		super(msg);
	}
	
}
