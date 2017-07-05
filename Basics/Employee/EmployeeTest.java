/*
 * Author - Vikram Gopal
 * Description - Test class for the Employee CLass
 */

package Viky_Programs;

public class EmployeeTest 
{
	public static void main(String [] args)
	{
		Employee employee = new Employee("Vikram",65000);
		
		System.out.println(employee.toString());
		
		employee.setmName("Arjun");
		employee.raiseSalary(10.0);
		
		System.out.println("Updating salary...");
		
		System.out.println(employee.toString());
		
	}
}
