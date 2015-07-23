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

public class NetworkVersion {
	private int networkVersionID;
	private String networkVersionName;
	private String validityBeginDate;
	private String validityEndDate;
	private List<Line> line = new ArrayList<Line>();
	
	/**
	 * Constructor for Line
	 * 
	 * The constructor gets the data either from user or from the ReadFile.java
	 * It dosen't allow 0 value to the networkVersionID.
	 * 
	 * @param int
	 * @param String
	 * @param String
	 * @param String
	 * 
	 * @see ReadFile.java
	 * 
	 */
	
	public NetworkVersion(int n_id, String n_name, String b_date, String e_date)
	{
		if(n_id != 0)
		{
			this.networkVersionID = n_id;
			this.networkVersionName = n_name;
			this.validityBeginDate = b_date;
			this.validityEndDate = e_date;
		}
		else
		{
			System.err.println("INVALID NETWORK VERSION ID");
		}
	}
	
	/**
	 * Constructor with limited parameters.
	 * 
	 *  The constructor gets the data either from user or from the ReadFile.java
	 * 	
	 * 
	 * @param n_id
	 * @param n_name
	 */
	public NetworkVersion(int n_id,String n_name)
	{
		this(n_id,n_name,"NA","NA");
	}
	
	
	/**
	 * It takes networkVersionId as an argument and checks the existence of the network.
	 * If the network is there in the data file then the function returns boolean value true, else false.
	 * 
	 * 
	 * @param n_id
	 * @return flag
	 * @throws IOException
	 */
	
	public boolean checkNetworkExistence(int n_id) throws IOException
	{
		ReadFile rf = new ReadFile();
		rf.readNetworkVersionFile();
		int i=0;
		boolean flag = false;
		for(i=0;i<rf.ListForNetworkVersionFile.size();i++)
		{
			if(n_id == rf.ListForNetworkVersionFile.get(i).getNetworkVersionID())
			{
				flag = true;
			}
		}
		return flag;
	}	
	
	/**
	 * It reads the Line data file and store the list of line objects into the local list i.e line.
	 * 
	 * @return line
	 * @throws IOException
	 */
	
	public List<Line> getLines()  throws IOException
	{
		ReadFile rf = new ReadFile();
		rf.readLineFile();
		line = rf.ListForLineFile;
		return line;
	}
	
	/**
	 * this function search and displays all the line for the particular network
	 * 
	 * @throws IOException
	 */
	
	public void searchLines() throws IOException 
	{
		int count=0;
		int i=0;
		getLines();
		
		if(checkNetworkExistence(networkVersionID) == true)
		{
			System.out.println("NetworkVersionID\t" + "LineID\t" + "LineTypeID\t" + "LineDescription\t" + "PublicLineName\t");
			for(i=0;i<line.size();i++)
			{
				if(networkVersionID == line.get(i).getNetworkVersionID())
				{
					System.out.println(line.get(i).getNetworkVersionID() + "\t\t\t" + line.get(i).getLineID()
						+ "\t\t" + line.get(i).getLineTypeID() + "\t" +line.get(i).getLineDescription()
						+ "\t\t" +line.get(i).getPublicLineName());
					count++;
				}
			}
		
			System.out.println("total number of Lines are : " + count);
	
		}
		else
		{
			System.out.println("Network does not exist");
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
	 * @return	String	value of the networkVersionName.
	 * */
	
	public String getNetworkVersionName()
	{
		return networkVersionName;
	}
	
	/**
	 * @return	String		value of the validityBeginDate.
	 * */
	
	public String getValidityBeginDate()
	{
		return validityBeginDate;
	}
	
	/**
	 * @return	String		value of the validityEndDate.
	 * */
	
	public String getValidityEndDate()
	{
		return validityEndDate;
	}
	
	/**
	 * prints value of networkVersionID, networkVersionName, validityBeginDate, validityEndDate in the console.
	 */
	
	public void display()
	{	
		System.out.println(networkVersionID +" "+ networkVersionName +" "+ validityBeginDate + " " + validityEndDate );
	}
}
