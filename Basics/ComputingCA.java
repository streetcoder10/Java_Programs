/*
 * Author - Vikram Gopal.
 * Title - Computing the Circumference and Area of a circle.
 */

package Viky_Programs;

public class ComputingCA 
{
	public static void main (String [] args)
	{
		double radius =4.5;
		double circumference;
		double area;
		
		circumference = 2*Math.PI*radius;
		
		area = Math.PI*radius*radius;
		
		System.out.println("The radius of the circle: "+radius);
		System.out.printf("Circumference of the circle: %6.3f\n",circumference);
		System.out.printf("Area of the circle is: %6.3f\n",area);
	}
}
