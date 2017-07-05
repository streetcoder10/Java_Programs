/*
 * Author - Vikram Gopal.
 * Title - Class to calculate Volume and Surface Area of a Soda Can
 */

package Viky_Programs;

public class SodaCan 
{
	private double mRadius;
	private double mHeight;
	
	public SodaCan(double radius,double height)
	{
		mRadius=radius;
		mHeight=height;
	}
	
	public double findVolume()
	{
		double volume = (2*Math.PI*mRadius*mHeight)+(2*Math.PI*mRadius*mRadius);
		
		return volume;			
	}
	
	public double findSurfaceArea()
	{
		double surfacearea = (Math.PI*mRadius*mRadius*mHeight);
		
		return surfacearea;
	}
  
}
