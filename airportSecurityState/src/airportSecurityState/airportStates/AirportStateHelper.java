package airportSecurityState.airportStates;
import airportSecurityState.util.MyLogger;
import java.util.HashMap;
import java.util.Map;

/**
* AirportStateHelper class.
* Created for cs542 - Design patterns, Assignment 3.
* @author Aravind Venkit
*/
public class AirportStateHelper{

	private AirportSecurity airportSecurity;
	private MyLogger myLogger;

	/**
	* AirportStateHelper constructor, gets airportSecurityIn(context class object) from state classes.
	*/
	public AirportStateHelper(AirportSecurity airportSecurityIn){
		myLogger = new MyLogger();
		myLogger.writeMessage("AirportSecurity Constructor Called.", MyLogger.DebugLevel.CONSTRUCTOR);
		airportSecurity = airportSecurityIn;
	}

	/**
	* Helper method to calculate different context variables.
	* Gets securityData(line from file) processes it.
	* Identifies the state change and returns the same in integer form back to state class
	* state class recives the return int value and and sets the airportState(current state)
	*/
	public int getAirportState(String securityData){
		// returns int corresponding to no action if the has no data
		if(securityData.equals("")){
			return -1; //No state conditions satisfied
		}
		// Read line is split into array of string based on '":" charecter.
		String[] securityArr = securityData.split(";");
    	HashMap<String, String> securityMap = new HashMap<>();
    	for(String securityTuple : securityArr){
    		String[] tuple = securityTuple.split(":");
    		if(tuple != null && !tuple[0].equals(null) && !tuple[1].equals(null)){
    			securityMap.put(tuple[0], tuple[1]);
    		}
    	}

		int travellersCount = airportSecurity.getTravellersCount();
		travellersCount++;
		airportSecurity.setTravellersCount(travellersCount);
		String item = "";
		if(securityMap.containsKey("Item")){
			item = securityMap.get("Item");
		}

		int prohibitedItemsCount = airportSecurity.getProhibitedItemsCount();
		if(isProhibitedItemsCount(item)){
			prohibitedItemsCount++;
			airportSecurity.setProhibitedItemsCount(prohibitedItemsCount);
		}

		int day = 0;
		if(securityMap.containsKey("Day")){
			try{
				day = Integer.parseInt(securityMap.get("Day"));
				if(day == 0){
					throw new Exception("day value incorrect in line data " + securityData);
				}
			}
	    	catch(Exception ex){
	    		System.err.println("Day should be a number : "+ ex.getMessage());// prints the error message.
	    		ex.printStackTrace();// prints stack trace.
	    		System.exit(0);
			}
		}

		myLogger.writeMessage("Day: "+day+"; Item: "+item, MyLogger.DebugLevel.DATA_NEEDED);

		airportSecurity.setDay(day);

		int avgTraffic = getAvg(travellersCount, day);
		airportSecurity.setAvgTraffic(avgTraffic);

		int avgProhibitedItems = getAvg(prohibitedItemsCount, day);
		airportSecurity.setAvgProhibitedItems(avgProhibitedItems);

		if((avgTraffic >= 8)||(avgProhibitedItems >= 2)){
			return 2; //High Risk
		}
		else if((4 <= avgTraffic && avgTraffic < 8)||(1 <= avgProhibitedItems && avgProhibitedItems < 2)){
			return 1; //Moderate Risk
		}
		else if((0 <= avgTraffic && avgTraffic < 4)||(0 <= avgProhibitedItems && avgProhibitedItems < 1)){
			return 0; //Low Risk
		}

		return -1; //No state conditions satisfied
	}

	/**
	* returns true if the passed item is prohibited item else returns false.
	*/
	private boolean isProhibitedItemsCount(String data){
		if(data.equals("Gun") || data.equals("NailCutter") 
			|| data.equals("Blade") || data.equals("Knife")){
				return true;
		}

		return false;
	}

	/**
	* returns average of passed total(counts like travellers count or items count) and number(day count) .
	*/
	private int getAvg(int total, int number){
		return total/number;
	}
}