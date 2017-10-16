package airportSecurityState.airportStates;

/**
* LowRisk class.
* Created for cs542 - Design patterns, Assignment 3.
* @author Aravind Venkit
*/
public class LowRisk implements AirportStateI{
	public LowRisk(){
		
	}

	public String operate(){
		String result = "";
		result += operate(1) + " ";
		result += operate(3) + " ";
		result += operate(5) + " ";
		result += operate(7) + " ";
		result += operate(9);
		return result;
	}

	private String operate(int operationID){
		return Integer.toString(operationID);
	}
}