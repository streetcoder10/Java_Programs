/*
 * Author - Vikram Gopal
 * Description - Selection Sort method used to sort an array of elements.
 */

package Viky_Programs;

public class SelectionSort 
{
	public static void main(String [] args)
	{
		int [] myArray = {10,40,65,23,71,21,38,21,80,90,100,25};

		System.out.println("Original Array: ");
		for(int i=0;i<myArray.length;i++)
			System.out.print(myArray[i]+" ");

		selectionSort(myArray);
		System.out.println();
		System.out.println();

		System.out.println("Sorted Array: ");
		for(int i=0;i<myArray.length;i++)
			System.out.print(myArray[i]+" ");
	}

	public static void selectionSort(int[] myArray)
	{
		int n= myArray.length;
		for(int i=0;i<n-1;i++)
		{
			int minIndex = i;

			for(int j=i+1;j<=n-1;j++)
			{
				if(myArray[j]<myArray[minIndex])
					minIndex=j;
			}
			int temp = myArray[i];
			myArray[i]=myArray[minIndex];
			myArray[minIndex]=temp;
		}
	}

}
