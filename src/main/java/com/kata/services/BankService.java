package com.kata.services;

import com.kata.domain.Account;

public interface BankService {

	public void deposit(Account account, double montant);

	public void withdrawal(Account account, double montant);

	public void printStatement(Account account);
}
