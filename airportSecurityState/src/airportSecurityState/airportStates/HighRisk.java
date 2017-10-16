package airportSecurityState.airportStates;

/**
* HighRisk class.
* Created for cs542 - Design patterns, Assignment 3.
* @author Aravind Venkit
*/
public class HighRisk implements AirportStateI{
	public HighRisk(){
		
	}

	public String operate(){
		String result = "";
		result += operate(2) + " ";
		result += operate(4) + " ";
		result += operate(6) + " ";
		result += operate(8) + " ";
		result += operate(10);
		return result;
	}

	private String operate(int operationID){
		return Integer.toString(operationID);
	}
}