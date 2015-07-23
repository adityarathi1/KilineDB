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
 *Class ReadFile reads the data from all the input files.
 */

public class ReadFile {
	List<Line> ListForLineFile = new ArrayList<Line>();
	List<Link> ListForLinkFile = new ArrayList<Link>();
	List<NetworkVersion> ListForNetworkVersionFile = new ArrayList<NetworkVersion>();
	List<Point> ListForPointFile = new ArrayList<Point>();
	List<Route> ListForRouteFile = new ArrayList<Route>();
	List<StopArea> ListForStopAreaFile = new ArrayList<StopArea>();
	List<StopPoint> ListForStopPointFile = new ArrayList<StopPoint>();
	int i=0;
	
	/**
	 * readLineFile() reads the data from the line.dat input file 
	 * and pass the list of objects to the Line class.
	 * 
	 * @return List<Line>
	 * @throws IOException
	 */
	
	public void readLineFile() throws IOException
	{
		String location = "C:/Eclipse workspace/Solution#1_AdityaRathi/line.dat"; //variable location stores the location of the input file.
		Scanner scan = new Scanner(new File(location)); //creates the scanner object for line.dat file
		readRouteFile();
		i=0;
		
		try{
			while(scan.hasNextLine())					//while loop runs until file has next line
			{
				String newLine = scan.nextLine();		//scans the next line
				String[] col = newLine.split("\\|");	//splits the data separated by "|" and stores it in the String array 
				Line l = new Line(Integer.parseInt(col[0]),Integer.parseInt(col[1]),Integer.parseInt(col[2]),col[3],col[4]);
				ListForLineFile.add(i,l);				//adds the Line object to list of same type
				i++;
			}
		}
		
		finally
		{
			scan.close();								//closes the scanner object.
		}
		
		
	}
	
	/**
	 * readLinkFile() reads the data from the link.dat input file 
	 * and pass the list of objects to the Link class.
	 * 
	 * @return List<Link>
	 * @throws IOException
	 */
	
	
	public void readLinkFile() throws IOException
	{
		String location = "C:/Eclipse workspace/Solution#1_AdityaRathi/link.dat";	 //variable location stores the location of the input file.
		Scanner scan = new Scanner(new File(location));		//creates the scanner object for link.dat file
		readPointFile();
		i=0;
		
		try{
			while(scan.hasNextLine())						//while loop runs until file has next line
			{
				
				String newLine = scan.nextLine();			//scans the next line
				String[] col = newLine.split("\\|");		//splits the data separated by "|" and stores it in the String array
				Link l = new Link(Integer.parseInt(col[0]),Integer.parseInt(col[1]),Integer.parseInt(col[2]),col[3],col[4]);						//calls the object of type Link
				ListForLinkFile.add(i,l);					//adds the Link object to list of same type
				i++;	
			}
		}
		
		finally
		{
			scan.close();									//closes the scanner object.
		}
		
	
	}
	
	
	
	/**
	 * readNetworkVersionFile() reads the data from the network_vrsn.dat input file 
	 * and pass the list of objects to the NetworkVersion class.
	 * 
	 * @return List<NetworkVersion>
	 * @throws IOException
	 */
	
	
	public void readNetworkVersionFile() throws IOException
	{
		String location = "C:/Eclipse workspace/Solution#1_AdityaRathi/network_vrsn.dat";
		Scanner scan = new Scanner(new File(location));
		readLineFile();
		i=0;
		
		try{
			while(scan.hasNextLine())
			{
				String newLine = scan.nextLine();
				String[] col = newLine.split("\\|");
				NetworkVersion nv = new NetworkVersion(Integer.parseInt(col[0]),col[1],col[2],col[3]);
				ListForNetworkVersionFile.add(i,nv);
				i++;
			}
			
		}	
		
		finally
		{
			scan.close();
		}		
		
		
	}
	
