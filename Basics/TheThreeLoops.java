/*
 * Author - Vikram Gopal.
 * Title - Class to demostrate the working of FOR,WHILE and DO WHILE loops.
 */

package Viky_Programs;

public class TheThreeLoops 
{
	public static void main(String [] args)
	{
		//FOR LOOP
		
		int sum=0;
		
		for(int i=0;i<6;i++)
		{
			sum = sum+i;
		}
		System.out.println("The sum of numbers from 1-5:  "+sum);
		
		//WHILE LOOP

		int sum1=0;
		int k=0;
		
		while(k<11)
		{
			sum1=sum1+k;
			k++;
		}
		System.out.println("The sum of numbers from 1-10: "+sum1);
		
		//DO WHILE LOOP
		
		int sum2=0;
		int n=0;
		
		do{
			sum2=sum2+n;
			n++;
		}while(n<16);
		System.out.println("The sum of numbers from 1-15: "+sum2);
		
	}
}
