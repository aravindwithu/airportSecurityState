package airportSecurityState.airportStates;

/**
* HighRisk class.
* Created for cs542 - Design patterns, Assignment 3.
* @author Aravind Venkit
*/
public class HighRisk implements AirportStateI{
	public HighRisk(){
		
	}

	public void operate(){
		System.out.println("High Risk");
	}
}