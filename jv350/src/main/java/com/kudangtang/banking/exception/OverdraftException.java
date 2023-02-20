package com.kudangtang.banking.exception;

public class OverdraftException extends InsufficientBalanceException{
	private static final long serialVersionUID = 3284265103058959014L;

	public OverdraftException(String msg) {
		super(msg);
	}
}
