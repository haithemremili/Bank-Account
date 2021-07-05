package com.kata.domain;

import java.util.List;

public class Account {

	private double balance;
	private List<Operation> operations;

	public Account() {
		super();
	}

	public Account(double balance, List<Operation> operations) {
		super();
		this.balance = balance;
		this.operations = operations;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double solde) {
		this.balance = solde;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

}
