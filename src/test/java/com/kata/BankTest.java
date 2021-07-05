package com.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.kata.domain.Account;
import com.kata.domain.TypeOperation;
import com.kata.exceptions.InsufficientBalanceException;
import com.kata.exceptions.NonExistentAccountException;
import com.kata.exceptions.WrongAmountException;
import com.kata.services.BankService;
import com.kata.services.BankServiceImp;

class BankTest {
	
	private BankService bankServie;
	
	private Account account;
	
	@Mock PrintStream printer;
	
	@BeforeEach
	private void Initialize() {
		bankServie = new BankServiceImp();
		account = new Account(100, null);
	}
	
	@Test
	void create_deposit_test() {
		bankServie.deposit(account, 100);
		assertEquals(200, account.getBalance());
		assertEquals(1, account.getOperations().size());
		assertEquals(TypeOperation.DEPOSIT, account.getOperations().get(0).getTypeOperation());
		assertEquals(100, account.getOperations().get(0).getAmount());
	}
	@Test
	void create_deposit_with_account_null() {
		Exception exception = assertThrows(RuntimeException.class, () -> bankServie.deposit(null, 100));
		String messageAttendu = NonExistentAccountException.NonExistentAccount;
		String messageReel = exception.getMessage();
		assertTrue(messageReel.contains(messageAttendu));
		assertEquals(100, account.getBalance());
		assertEquals(null , account.getOperations());
	}
	@Test
	void create_deposit_with_negative_amount() {
		Exception exception = assertThrows(RuntimeException.class, () -> bankServie.deposit(account, -100));
		String messageAttendu = WrongAmountException.WrongAmount;
		String messageReel = exception.getMessage();
		assertTrue(messageReel.contains(messageAttendu));
		assertEquals(100, account.getBalance());
		assertEquals(null , account.getOperations());
	}
	
	@Test
	void create_withdrawal_test() {
		bankServie.withdrawal(account, 50);
		assertEquals(50, account.getBalance());
		assertEquals(1, account.getOperations().size());
		assertEquals(TypeOperation.WITHDRAWL, account.getOperations().get(0).getTypeOperation());
		assertEquals(-50, account.getOperations().get(0).getAmount());
	}
	
	@Test
	void create_withdrawal_with_account_null() {
		Exception exception = assertThrows(RuntimeException.class, () -> bankServie.withdrawal(null, 100));
		String messageAttendu = NonExistentAccountException.NonExistentAccount;
		String messageReel = exception.getMessage();
		assertTrue(messageReel.contains(messageAttendu));
		assertEquals(100, account.getBalance());
		assertEquals(null , account.getOperations());
	}
	
	@Test
	void create_withdrawal_with_negative_amount() {
		Exception exception = assertThrows(RuntimeException.class, () -> bankServie.withdrawal(account, -100));
		String messageAttendu = WrongAmountException.WrongAmount;
		String messageReel = exception.getMessage();
		assertTrue(messageReel.contains(messageAttendu));
		assertEquals(100, account.getBalance());
		assertEquals(null , account.getOperations());
	}
	
	@Test
	void create_withdrawal_insufficient_balance() {
		Exception exception = assertThrows(RuntimeException.class, () -> bankServie.withdrawal(account, 200));
		String messageAttendu = InsufficientBalanceException.InsufficientBalance;
		String messageReel = exception.getMessage();
		assertTrue(messageReel.contains(messageAttendu));
		assertEquals(100, account.getBalance());
		assertEquals(null , account.getOperations());
	}

}
