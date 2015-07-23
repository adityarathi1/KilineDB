/**
 * @author Aditya
 * @version 1.0
 * @last-modified 01-07-2015
 * 
 * All rights reserved.
 */

package com.lumiplan.Assignment;


import java.io.*;
import java.util.*;

/**
 * the queries class is created to write the queries to extract meaningful data
 *
 */

public class Queries {

	public static void main(String args[]) throws IOException
	{
		
		NetworkVersion nv = new NetworkVersion(2,"");
		
		System.out.println("Solution#1");
		nv.searchLines();
		
		System.out.println("Solution#2");
		for(int i=0; i<nv.getLines().size();i++)
		{
			nv.getLines().get(i).searchRoutes();
		}
		
		System.out.println("Solution#3");
		Route r = new Route(2,1,1);
		r.getStopAreas().get(0).searchStopPoints();

		
	}
	
}
		
		
		