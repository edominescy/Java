/*
Erin Dominescy
12/5/2014
*/


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Driver {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		File file = new File("2013ALL.csv");								//establishes file location
		BufferedReader fileReader = null;									//Names and sets BufferedReader
		HashMap<String, Integer> map = new HashMap<String, Integer>();		//creates Hashmap of String keys and Integer values

		final String delimOne = " ";										//sets first delimiter as a space
		final String delimTwo = ",";										// sets second delimiter as a comma

		
		String line = "";										// temp string variable
		fileReader = new BufferedReader(new FileReader(file));	//sets the BufferedReader to read 2013ALL.csv file
		String[] tokens;										//creates string array of tokens
		ArrayList<String> list = new ArrayList<String>();		//creates arraylist for tokens
		while ((line = fileReader.readLine()) != null) {		//while the file still has lines to be read,
			tokens = line.split(delimOne);						//splits line where there is a space
			if (tokens[0].equals("@attribute"))					// if the first word before space is "@attribute"
				list.add(tokens[1]);							//add the second word after the space to the arraylist
			else if (tokens[0].equals("@data"))					// else if first word before space is "@data"
				break;											//then break the loop
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.println("Attribute " + i + " " + list.get(i));					//prints arraylist in proper format
		}

		System.out.println("What attribute would you like to summarize (0..23)?");		//requests user input for number from 0 to 23
		Scanner in = new Scanner(System.in);											//creates scanner
		int userin = in.nextInt();														//sets integer variable to store user input
		
		if (userin <= 23 && userin >= 0) {												//if user input is less than or equal to 23 or greater than or equal to 0
				System.out.println("Summarizing attribute " + userin);			
			
				while ((line = fileReader.readLine()) != null) {								//while file still has a next line
						tokens = line.split(delimTwo);											//splits line where there is commas
								if (map.containsKey(tokens[userin])) {							//if there is already a value at the key the user input
										map.put(tokens[userin], map.get(tokens[userin]) + 1);	// add one to the value
								} else															//else
										map.put(tokens[userin], 1);								//put one as the value to set the value as a new key
								}
	
						String [] keys = map.keySet().toArray(new String[map.size()]);				//creates an array of keys
			
						for(String key:keys){														//for each and every key in the keys array
								System.out.println(key + " appeared " + map.get(key) + " times");	//states the number of times each key appears
						}		
				System.out.println("There were " + keys.length + " unique attributes values.");		//states the number of keys in the keys array 
				} else
						System.out.println("Not a valid input.");									//The user input an invalid input

	}
}