	/**
	 * readPointFile() reads the data from the point.dat input file 
	 * and pass the list of objects to the Point class.
	 * 
	 * @return List<Point>
	 * @throws IOException
	 */
	
	
	public void readPointFile() throws IOException
	{
		String location = "C:/Eclipse workspace/Solution#1_AdityaRathi/point.dat";
		Scanner scan = new Scanner(new File(location));
		i=0;
		try{
			while(scan.hasNextLine())
			{
				String newLine = scan.nextLine();
				String[] col = newLine.split("\\|");
				Point p = new Point(Integer.parseInt(col[0]),Integer.parseInt(col[1]),Integer.parseInt(col[2]));
				ListForPointFile.add(i,p);
				i++;
				
			}
			
		}	
		
		finally
		{
			scan.close();
		}

		
	}

	
	
	/**
	 * readRouteFile() reads the data from the route.dat input file 
	 * and pass the list of objects to the Route class.
	 * 
	 * @return List<Route>
	 * @throws IOException
	 */
	
	
	public void readRouteFile() throws IOException
	{
		String location = "C:/Eclipse workspace/Solution#1_AdityaRathi/route.dat";
		Scanner scan = new Scanner(new File(location));
		i=0;
		
		try{
			while(scan.hasNextLine())
			{
				String newLine = scan.nextLine();
				String[] col = newLine.split("\\|");
				Route r = new Route(Integer.parseInt(col[0]),Integer.parseInt(col[1]),Integer.parseInt(col[2]));
				ListForRouteFile.add(i,r);
				i++;
			}
		}	
		
		finally
		{
			scan.close();
		}			

	}
	
	
	
	/**
	 * readStopAreaFile() reads the data from the stoparea.dat input file 
	 * and pass the list of objects to the StopArea class.
	 * 
	 * @return List<StopArea>
	 * @throws IOException
	 */
	
	
	public void readStopAreaFile() throws IOException
	{
		String location = "C:/Eclipse workspace/Solution#1_AdityaRathi/stoparea.dat";
		Scanner scan = new Scanner(new File(location));
		i=0;
	//	readStopPointFile();
		
		try{
			while(scan.hasNextLine())
			{
				String newLine = scan.nextLine();
				String[] col = newLine.split("\\|");
				StopArea s = new StopArea(Integer.parseInt(col[0]),Integer.parseInt(col[1]),col[2],Integer.parseInt(col[3]));
			//	s.addStopPoints(ListForStopPointFile);
				ListForStopAreaFile.add(i,s);
				i++;
			}
		}
		
		finally
		{
			scan.close();
		}			

	}
	
	/**
	 * readStopPointFile() reads the data from the stopoint.dat input file 
	 * and pass the list of objects to the StopPoint class.
	 * 
	 * @return List<StopPoint>
	 * @throws IOException
	 */
	
	
	public void readStopPointFile() throws IOException
	{
		String location = "C:/Eclipse workspace/Solution#1_AdityaRathi/stopoint.dat";
		Scanner scan = new Scanner(new File(location));
		i=0;
		
		try{
			while(scan.hasNextLine())
			{
				String newLine = scan.nextLine();
				String[] col = newLine.split("\\|");
				StopPoint p = new StopPoint(col);
				ListForStopPointFile.add(i,p);
				i++;
			}
		}	
		
		finally
		{
			scan.close();
		}		

	}
	
/**
 * readLinkOnRouteFile() reads the data from the lnk_on_rte.dat input file 
 * and pass the list of objects to the Route class.
 * 
 * @param n_id
 * @param l_id
 * @param r_id
 * @return LinkList
 * @throws IOException
 */
	public List<Link> readLinkOnRouteFile(int n_id,int l_id,int r_id) throws IOException
	{
		String location = "C:/Eclipse workspace/Solution#1_AdityaRathi/lnk_on_rte.dat";
		Scanner scan = new Scanner(new File(location));
		readRouteFile();
		readLinkFile();
		List<Integer> temp = new ArrayList<Integer>();
		List<Link> LinkList = new ArrayList<Link>();
		i=0;
		int j=0;
		int k=0;
		try{
			while(scan.hasNextLine())
			{	
				j=0;
				k=0;
				String newLine = scan.nextLine();
				String[] col = newLine.split("\\|");
				
				
					if(r_id == Integer.parseInt(col[2]) &&
							n_id == Integer.parseInt(col[0]) &&
							l_id== Integer.parseInt(col[1]))
					{
						temp.add(new Integer(Integer.parseInt(col[3])));
					}
				
			}
			
			while(k<temp.size())
			{
				j=0;
				while(j<ListForLinkFile.size())
				{
					if(ListForLinkFile.get(j).getLinkID() == temp.get(k))
					{
						LinkList.add(ListForLinkFile.get(j));
						System.out.println(ListForLinkFile.get(j) + " " + j);
					}
					j++;
				}	
				k++;
			}
			
		}	
		
		finally
		{
			scan.close();
		}		
		return LinkList;
	}
	
/**
 * readPointOnLinkFile() reads the data from the pnt_on_lnk.dat input file 
 * and pass the list of objects to the Link class.
 * 
 * @param l_id
 * @return PointList
 * @throws IOException
 */
	
