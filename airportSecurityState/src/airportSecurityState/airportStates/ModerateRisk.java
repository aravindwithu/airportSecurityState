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
	
	/**
	* Constructor for ModerateRisk class
	*/
	public ModerateRisk(){
		myLogger = new MyLogger();
		myLogger.writeMessage("ModerateRisk Constructor Called.", MyLogger.DebugLevel.CONSTRUCTOR);
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
				airportSecurity.setAirportState(new LowRisk());
				myLogger.writeMessage("State change from Moderate Risk to Low Risk.", MyLogger.DebugLevel.STATE_CHANGE);
				break;
			case 1:
				myLogger.writeMessage("No change, State is Moderate Risk.", MyLogger.DebugLevel.STATE_CHANGE);
				//airportSecurity.setAirportState(new ModerateRisk());
				break;
			case 2:
				airportSecurity.setAirportState(new HighRisk());
				myLogger.writeMessage("State change from Moderate Risk to High Risk.", MyLogger.DebugLevel.STATE_CHANGE);
				break;
		}
	}

	/**
	* operates the current class operations.
	* returns operations as string.
	*/
	public String operate(){
		return "2 3 5 8 9";
	}
}