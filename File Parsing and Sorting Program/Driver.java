import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* 
Name: Erin Dominescy
Current Date: 7/18/2014 
Honor Code Statement: In keeping with the honor code policies of the University of 
Mississippi, the School of Engineering, and the Department of Computer and Information 
Science, I affirm that I have neither given nor received assistance on this programming 
assignment. This assignment represents my individual, original effort. 
... My Signature is on File.
*/

public class Driver {

	/*Scanner variable instantiated and called scan */

	private static Scanner scan;	

	/*main method */

	public static void main(String[] args) throws FileNotFoundException {

		/*scan is instructed to read the data from data.txt file */

		scan = new Scanner(new File("data.txt"));

		/*Work object created called work */

		Work work = new Work();

		/*while loop where tokenizing of each piece of data that is separated by a comma is taken
			where the data before the first comma is tokenized under name, the data after the first 
			comma is tokenized as position, and the data following the second comma is the year and 
			added to the person ArrayList. The year is converted into an integer.

			This processs is repeated while the file has another token. */

		while (scan.hasNext()) {
			String line = scan.nextLine();
			String[] tokens = line.split(",");
			work.addPerson(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
		}

		/*Printing of unsorted data by calling displayData method */

		System.out.println("*****************Unsorted Data*****************" + "\n");
		work.displayData();

		/*calling the Sort method to sort the ArrayList in the work object */

		work.Sort();

		/*Printing of freshly sorted data */

		System.out.println("******************** Sorted by Age ********************" + "\n");
		work.displayData();

		/*calling the Search method to find out if anyone in the Arraylist is
			 72, 17, or 25 years old */

		System.out.println("************* Searching for Age *************" + "\n");
		work.search(72);
		work.search(17);
		work.search(25);

		/*Save method is called to write the sorted ArrayList to "workerlist.txt" file */

		work.Save("workerlist.txt");

	}

}

/*end of program */
