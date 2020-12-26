package com.sl.ms.sprint1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.sl.ms.sprint1.Inventory;
import com.sl.ms.sprint1.InventoryDatabase;

public class SalesSummary {

	private static final int Month = 10;
	static Date date1 ;
	
	//Stock summary per day
	public static Map<Date,List<Inventory>> summaryPerDay()

	{
		Map<Date,List<Inventory>> summaryMap=  InventoryDatabase.getInventoryDatabase().stream().sorted(Comparator.comparing(Inventory::getSaleOfDate))
		.collect(Collectors.groupingBy(Inventory::getSaleOfDate));
		System.out.println("******Stock Summary Per Day********");
		//System.out.println(summaryMap);
		summaryMap.forEach((key, value) -> System.out.println(key + ":==>" + value + "\n"));
		
		return summaryMap;
		
		}

	//Sales leader board. TOP 5 items in demand.  (For last 1 month)
	
	public static List<String> Top5ItemsinDemand()
	{
		List<String> map2 = 	
		InventoryDatabase.getInventoryDatabase().stream()
		.collect(Collectors.groupingBy(Inventory::getName,Collectors.summingInt(Inventory::getQuantitySold)))
		.entrySet().stream().sorted(Entry.<String, Integer>comparingByValue().reversed())
		.map(Entry::getKey)
		.limit(5)
		.collect(Collectors.toList());
		System.out.println("******Top5ItemsinDemand********");
		System.out.println(map2);
		return map2;
		}
	
	//Summary of total items sold today
	
	public static List<Inventory> salesForToday(String SaleDate)

	{
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		try {
			date1 = formatter1.parse(SaleDate);
				} catch (ParseException e) { 
			e.printStackTrace();
		}
		List<Inventory> todaysSummary =  InventoryDatabase.getInventoryDatabase().stream()
				.filter((Inventory -> Inventory.getName().equals("Item1")))
				.filter((Inventory -> Inventory.getSaleOfDate().equals(date1)))
				.collect(Collectors.toList());
		
		System.out.println("******Summary of total items sold today********");
		System.out.println("Date is"+date1);
		//System.out.println(todaysSummary.toString());
		
		todaysSummary.stream().forEach(System.out::println);
		
		return todaysSummary;
	
		}

	//Summary of total items sold per month 
	@SuppressWarnings("deprecation")
	public static int getQuantity()

	{
		 int overallquantity = InventoryDatabase.getInventoryDatabase().stream()
			 .filter(Inventory -> Inventory.getSaleOfDate().getMonth()== Month)
			//.map(Inventory::getQuantitySold).reduce(0, (a,b)->(a+b));
			 .map(Inventory::getQuantitySold).reduce(0,Integer::sum);
		System.out.println("******Total items sold per month********");
		System.out.println(overallquantity);
		return overallquantity;
		
	}
	//Summary of quantity of sale for one particular item.
	
	public static Map<String, Integer> getQuantitybyMonthGroupbyType()
	{
	Map<String, Integer> map1 = 
			
		InventoryDatabase.getInventoryDatabase().stream()
		.collect(Collectors.groupingBy(Inventory::getName,Collectors.summingInt(Inventory::getQuantitySold)));
	System.out.println("******Summary of quantity of sale per item********");		
	System.out.println(map1);
	return map1;
	}
	
	
	}
	

