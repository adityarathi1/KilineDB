# KilineDB

This project is serves as the small solution for the transportation field. 
Store all your data files in the location "C:/Eclipse workspace/Solution#1_AdityaRathi".

After downloading all the java files, you can write your queries in Query.java file and run this file to get the desired output.

The data files should have the following name and the attributes.

route.dat
network ver id | line id | route id

line.dat
netwrk_ver_id | line_id | line_type_id | Public line name | line desc

network_vrsn.dat
network version id | net_ver_name | validity begin date | validity end date



sar_on_rte.dat
network_ver_id | stopearea id | line id | route id | stop point id | stop point place from 1 to n


lnk_on_rte.dat
network_version | line id | route id | link id | link place 


link.dat
link id | first point of link | last point of link | link desc | date and time this link has been  acquired


pnt_on_lnk.dat
link id | point id | place order of the point into the link

point.dat
point id | x coordinate | y coordiniate

stoparea.dat
net_ver_id | stoparea_id | stoparea_name | 1 = sa is timing point, 0 = not timing point

stopoint.dat
net_ver_id | stop_point_id | stop_area_id | detection_area_id | point_id | stop_area_desc
