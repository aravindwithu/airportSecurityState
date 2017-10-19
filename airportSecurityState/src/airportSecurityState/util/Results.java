package airportSecurityState.util;

//Header to import supporting classes.
import java.io.PrintWriter;
import java.util.ArrayList;
import airportSecurityState.util.MyLogger;
/**
* Results class.
* Created by Aravind Venkit for cs542 - Design patterns.
* Results class to process results of the test case.
* Implements FileDisplayInterface and StdoutDisplayInterface interfaces.
* @author Aravind Venkit
*/
public class Results implements FileDisplayInterface, StdoutDisplayInterface{
	private ArrayList<String> resultArray = new ArrayList<String>();// string array to store results.
	private PrintWriter writer;// writer object to write to file.
	private MyLogger myLogger;
	/**
	* Results constructor to intialize Results class.
	* Calls intializeArray.
	*/
	public Results(){
		myLogger = new MyLogger();
		myLogger.writeMessage("Results Constructor Called.", MyLogger.DebugLevel.CONSTRUCTOR);
		intializeArray();
	}
	/**
	* intializeArray method.
	* intializes resultArray with empty string.
	*/
	private void intializeArray(){
		for(int i=0; i < resultArray.size(); i++){
			resultArray.set(i, "");
		}
	}
	/**
	* storeNewResult method.
	* Stores the given value in given index.
	* @param value of string to be stored.
	*/
	public void storeNewResult(String value){
		resultArray.add(value);
	}
	/**
	* printAll method.
	* prints all the values in resultArray to command line.
	*/
	public void printAll(){
		for(int i = 0; i < resultArray.size(); i++){
			writeToStdout(resultArray.get(i));
		}
	}
	/**
	* writeAll method.
	* writes all the values in resultArray to output file.
	* @param writer_in object to write resultArray values to it
	*/
	public void writeAll(PrintWriter writer_in){
		writer = writer_in;
		for(int i = 0; i < resultArray.size(); i++){
			writeToFile(resultArray.get(i));
		}
	}
	/**
	* writeToStdout method.
	* Implements StdoutDisplayInterface writeToStdout method.
	* gets String s as argument.
	* prints the given string to command line.
	* @param s to print the same to output command line.
	*/
	public void writeToStdout(String s){
		System.out.println(s);
	}
	/**
	* writeToFile method.
	* Implements FileDisplayInterface writeToFile method.
	* gets String s as argument.
	* writes the given string to output file.
	* @param s to be writtern to the writer object. 
	*/
	public void writeToFile(String s){
			writer.println(s);
	}
}