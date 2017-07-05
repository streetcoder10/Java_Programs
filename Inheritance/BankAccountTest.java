/*
 * Author - Vikram Gopal
 * Description - Test class for BankAccount, CheckingAccount and InsufficientFunds Class.
 */

package Viky_Programs;

import java.util.Scanner;

public class BankAccounTest 
{
	public static void main(String [] args)
	{
		Scanner myScanner = new Scanner(System.in);

		System.out.println("Enter Initial Balance:  ");
		double amount = Double.parseDouble(myScanner.nextLine());
		CheckingAccount myCA = new CheckingAccount(amount);
		System.out.println("Welcome to Chase banking terminal!!");

		boolean done=false;
		while(!done)
		{
			System.out.println("Please choose desired action to perform");
			System.out.println("D- deposit");
			System.out.println("W- withdraw");
			System.out.println("S- current balance");
			System.out.println("P- process fee");
			System.out.println("X- exit terminal");
			System.out.println("> ");
			String choice = myScanner.nextLine();

			if(choice.equalsIgnoreCase("D"))
			{
				System.out.println("Enter amount to deposit:  ");
				amount = Double.parseDouble(myScanner.nextLine());
				myCA.deposit(amount);
			}

			else if(choice.equalsIgnoreCase("W"))
			{
				try{
					System.out.println("Enter amount to withdraw:  ");
					amount = Double.parseDouble(myScanner.nextLine());
					myCA.withdraw(amount);
				}
				catch(InsufficientFunds myEx)
				{
					System.out.println(myEx.getMessage());
					System.out.println("Transaction Aborted!!");
				}
			}

			else if(choice.equalsIgnoreCase("S"))
			{
				System.out.println("Current balance:  "+myCA.getBalance());
			}

			else if(choice.equalsIgnoreCase("P"))
			{
				myCA.deductFee();
				System.out.println("Current balance after processing:  "+myCA.getBalance());
			}
			else if(choice.equalsIgnoreCase("X"))
			{
				done=true;	
			}
			else
				System.out.println("Invalid Input");
		}
		System.out.println("Goodbye!!");
		myScanner.close();	
	}
}
