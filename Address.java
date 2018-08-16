//Chana Riva Levine 
//Hadass d'Ancona

package TravelAgency;

public class Address {
	private String street, city, state, zipcode;
	
	public Address(String street, String city, String state, String zipcode) 
		throws InvalidDataException
	{
		if(street.equals("") || city.equals("") || state.equals("") || zipcode.equals("")) {
			throw new InvalidDataException("Please fill in the required fields.");
		}
		else {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		}
	}
	
	public Address(Address a) {
		this.street = a.street;
		this.city = a.city;
		this.state = a.state;
		this.zipcode = a.zipcode;
	}
	
	public String getStreet() {return street;}
	public void setStreet(String street) {this.street = street;}
	
	public String getCity() {return city;}
	public void setCity(String city) {this.city = city;}

	public String getState() {return state;}
	public void setState(String state) {this.state = state;}

	public String getZipcode() {return zipcode;}
	public void setZipcode(String zipcode) {	this.zipcode = zipcode;	}
	
	public String toString() {
		return "Address - " + this.street + ", " + this.city + " " + this.state + ", " + this.zipcode;
	}

}
