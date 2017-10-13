package airportSecurityState.driver;

//Header to import supporting classes.
import airportSecurityState.util.Results;
import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.MyLogger;
import java.io.PrintWriter;

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

	    try{
	    	// command line validation for input file and output file respectively.
	    	String inputFile = "", deleteFile = "", output1File = "", output2File = "", output3File = "";
		    if(5 == args.length){// validates given arguments array length to 5.
		    	if(!args[0].equals("${arg0}")){// validates 1st input file argument value.
		    		inputFile = args[0];
		    	}
		    	else{
		    		throw new Exception("Please provide input file.");
		    	}

		    	if(!args[1].equals("${arg1}")){// validates 2nd delete file argument value.
					deleteFile = args[1];
		    	}
		    	else{
		    		throw new Exception("Please provide output file.");
		    	}

		    	if(!args[2].equals("${arg2}")){// validates 3rd output1 file argument value.
					output1File = args[2];
		    	}
		    	else{
		    		throw new Exception("Please provide output file.");
		    	}

		    	if(!args[3].equals("${arg3}")){// validates 4th output2 file argument value.
					output2File = args[3];
		    	}
		    	else{
		    		throw new Exception("Please provide output file.");
		    	}

		    	if(!args[4].equals("${arg4}")){// validates 5th output3 file argument value.
					output3File = args[4];
		    	}
		    	else{
		    		throw new Exception("Please provide output file.");
		    	}
		    }
		    else{
		    	throw new Exception("Please pass exactly 5 arguments one for input and another for output files.");
		    }

		    // Object intialized for FileProcessor with respective input file.
			file = new FileProcessor(inputFile);
			// The input values are read from file and stored treeBuilder object in BST format.
			String line;
		    while ((line = file.readLine(true)) != null)
		    {
		    	// Read line is split into array of string based on '":" charecter.
		    	String[] lineValues = line.split(":");
		    }
		    // closes the file reader.
		    file.readLine(false);

		    // Object declared for Results class.
		    results = new Results();

		   	// Object for PrintWriter is intialized with respective output file name and encoding format.
		   	// To write original Tree to the output file.
		   	writer = new PrintWriter(output1File, "UTF-8");
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