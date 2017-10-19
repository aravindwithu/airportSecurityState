package airportSecurityState.driver;

//Header to import supporting classes.
import airportSecurityState.util.Results;
import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.MyLogger;
import airportSecurityState.airportStates.AirportSecurity;
import java.io.PrintWriter;
import java.util.HashMap;

/**
* Driver class contains main method.
* Created for cs542 - Design patterns, Assignment 3.
* @author Aravind Venkit
*/
public class Driver 
{
	public static void main(String[] args) 
	{
	    // Object declared for Results class (Original).
	    Results results;
	    // Object declared for FileProcessor class.
	    FileProcessor file;
	    // Object declared for PrintWriter class.
	    PrintWriter writer;
	    // Object declared for MyLogger class.
	    MyLogger myLogger;

	    try{
	    	// command line validation for input file and output file respectively.
	    	String inputFile = "",outputFile = "";
		    if(3 == args.length){// validates given arguments array length to 5.
		    	if(!args[0].equals("${arg0}")){// validates 1st input file argument value.
		    		inputFile = args[0];
		    	}
		    	else{
		    		throw new Exception("Please provide input file.");
		    	}

		    	if(!args[1].equals("${arg1}")){// validates 2nd output file argument value.
					outputFile = args[1];
		    	}
		    	else{
		    		throw new Exception("Please provide output file.");
		    	}

		    	if(!args[2].equals("${arg2}")){// validates 3rd my Logger Level value.
		    		myLogger = new MyLogger();
					myLogger.setDebugValue(Integer.parseInt(args[2]));
		    	}
		    	else{
		    		//By default my logger level is 0;
		    	}
		    }
		    else{
		    	throw new Exception("Please pass exactly 2 arguments one for input and another for output files.");
		    }

		    // Object intialized for FileProcessor with respective input file.
			file = new FileProcessor(inputFile);
			// The input values are read from file and stored treeBuilder object in BST format.
			
			results = new Results();
			AirportSecurity airportSecurity = new AirportSecurity();
			String line;
		    while ((line = file.readLine(true)) != null)
		    {
		    	// Read line is split into array of string based on '":" charecter.
		    	String[] lineArr = line.split(";");
		    	HashMap<String, String> securityData = new HashMap<>();
		    	for(String lineTuple : lineArr){
		    		String[] tuple = lineTuple.split(":");
		    		if(!tuple[0].equals(null) && !tuple[1].equals(null)){
		    			securityData.put(tuple[0], tuple[1]);
		    		}
		    	}
		    	airportSecurity.tightenOrLoosenSecurity(securityData);
		    	results.storeNewResult(airportSecurity.operate());
		    }
		    // closes the file resader.
		    file.readLine(false);

		   	// Object for PrintWriter is intialized with respective output file name and encoding format.
		   	// To write original Tree to the output file.
		   	writer = new PrintWriter(outputFile, "UTF-8");
		    // writeAll method from Results class is called with writer object to write the test case results to the output file.
		    results.writeAll(writer);
		    // writer object is closed.
		    writer.close();

		    System.out.println("Output files generated successfully.");
	    }
	    catch(Exception ex){
	    	System.err.println(ex.getMessage());// prints the error message.
	    	ex.printStackTrace();// prints stack trace.
	    	System.exit(0);
	    }
	    finally{// Clears all the objects created.
		    results = null;
		    file = null;
		    writer = null;
	    }
	}
}