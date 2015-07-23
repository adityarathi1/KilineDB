/**
 * @author Aditya
 * @version 1.0
 * @last-modified 01-07-2015
 * 
 * All rights reserved.
 */

package com.lumiplan.Assignment;

import java.util.*;
import java.io.*;

public class Line{
	private int networkVersionID;	//stores network version id
	private int lineID;				//stores line id
	private int lineTypeID;			//stores line type id
	private String publicLineName;	//stores public line name
	private String lineDescription;	//stores line description
	private List<Route> route = new ArrayList<Route>();	//Array list of type Route
	
	
	/**
	 * Constructor for Line
	 * 
	 * The constructor gets the data either from user or from the ReadFile.java
	 * It dosen't allow 0 value to the networkVersionID and lineID.
	 * 
	 * @param int,String 
	 * @param List<Route>
	 * 
	 * @see ReadFile.java
	 * 
	 */
	
	
	
	public Line(int n_id, int l_id, int lt_id, String pl_name, String ld)
	{
		if(l_id != 0 && n_id !=0)
		{
			this.networkVersionID = n_id;
			this.lineID = l_id;
			this.lineTypeID = lt_id;
			this.publicLineName = pl_name;
			this.lineDescription = ld;
		}
		else
		{
			System.err.println("INVALID LINE ID");
		}
	}
	
	/**
	 * 
	 * Constructor with limited parameters.
	 * 
	 * The constructor gets the data either from user or from the ReadFile.java
	 * 	
	 * 
	 * @param n_id
	 * @param l_id
	 * @param lt_id
	 * @param pl_name
	 */
	
	public Line(int n_id, int l_id, int lt_id, String pl_name)
	{
		this(n_id,l_id,lt_id,pl_name,"NA");
	}
	
	/**
	 *
	 * Constructor with limited parameters.
	 * 
	 *  The constructor gets the data either from user or from the ReadFile.java
	 *  
	 * @param n_id
	 * @param l_id
	 */
	public Line(int n_id, int l_id)
	{
		this(n_id,l_id,0,"NA","NA");
	}
	
	/**
	 * It takes lineId as an argument and checks the existence of the line.
	 * If the network is there in the data file then the function returns boolean value true, else false.
	 * 
	 * 
	 * @param l_id
	 * @return flag
	 * @throws IOException
	 */
	
	public boolean checkLineExistence(int l_id) throws IOException
	{
		ReadFile rf = new ReadFile();
		rf.readLineFile();
		int i=0;
		boolean flag = false;
		for(i=0;i<rf.ListForLineFile.size();i++)
		{
			if(l_id == rf.ListForLineFile.get(i).getLineID())
			{
				flag = true;
			}
		}
		return flag;
	}	
	
	/**
	 * It reads the Route data file and store the list of route objects into the local list i.e route.
	 * 
	 * @return route
	 * @throws IOException
	 */
	public List<Route> getRoutes()  throws IOException
	{
		ReadFile rf = new ReadFile();
		rf.readRouteFile();
		route = rf.ListForRouteFile;
		return route;
	}
	
	/**
	 * this function search and displays all the routes for the particular line
	 * 
	 * @throws IOException
	 */
	
	public void searchRoutes() throws IOException 
	{
		int count=0;
		int i=0;
		getRoutes();
		
		if(checkLineExistence(lineID) == true)
		{
			System.out.println("NetworkVersionID\t" + "LineID\t" + "RouteID\t");
			for(i=0;i<route.size();i++)
			{
				if(lineID == route.get(i).getLineID())
				{
					System.out.println(route.get(i).getNetworkVersionID() + "\t\t\t" + route.get(i).getLineID()
						+ "\t\t" + route.get(i).getRouteID());
					count++;
				}
			}
		
			System.out.println("total number of routes are : " + count);
	
		}
		else
		{
			System.out.println("Line does not exist");
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
	 * @return	int		value of the lineID.
	 * */
	
	public int getLineID()
	{
		return lineID;	
	}
	
	/**
	 * @return	int		value of lineTypeID
	 */
	
	
	public int getLineTypeID()
	{
		return lineTypeID;
	}
	
	/**
	 * 
	 * @return	String		value of publicLineName
	 */
	
	public String getPublicLineName()
	{
		return publicLineName;
	}
	
	/**
	 * 
	 * @return	String		value of lineDescription
	 */
	
	public String getLineDescription()
	{
		return lineDescription;
	}
	
	/**
	 * prints value of networkVersionID, lineID, lineTypeID, publicLineName, lineDescription in the console.
	 */
	
	public void display()
	{
		System.out.println(networkVersionID +" "+ lineID +" "+ lineTypeID + " " + 
					publicLineName + " " +lineDescription);
			
	}

	
}
