/*
 * Author - Vikram Gopal
 * Description - This is a runtime exception created manually to throw an exception
 * when requested amount of withdrawal exceed available balance.
 */

package Viky_Programs;

public class InsufficientFunds extends RuntimeException
{
	public InsufficientFunds()
    {
    }
    
    public InsufficientFunds(String msg)
    {
        super(msg);
    }
}
