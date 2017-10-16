package airportSecurityState.airportStates;

/**
* ModerateRisk class.
* Created for cs542 - Design patterns, Assignment 3.
* @author Aravind Venkit
*/
public class ModerateRisk implements AirportStateI{
	public ModerateRisk(){
		
	}

	public String operate(){
		String result = "";
		result += operate(2) + " ";
		result += operate(3) + " ";
		result += operate(5) + " ";
		result += operate(8) + " ";
		result += operate(9);
		return result;
	}

	private String operate(int operationID){
		return Integer.toString(operationID);
	}
}