public class Policyholder {
	private String name;
	private String address;
	private String city;
	private String state;

	/*Empty Policyholder constructor */

	public Policyholder() {
		name = " ";
		address = " ";
		city = " ";
		state = " ";
	}

	/*Policyholder object that stores customer's name, address, city, and state.

		@param name stores the string value of name
		@oaram address stores the string value of address
		@param city stores the string value of city
		@param state stores the string value of state */

	public Policyholder(String name, String address, String city, String state) {
		this.setName(name);
		this.setAddress(address);
		this.setCity(city);
		this.setState(state);
	}

	/*setName method stores a value in the name variable

		@param name The value to store in name */

	public void setName(String name) {
		this.name = name;
	}

	/*setAddress method stores a value in the address variable

		@param address The value to store in address */

	public void setAddress(String address) {
		this.address = address;
	}

	/*setCity method stores a value in the city variable

		@param city The value to store in city */

	public void setCity(String city) {
		this.city = city;
	}

	/*setState method stores a value in the state variable

		@param state The value to store in state */

	public void setState(String state) {
		this.state = state;
	}

	/*getName method returns the value stored in name */

	public String getName() {
		return name;
	}

	/*getAddress method returns the value stored in address */

	public String getAddress() {
		return address;
	}

	/*getCity method returns the value stored in city */

	public String getCity() {
		return city;
	}

	/*getState method returns the value stored in state */

	public String getState() {
		return state;
	}

	/*toString method returns the printed data from this class in a 
		readable format */
	
	public String toString(){
		String string = "\nPolicy Holder: " + name +
							"\nAddress: " + address +
							"\nCity: " + city +
							"\nState: " + state;
		return string;
	}

} /*END OF DOCUMENT */
