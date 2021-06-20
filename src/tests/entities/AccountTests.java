package tests.entities;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {
	@Test
	public void depositShouldIncreaseBalanceWhenPositiveAmount() {
		
		double amount = 200.0;
		double expectedValue = 196.0;
		Account acc = AccountFactory.createEmptyAccount();
		
		acc.deposit(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
		
	}
	
	@Test
	public void depositShouldIncreaseBalanceWhenNegativeAmount() {
		
		double expetedValue = 100.0;
		Account acc = AccountFactory.createAccount(expetedValue);
		double amount = -200.0;
		
		acc.deposit(amount);
		
		Assertions.assertEquals(expetedValue, acc.getBalance());
	}
	
	@Test
	public void fullWithdrawShouldClearBalanceAndReturnFullBalance() {
		
		double expetedValue = 0.0;
		double initialBalance = 800.0;
		Account acc = AccountFactory.createAccount(initialBalance);	
		
		double result =  acc.fullWithdraw();
		Assertions.assertTrue(expetedValue == acc.getBalance());
		Assertions.assertTrue(result == initialBalance);
		
	}
	
	@Test
	public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {
		
		Account acc = AccountFactory.createAccount(800.0);
		acc.withdraw(500.0);
		
		Assertions.assertEquals(300.0, acc.getBalance());
		
	}
	
	@Test
	public void withdrawShouldDecreaseBalanceWhenInsufficientBalance() {
		
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			Account acc = AccountFactory.createAccount(800.0);
			acc.withdraw(801.0);
		});
		
	}
}
