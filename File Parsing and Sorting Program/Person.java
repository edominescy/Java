public class Person {
	String name;
	String position;
	int year;
	

	/*Empty Person Constructor*/

	public Person(){
		name = "";			
		position = "";
		year = 0;
	}

	/*Person Object that stores a person's name, job position, and year they were born
	*	@param name stores the string value of name
	*	@param position stores the string value of position
	*	@param year stores the integer value of year 
	*/
	
	public Person(String name, String position, int year){
		this.name = name;
		this.position = position;
		this.year = year;
	}
	
	/*setName method stores a value in the name field
		@param name The value to store in name */

	public void setName(String name){
		this.name = name;
	}
	
	/*setPosition method stores a value in the position field
		@param position The value to store in position */

	public void setPos(String position){
		this.position = position;
	}

	/*setYear method stores a value in the year field
		@param year The value to store in year */
	
	public void setYear(int year){
		this.year = year;
	}

	/*getName method returns a Person object's name
		@return The value in the name field */
	
	public String getName(){
		return name;
	}

	/*getPos method returns a Person object's job position
		@return The value in the position field */
	
	public String getPos(){
		return position;
	}

	/*getYear method returns a Person object's year of birth
		@return The value in the year field */

	public int getYear(){
		return year;
	}

	/*toString method returns the print statement for how the Person object data is displayed*/
	
	public String toString(){
		String string = "Name: " + getName() + "\nPosition: " + getPos() + "\nYear Born: " + getYear() + "\n";
		return string;
	}
	
	/*Reset method returns the string created for how to display each Person data
		in the written .txt file */

	public String Reset(){
		String string = getName() + ", " + getPos() + ", " + getYear();
		return string;
	}
}

/*end of class */
