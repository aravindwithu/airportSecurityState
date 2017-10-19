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
		String result = "2 4 6 8 10";
		return result;
	}
}