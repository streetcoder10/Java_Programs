/*
 * Author - Vikram Gopal
 * Description - Class to create and use arrays.
 */

package Viky_Programs;

public class Arrays 
{
	public static void main(String [] args)
	{
		int [] myArray = {3,7,13,18,21};

		for(int i=0;i<myArray.length;i++)
		{
			System.out.println(myArray[i]+" squared is: "+myArray[i]*myArray[i]);

			if(myArray[i]<10)
				System.out.println(myArray[i]+" is less than 10");
			else if(myArray[i]>10 && myArray[i]<20)
				System.out.println(myArray[i]+" is greater than 10 but less than 20");
			else
				System.out.println(myArray[i]+" is greater than 20");
		}
    
	}
}
