/*
 * Author - Vikram Gopal
 * Description - This class extends the BankAccount class and inlcudes the deduct fee 
 * mthod which will process a fee for the number for transactions made.
 */

package Viky_Programs;

public class CheckingAccount extends BankAccount
{
private int transactionCount;
	
	public CheckingAccount()
	{
		transactionCount=0;
	}
	
	public CheckingAccount(double initialBalance)
	{
		super(initialBalance);
		transactionCount=0;
	}
	
	public void deposit(double amount)
	{
		super.deposit(amount);
		transactionCount++;
	}
	
	public void withdraw(double amount)
	{
		super.withdraw(amount);
		transactionCount++;
	}
	
	public void deductFee()
	{
		if(transactionCount>3)
		{
		double fee = transactionCount*2;
		super.withdraw(fee);
		}
	}
}
