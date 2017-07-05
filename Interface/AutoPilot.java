/*
 * Author - Vikram Gopal
 * Description - Interface to ensure programmers who implement the airliner class
 * include essential functions of an autopilot.
 */

package Viky_Programs;

public interface AutoPilot 
{
	final double MAX_AIRSPEED = 550;

	public void setAirspeed(double inAirspeed);
	public void setAltitude(double inAltitude);
	public void setHeading(double inHeading);

}
