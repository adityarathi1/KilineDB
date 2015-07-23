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

public class StopArea {
	private int networkVersionID;
	private int stopAreaID;
	private String stopAreaName;
	private int principle;
	private List<StopPoint> stopPoint = new ArrayList<StopPoint>();
	
	/**
	 * The constructor gets the data either from user or from the ReadFile.java
	 * It dosen't allow 0 value to the stopAreaID.
	 * 
	 * @param n_id
	 * @param sa_id
	 * @param sa_name
	 * @param p
	 */
	
	public StopArea(int n_id, int sa_id,String sa_name,int p)
	{
		if(sa_id != 0 )
		{
			networkVersionID = n_id;
			stopAreaID = sa_id;
			stopAreaName = sa_name;
			principle = p;
		}
		else
		{
			System.err.println("INVALID STOPAREA ID");
		}
	}
	
	/**
	 * Constructor with limited parameters.
	 * 
	 * The constructor gets the data either from user or from the ReadFile.java
	 * 
	 * @param n_id
	 * @param sa_id
	 * @param sa_name
	 */
	public StopArea(int n_id, int sa_id,String sa_name)
	{
		this(n_id,sa_id,sa_name,0);
	}
	
	/**
	 * takes the input of stop area id and checks its existence.
	 * 
	 * @param sa_id
	 * @return
	 * @throws IOException
	 */
	public boolean checkStopAreaExistence(int sa_id) throws IOException
	{
		ReadFile rf = new ReadFile();
		rf.readStopAreaFile();
		int i=0;
		boolean flag = false;
		for(i=0;i<rf.ListForStopAreaFile.size();i++)
		{
			if(sa_id == rf.ListForStopAreaFile.get(i).getStopAreaID())
			{
				flag = true;
			}
		}
		return flag;
	}	
	
	/**
	 * gets the stop point from the ReadFile.java class
	 * 
	 * @return stopPoint
	 * @throws IOException
	 */
	public List<StopPoint> getStopPoints()  throws IOException
	{
		ReadFile rf = new ReadFile();
		rf.readStopPointFile();
		stopPoint = rf.ListForStopPointFile;
		return stopPoint;
	}
	
	/**
	 * search and displays the stop points for the particular stop area.
	 * 
	 * 
	 * @throws IOException
	 */
	public void searchStopPoints() throws IOException 
	{
		int count=0;
		int i=0;
		getStopPoints();
		
		if(checkStopAreaExistence(stopAreaID) == true)
		{
		
			for(i=0;i<stopPoint.size();i++)
			{
				if(stopAreaID == stopPoint.get(i).getStopAreaID())
				{
					System.out.println(stopPoint.get(i).getNetworkVersionID() + "\t\t\t" + stopPoint.get(i).getStopPointID()
						+ "\t\t" + stopPoint.get(i).getStopAreaID() + "\t" +stopPoint.get(i).getDetectionAreaID()
						+ "\t\t" +stopPoint.get(i).getPointID() + "\t" + stopPoint.get(i).getStopAreaDescription());
					count++;
				}
			}
		
			System.out.println("total number of Stop Points are : " + count);
	
		}
		else
		{
			System.out.println("Stop Area does not exist");
		}
	}

	/**
	 * @return	int		value of the networkVersionID.
	 * */
	
	public int getNetworkVersionID()
	{
		return networkVersionID;
	}
	
	/**
	 * @return	int		value of the stopAreaID.
	 * */
	
	public int getStopAreaID()
	{
		return stopAreaID;
	}
	
	/**
	 * @return	String		value of the stopAreaName.
	 * */
	
	public String getStopAreaName()
	{
		return stopAreaName;
	}
	
	/**
	 * @return	int		value of the principle.
	 * */
	
	public int getPrinciple()
	{
		return principle;
	}
	
	/**
	 * prints value of networkVersionID, stopAreaID, stopAreaName, principle in the console.
	 */
	
	public void display()
	{
		System.out.println(networkVersionID +" "+ stopAreaID +" "+ stopAreaName + " " + principle);
	}
}
