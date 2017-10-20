package airportSecurityState.airportStates;
import airportSecurityState.util.MyLogger;

/**
* airportSecurity class.
* Created for cs542 - Design patterns, Assignment 3.
* @author Aravind Venkit
*/
public class AirportSecurity{
	// Context variables declarations.
	private int day;
	private int avgTraffic;
	private int avgProhibitedItems;
	private int travellersCount;
	private int prohibitedItemsCount;
	private AirportStateI airportState;
	private MyLogger myLogger;

	/**
	* AirportSecurity constructor - initializes context declarations. 
	*/
	public AirportSecurity(){
		myLogger = new MyLogger();
		// Constructor Logger
		myLogger.writeMessage("AirportSecurity Constructor Called.", MyLogger.DebugLevel.CONSTRUCTOR);
		day = 0;
		avgTraffic = 0;
		avgProhibitedItems = 0;
		travellersCount = 0;
		airportState = new LowRisk();
	}

	/**
	* tightenOrLoosenSecurity method - calls tightenOrLoosenSecurity method of airportState class.
	*/
	public void tightenOrLoosenSecurity(String securityData){
		airportState.tightenOrLoosenSecurity(this, securityData);
	}

	/**
	* operate method - calls operate method of airportState class.
	*/
	public String operate(){
		return airportState.operate();
	}

	/**
	* returns day value.
	*/
	public int getDay(){
		return day;
	}

	/**
	* returns travellersCount value.
	*/
	public int getTravellersCount(){
		return travellersCount;
	}

	/**
	* returns prohibitedItemsCount value.
	*/
	public int getProhibitedItemsCount(){
		return prohibitedItemsCount;
	}

	/**
	* sets day value.
	*/
	public void setDay(int dayIn){
		day = dayIn;
	}

	/**
	* sets travellersCount value.
	*/
	public void setTravellersCount(int travellersCountIn){
		travellersCount = travellersCountIn;
	}

	/**
	* sets prohibitedItemsCount value.
	*/
	public void setProhibitedItemsCount(int prohibitedItemsCountIn){
		prohibitedItemsCount = prohibitedItemsCountIn;
	}

	/**
	* sets airportState(current state) value.
	*/
	public void setAirportState(AirportStateI airportStateIn){
		airportState = airportStateIn;
	}

	/**
	* sets avgTraffic value.
	*/
	public void setAvgTraffic(int avgTrafficIn){
		avgTraffic = avgTrafficIn;
	}

	/**
	* sets avgProhibitedItems value.
	*/
	public void setAvgProhibitedItems(int avgProhibitedItemsIn){
		avgProhibitedItems = avgProhibitedItemsIn;
	}
}