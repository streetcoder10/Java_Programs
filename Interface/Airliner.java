/*
 * Author - Vikram Gopal
 * Description - Class which implement the Autopilot Interface.
 */

package Viky_Programs;

public class Airliner 
{
	private double maxAltitude;
	private double airspeed=0;
	private double altitude=0;
	private double heading=0;
	
	public Airliner(double inMaxAltitude)
	{
		maxAltitude = inMaxAltitude;
	}
	public void setAirspeed(double inAirspeed)
	{
		airspeed = inAirspeed;
	}
	public void setAltitude(double inAltitude)
	{
		altitude = inAltitude;
	}
	public void setHeading(double inHeading)
	{
		heading=inHeading;
	}
}
