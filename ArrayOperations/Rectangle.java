/*
 * Author - Vikram Gopal
 * Description - Class that calculates the perimeter of a rectangle
 * and using the compareto method to sort the array of rectangles based on perimeter.
 */

package Viky_Programs;

public class Rectangle implements Comparable<Rectangle> 
{
	private double length,width;

	public Rectangle(double length, double width)
	{
		this.length=length;
		this.width=width;
	}
  
	public double findPerimeter()
	{
		return 2*(this.length+this.width);
	}
  
	public int compareTo (Rectangle other)
	{
		if(this.findPerimeter()==other.findPerimeter())
			return 0;
		else if(this.findPerimeter()>other.findPerimeter())
			return 1;
		else
			return -1;
	}
  
	public String toString()
	{
		return "\n"+"Perimeter: "+findPerimeter()+"  Length: "+length+"  Width: "+width+"\n";
	}

}
