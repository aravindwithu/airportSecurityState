package airportSecurityState.airportStates;
import airportSecurityState.util.MyLogger;

/**
* LowRisk class.
* Created for cs542 - Design patterns, Assignment 3.
* @author Aravind Venkit
*/
public class LowRisk implements AirportStateI{
	private MyLogger myLogger;
	private AirportStateHelper airportStateHelper;
	private AirportSecurity airportSecurity;
	
	/**
	* Constructor for LowRisk class
	*/
	public LowRisk(){
		myLogger = new MyLogger();
		myLogger.writeMessage("LowRisk Constructor Called.", MyLogger.DebugLevel.CONSTRUCTOR);	
	}

	/**
	* tightenOrLoosenSecurity Method
	* Gets airportSecurityIn(context class object) and securityData(line from file) as parameters.
	* Uses helper function to perform the calculations required and to find the airportState(currentState).
	* Sets the airportState of the airportSecurityIn(context class object).
	*/
	public void tightenOrLoosenSecurity(AirportSecurity airportSecurityIn, String securityData){
		airportSecurity = airportSecurityIn;
		airportStateHelper = new AirportStateHelper(airportSecurity);	
		int airportState = airportStateHelper.getAirportState(securityData);
			switch(airportState){
			case 0:
				myLogger.writeMessage("No change, State is Low Risk.", MyLogger.DebugLevel.STATE_CHANGE);
				//airportSecurity.setAirportState(new LowRisk());
				break;
			case 1:
				airportSecurity.setAirportState(new ModerateRisk());
				myLogger.writeMessage("State change from Low Risk to Moderate Risk.", MyLogger.DebugLevel.STATE_CHANGE);
				break;
			case 2:
				airportSecurity.setAirportState(new HighRisk());
				myLogger.writeMessage("State change from Low Risk to High Risk.", MyLogger.DebugLevel.STATE_CHANGE);
				break;
		}
	}

	/**
	* operates the current class operations.
	* returns operations as string.
	*/
	public String operate(){
		return "1 3 5 7 9";
	}
}