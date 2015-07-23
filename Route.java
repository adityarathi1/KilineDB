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

public class Route {
	private int networkVersionID;
	private int lineID;
	private int routeID;
	private List<Link> link = new ArrayList<Link>();
	private List<StopArea> sar = new ArrayList<StopArea>();
	private ReadFile rf = new ReadFile();

	/**
	 *Constructor for Route
	 * 
	 * The constructor gets the data either from user or from the ReadFile.java
	 * It dosen't allow 0 value to the networkVersionID, routeID and lineID.
	 * 
	 * @param n_id
	 * @param l_id
	 * @param r_id
	 */
	public Route(int n_id, int l_id,int r_id)
	{
		if(r_id!=0 && n_id!=0 && l_id!=0)
		{
			networkVersionID = n_id;
			lineID = l_id;
			routeID = r_id;
		}
		else
		{
			System.err.println("INVALID ROUTE ID");
		}
		
	}
	
	
	
	
/**
 *this function get the links for the particular network, line and route.
 *
 * @param n_id
 * @param l_id
 * @param r_id
 * @return link
 * @throws IOException
 */
	
	
	public List<Link> getLinks(int n_id, int l_id, int r_id) throws IOException
	{
		link = rf.readLinkOnRouteFile(n_id,l_id,r_id);
		return link;
	}
	
	/**
	 * it displays the links for the particular network,line and route.
	 * 
	 * @throws IOException
	 */

	public void showLinks() throws IOException 
	{
		int i=0;
		getLinks(networkVersionID, lineID,routeID);
		System.out.println("From Route file : size " + link.size());
	
			for(i=0;i<link.size();i++)
			{
				
					System.out.println(link.get(i).getLinkID() + "\t\t\t" + link.get(i).getLinkDescription()
						+ "\t\t" + link.get(i).getDateTime() + "\t" +link.get(i).getFirstPoint()
						+ "\t\t" +link.get(i).getLastPoint());
					
				
			}
		
	}
		
	/**
	 * this function gets the list of stop areas for the particular network,line and route.
	 * 
	 * @param n_id
	 * @param l_id
	 * @param r_id
	 * @return sar
	 * @throws IOException
	 */
	public List<StopArea> getStopAreas() throws IOException
	{
		sar = rf.readSarOnRouteFile(networkVersionID, lineID, routeID);
		return sar;
	}
	
	/**
	 * it displays the stop areas for the particular network,line and route.
	 * @throws IOException
	 */

	public void showStopAreas() throws IOException 
	{
		int i=0;
		getStopAreas();
		System.out.println("From Route file : size " + sar.size());
	
			for(i=0;i<sar.size();i++)
			{
					System.out.println(sar.get(i).getNetworkVersionID() + "\t\t\t" + sar.get(i).getStopAreaID()
						+ "\t\t" + sar.get(i).getStopAreaName() + "\t" +sar.get(i).getPrinciple());
			}
		
	}
	

	/**
	 * It takes routeId as an argument and checks the existence of the route.
	 * If the route is there in the data file then the function returns boolean value true, else false.
	 * 
	 * @param r_id
	 * @return flag
	 * @throws IOException
	 */
	
	public boolean checkRouteExistence(int r_id) throws IOException
	{
		ReadFile rf = new ReadFile();
		rf.readRouteFile();
		int i=0;
		boolean flag = false;
		for(i=0;i<rf.ListForRouteFile.size();i++)
		{
			if(r_id == rf.ListForRouteFile.get(i).getNetworkVersionID())
			{
				flag = true;
			}
		}
		return flag;
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
	 * @return	String		value of the routeDescription.
	 * */
	
	public int getRouteID()
	{
		return routeID;
	}
	
	/**
	 * prints value of networkVersionID, lineID, routeDescription in the console.
	 */
	
	public void display()
	{
		System.out.println(networkVersionID +" "+ lineID +" "+ routeID);
	}
}
