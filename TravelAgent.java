//Chana Riva Levine 
//Hadass d'Ancona

package TravelAgency;

public class TravelAgent extends Person {
	private int earnings = 0;
	private String employeeID, ssn;
	private static double commissionrate = .1;
	
	public TravelAgent(String firstname, String lastname, char gender, String phonenumber, String street, String city, String state, String zipcode, String ssn, String employeeID, int earnings)
		throws InvalidDataException
	{
		super(firstname, lastname, gender, phonenumber, street, city, state, zipcode);
		if(employeeID.equals("")|| ssn.equals("")) {
			throw new InvalidDataException("Please fill in required fields.");
		}
		else {
			this.employeeID = employeeID;
			this.ssn = ssn;
		}
		
	}
	
	public TravelAgent(String firstname, String lastname, char gender, String phonenumber, Address adrs, String ssn, String employeeID)
		throws InvalidDataException 
	{
		super(firstname, lastname, gender, phonenumber, adrs);
		if(employeeID.equals("")||ssn.equals("")) {
			throw new InvalidDataException("Please fill in required fields.");
		}
		else {
			this.employeeID = employeeID;
			this.ssn = ssn;
		}
	}
	
	public String getEmployeeID() {return employeeID;}
	public int getEarnings() {return earnings;}
	public String getSSn() {return ssn;}
	public static double getCommissionrate() {return commissionrate;}
	public static void setCommissionrate(double commissionrate) {TravelAgent.commissionrate = commissionrate;}
	
	public void bookTicket(double price) {
		earnings += commissionrate*price;
	}
	
	public String toString() {
		return "Employee ID - " + employeeID + "\n" +
				"Social Security Number - " + ssn + "\n" +
				"Commission Rate - " + commissionrate + "\n" +
				"Earnings - " + earnings;
	}

}
