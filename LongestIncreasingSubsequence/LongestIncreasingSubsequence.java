/*
 * Author - Vikram Gopal
 * Description - Program to find the length of the longest subsequence in a give array of 
 * integers such that all elements in the subsequence are sorted in 
 * ascending order.
 */

package Viky_Programs;

public class LongestIncreasingSubsequence 
{
	public void longestSub(int[] a) 
	{
		int[] longest = new int[a.length];
		longest[0]=1;
		
		for (int k = 0; k < a.length; k++) 
		{
			int max = -1;
			for (int i = 0; i < k; i++) 
			{	
				if (a[k] > a[i]) 
				{
					if (max == -1 || max < longest[i] + 1) 
					{
						max = 1 + longest[i];
					}
				}
			}
			if (max == -1) 
			{
				max = 1;
			}
			longest[k] = max;
		}

		int LIS = -1;
		int index = -1;
		for (int j = 0; j < longest.length; j++) {
			if (LIS < longest[j]) 
			{
				LIS = longest[j];
				index = j;
			}
		}

		String sequence =  a[index] + " ";
		int res = LIS-1;
		
		for (int i = index-1; i >= 0; i--) 
		{
			if(longest[i]==res)
			{
				sequence =  a[i] + " " + sequence;
				res--;
			}			
		}
		
		System.out.println("Longest Increasing subsequence: "  +LIS);
		System.out.println("Sequence is: " + "{ "+sequence+"}");

	}
}
