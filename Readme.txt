[Date: 10/19/2017]
[By: Aravindhan Venkituswamy]

Assuming you are in the directory containing this README:
go to airportSecurityState directory then,

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=FIRST -Darg1=SECOND -Darg2=THIRD

-----------------------------------------------------------------------

## To create tarball for submission

tar -czvf airportSecurityState.tar.gz --exclude=.* airportSecurityState

-----------------------------------------------------------------------

## To unzip tarball for execution

tar -xvf airportSecurityState.tar.gz

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

Result array list: O(n)

Used context class to maintain state variables like airportState(current State), day. travellersCount, prohibitedItemsCount, avgTraffic, avgprohibitedItems etc.

Used AirportStateI interface and implemented the same in HighRisk, ModerateRisk, and LowRisk classes.

Used AirportStateHelper to perform relevant calculations for state classes.

General Execution:

Driver class will call the context class - tightenOrLoosenSecurity Method, which in turn will calls the respective current state class tightenOrLoosenSecurity Method to calculate the context class variables and changes the airportState(current state variable in context class) as well. 

Then the driver class calls operate method to store the resulted operation in result array of result class, again the call is made through context class to current state class as mentioned above.

average traffic: total number of travelers(travelersCount is maintained) / total number of days(day as such is taken) 
average prohibited item: total number of prohibited item(prohibitedItemsCount is maintained) / total number of days(day as such is taken).

Logger:
0: RESULT - no logger message is printed.
1: DATA_NEEDED - most required input data say day and item for each file line is printed as logger message.
2: STATE_CHANGE - the state changes are notified as logger message.
3: RESULTS_OUTPUT - result output is printed as logger message.
4: CONSTRUCTOR - to print constructor entry for each class as logger message.

-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).
https://dzone.com/articles/design-patterns-state
https://www.youtube.com/watch?v=MGEx35FjBuo&t=354s