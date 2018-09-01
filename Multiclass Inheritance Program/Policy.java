import java.text.DecimalFormat; //to convert doubles into money format


public class Policy {
	protected String policyNum;
	protected String policyDate;
	protected double ypa;
	protected double mpa;
	
	/*new DecimalFormat object called "dollar" for turning doubles into money format */

	DecimalFormat dollar = new DecimalFormat("0.00"); 

	/*new Policyholder object called "pHolder" created */

	Policyholder pHolder = new Policyholder();
	
	/*Empty Policy constructor */

	public Policy(){
		policyNum = " ";
		policyDate = " ";
		ypa = 0.00;
	}
	
	/*Policy object that stores a person's policy number, date the policy was created, and 
		their yearly premium amount

		@param policyNum stores the string value of policyNum
		@param policyDate stores the string value of policyDate
		@param ypa stores the double value of ypa */

	public Policy(String policyNum, String policyDate, double ypa){
		this.setNumber(policyNum);
		this.setDate(policyDate);
		this.setYPA(ypa);
	}

	/*setNumber method stores a value in policyNum variable

		@param policyNum The value to store in policyNum */
	
	public void setNumber(String policyNum){
		this.policyNum = policyNum;
	}

	/*setDate method stores a value in the policyDate variable

		@param policyDate The value to store in policyDate */
	
	public void setDate(String policyDate){
		this.policyDate = policyDate;
	}
	
	/*setYPA method stores a value in the ypa variable

		@param ypa The value to store in ypa */

	public void setYPA(double ypa){
		this.ypa = ypa;
	}
	
	/*getNumber method returns the value stored in the policyNum variable */

	public String getNumber(){
		return policyNum;
	}
	
	/*getDate method returns the value stored in the policyDate variable */

	public String getDate(){
		return policyDate;
	}
	
	/*getYPA method returns the value stored in the ypa variable */

	public double getYPA(){
		return ypa;
	}
	
	/*toStrongOut method prints out the data from the variables in a more
		readable format for the user */

	public void toStringOut(){
		System.out.println("\nPolicy Number: " + policyNum +
							"\nPolicy Date: " + policyDate +
							"\nYearly Premium Amount: " + dollar.format(ypa) +
							"\nMonthly Premium Amount: " + dollar.format(mpa));
	}
	
	/*calculateMonthlyPremium method calculates the monthly premium amount 
		each customer pays given their yearly premium amount */

	public void calculateMonthlyPremium(){
		mpa = ypa/12.0;
	}
}

/*End of document */
