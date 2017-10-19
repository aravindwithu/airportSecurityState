package airportSecurityState.airportStates;
import airportSecurityState.util.MyLogger;

import java.util.HashMap;
import java.util.Map;
/**
* HighRisk class.
* Created for cs542 - Design patterns, Assignment 3.
* @author Aravind Venkit
*/
public class HighRisk implements AirportStateI{
	private MyLogger myLogger;
	private AirportStateHelper airportStateHelper;
	private AirportSecurity airportSecurity;
	

	public HighRisk(){
		myLogger = new MyLogger();
		myLogger.writeMessage("HighRisk Constructor Called.", MyLogger.DebugLevel.CONSTRUCTOR);		
	}

	public void tightenOrLoosenSecurity(AirportSecurity airportSecurityIn, HashMap<String, String> securityData){
		airportSecurity = airportSecurityIn;
		if (securityData.containsKey("Day") && securityData.containsKey("Item")){
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
		result += operate(4) + " ";
		result += operate(6) + " ";
		result += operate(8) + " ";
		result += operate(10);
		myLogger.writeMessage("HighRisk operations are: " + result, MyLogger.DebugLevel.OPERATIONS_RESULTS);
		return result;
	}

	private String operate(int operationID){
		return Integer.toString(operationID);
	}
}