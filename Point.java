/**
 * @author Aditya
 * @version 1.0
 * @last-modified 01-07-2015
 * 
 * All rights reserved.
 */

package com.lumiplan.Assignment;


public class Point {
	int pointId;	//stores the point id
	int xCoordinate;	//stores the x coordinate of the point
	int yCoordinate;	//stores the y coordinate of the point
	
/**
 * Constructor for Point
 * 
 * The constructor gets the data either from user or from the ReadFile.java
 * It dosen't allow 0 value to the pointID.
 * 
 * @param p_id
 * @param x
 * @param y
 */
	
	
	public Point(int p_id, int x, int y)
	{
		if(p_id !=0)
		{
			pointId = p_id;
			xCoordinate = x;
			yCoordinate = y;
		}
		else
		{
			System.err.println("INVALID POINT ID");
		}
	}
	
	

	
	/**
	 * @return	int		value of the pointID.
	 * */
	
	public int getPointId()
	{
		return pointId;
	}
	
	/**
	 * @return	int		value of the xCoordinate.
	 * */
	
	public int getXCoordinate()
	{
		return xCoordinate;
	}
	
	/**
	 * @return	int		value of the yCoordinate.
	 * */
	
	public int getYCoordinate()
	{
		return yCoordinate;
	}
	
	/**
	 * prints value of pointID, xCoordinate, yCoordinate in the console.
	 */
	
	public void display()
	{
		System.out.println(pointId +" "+ xCoordinate +" "+ yCoordinate);
	}
	
}
