/*
 * Author - Vikram Gopal
 * Description - Using nested for loops to display a Checker Board
 */

package Viky_Programs;

public class NestedForLoop 
{
	public static void main(String [] args)
	{
		int row;
		int column;
		
		System.out.println("This is a checkerboard!");
		
		for(row=0;row<8;row++)
		{
			for(column=0;column<8;column++)
			{
				if((row+column)%2==0)
					System.out.print(" X ");
				else
					System.out.print(" _ ");
			}
			
			System.out.println();
		}
	}
}
