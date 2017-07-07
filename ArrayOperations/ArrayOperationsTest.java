/*
 * Author - Vikram Gopal
 * Description - Test class to find minimum and maximum values in the array,
 * find the largest and smallest rectangle and 
 * Sort the array of values using selection sort method 
 * sort array of rectangles based on perimeter value using compareto method.
 * Values are hard coded but can be recevied as user input using Scanner class.
 */

package Viky_Programs;

import java.util.Arrays;

public class ArrayOperationsTest 
{
	public static void main (String [] args)
	{
		Double [] anArray = {6.7,8.4,1.1,2.3,5.67,12.2,0.45};
		ArrayOperations<Double> myArray = new ArrayOperations<Double>(anArray);
		System.out.println("The Largest Double is: "+myArray.findMax());
		System.out.println("The Smallest Double is: "+myArray.findMin());

		Rectangle[] rect = new Rectangle[4];
		rect[0]=new Rectangle(2, 4);
		rect[1]=new Rectangle(10, 20);
		rect[2]=new Rectangle(2, 3);
		rect[3]=new Rectangle(1, 1);

		ArrayOperations<Rectangle> rectArray = new ArrayOperations<Rectangle>(rect);

		System.out.println("\nThe largest rectangle is: "+rectArray.findMax());
		System.out.println("The smallest rectanlge is: "+rectArray.findMin());
		System.out.println();

		selectionSort(anArray);
		System.out.println("The sorted Array is: ");
		for(int i=0;i<anArray.length;i++)
			System.out.print(+anArray[i]+" ");
		System.out.println();

		Arrays.sort(rect);
		System.out.println("\nThe sorted Array of rectangles is: ");
		for(int i=0;i<rect.length;i++)
			System.out.print(rect[i]+" ");
	}

	public static void selectionSort(Double [] myArray)
	{
		double n= myArray.length;
		for(int i=0;i<n-1;i++)
		{
			int minIndex = i;

			for(int j=i+1;j<=n-1;j++)
			{
				if(myArray[j]<myArray[minIndex])
					minIndex=j;
			}
      
			double temp = myArray[i];
			myArray[i]=myArray[minIndex];
			myArray[minIndex]=temp;
		}
	}
  
}
