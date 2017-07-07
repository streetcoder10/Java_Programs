/*
 * Author - Vikram Gopal
 * Description - Class containing methods to find minimum and maximum values in arrays
 * using the comparable interface.
 */

package Viky_Programs;

public class ArrayOperations <E extends Comparable> 
{
	private E[] data;

	private int length;

	public ArrayOperations(E[] data)
	{
		this.length=data.length;
		this.data=data;
	}
	
	public E findMax()
	{
		E max = data[0];
		for(int i=0;i<data.length;i++)
		{
			if(data[i].compareTo(max)>0)
				max=data[i];
		}
		return max;
	}

	public E findMin()
	{
		E min = data[0];
		for(int i=0;i<data.length;i++)
		{
			if(data[i].compareTo(min)<0)
				min=data[i];
		}
		return min;
	}
  
}
