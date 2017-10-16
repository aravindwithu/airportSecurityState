package airportSecurityState.airportStates;

/**
* LowRisk class.
* Created for cs542 - Design patterns, Assignment 3.
* @author Aravind Venkit
*/
public class LowRisk implements AirportStateI{
	public LowRisk(){
		
	}

	public void operate(){
		System.out.println("Low Risk");
	}
}