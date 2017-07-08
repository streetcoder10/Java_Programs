/*
 * Author - Vikram Gopal
 * Description - Insertion Sort method used to sort an array of elements.
 */

package Viky_Programs;

public class InsertionSort 
{
	public static void main(String [] args)
	{
		int [] myArray = {10,40,65,23,71,21,38,21,80,90,100,25};

		System.out.println("Original Array: ");
		for(int i=0;i<myArray.length;i++)
			System.out.print(myArray[i]+" ");

		insertionSort(myArray);

		System.out.println("\n\nSorted Array: ");
		for(int i=0;i<myArray.length;i++)
			System.out.print(myArray[i]+" ");
	}

	public static void insertionSort(int array[]) 
	{  
		int n = array.length;  
		for (int i = 1; i < n; i++) 
		{  
			int key = array[i];  
			int j = i-1;  

			while ( (j > -1) && ( array [j] > key ) ) 
			{  
				array [j+1] = array [j];  
				j--;  
			}  

			array[j+1] = key;  
		}  
	}  
}
