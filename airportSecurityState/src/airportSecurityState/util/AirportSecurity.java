package airportSecurityState.util;

import airportSecurityState.util.Results;
import java.util.HashMap;

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
	private int itemsCount;
	private HashMap<String, String> securityData;

	public AirportSecurity(){
		day = 0;
		avgTraffic = 0;
		avgProhibitedItems = 0;
		travellersCount = 0;
	}

	public void tightenOrLoosenSecurity(HashMap<String, String> securityDataIn){

	}

	private void setAvgTraffic(){

	}

	private void setAvgProhibitedItems(){
		
	}
}