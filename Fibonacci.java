/*
 * Author - Vikram Gopal
 * Description - Classic Fibonacci Program using recursion.
 */

package Viky_Programs;

import java.util.Scanner;

public class Fibonacci 
{

	public static void main(String[] args)
	{
		Scanner myScanner = new Scanner(System.in);
		boolean done = false;
		while (!done)
		{
			System.out.print("Enter an integer or Q to quit: ");
			String answer = myScanner.nextLine();
			if (answer.equalsIgnoreCase("q"))
				done = true;
			else
			{
				int myLong = Integer.parseInt(answer);
				long startTime = System.currentTimeMillis();
				long fibN = fibonacci(myLong);
				long endTime = System.currentTimeMillis();
				double elapsedTime = (endTime - startTime)/1000.0;
				System.out.print("Fibonacci(" + myLong + ") = " + fibN);
				System.out.println(" took " + elapsedTime + " seconds");
			}
		}
		System.out.println("Goodbye!");
		myScanner.close();
	}
	public static long fibonacci(long n)
	{
		if (n == 0)
			return 0;
		else if (n==1 || n==2)
			return 1;
		else
			return fibonacci(n-1)+fibonacci(n-2);//enter the code for the recursive case here
	}
}
