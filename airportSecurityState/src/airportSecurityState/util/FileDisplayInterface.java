package airportSecurityState.util;

/**
* FileDisplayInterface interface.
* Created for cs542 - Design patterns.
* FileDisplayInterface interface to write to output file.
* @author Aravind Venkit
*/
public interface FileDisplayInterface{
	/**
	* writeToFile method.
	* Implements FileDisplayInterface writeToFile method.
	* gets String s as argument.
	* writes the given string to output file.
	* @param s to be writtern to the writer object. 
	*/
	public void writeToFile(String s);
}