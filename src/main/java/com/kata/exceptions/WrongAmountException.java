package com.kata.exceptions;

public class WrongAmountException extends RuntimeException {

	public static final String WrongAmount = "the amount is incorrect";

	public WrongAmountException() {
		super(WrongAmount);
	}
}
