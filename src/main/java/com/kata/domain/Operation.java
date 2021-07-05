package com.kata.domain;

import java.util.Date;

public class Operation {
	private Date dateOperation;
	private double amount;
	private TypeOperation typeOperation;
	private double balance;

	public Operation() {
		super();
	}

	public Operation(Date dateOperation, double amount, TypeOperation typeOperation, double balance) {
		super();
		this.dateOperation = dateOperation;
		this.amount = amount;
		this.typeOperation = typeOperation;
		this.balance = balance;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public TypeOperation getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(TypeOperation typeOperation) {
		this.typeOperation = typeOperation;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
