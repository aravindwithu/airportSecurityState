package airportSecurityState.airportStates;
import airportSecurityState.util.MyLogger;
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

	public void tightenOrLoosenSecurity(AirportSecurity airportSecurityIn, String securityData){
		airportSecurity = airportSecurityIn;
		airportStateHelper = new AirportStateHelper(airportSecurity);	
		int airportState = airportStateHelper.getAirportState(securityData);
		switch(airportState){
			case 0:
				airportSecurity.setAirportState(new LowRisk());
				myLogger.writeMessage("State change from High Risk to Low Risk.", MyLogger.DebugLevel.STATE_CHANGE);
				break;
			case 1:
				airportSecurity.setAirportState(new ModerateRisk());
				myLogger.writeMessage("State change from High Risk to Moderate Risk.", MyLogger.DebugLevel.STATE_CHANGE);
				break;
			case 2:
				myLogger.writeMessage("No change, State is High Risk.", MyLogger.DebugLevel.STATE_CHANGE);
				//airportSecurity.setAirportState(new HighRisk());
				break;
		}
	}

	public String operate(){
		return "2 4 6 8 10";
	}
}