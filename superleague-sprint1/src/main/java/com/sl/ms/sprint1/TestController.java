package com.sl.ms.sprint1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sl.ms.sprint1.Inventory;
import com.sl.ms.sprint1.SalesSummary;
 
@RestController
public class TestController 
{
   @RequestMapping("/getInventory")
   public List<Inventory> getInventory() 
   {
	   List<Inventory> InputData = (java.util.List<Inventory>) InventoryDatabase.getInventoryDatabase();
	   return InputData;
		
   }
   
   @RequestMapping("/summaryPerDay")
   public Map<Date,List<Inventory>> summaryPerDayController() 
   {
	   Map<Date,List<Inventory>> summaryMap= SalesSummary.summaryPerDay();
	   return summaryMap;
		
   }
   
   @RequestMapping("/Top5ItemsinDemand")
   public List<String> Top5ItemsinDemandController() 
   {
	   List<String> map2= SalesSummary.Top5ItemsinDemand();
	   return map2;
		
   }
   
   @RequestMapping("/salesForToday")
   public List<Inventory> salesForTodayController() 
   {
	   String SaleDate = "2020-12-01";
	   List<Inventory> todaysSummary = SalesSummary.salesForToday(SaleDate);
	   return todaysSummary;
   }
   
   @RequestMapping("/getQuantityForAMonth")
   public int getQuantityController() 
   {
	   int QuantityPerMonth = SalesSummary.getQuantity();
	   return QuantityPerMonth;
   }
   
   @RequestMapping("/getQuantitybyMonthGroupbyType")
   public Map<String, Integer> getQuantitybyMonthGroupbyTypeCont() 
   {
	   Map<String, Integer> map1 = SalesSummary.getQuantitybyMonthGroupbyType();
	   return map1;
   }
  
}

