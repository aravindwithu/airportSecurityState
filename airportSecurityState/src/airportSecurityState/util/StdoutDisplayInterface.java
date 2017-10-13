package airportSecurityState.util;

/**
* StdoutDisplayInterface interface.
* Created by Aravind Venkit for cs542 - Design patterns.
* StdoutDisplayInterface interface to write to stdout (print) in command line.
* @author Aravind Venkit
*/
public interface StdoutDisplayInterface{
	/**
	* writeToStdout method.
	* Implements StdoutDisplayInterface writeToStdout method.
	* gets String s as argument.
	* prints the given string to command line.
	* @param s to print the same to output command line.
	*/
	public void writeToStdout(String s);
}