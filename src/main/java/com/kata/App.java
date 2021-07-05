package com.kata;

import com.kata.domain.Account;
import com.kata.services.BankService;
import com.kata.services.BankServiceImp;

public class App {
	public static void main(String[] args) {
		BankService bankService = new BankServiceImp();
		Account account = new Account(100, null);

		bankService.deposit(account, 100);

		bankService.deposit(account, 100);
		bankService.withdrawal(account, 200);

		bankService.printStatement(account);
	}
}
