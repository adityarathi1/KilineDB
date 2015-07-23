/**
 * @author Aditya
 * @version 1.0
 * @last-modified 01-07-2015
 * 
 * All rights reserved.
 */

package com.lumiplan.Assignment;


public class StopPoint extends Point{
	int networkVersionID;
	int stopPointID;
	int stopAreaID;
	int detectionAreaID;
	int pointID;
	String stopAreaDescription;
	
	
	/**
	 * Constructor for Line
	 * 
	 * String sp[] holds the data for all the properties of the class Line
	 * @param string 
	 * 
	 * @see ReadFile.java
	 * 
	 */
	
	public StopPoint(String sp[]) 
	{	
		super(1,1,1);
		networkVersionID = Integer.parseInt(sp[0]);
		stopPointID = Integer.parseInt(sp[1]);
		stopAreaID = Integer.parseInt(sp[2]);
		detectionAreaID = Integer.parseInt(sp[3]);
		pointID = Integer.parseInt(sp[4]);
		stopAreaDescription = sp[5];
	}
	
	
	
	/**
	 * @return	int		value of the networkVersionID.
	 * */
	
	public int getNetworkVersionID()
	{
		return networkVersionID;
	}
	
	/**
	 * @return	int		value of the stopPointID.
	 * */
	
	public int getStopPointID()
	{
		return stopPointID;
	}
	
	/**
	 * @return	int		value of the stopAreaID.
	 * */
	
	public int getStopAreaID()
	{
		return stopAreaID;
	} 
	
	/**
	 * @return	int		value of the detectionAreaID.
	 * */
	
	public int getDetectionAreaID()
	{
		return detectionAreaID;
	} 
	
	/**
	 * @return	int		value of the pointID.
	 * */
	
	public int getPointID()
	{
		return pointID;
	} 
	
	/**
	 * @return	String 	value of the stopAreaDescription.
	 * */
	
	public String getStopAreaDescription()
	{
		return stopAreaDescription;
	}
	
	
	/**
	 * prints value of networkVersionID, stopPointID, stopAreaID, detectionAreaID,
	 * 									pointID, stopAreaDescription in the console.
	 */
	
	public void display()
	{
		System.out.println(networkVersionID +" "+ stopPointID +" "+ stopAreaID + " " + 
								detectionAreaID + " " + pointID + " " + stopAreaDescription);
	}
}
