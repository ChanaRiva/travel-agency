//Chana Riva Levine 
//Hadass d'Ancona

package TravelAgency;

public class Person {
	private String firstname, lastname, phonenumber;
	char gender;
	private Address adrs;
	
	public Person(String firstname, String lastname, char gender, String phonenumber, Address adrs)
			throws InvalidDataException
	{
		if(firstname.equals("") || lastname.equals("") || phonenumber.equals("")) {
			throw new InvalidDataException("Please fill in the required fields.");
		}
		else if(gender != 'f' && gender != 'm') {
			throw new InvalidDataException("Invalid data entered. Please enter an 'm' for male or 'f' for female.");
		}
		else {
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.phonenumber = phonenumber;
		this.adrs = new Address(adrs);
		}
		
	
	}
	
	public Person(String firstname, String lastname, char gender, String phonenumber, String street, String city, String state, String zipcode) 
			throws InvalidDataException
	{
		if(firstname.equals("") || lastname.equals("")||phonenumber.equals("")|| street.equals("") || city.equals("")|| state.equals("") || zipcode.equals("")) {
			throw new InvalidDataException("Please fill in the required fields.");
		}
		else if(gender != 'f' && gender != 'm') {
			throw new InvalidDataException("Invalid data entered. Please enter an 'm' for male or 'f' for female.");
		}
		else {
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.phonenumber = phonenumber;
		adrs = new Address(street, city, state, zipcode);
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this.getClass().equals(obj.getClass())) {
			Person that = (Person)obj;
			if(firstname.equals(that.getFirstName()) && lastname.equals(that.getLastName()) && phonenumber.equals(that.getPhoneNumber())) {
				return true;
			}
		}
		return false;
	}
	
	public String getFirstName() {return firstname;}
	public void setFirstName(String firstname) {this.firstname = firstname;}
	
	public String getLastName() {return lastname;}
	public void setLastName(String lastname) {this.lastname = lastname;}
	
	public char getGender() {return gender;}
	public void setGender(char gender) {this.gender = gender;}
	
	public Address getAddress() {return adrs;}
	public void setAddress(Address adrs) {this.adrs = new Address(adrs);}
	
	public String getPhoneNumber() {return phonenumber;}
	public void setPhoneNumber(String phonenumber) {this.phonenumber = phonenumber;}

	public String toString() {
		return this.firstname + " " + this.lastname + "\n" + 
			   "Gender - " + this.gender + "\n" + 
			   "Phone number - " + phonenumber + "\n" +
			   adrs;
	}
}
