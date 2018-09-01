import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* 
Name: Erin Dominescy 
Current Date: 7/14/2014 
Honor Code Statement: In keeping with the honor code policies of the University of 
Mississippi, the School of Engineering, and the Department of Computer and Information 
Science, I affirm that I have neither given nor received assistance on this programming 
assignment. This assignment represents my individual, original effort. 
... My Signature is on File.
*/

public class Driver {

	/*Scanner variable */

	private static Scanner scan;

	/*main method */

	public static void main(String[] args) throws FileNotFoundException {
	
		/*instantiated integer variable to 0 */

		int index = 0;
		
		/*created new scanner object to read "autodata.txt" file for input */

		scan = new Scanner(new File("autodata.txt"));

		/*created a new String array with an index of 7 called a */

		String[] a = new String[7];
		
		
		/*while "autodata.txt" has next token, for each new line, increase the index of array a */

		while (scan.hasNext()) {
				String line = scan.nextLine();
				a[index++] = line;
		}
	
		/*for loop for tokenizing data from file */

		for (int i = 0; i < (a.length); i++) {
				String[] tokens = a[i].split(",");

				/*if only three pieces of data are tokenized, then a new policy object is created
					and the first piece of data is the policyNum parameter, the second is the policyDate
					parameter, and the last is the ypa (yearly premium amount) parameter.

					The calculateMonthlyPremium method and the toStringOut method are called from the 
					Policy class to calculate the monthly premium amount and print the data in a more
					readable format.  */

				if(tokens.length == 3){
						Policy p = new Policy(tokens[0], 
											tokens[1], 
											Double.parseDouble(tokens[2]));
						p.calculateMonthlyPremium();
						p.toStringOut();	
				}
				
				/*if 11 pieces of data are tokenized, then a new Policyproperty object is created 
					and filled with the data respective to its parameters.

					The calculateMonthlyPremium and toStringOut methods are called from the Policyproperty
					class to calculate the monthly premium amount and print the data in a more readable
					format. */

				else if(tokens.length == 11){
						Policyproperty p = new Policyproperty(tokens[0], 
															tokens[1], 
															Double.parseDouble(tokens[2]),
															tokens[3],
															tokens[4],
															tokens[5],
															tokens[6],
															tokens[7],
															tokens[8],
															Boolean.parseBoolean(tokens[9]),
															Boolean.parseBoolean(tokens[10]));
						p.calculateMonthlyPremium();
						p.toStringOut();	
				}
				
				/*if 12 pieces of data are tokenized, then a new Policyauto object is created and 
					and filled with the data respective to its parameters.

					The calculateMonthlyPremium and toStringOut methods are called from the Policyauto 
					class to calculate the monthly premium amount and print the data for the customer 
					in a more readable format. */

				else if(tokens.length == 12){
						Policyauto p = new Policyauto(tokens[0], 
													tokens[1], 
													Double.parseDouble(tokens[2]),
													tokens[3],
													tokens[4],
													tokens[5],
													Integer.parseInt(tokens[6]),
													tokens[7],
													tokens[8],
													tokens[9],
													tokens[10],
													Integer.parseInt(tokens[11]),
													Integer.parseInt(tokens[6]));
						p.calculateMonthlyPremium();
						p.toStringOut();		
				}
		}
	}
}