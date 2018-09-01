/*Policyauto inherits variables and objects created in the Policy subclass */

public class Policyauto extends Policy {
	private String VIN;
	private String vehicleMake;
	private String vehicleModel;
	private int year;
	private int numAccidents;
	private int vehicleAge;
	
	/* Empty Policyauto constructor */

	public Policyauto(){
		super();
		VIN = " ";
		vehicleMake = " ";
		vehicleModel = " ";
		
		year = 0;
		numAccidents = 0;
		vehicleAge = 0;
	}

	/*Policyauto object with policy number, policy creation date,
		yearly premium amount, vehicle identification number, make of vehicle,
		model of vehicle, year of vehicle, customer's name, customer's address,
		customer's city, customer's state, number of accidents, and the vehicle age
		as parameters. 

		@param pnumber stores the string value of the policyNum in Policy object from Policy class
		@param pdate stores the string value of the policyDate in Policy object from Policy class
		@param ypa stores the double value of ypa in Policy object from Policy class
		@param VIN stores the string value of VIN
		@param vehicleMake stores the string value of vehicleMake
		@param vehicleModel stores the string value of vehicleModel
		@param year stores the integer value of year
		@param name stores the string value of name in Policyholder object from Policyholder class
		@param address stores the string value of address in Policyholder object from Policyholder class
		@param city stores the string value of city in Policyholder object from Policyholder class
		@param state stores the string value of state in Policyholder object from Policyholder class
		@param numAccidents stores the integer value of numAccidents
		@param vehicleAge stores the integer value of vehicleAge */
	
	public Policyauto(String pnumber,
						String pdate, 
						double ypa, 
						String VIN, 
						String vehicleMake, 
						String vehicleModel,
						int year,
						String name,
						String address,
						String city,
						String state,
						int numAccidents,
						int vehicleAge){
		super(pnumber,pdate,ypa);
		this.setVIN(VIN);
		this.setMake(vehicleMake);
		this.setModel(vehicleModel);
		this.setYear(year);
		pHolder = new Policyholder(name, address, city, state);
		this.setAccidents(numAccidents);
		this.setVehicleAge(vehicleAge);
	}

	/*setVIN method stores a value in the VIN variable 

		@param VIN The value to store into VIN */

	public void setVIN(String VIN){
		this.VIN = VIN;
	}

	/*setMake method stores a value in the make variable

		@param make The value to store into make */
	
	public void setMake(String make){
		this.vehicleMake = make;
	}

	/*setModel method stores a value in the make variable

		@param model The value to store into model */
	
	public void setModel(String model){
		this.vehicleModel = model;
	}

	/*SetYear method stores a value into the year variable

		@param year The value to store into year */
	
	public void setYear(int year){
		this.year = year;
	}

	/*setAccidents method stores a value into the accidents variable

		@param accidents The value to store into accidents */
	
	public void setAccidents(int accidents){
		this.numAccidents = accidents;
	}

	/*setVehicleAge method stores a value into the vehicleAge variable

		@param va The value to store into vehicleAge */
	
	public void setVehicleAge(int va){
		va = 2014 - year;
		this.vehicleAge = va;
	}
	
	/*getVIN method returns the value stored in VIN variable */

	public String getVIN(){
		return VIN;
	}
	
	/*getMake method returns the value stored in vehicleMake variable */

	public String getMake(){
		return vehicleMake;
	}

	/*getModel method returns the value stored in vehicleModel variable */
	
	public String getModel(){
		return vehicleModel;
	}

	/*getYear method returns the value stored in year variable */
	
	public int getYear(){
		return year;
	}

	/*getAccidents method returns the value stored in numAccidents variable */
	
	public int getAccidents(){
		return numAccidents;
	}

	/*getVAge method returns the value stored in vehicleAge variable */
	
	public int getVAge(){
		vehicleAge = 2014 - year;
		return vehicleAge;
	}

	/*toStringOut method prints the toStringOut method from the Policy parent class
		as well as the data from this class in a more readable format for the user */
	
	public void toStringOut(){
		super.toStringOut();
		System.out.println("VIN: " + VIN +
							"\nMake: " + vehicleMake +
							"\nModel: " + vehicleModel +
							"\nYear: " + year + 
							pHolder.toString() +
							"\n# of Accidents: " + numAccidents +
							"\nVehicle Age: " + vehicleAge);			
	}
	
	/*calculateMonthlyPremium method factors in if the customer has had 0 accidents to 
		reduce the yearly premium amount(ypa) by $200, and if the vehicle is under 6 
		years old to reduce the ypa by $100. Once these are factored in, the 
		calculateMonthlyPremium method from the Policy subclass is called to calculate 
		the monthly premium amount. */
 
	public void calculateMonthlyPremium(){
		
		if (numAccidents == 0) {
			ypa -= 200.00;
		}
		if (vehicleAge > 6) {
			ypa -= 100.00;
		}
		super.calculateMonthlyPremium();
	}
	
} /*END OF DOCUMENT */