	public List<Point> readPointOnLinkFile(int l_id) throws IOException
	{
		String location = "C:/Eclipse workspace/Solution#1_AdityaRathi/pnt_on_lnk.dat";
		Scanner scan = new Scanner(new File(location));
		readLinkFile();
		System.out.println("reading point file");
		readPointFile();
		System.out.println("reading done");
		List<Integer> ptemp = new ArrayList<Integer>();
		List<Point> PointList = new ArrayList<Point>();
		i=0;
		int j=0;
		int k=0;
		try{
			while(scan.hasNextLine())
			{	
				j=0;
				k=0;
				String newLine = scan.nextLine();
				String[] col = newLine.split("\\|");
				
					if(l_id == Integer.parseInt(col[0]))
					{
						ptemp.add(new Integer(Integer.parseInt(col[1])));
					}
				
			}
			k=0;
			while(k<ptemp.size())
			{
				j=0;
				System.out.println("size of point list" + ListForPointFile.size());
				while(j<ListForPointFile.size())
				{
					if(ListForPointFile.get(j).getPointId() == ptemp.get(k))
					{
						PointList.add(ListForPointFile.get(j));
						System.out.println(ListForPointFile.get(j) + " " + j);
					}
					j++;
				}	
				k++;

			}
		}
		
		finally
		{
			scan.close();
		}		
		return PointList;
	}

/**
 * readSarOnRouteFile() reads the data from the sar_on_rte.dat input file 
 * and pass the list of objects to the Route class.
 * 
 * @param n_id
 * @param l_id
 * @param r_id
 * @return StopAreaList
 * @throws IOException
 */
	public List<StopArea> readSarOnRouteFile(int n_id, int l_id, int r_id) throws IOException
	{
		String location = "C:/Eclipse workspace/Solution#1_AdityaRathi/sar_on_rte.dat";
		Scanner scan = new Scanner(new File(location));
		
		readRouteFile();
		readStopAreaFile();
		List<Integer> temp = new ArrayList<Integer>();
		List<StopArea> StopAreaList = new ArrayList<StopArea>();
		i=0;
		int j=0;
		int k=0;
		try{
			while(scan.hasNextLine())
			{	
				j=0;
				k=0;
				String newLine = scan.nextLine();
				String[] col = newLine.split("\\|");
				//System.out.println("getting into while");
			
					if(r_id == Integer.parseInt(col[3]) && 
							n_id == Integer.parseInt(col[0]) &&
							l_id == Integer.parseInt(col[2]))
					{
						temp.add(new Integer(Integer.parseInt(col[1])));
					}
				
			}
			
		while(k<temp.size())
			{
				j=0;
				while(j<ListForStopAreaFile.size())
				{
					if(ListForStopAreaFile.get(j).getStopAreaID() == temp.get(k))
					{
						StopAreaList.add(ListForStopAreaFile.get(j));
					}
					j++;
				}	
				k++;
			}
			
		}	
		
		finally
		{
			scan.close();
		}		
		return StopAreaList;
	}
	
}
