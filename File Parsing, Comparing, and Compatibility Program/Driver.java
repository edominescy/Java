/*
 Erin Dominescy
 2/14/2016
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Driver {

	private static final int NUM_QUESTIONS = 50;			//created a constant for number of survey questions

	public static void main(String[] args) throws FileNotFoundException {	

			String split=",";						//set delimiter to comma

			int numstudents=0;						//instantiated numstudents variable to 0
			
			/*Arrays for storing the totals of 0s, 1s, and null answers (-1) respectively */

			int [] sum0= new int [NUM_QUESTIONS];	//array for storing the number of 0s
			int [] sum1= new int [NUM_QUESTIONS];	//array for storing the number of 1s
			int [] sumi= new int [NUM_QUESTIONS];	//array for storing the number of -1s


			ArrayList <Student> studentList = new ArrayList<Student>();		//arraylist of students
			
			
			Scanner scan = new Scanner (new File("EitherOrResults.csv"));		//scanner for reading in files

			while(scan.hasNextLine()){							//while the csv file has another line
					numstudents++;								// count number of lines for number of students
					String str = scan.nextLine();				//sets string variable to read next line
					String[] tokens=str.split(split);			//separates the names by the delimiter

					studentList.add(new Student(tokens));		//stores the names in the arraylist

			}

			scan.close();			//closes scanner

			Scanner scan2 = new Scanner(new File("choices.txt"));		//new scanner for reading the txt file

			/*Part One of the Assignment: Print the results of the survey. Invalids = -1 = no answer given. */

			System.out.println("\nPart One: \n\n");						
			System.out.println("Class Summary: \n");			

			/*for loop that goes through each of the questions and counts the 
				0s, 1s, and -1s for each student case switch to tally each answer 
				and prints the total sums for each answer type in a readable format */

			for(int i=0; i<NUM_QUESTIONS; i++){						
					for(int j=0; j<numstudents; j++){
							 switch(studentList.get(j).getSurveyRes(i)){	//creates switch case for getting and 
								    case -1:								// adding the columns of the csv file by -1s, 0s, and 1s
					    				sumi[i]++;
					    				break;
								    case 0:
					   				 	sum0[i]++;
					    				break;
					   				case 1:
					    				sum1[i]++;
					    				break;
					  		 }
					}
			System.out.println(scan2.nextLine() + ": " + sum0[i] + "\t\t" +		//prints the choices by line for the
					scan2.nextLine() + ": " + sum1[i]+ "\t\tInvalid: " 			//either/or and invalid options as well 
					+ sumi[i]);													//as each of their sums
			}

			scan2.close();			//closes choices.txt scanner
			
			
			/*Part Two of the Assignment: Find the most compatible students and least compatible students and 
				how many answers they had in common respectively. */

			System.out.println("\n\n Part Two\n");						//Print statement indicating part two

			ArrayList <Integer> wpair = new ArrayList<Integer>();		//Creates an int arraylist of worst pair

			ArrayList <Integer> bpair = new ArrayList<Integer>();		//Creates an int arraylist of best pair

			int wvalue=NUM_QUESTIONS;		//sets worst value to 50
			int bvalue=0;					//instantiates best value variable to 0
			int currentv=0;					//instantiates current value variable to 0

			/* for loops for comparing current value (currentv) variable with best (bvalue) and worst (wvalue) value.
				for each student in numstudents - 1 (so there is no comparing the same person) and each student 
					starting with the second student in the arraylist, it will loop through comparing the 
					students answers and getting those with the best values (the most compatible) and add 
					them to the best pair arraylist as well as those with the worst values (the least compatible) 
					and add those to the worst pair arraylist.

				If the current value is equal to the best value, then the students are added to the best pair 
				arraylist (bpair).

				If the current value is equal to the worst value, then the students are added to the worst pair 
				arraylist (wpair).

				If the current value is greater than the best value, then a new integer arraylist is created 
				called bpair and the students are added to that arraylist. The best value is then set to the 
				current value.

				If the current value is less than the worst value, a new integer arraylist is created called 
				wpair and the students are added to that arraylist. The worst value is then set to the current 
				value. */ 

			for (int i=0;i<numstudents-1;i++){
					for (int j=i+1; j<numstudents; j++){
							currentv = studentList.get(i).compare(studentList.get(j));	//sets current value to compare each student
							if (currentv==bvalue){						
									bpair.add(i);
									bpair.add(j);
							}
							if (currentv==wvalue){
									wpair.add(i);
									wpair.add(j);
							}
							if (currentv>bvalue){
									bpair=new ArrayList<Integer>();
									bpair.add(i);
									bpair.add(j);
									bvalue=currentv;
							}
							if (currentv<wvalue){
									wpair=new ArrayList<Integer>();
									wpair.add(i);
									wpair.add(j);
									wvalue=currentv;
							}
					}
			}
			
			/*print statements declaring how many of the 50 survey answers the most compatible students 
				answered similarly and who those students were */

			System.out.println("The student pair(s) with most similar taste have " + bvalue
								+ " of 50 answers in common.");			
			
			for (int i=0;i<bpair.size();i++){
					System.out.println(studentList.get(bpair.get(i))+ " and " + studentList.get(bpair.get(i+1)));
					i=i+1;
			}					//prints multiple pairs if found of students with most similar tastes

			/*print statements declaring how many of the survey questions the least compatible pair answered 
				similarly and who they were */
			
			System.out.println("The student pair(s) with least similar taste have " + wvalue
								+ " of 50 answers in common.");
			
			for (int i=0;i<wpair.size();i++){
					System.out.println(studentList.get(wpair.get(i)) + " and " + studentList.get(wpair.get(i+1)));
					i=i+1;
			}					//prints multiple pairs if found of students with least similar tastes
		
			
			/*Part Three of the Assignment: Find and print which students were most and least compatible to 
				me and how many answers we had in common respectively. */
			
			System.out.println("\n\n Part Three\n");			//Indicates Part Three
			
			ArrayList <Integer> wmatch = new ArrayList<Integer>();	//created new arraylists for worst and best matches
			
			ArrayList <Integer> bmatch = new ArrayList<Integer>();
			
			int wval2=NUM_QUESTIONS;			//wval2 instantiated to NUM_QUESTIONS (50)
			int bval2=0;						//bval2 instantiated to 0
			int cval2=0;						//cval2 instantiated to 0
			int myindex=0;						//variable for once my index number is found to store in
			String myname = "Erin D";			//string variable of my name as it appears in csv file

			for (int i = 0;i<numstudents;i++){		
					if(myname.equals(studentList.get(i))){
							myindex=i;						//goes through and finds my name and stores the index in variable "myindex"					
					}
			}
			
			/* for loop that goes through the arraylist and compares each students answers to my answers and 
				finds who is most and least compatible with me and how many answers we have in common. It first
				checks to make sure the student being compared with is not my index value, then if it is not, 
				proceeds with comparing values.

				If current value (cval2) is equal to best value (bval2) then that student is added to the best 
					match arraylist (bmatch).

				If current value is equal to worst value (wval2) then the student is added to the worst match 
					arraylist (wmatch).

				If current value is greater than best value, a new best match integer arraylist is created called 
					bmatch and the student is added to that arraylist. Best value is then set to current value.

				If current value is less than worst value, a new worst match integer arraylist is created called
					wmatch and the student is added to that arraylist. Worst value is then set to current value. */

			for (int i=0;i<numstudents;i++){
					cval2 = studentList.get(i).compare(studentList.get(myindex));	//compares students choices with mine
					if(i!=myindex){			//to do if not my index so it does not compare me with myself
							if (cval2==bval2){
									bmatch.add(i);
							}
							if (cval2==wval2){
									wmatch.add(i);
							}
							if (cval2>bval2){
									bmatch=new ArrayList<Integer>();
									bmatch.add(i);
									bval2=cval2;
							}
							if (cval2<wval2){
									wmatch=new ArrayList<Integer>();
									wmatch.add(i);
									wval2=cval2;
							}
					}
			}
			
			/*print statements declaring how many answers me and the student I'm most compatible with shared 
			and who they were */

			System.out.println("The student(s) with most similar taste to me have " + bval2
								+ " of 50 answers in common.");
			
			for (int i=0;i<bmatch.size();i++){
					System.out.println(studentList.get(bmatch.get(i)));
			}		

			/*print statements declaring how many answers me and the student I'm least compatible with shared 
			and who they were */
			
			System.out.println("The student(s) with least similar taste to me have " + wval2
								+ " of 50 answers in common.");
			
			for (int i=0;i<wmatch.size();i++){
					System.out.println(studentList.get(wmatch.get(i)));
			}		
		
		}

}			//END OF PROGRAM