package com.kata.services;

import java.util.ArrayList;
import java.util.Date;

import com.kata.domain.Account;
import com.kata.domain.Operation;
import com.kata.domain.TypeOperation;
import com.kata.exceptions.InsufficientBalanceException;
import com.kata.exceptions.NonExistentAccountException;
import com.kata.exceptions.WrongAmountException;
import com.kata.utils.DateUtils;

public class BankServiceImp implements BankService {

	public void deposit(Account account, double amount) {
		if (null == account) {
			throw new NonExistentAccountException();
		}
		if (amount <= 0) {
			throw new WrongAmountException();
		}
		if (null == account.getOperations()) {
			account.setOperations(new ArrayList<Operation>());
		}
		Operation operation = new Operation(new Date(), amount, TypeOperation.DEPOSIT, account.getBalance() + amount);
		account.getOperations().add(operation);
		account.setBalance(account.getBalance() + amount);

	}

	public void withdrawal(Account account, double amount) {
		if (null == account) {
			throw new NonExistentAccountException();
		}
		if (amount <= 0) {
			throw new WrongAmountException();
		}
		if (account.getBalance() < amount) {
			throw new InsufficientBalanceException();
		}
		if (null == account.getOperations()) {
			account.setOperations(new ArrayList<Operation>());
		}
		amount = -amount;
		Operation operation = new Operation(new Date(), amount, TypeOperation.WITHDRAWL, account.getBalance() + amount);
		account.getOperations().add(operation);
		account.setBalance(account.getBalance() + amount);

	}

	@Override
	public void printStatement(Account account) {
		System.out.println(String.format("%-15s%-15s%-15s%-15s", "Date", "Amount", "Type", "balance"));
		printOperations(account);

	}

	private void printOperations(Account account) {
		for (Operation op : account.getOperations()) {
			System.out.println(String.format("%-15s%-15s%-15s%-15s", DateUtils.dateAsString(op.getDateOperation()),
					String.valueOf(op.getAmount()), op.getTypeOperation().name(), String.valueOf(op.getBalance())));
		}
	}

}
