/*
 * Author - Vikram Gopal
 * Description - Test class for Longest Increasing Subsequence Program
 * Input is hard coded but can be prompted from the user using Scanner class.
 */

package Viky_Programs;

public class LISTest 
{
	public static void main(String[] args) 
	{
		int[] A = { 56,43,71,90,101,204,35,64,70};
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		lis.longestSub(A);
	}
}
