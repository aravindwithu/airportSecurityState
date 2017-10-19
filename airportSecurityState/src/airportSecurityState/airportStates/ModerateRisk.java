package airportSecurityState.airportStates;
import airportSecurityState.util.MyLogger;

import java.util.HashMap;
import java.util.Map;
/**
* ModerateRisk class.
* Created for cs542 - Design patterns, Assignment 3.
* @author Aravind Venkit
*/
public class ModerateRisk implements AirportStateI{
	private MyLogger myLogger;
	private AirportStateHelper airportStateHelper;
	private AirportSecurity airportSecurity;
	

	public ModerateRisk(){
		myLogger = new MyLogger();
		myLogger.writeMessage("ModerateRisk Constructor Called.", MyLogger.DebugLevel.CONSTRUCTOR);
	}

	public void tightenOrLoosenSecurity(AirportSecurity airportSecurityIn, HashMap<String, String> securityData){
		airportSecurity = airportSecurityIn;
		if (securityData.containsKey("Day")){
			airportStateHelper = new AirportStateHelper(airportSecurity);	
			int airportState = 
			airportStateHelper.getAirportState( Integer.parseInt(securityData.get("Day")), securityData.get("Item"));
			switch(airportState){
				case 0:
					airportSecurity.setAirportState(new LowRisk());
					break;
				case 1:
					airportSecurity.setAirportState(new ModerateRisk());
					break;
				case 2:
					airportSecurity.setAirportState(new HighRisk());
					break;
			}
		}
	}

	public String operate(){
		String result = "";
		result += operate(2) + " ";
		result += operate(3) + " ";
		result += operate(5) + " ";
		result += operate(8) + " ";
		result += operate(9);
		myLogger.writeMessage("ModerateRisk operations are: " + result, MyLogger.DebugLevel.OPERATIONS_RESULTS);
		return result;
	}

	private String operate(int operationID){
		return Integer.toString(operationID);
	}
}