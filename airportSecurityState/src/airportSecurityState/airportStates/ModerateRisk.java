package airportSecurityState.airportStates;

/**
* ModerateRisk class.
* Created for cs542 - Design patterns, Assignment 3.
* @author Aravind Venkit
*/
public class ModerateRisk implements AirportStateI{
	public ModerateRisk(){
		
	}

	public void operate(){
		System.out.println("Moderate Risk");
	}
}