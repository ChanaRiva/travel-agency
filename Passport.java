//Chana Riva Levine 
//Hadass d'Ancona

package TravelAgency;
import java.time.LocalDate;

public class Passport {
	private String passportID;
	private String firstName;
	private String lastName;
	private String birthplace;
	private LocalDate birthdate;
	private LocalDate issueDate;
	private LocalDate expirationDate;
	private String nationality;
	
	public Passport(String passportID, String firstName, String lastName, String birthdate, String birthplace, String issueDate, String expirationDate, String nationality)
		throws InvalidDataException
	{
		if(passportID.isEmpty()||firstName.isEmpty()|| lastName.isEmpty()||nationality.isEmpty()||birthplace.isEmpty()) {
			throw new InvalidDataException("Please fill in the required fields.");
		}
		else {
			this.passportID = passportID;
			this.firstName = firstName;
			this.lastName = lastName;
			this.birthdate = LocalDate.parse(birthdate);
			this.birthplace = birthplace;
			this.issueDate = LocalDate.parse(issueDate);
			this.expirationDate = LocalDate.parse(expirationDate);
			this.nationality = nationality;
		}
	}//End of ctor
	
	public Passport(Passport p) {
		this.passportID = p.passportID;
		this.firstName = p.firstName;
		this.lastName = p.lastName;
		this.birthplace = p.birthplace;
		this.birthdate = p.birthdate;
		this.issueDate = p.issueDate;
		this.expirationDate = p.expirationDate;
		this.nationality = p.nationality;
	}//End of copy ctor
	
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public LocalDate getExpirationDate() {return expirationDate;}
	public String getPassportID() {return passportID;}
	public String getNationality() {return nationality;}
	
	public boolean isExpired() {
		if(expirationDate.isBefore(LocalDate.now())) 
			return false;
		else 
			return true;
	}
	
	public String toString() {
		return getFirstName() + " " + getLastName() + "\n" 
				+ "Passport ID - " + getPassportID() + "\n"
				+ "Birthplace - " + birthplace + "\n"
				+ "Birthdate - " + birthdate + "\n" 
				+ "Issue Date - " + issueDate + "\n"
				+ "Expiration Date - " + getExpirationDate() + "\n"
				+ "nationality - " + getNationality();
	}

}//End of class Passport
