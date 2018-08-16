//Chana Riva Levine 
//Hadass d'Ancona

package TravelAgency;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class UseTravelAgency {
	static Scanner stdin = new Scanner(System.in);
	static TravelAgency travelagency = new TravelAgency();

	public static void main(String[] args) throws InvalidDataException, ParseException, DuplicateDataException, NotFoundException, FullyBookedException, SeatNotAvailableException, InvalidPinException, InsufficientFundsException, CardExpiredException{
		
	//try {
		while(true){
			try {
	
			Display();
			int choice = stdin.nextInt();
			switch(choice) {
			case 1:
				
				System.out.println("To add a passenger, enter 1. ");
				System.out.println("To add a customer, enter 2.");
				System.out.println("To add a travel agent, enter 3");
				int innerchoice = stdin.nextInt();
				switch(innerchoice) {
				case 1:
					travelagency.addPassenger(getFirstName(), getLastName(), getGender(), getStreet(), getCity(), getState(), getZipcode(), getPhoneNumber(), getPassengerID(), getPassport());
					break;
				case 2: 
					travelagency.addCustomer(getFirstName(), getLastName(), getGender(), getStreet(), getCity(), getState(), getZipcode(), getPhoneNumber(),getCustomerID(), getCreditCard());
					break;
				case 3:
					travelagency.addAgent(getFirstName(), getLastName(), getGender(), getAddress(), getPhoneNumber(), getSocialSecurity(), getEmployeeID());
					break;
				}//End of inner switch
				break;
			case 2:
				System.out.println("Please enter the departure date (yyyy-mm-dd)");
				String departureDate = stdin.next();
				travelagency.addScheduledFlight(departureDate, getFlightNumber());
				break;
			case 3:
				travelagency.bookFlight(getFlightNumber(), getCustomerID(), getPassengerID(), getSeatNumber(), getEmployeeID(), getPrice(), getPin());
				break;
			case 4:
				travelagency.findFlight(getFlightNumber()).viewPlaneLayout();
				break;
			case 5:
				travelagency.cancelFlight(getFlightNumber(), getPassengerID(), getSeatNumber());
				break;
			case 6:
				System.out.println(travelagency.findPassengerInfo(getPassengerID()));
				break;
			case 7:
				System.out.println(travelagency.findCustomer(getCustomerID()));
				break;
			case 8:
				System.out.println(travelagency.getPassengers());
				break;
			case 9:
				System.out.println(travelagency.findFlight(getFlightNumber()));
				break;
			case 10:
				System.out.println(travelagency.getPerson());
				System.out.println(travelagency.getScheduledFlights());
				break;
			case 0:
				System.out.println("Goodbye.");
				System.exit(0);
			}
			
		//}//End of while
	}//End of try
	catch(CardExpiredException c){
		System.out.println(c.getMessage());
	}
	catch(DuplicateDataException d) {
		System.out.println(d.getMessage());
	}
	catch(FullyBookedException f) {
		System.out.println(f.getMessage());
	}
	catch(InsufficientFundsException i) {
		System.out.println(i.getMessage());
	}
	catch(InvalidDataException i) {
		System.out.println(i.getMessage());
	}
	catch(InvalidPinException i) {
		System.out.println(i.getMessage());
	}
	catch(NotFoundException n) {
		System.out.println(n.getMessage());
	}
	
	catch(SeatNotAvailableException s) {
		System.out.println(s.getMessage());
	}
	catch(DateTimeParseException p) {
		System.out.println("The date was entered incorrectly.");
	}
		}//end of while
		
	}//End of main
	
	public static void Display() {
		System.out.println("Enter one of the following numbers to perform an action.");
		System.out.println("1 - add a person");
		System.out.println("2 - add a flight");
		System.out.println("3 - book a seat");
		System.out.println("4 - view a plane layout");
		System.out.println("5 - cancel a reservation");
		System.out.println("6 - get information for a passenger");
		System.out.println("7 - get information for a customer");
		System.out.println("8 - get a list of all passengers");
		System.out.println("9 - get information for a flight");
		System.out.println("10 - get information for all people and all flights");
		System.out.println("0 - EXIT");
	}//End of Display
	
	public static String getFirstName() {
		System.out.println("Please enter the first name.");
		String firstName = stdin.next();
		return firstName;
	}
	
	public static String getLastName() {
		System.out.println("Please enter the last name.");
		String lastName = stdin.next();
		return lastName;
	}
	
	public static char getGender() {
		System.out.println("For a male, enter 'm'. For a female, enter 'f'.");
		String gender = stdin.next();
		return gender.charAt(0);
	}
	
	public static String getStreet() 
			throws InvalidDataException
	{
		System.out.println("Please enter the street.");
		String street = stdin.next();
		return street;
	}
	
	public static String getCity() {
		System.out.println("Please enter the city.");
		String city = stdin.next();
		return city;
	}
	
	public static String getState() {
		System.out.println("Please enter the state.");
		String state = stdin.next();
		return state;
	}
	
	public static String getZipcode() {
		System.out.println("Please enter the zipcode.");
		String zip = stdin.next();
		return zip;
	}
	
	public static Address getAddress() throws InvalidDataException {
		Address a = new Address(getStreet(),getCity(),getState(),getZipcode());
		return a;
	}
	
	public static String getPhoneNumber() {
		System.out.println("Please enter the phone number");
		String phoneNumber = stdin.next();
		return phoneNumber;
	}
	
	public static Passport getPassport()
			throws InvalidDataException, ParseException 
	{
		System.out.println("Please enter the passport ID number.");
		String passportID = stdin.next();
		System.out.println("Please enter the first and last name as it appears on the passport.");
		String firstName = stdin.next();
		String lastName = stdin.next();
		System.out.println("Please enter the date of birth(yyyy-mm-dd)");
		String birthdate = stdin.next();
		System.out.println("Please enter the place of birth.");
		String birthplace = stdin.next();
		System.out.println("Please enter the date of issue(yyyy-mm-dd)");
		String issueDate = stdin.next();
		System.out.println("Please enter the expiration date(yyyy-mm-dd)");
		String expirationDate = stdin.next();
		System.out.println("Please enter the nationality.");
		String nationality = stdin.next();
		Passport p = new Passport(passportID, firstName, lastName, birthdate, birthplace, issueDate, expirationDate, nationality );
		return p;
	}
	
	public static CreditCard getCreditCard() throws InvalidDataException, ParseException {
		System.out.println("Please enter the creditcard ID number");
		String creditcardID = stdin.next();
		System.out.println("Please enter the pin number");
		String pin = stdin.next();
		System.out.println("Please enter the expiration date(mm/dd/yyyy)");
		String expirationdate = stdin.next();
		CreditCard c = new CreditCard(creditcardID, pin, expirationdate);
		return c;
	}
	
	public static String getSocialSecurity() {
		System.out.println("Please enter the social security number.");
		String ssn = stdin.next();
		return ssn;
	}
	
	public static String getFlightNumber() {
		System.out.println("Please enter the flight number.");
		String flightNumber = stdin.next();
		return flightNumber;
	}
	
	public static int getPassengerID() {
		System.out.println("Please enter the passenger ID.");
		int passengerID = stdin.nextInt();
		return passengerID;
	}
	
	public static int getSeatNumber() {
		System.out.println("Please enter the seat number.");
		int seatNumber = stdin.nextInt();
		return seatNumber;
	}
	
	public static int getCustomerID() {
		System.out.println("Please enter the customer ID number.");
		int customerID = stdin.nextInt();
		return customerID;
	}
	
	public static String getEmployeeID() {
		System.out.println("Please enter the employee ID number.");
		String employeeID = stdin.next();
		return employeeID;
	}
	
	public static double getPrice() {
		System.out.println("Please enter the price.");
		double price = stdin.nextDouble();
		return price;
	}
	
	public static String getPin() {
		System.out.println("Please enter the credit card pin.");
		String pin = stdin.next();
		return pin;
	}
	
	

}
