/*Policyproperty is a child class of the Policy subclass */

public class Policyproperty extends Policy {
	private String sqft;
	private String yb;
	private boolean firestat;
	private boolean gated;
	
	/*Empty Policyproperty constructor */

	public Policyproperty(){
	sqft = " ";
	yb = " ";
	firestat = false;
	gated = false;
	}

	/*Policyproperty object that stores policy number, policy date, yearly 
		premium amount, square footage of property, year property was built, 
		customer name, customer's address, customer's city, customer's state, 
		if the customer lives near a firestation, and if the customer lives in a 
		gated commmunity.

		@param policyNum stores the string value of policyNum from Policy subclass
		@param policyDate stores the string value of policyDate from Policy subclass
		@param ypa stores the double value of ypa from Policy subclass
		@param sqft stores the string value of sqft
		@param yb stores the string value of yb
		@param name stores the string value of name
		@param address stores the string value of address
		@param city stores the string value of city
		@param state stores the string value of state
		@param firestat stores the boolean value of firestat
		@param gated stores the boolean value of gated */

	public Policyproperty(String policyNum,
							String policyDate, 
							double ypa,
							String sqft,
							String yb,
							String name,
							String address,
							String city,
							String state,
							boolean firestat,
							boolean gated){
		super(policyNum,policyDate,ypa);
		this.setSqft(sqft);
		this.setYearbuilt(yb);
		pHolder = new Policyholder(name, address, city, state);
		this.setFirestat(firestat);
		this.setGated(gated);
	}

	/*setSqft method stores a value in the sqft variable 

		@param sqft The value to be stored in sqft */
	
	public void setSqft(String sqft){
		this.sqft = sqft;
	}
	
	/*setYearbuilt method stores a value in the yb variable

		@param yb The value to be stored in yb */

	public void setYearbuilt(String yb){
		this.yb = yb;
	}

	/*setFirestat method stores a value in the firestat variable

		@param firestat The value to be stored in firestat */
	
	public void setFirestat(boolean firestat){
		this.firestat = firestat;
	}

	/*setGated method stores a value in the gated variable

		@param gated The value to be stored into gated */
	
	public void setGated(boolean gated){
		this.gated = gated;
	}

	/*getSqft method returns the value stored in sqft */
	
	public String getSqft(){
		return sqft;
	}
	
	/*getYearbuilt method returns the value stored in yb */

	public String getYearbuilt(){
		return yb;
	}

	/*getFirestat method returns the value stored in firestat */
	
	public boolean getFirestat(){
		return firestat;
	}

	/*getGated method returns the value stored in gated */
	
	public boolean getGated(){
		return gated;
	}

	/*writeOutput method calls the writeOutput method from the Policy 
		parent class and prints the data from this class in a readable 
		format */
	
	public void writeOutput(){
		super.writeOutput();
		System.out.print("Sqft of Property: " + sqft +
							"\nYear Built: " + yb +
							pHolder.toString() +
							"\nNear Firestation: " + firestat +
							"\nGated Community: " + gated
							+"\n");
	}
	
	/*calculateMonthlyPremium method checks to see if the customer lives 
		near a firestation and if they do reduces yearly monthly premium 
		amount (ypa) by $200, then checks to see if the customer lives in 
		a gated community and if they do reduces their ypa by $100. 
		
		Then the calculateMonthlyPremium is called from the Policy subclass 
		to calculate the monthly premium. */

	public void calculateMonthlyPremium(){
		if(firestat == true){
			ypa -= 200.00;
		}
		if(gated == true){
			ypa -= 100.00;
		}
		super.calculateMonthlyPremium();
	}
} /*END OF DOCUMENT */
