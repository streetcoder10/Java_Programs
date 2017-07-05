/*
 * Author - Vikram Gopal	
 * Title - Using If Else statements to provide coupons.
 */

package Viky_Programs;

import java.util.Scanner;

public class IfElseStatements 
{
	public static void main(String [] args)
	{
		double myCost;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter total cost of purchase: ");
		myCost = scanner.nextDouble();
		
		double discount =0;
		
		if(myCost<10)
			discount=0;
		else if(myCost>10 && myCost<60)
			discount=8;
		else if(myCost>60 && myCost<150)
			discount=10;
		else
			discount=14;
		
		System.out.println("Total cost of purchase: "+myCost);
		System.out.printf("You have recieved a coupon for: $%6.2f\n",myCost*(discount/100));
		
		scanner.close();
	}
}
