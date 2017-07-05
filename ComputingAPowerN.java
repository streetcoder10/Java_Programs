/*
 * Author - Vikram Gopal
 * Description - Using recursive algorithm to compute the 
 * value of a to the power n, where 'a' is any number and n>=0.
 */

package Viky_Programs;

import java.util.Scanner;


public class ComputingAPowerN 
{
	public static void main(String [] args)
	{
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Enter the value of a:  ");
		double a = Double.parseDouble(myScanner.nextLine());
		System.out.println("Enter value of n:  ");
		double n = Double.parseDouble(myScanner.nextLine());
		double aN = aPowerN(a,n);

		System.out.println("a^n is:  " + aN);

		myScanner.close();
	}

	public static double aPowerN(double a, double n)
	{
		if(n==0)
			return 1;
		else if(n%2==0)
		{
			double x = Math.pow(a, n/2);
			return x*x;
		}
		else
			return a*Math.pow(a, n-1);
	}
}
