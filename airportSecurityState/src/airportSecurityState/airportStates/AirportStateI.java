package airportSecurityState.airportStates;

import java.util.HashMap;
/**
* AirportStateI interface.
* Created for cs542 - Design patterns, Assignment 3.
* @author Aravind Venkit
*/
public interface AirportStateI{
	public void tightenOrLoosenSecurity(AirportSecurity airportSecurityIn, HashMap<String, String> securityDataIn);
	public String operate();
}