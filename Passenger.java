//Chana Riva Levine 
//Hadass d'Ancona

package TravelAgency;

import java.time.LocalDate;

public class Passenger extends Person{
	private int ID;
	private Passport passport;
	
	public Passenger(String firstname, String lastname, char gender, String phonenumber, String street, String city, String state, String zipcode, int ID, Passport passport) 
		throws InvalidDataException
	{
		super(firstname, lastname, gender, phonenumber, street, city, state, zipcode);
		if(ID == 0) {
			throw new InvalidDataException("Please fill in the required fields.");
		}
		else {
			this.ID = ID;
			this.passport = new Passport(passport);
		}
		
	}//End of ctor
	
	public Passenger(String firstname, String lastname, char gender, String phonenumber, Address adrs, int ID, Passport passport)
			throws InvalidDataException
		{
			super(firstname, lastname, gender, phonenumber, adrs);
			if(this.ID == 0) {
				throw new InvalidDataException("Please fill in the required fields.");
			}
			else {
				this.ID = ID;
				this.passport = new Passport(passport);
		}
	}//End of ctor
	
	public boolean hasPassport() throws InvalidDataException
	{
		if(passport.isExpired()) {
			throw new InvalidDataException("Your passport is expired.");
		}
		else if(passport.equals(null)) {
			return false;
		}
		else
		{
			return true;
		}
	}//End of hasPassport
	
	public void setPassport(Passport p) {this.passport = new Passport(p);}
	public Passport getPassport() {return this.passport;}
	
	public int getID() {return this.ID;}

}
