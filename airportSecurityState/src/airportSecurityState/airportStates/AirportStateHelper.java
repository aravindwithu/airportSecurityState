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

	public AirportStateHelper(AirportSecurity airportSecurityIn){
		myLogger = new MyLogger();
		myLogger.writeMessage("AirportSecurity Constructor Called.", MyLogger.DebugLevel.CONSTRUCTOR);
		airportSecurity = airportSecurityIn;
	}

	public int getAirportState(String securityData){
		String[] securityArr = securityData.split(";");
    	HashMap<String, String> securityMap = new HashMap<>();
    	for(String securityTuple : securityArr){
    		String[] tuple = securityTuple.split(":");
    		if(!tuple[0].equals(null) && !tuple[1].equals(null)){
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
			day = Integer.parseInt(securityMap.get("Day"));
		}

		myLogger.writeMessage("Day: "+day+"; Item: "+item, MyLogger.DebugLevel.DATA_NEEDED);

		airportSecurity.setDay(day);

		int avgTraffic = getAvg(travellersCount, day);
		airportSecurity.setAvgTraffic(avgTraffic);

		int avgProhibitedItems = getAvg(prohibitedItemsCount, day);
		airportSecurity.setAvgProhibitedItems(avgProhibitedItems);

		if((avgTraffic >= 8)||(avgProhibitedItems >= 2)){
			return 2;
		}
		else if((4 <= avgTraffic && avgTraffic < 8)||(1 <= avgProhibitedItems && avgProhibitedItems < 2)){
			return 1;
		}
		else if((0 <= avgTraffic && avgTraffic < 4)||(0 <= avgProhibitedItems && avgProhibitedItems < 1)){
			return 0;
		}

		return -1;
	}

	private boolean isProhibitedItemsCount(String data){
		if(data.equals("Gun") || data.equals("NailCutter") 
			|| data.equals("Blade") || data.equals("Knife")){
				return true;
		}

		return false;
	}

	private int getAvg(int total, int number){
		return total/number;
	}
}