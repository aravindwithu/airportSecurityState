package airportSecurityState.airportStates;

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
	private AirportStateI highRisk;
	private AirportStateI moderateRisk;
	private AirportStateI lowRisk;
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
			setAirportState();
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

	private void setAirportState(){
		if((avgTraffic > 8)||(avgProhibitedItems >= 2)){
			highRisk = new HighRisk();
			highRisk.operate();
		}
		else if((4 <= avgTraffic && avgTraffic >= 8)||(1 <= avgProhibitedItems && avgProhibitedItems < 2)){
			moderateRisk = new ModerateRisk();
			moderateRisk.operate();
		}
		else if((0 <= avgTraffic && avgTraffic < 4)||(0 <= avgProhibitedItems && avgProhibitedItems < 1)){
			lowRisk = new LowRisk();
			lowRisk.operate();
		}
		highRisk = new HighRisk();
	}
}