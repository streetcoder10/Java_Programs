/*
 * Author - Vikram Gopal
 * Description - Classic knapsack problem.
 */
package Viky_Programs;

public class Knapsack
{
	public boolean[][] KnapSack(int[] val, int[] wt, int W) 
	{
		int N = val.length;
		int[][] knapSackTable = new int[N + 1][W + 1];
		boolean[][] V = new boolean[N][W + 1];

		for (int i = 1; i <= N; i++) 
		{
			for (int w = 1; w <= W; w++) 
			{
				if (wt[i - 1] > w) 
				{
					knapSackTable[i][w] = knapSackTable[i - 1][w];
				} 
				else 
				{
					int p1 = val[i - 1] + knapSackTable[i - 1][w - wt[i - 1]];
					int p2 = knapSackTable[i - 1][w];
					if (p1 > p2)
					{
						V[i - 1][w] = true;
						knapSackTable[i][w] = p1;
					} 
					else 
					{
						knapSackTable[i][w] = p2;
					}
				}
			}
		}
		return V;
	}

	public void printSelectedItems(boolean[][] V, int W, int[] val, int[] wt) 
	{
		System.out.println("Maximum weight was " + W);
		System.out.println("\nSelected items:");
		int K = W;
		int n = val.length;
		int wt1 = 0;
		int val1 = 0;

		for (int i = n - 1; i >= 0; i--) 
		{ 
			if (V[i][K] == true) 
			{
				System.out.println("Item:"+i + "\tValue=" + val[i] + "\tWeight=" + wt[i]);
				wt1 += wt[i];
				val1 += val[i];
				K = K - wt[i];
			}
		}
    
		System.out.println();
		System.out.println("Maximum value obtained is:  " + val1 );
		System.out.println("Combined weight of selected items is: " + wt1);
	}
}
