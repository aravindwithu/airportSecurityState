package airportSecurityState.util;

import airportSecurityState.util.Results;
import java.util.HashMap;
import java.util.Map;

/**
* airportSecurity class.
* Created for cs542 - Design patterns, Assignment 3.
* @author Aravind Venkit
*/
public class AirportSecurity{
	private int day;
	private int avgTraffic;
	private int avgProhibitedItems;
	private int travellersCount;
	private int prohibitedItemsCount;
	private HashMap<String, String> securityData;

	public AirportSecurity(){
		day = 0;
		avgTraffic = 0;
		avgProhibitedItems = 0;
		travellersCount = 0;
	}

	public void tightenOrLoosenSecurity(HashMap<String, String> securityDataIn){
		securityData = securityDataIn;
		if (securityData.containsKey("Day")){
			if(day == Integer.parseInt(securityData.get("Day"))){
				setTravellersCount();
				setItemsCount();
			}
			day = Integer.parseInt(securityData.get("Day"));
			setAvgTraffic();
			setAvgProhibitedItems();
		}
	}

	private void setTravellersCount(){
		travellersCount++;
	}

	private void setItemsCount(){
		if (securityData.containsKey("Item")){
			String item = securityData.get("Item");
			if(item.equals("Gun") || item.equals("NailCutter") 
				|| item.equals("Blade") || item.equals("Knife")){
				prohibitedItemsCount++;
			}
		}
	}

	private void setAvgTraffic(){
		avgTraffic = travellersCount/day;
	}

	private void setAvgProhibitedItems(){
		avgProhibitedItems = prohibitedItemsCount/day;
	}
}