/**
 * @author Aditya
 * @version 1.0
 * @last-modified 01-07-2015
 * 
 * All rights reserved.
 */

package com.lumiplan.Assignment;

import java.io.IOException;
import java.util.*;


public class Link {
	private int linkID;					//stores link id
	private int firstPointID;				//stores first point of the link
	private int lastPointID;				//stores last point of the link
	private String linkDescription;		//stores the link description
	private String dateTime;			// stores date and time of the link creation
	private Point firstPoint;
	private Point lastPoint;
	private List<Point> point = new ArrayList<Point>(); //stores the list of objects of type Point

	private ReadFile rf = new ReadFile();
	
/**
 * Constructor for Line
 *  
 * The constructor gets the data either from user or from the ReadFile.java
 * It dosen't allow 0 value to the linkID.
 * 
 * @param l_id
 * @param fp_id
 * @param lp_id
 * @param ld
 * @param dt
 */

	public Link(int l_id, int fp_id, int lp_id, String ld, String dt)
	{
		if(l_id !=0)
		{
		linkID = l_id; 		
		firstPointID = fp_id; 	
		lastPointID = lp_id;
		linkDescription = ld;
		dateTime = dt;
		}
		else
		{
			System.err.println("INVALID LINK ID");
		}
	}
	
	/**
	 * Constructor with limited parameters.
	 * 
	 * The constructor gets the data either from user or from the ReadFile.java
	 * 
	 * @param l_id
	 * @param fp
	 * @param lp
	 */
	public Link(int l_id, int fp, int lp)
	{
		this(l_id,fp,lp,"NA","NA");
	}
	
	/**
	 * it gets the coordinate object for the particular point id and returns the same.
	 * 
	 * 
	 * @param p_id
	 * @return coordinates
	 * @throws IOException
	 */
	
	public Point getCoordinates(int p_id) throws IOException
	{
		int i=0;
		Point coordinates = null;
		rf.readPointFile();
	
		for(i=0;i<rf.ListForPointFile.size();i++)
		{
			if(p_id == rf.ListForPointFile.get(i).pointId)
			{
				coordinates = rf.ListForPointFile.get(i);
			}
		}
		return coordinates;
			
	}
	/**
	 * gets the object i.e. coordinates of the first point of the link.
	 *  
	 * @throws IOException
	 */
	public void setFirstPoint() throws IOException
	{
		firstPoint = getCoordinates(firstPointID);
	}
	/**
	 *  returns the object i.e. coordinates of the first point of the link.
	 * @return firstPoint
	 * @throws IOException
	 */
	
	public Point getFirstPoint() throws IOException
	{
		setFirstPoint();
		return firstPoint;
	}
	/**
	 * gets the object i.e. coordinates of the last point of the link.
	 *  
	 * @throws IOException
	 */
	public void setLastPoint() throws IOException
	{
		lastPoint = getCoordinates(lastPointID);
	}
	
	/**
	 * returns the object i.e. coordinates of the last point of the link.
	 * 
	 * @return lastPoint
	 * @throws IOException
	 */ 
	public Point getLastPoint() throws IOException
	{
		setLastPoint();
		return lastPoint;
	}
	
	/**
	 * get points for the particular link id
	 * 
	 * @param l_id
	 * @return point
	 * @throws IOException
	 */
	public List<Point> getPoints(int l_id) throws IOException
	{
		point = rf.readPointOnLinkFile(l_id);
		return point;
	}
	
/**
 * Displays the points for the particular link id
 * 
 * @throws IOException
 */
	public void showPoints() throws IOException 
	{
		int i=0;
		getPoints(linkID);
		System.out.println("From Route file : size " + point.size());
	
			for(i=0;i<point.size();i++)
			{
					System.out.println(point.get(i).getPointId() + "\t\t\t" + point.get(i).getXCoordinate()
						+ "\t\t" + point.get(i).getYCoordinate());
			}
		
	}
	
	/**
	 * @return	int		value of the linkID.
	 * */
	
	
	public int getLinkID()
	{
		return linkID;
	}
	
	/**
	 * @return	int		value of the firstPoint.
	 * */
	
	public int getFirstPointID()
	{
		return firstPointID;
	}
	
	/**
	 * @return	int		value of the lastPoint.
	 * */
	
	public int getLastPointID()
	{
		return lastPointID;
	}
	
	/**
	 * @return	String		value of the linkDescription.
	 * */
	
	public String getLinkDescription()
	{
		return linkDescription;
	}
	
	/**
	 * @return	String		value of the dateTime.
	 * */
	
	public String getDateTime()
	{
		return dateTime;
	}
	
	/**
	 * prints value of linkID, firstPoint, lastPoint, lineDescription, dateTime in the console.
	 */
	
	public void display()
	{
		System.out.println(linkID +" "+ firstPointID +" "+ lastPointID + " " + linkDescription + " " +dateTime);
	}
	
}
