package com.kata.exceptions;

public class NonExistentAccountException extends RuntimeException {

	public static final String NonExistentAccount = "the account does not exist";

	public NonExistentAccountException() {
		super(NonExistentAccount);
	}

}
