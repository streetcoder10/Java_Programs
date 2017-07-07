/*
 * Author - Vikram Gopal
 * Description - Bubble Sort method used to sort an array of elements.
 */

package Viky_Programs;

public class BubbleSort 
{
	public static void main(String [] args)
	{
		int [] myArray = {10,40,65,23,71,21,38,21,80,90,100,25};

		System.out.println("Original Array: ");
		for(int i=0;i<myArray.length;i++)
			System.out.print(myArray[i]+" ");

		bubbleSort(myArray);

		System.out.println("\n\nSorted Array: ");
		for(int i=0;i<myArray.length;i++)
			System.out.print(myArray[i]+" ");
	}

	public static void bubbleSort(int [] myArray)
	{
		int n = myArray.length;  
		int temp = 0;  

		for(int i=0; i < n; i++){  
			for(int j=1; j < (n-i); j++)
			{  
				if(myArray[j-1] > myArray[j])
				{    
					temp = myArray[j-1];  
					myArray[j-1] = myArray[j];  
					myArray[j] = temp;  
				}  

			}  
		}  
	}
}
