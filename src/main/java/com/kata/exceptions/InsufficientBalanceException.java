package com.kata.exceptions;

public class InsufficientBalanceException extends RuntimeException {
	public static final String InsufficientBalance = "the balance is insufficient";

	public InsufficientBalanceException() {
		super(InsufficientBalance);
	}
}
