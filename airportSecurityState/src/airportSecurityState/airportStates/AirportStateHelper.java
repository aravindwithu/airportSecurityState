package airportSecurityState.airportStates;

/**
* AirportStateHelper class.
* Created for cs542 - Design patterns, Assignment 3.
* @author Aravind Venkit
*/
public class AirportStateHelper{

	private AirportSecurity airportSecurity;

	public AirportStateHelper(AirportSecurity airportSecurityIn){
		airportSecurity = airportSecurityIn;
	}

	public int getAirportState(int dayIn, String item){

		int travellersCount = airportSecurity.getTravellersCount();
		travellersCount++;
		airportSecurity.setTravellersCount(travellersCount);

		int prohibitedItemsCount = airportSecurity.getProhibitedItemsCount();
		if(isProhibitedItemsCount(item)){
			prohibitedItemsCount++;
			airportSecurity.setProhibitedItemsCount(prohibitedItemsCount);
		}

		int day = dayIn;
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

	public int getAvg(int total, int number){
		return total/number;
	}
}