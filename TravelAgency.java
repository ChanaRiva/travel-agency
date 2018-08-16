//Chana Riva Levine 
//Hadass d'Ancona

package TravelAgency;
import java.util.ArrayList;

public class TravelAgency {
	private ArrayList<Person> person;
	private ArrayList<ScheduledFlight> scheduledFlight;
	
	public TravelAgency() {
		person = new ArrayList<Person>();
		scheduledFlight = new ArrayList<ScheduledFlight>();
	}
	
	public void addCustomer(String firstName, String lastName, char gender, String street, String city, String state, String zip, String phoneNumber,int customerID, CreditCard creditcard) 
		throws DuplicateDataException, InvalidDataException
	{
		Customer customer = new Customer(firstName, lastName, gender,  phoneNumber, new Address(street, city, state, zip), customerID, creditcard);
		for(int i=0; i<person.size(); i++) {
			if(person.get(i) instanceof Customer) {
				if(((Customer)person.get(i)).getCustomerID() == customerID)
					throw new DuplicateDataException("This customer is already in the system.");
			}
		}//End of for
		
		if(firstName.equals("")||lastName.equals("")||phoneNumber.equals("")||street.equals("")||city.equals("")||state.equals("")||zip.equals(""))
			throw new InvalidDataException("You entered invalid data.");
		else
			person.add(customer);
		
	}//End of addCustomer
	
	public void addAgent(String firstName, String lastName, char gender, Address adrs, String phoneNumber, String ssn, String employeeID) 
			throws DuplicateDataException, InvalidDataException
		{
			TravelAgent agent = new TravelAgent(firstName, lastName, gender,  phoneNumber, adrs, ssn, employeeID);
			for(int i=0; i<person.size(); i++) {
				if(person.get(i) instanceof TravelAgent) {
					if(((TravelAgent)person.get(i)).getEmployeeID().equals(employeeID))
						throw new DuplicateDataException("This travel agent is already in the system.");
				}
			}//End of for
			
			if(firstName.equals("")||lastName.equals("")||phoneNumber.equals("")||adrs.getStreet().equals("")||adrs.getCity().equals("")||adrs.getState().equals("")||adrs.getZipcode().equals(""))
				throw new InvalidDataException("You entered invalid data.");
			else
				person.add(agent);
			
		}//End of addAgent
	
	public void addPassenger(String firstName, String lastName, char gender, String street, String city, String state, String zip, String phoneNumber,int ID, Passport p) 
			throws DuplicateDataException, InvalidDataException
		{
			Passenger passenger = new Passenger(firstName, lastName, gender, phoneNumber, street, city, state, zip, ID, p);
			for(int i=0; i<person.size(); i++) {
				if(person.get(i) instanceof Passenger) {
					if(((Passenger)person.get(i)).getID() == ID)
						throw new DuplicateDataException("This passenger is already in the system.");
				}
				}//End of for
			if(firstName.equals("")||lastName.equals("")||phoneNumber.equals("")||street.equals("")||city.equals("")||state.equals("")||zip.equals(""))
				throw new InvalidDataException("You entered invalid data.");
			else
				person.add(passenger);
			
		}//End of addPassenger
	
	public Passenger findPassengerInfo(int ID)
		throws NotFoundException
	{
		for(int i=0; i<person.size(); i++) {
			if(person.get(i) instanceof Passenger) {
				if(((Passenger)person.get(i)).getID() == ID )
					return (Passenger) person.get(i);
				}
		}//End of for
		throw new NotFoundException("The passenger was not located in our system.");
		
	}//End of findPassengerInfo
	
	public Customer findCustomer(int ID)
			throws NotFoundException
		{
			for(int i=0; i<person.size(); i++) {
				if(person.get(i) instanceof Customer) {
					if(((Customer)person.get(i)).getCustomerID() == ID )
						return (Customer) person.get(i);
				}
			}//End of for
			throw new NotFoundException("The passenger was not located in our system.");
			
		}//End of findCustomer
	
	public ArrayList<Passenger> getPassengers(){
		ArrayList<Passenger> passenger = new ArrayList<Passenger>();
		for(int i=0; i<person.size(); i++) {
			if(person.get(i) instanceof Passenger)
				passenger.add((Passenger)person.get(i));
		}//End of for
		return passenger;
	}//End of getPassengers
	
	public void addScheduledFlight(String departureDate, String flightID)
		throws DuplicateDataException, InvalidDataException
	{
		ScheduledFlight newFlight = new ScheduledFlight(departureDate, flightID);
		for(int i=0; i<scheduledFlight.size(); i++) {
			if(scheduledFlight.get(i).getFlightID().equals(flightID))
				throw new DuplicateDataException("I'm sorry, this flight is already scheduled.");
		}//End of for
		scheduledFlight.add(newFlight);
	}//End of addScheduledFlight
	
	public void bookFlight(String flightID, int customerID, int passengerID, int seatNumber, String employeeID, double price, String pin) 
		throws NotFoundException, FullyBookedException, SeatNotAvailableException, DuplicateDataException, InvalidPinException, InsufficientFundsException, CardExpiredException
	{
		Passenger passenger = null;
		TravelAgent agent = null;
		Customer customer = null;
		ScheduledFlight flight = null;
		boolean found = true;
		passenger = findPassengerInfo(passengerID);//check passenger is valid
		customer = findCustomer(customerID);//check customer is valid
		//Check that travel agent is valid
		for(int i=0; i<person.size(); i++) {
			if(person.get(i) instanceof TravelAgent) {
				if(((TravelAgent) person.get(i)).getEmployeeID().equals(employeeID)) {
					agent = (TravelAgent)person.get(i);
					found = false;
				}
			}
		}//End of for
		if(found)
			throw new NotFoundException("I'm sorry, this travel agent was not located in our system.");
		flight = findFlight(flightID);
		agent.bookTicket(price);
		flight.bookSeat(passenger, seatNumber);
		customer.chargeCard(price, pin);
	}//End of bookFlight
	
	public void cancelFlight(String flightNumber, int passengerID, int seatNumber) throws NotFoundException, InvalidDataException {
		Passenger p = findPassengerInfo(passengerID);
		for(int i=0; i<scheduledFlight.size(); i++) {
			if(scheduledFlight.get(i).getFlightID().equals(flightNumber)) {
				scheduledFlight.get(i).cancelReservation(p, seatNumber);
			}
		}
	}//End of cancelFlight
	
	public ScheduledFlight findFlight(String ID) throws NotFoundException {
		for(int i=0; i<scheduledFlight.size(); i++) {
			if(scheduledFlight.get(i).getFlightID().equals(ID))
				return scheduledFlight.get(i);
		}
		throw new NotFoundException("I'm sorry, this flight was not located in our system.");
	}
	
	public ArrayList<Person> getPerson(){
		return this.person;
	}
	
	public ArrayList<ScheduledFlight> getScheduledFlights(){
		return scheduledFlight;
	}
	
	
}
