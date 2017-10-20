package airportSecurityState.airportStates;

/**
* AirportStateI interface.
* Created for cs542 - Design patterns, Assignment 3.
* @author Aravind Venkit
*/
public interface AirportStateI{
	/**
	* tightenOrLoosenSecurity method.
	* Changes the airportState (currentState).
	*/
	public void tightenOrLoosenSecurity(AirportSecurity airportSecurityIn, String securityData);

	/**
	* Operate method.
	* Implements the airportState operations.
	*/
	public String operate();
}