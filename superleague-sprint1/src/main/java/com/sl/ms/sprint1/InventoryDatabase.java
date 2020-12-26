package com.sl.ms.sprint1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InventoryDatabase
{
	// Read the csv file which has inventory details
	public  static List<Inventory> getInventoryDatabase()
	{
		Stream<String> lines = null;
		Pattern pattern = Pattern.compile(",");
		Path path = Paths.get("c://Users/prabh/eclipse-workspace/SuperLeague/Input/Inventory.csv");
		if (Files.exists(path)) 
		{
			try {
				
				lines  = Files.lines(path);		
			}
				
			catch (IOException e) 
			{
			e.printStackTrace();
			}
		}
		//Skip the first line and read comma seperated columns 
		  List<Inventory> Inventories = 
				  lines.skip(1).map(line -> { String[] stck = pattern.split(line);
	     //Convert the date column from String to date 
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH); 
		  String dateInString = stck[1] ;
					  
					  Date date = null; 
					  try { 
						  date = formatter.parse(dateInString); 
						  } 
					  catch (ParseException e) 
					  { // TODO Auto-generated catch block 
						  e.printStackTrace();
					  }
					 
		// create Inventory objects	  
				  
		  return new Inventory(Integer.parseInt(stck[0]), stck[2], Integer.parseInt(stck[3]),Integer.parseInt(stck[4]),Integer.parseInt(stck[5]),date);
		  }).collect(Collectors.toList());
		return Inventories;
			}
}
