package airportSecurityState.airportStates;

import java.util.HashMap;
import java.util.Map;
import airportSecurityState.util.MyLogger;

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
	private AirportStateI airportState;
	private MyLogger myLogger;

	public AirportSecurity(){
		myLogger = new MyLogger();
		myLogger.writeMessage("AirportSecurity Constructor Called.", MyLogger.DebugLevel.CONSTRUCTOR);
		day = 0;
		avgTraffic = 0;
		avgProhibitedItems = 0;
		travellersCount = 0;
		airportState = new LowRisk();
	}

	public void tightenOrLoosenSecurity(HashMap<String, String> securityDataIn){
		myLogger.writeMessage("tightenOrLoosenSecurity securityData: "+securityDataIn, MyLogger.DebugLevel.INPUT_DATA);
		airportState.tightenOrLoosenSecurity(this, securityDataIn);
	}

	public String operate(){
		return airportState.operate();
	}

	public int getDay(){
		return day;
	}

	public int getTravellersCount(){
		return travellersCount;
	}

	public int getProhibitedItemsCount(){
		return prohibitedItemsCount;
	}

	public void setTravellersCount(int travellersCountIn){
		travellersCount = travellersCountIn;
	}

	public void setProhibitedItemsCount(int prohibitedItemsCountIn){
		prohibitedItemsCount = prohibitedItemsCountIn;
	}

	public void setAirportState(AirportStateI airportStateIn){
		airportState = airportStateIn;
	}

	public void setDay(int dayIn){
		day = dayIn;
	}

	public void setAvgTraffic(int avgTrafficIn){
		avgTraffic = avgTrafficIn;
	}

	public void setAvgProhibitedItems(int avgProhibitedItemsIn){
		avgProhibitedItems = avgProhibitedItemsIn;
	}
}