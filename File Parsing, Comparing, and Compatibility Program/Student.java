public class Student {

String Name;

private int [] surveyRes = new int [50];				//array for storing survey answers	

/*Student method used for getting the student names 
	then converting the rest of the responses into integer
	values 

	@param tokens The string array of the tokens gathered 
		from the file */

public Student (String[] tokens){

	Name=tokens[0];										//gets the first column of names in the csv file and stores them as string "Name"

	for (int i=1; i<tokens.length;i++) {

		surveyRes[i-1]=Integer.parseInt(tokens[i]); 	//turns the rest of tokens into integers

	}

}

/*getSurveyRes method returns a specific index from the 
	array of survey results 

	@param index The index value to be returned from the 
		array */

public int getSurveyRes(int index){						

	return surveyRes[index];

}

/*compare method for comparing the answers of each student's choice in survey results 
	with the other students' choices, if they share the same
	response as another student, simnum (similar answers variable) increases by 1
	so long that the survey response is not null. 

	Returns the number of similar answers (simnum)

	@param otherStudent The Student object to be compared to the current student */

public int compare(Student otherStudent){				//method for comparing students
	int simnum=0;										//variable for storing number of similar answers
	
	for (int i = 0; i < surveyRes.length; i++ ) {       
	            
	            if(surveyRes[i]==(otherStudent.getSurveyRes(i)) && surveyRes[i]!=-1){
	            
	            	simnum++;
	            
	            }
	
	}
	
	return simnum;
}

/*toString method returns the string variable name */

public String toString(){								
	
	return Name;

}

} /*END OF DOCUMENT */
