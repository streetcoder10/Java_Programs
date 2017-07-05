/*
 * Author - Vikram Gopal
 * Description - Using getters and setters for manipulating employee information
 */

package Viky_Programs;

public class Employee 
{
	private String mName;
	private double mSalary;
	
	public Employee(String name,double salary)
	{
		mName=name;
		mSalary=salary;
	}

	public String getmName() 
	{
		return mName;
	}

	public void setmName(String mName) 
	{
		this.mName = mName;
	}

	public double getmSalary() 
	{
		return mSalary;
	}

	public void setmSalary(double mSalary) 
	{
		this.mSalary = mSalary;
	}
	
	public void raiseSalary(double byPercent)
	{
		mSalary = mSalary*(1+byPercent/100);
	}
	
	public String toString()
	{
		return "Name: "+getmName()+"\nSalary: "+getmSalary();
	}

}
