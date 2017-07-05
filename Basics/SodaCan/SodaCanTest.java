/*
 * Author - Vikram Gopal.
 * Title - Test class for the Soda Can Program
 */

package Viky_Programs;

import java.util.Scanner;

public class SodaCanTest 
{
	public static void main(String [] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter radius: ");
		double radius = Double.parseDouble(scanner.nextLine());
		System.out.println("Enter height: ");
		double height = Double.parseDouble(scanner.nextLine());
		
		SodaCan sodacan = new SodaCan(radius,height);
		System.out.printf("The Volume is: %6.3f\n",sodacan.findVolume());
		System.out.printf("The Surface Area is: %6.3f\n",sodacan.findSurfaceArea());
		
		scanner.close();
	}
}
