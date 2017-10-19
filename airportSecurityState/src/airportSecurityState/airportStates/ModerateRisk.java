package airportSecurityState.airportStates;
import airportSecurityState.util.MyLogger;

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

	public void tightenOrLoosenSecurity(AirportSecurity airportSecurityIn, String securityData){
		airportSecurity = airportSecurityIn;
		airportStateHelper = new AirportStateHelper(airportSecurity);	
		int airportState = airportStateHelper.getAirportState(securityData);
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

	public String operate(){
		String result = "2 3 5 8 9";
		return result;
	}
}