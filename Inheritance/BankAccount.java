/*
 * Author - Vikram Gopal
 * Description - Class to create an ATM terminal with options to deposit, 
 * withdraw, view balance and exit terminal.
 */

package Viky_Programs;

public class BankAccount 
{
	private double balance;

	public BankAccount()
	{
		balance=0;
	}

	public BankAccount (double initialBalance)
	{
		balance = initialBalance;
	}

	public void deposit(double amount)
	{
		balance = balance+amount;
	}

	public void withdraw(double amount)
	{
		if(amount<=balance)
			balance = balance-amount;
		else
		{
			InsufficientFunds myEx;
			myEx = new InsufficientFunds ("Amount Exceeds Funds Available!!");
			throw myEx;
		}
	}

	public double getBalance()
	{
		return balance;
	}
}
