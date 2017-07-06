/*
 * Author - Vikram Gopal
 * Description - Test class for the Knapsack Program
 * Input is hard coded but user can also be prompted for input using the Scanner class.
 */

package Viky_Programs;

public class KnapsackTest 
{	
	public static void main(String[] args) 
	{
		int[] val = {10,40,30,50,25,80};  
		int[] wt = {5,4,6,3,10,2,9};

		int W = 10;

		Knapsack knapsack = new Knapsack();

		boolean[][] V = knapsack.KnapSack(val, wt, W);
		knapsack.printSelectedItems(V, W, val, wt);
	}
}
