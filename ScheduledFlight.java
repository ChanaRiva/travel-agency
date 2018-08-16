//Chana Riva Levine 
//Hadass d'Ancona

package TravelAgency;
import java.time.LocalDate;
import java.util.ArrayList;

public class ScheduledFlight {
	private LocalDate departureDate;
	private String flightID;
	private int availableFirstClassSeats = 5;
	private int availableEconomySeats = 5;
	private ArrayList<Passenger> passengerArray;
	private Seat [] seatArray;
	
	public ScheduledFlight(String departureDate, String flightID)
		throws InvalidDataException
	{
		this.departureDate = LocalDate.parse(departureDate);
		this.flightID = flightID;
		
		passengerArray = new ArrayList<Passenger>();
		seatArray = new Seat[10];
		
		for(int i=0; i<seatArray.length; i++) {
			if(i<=5)
				seatArray[i] = new Seat("First Class Seat");
			else
				seatArray[i] = new Seat("Economy Seat");
		}
		
	}//End of ctor
	
	public String getSeatType(int seatNumber)
	{
			return seatArray[seatNumber].getSeatType();
	}//End of getSeatType
	
	public void bookSeat(Passenger p, int seatNumber)
		throws FullyBookedException, SeatNotAvailableException, DuplicateDataException
	{ 

		if(availableFirstClassSeats + availableEconomySeats == 0)
			throw new FullyBookedException("I'm sorry, this flight is fully booked.");
		else if(seatArray[seatNumber].isAvailable() == false)
			throw new SeatNotAvailableException("I'm sorry, this desired seat is unavailable.");
		for(int i=0; i<passengerArray.size(); i++) {
			if(p.getFirstName()==passengerArray.get(i).getFirstName() && p.getLastName()==passengerArray.get(i).getLastName() && p.getID()==passengerArray.get(i).getID())
				throw new DuplicateDataException("The passenger has already booked a seat on this flight.");
		}//End of for
		passengerArray.add(p);
		seatArray[seatNumber].bookSeat(p);
		if(seatNumber<=5)
			availableFirstClassSeats--;
		else
			availableEconomySeats--;
		
	}//End of bookSeat
	
	public void cancelReservation(Passenger p, int seatNumber)
		throws InvalidDataException
	{
		if(seatArray[seatNumber].getPassenger().equals(p)) {
			seatArray[seatNumber].cancelReservation();
			passengerArray.remove(p);
			if(seatNumber<=5)
				availableFirstClassSeats++;
			else
				availableEconomySeats++;
		}
		else
			throw new InvalidDataException("Invalid Data Error");
		
	}//End of cancelReservation
	
	public void viewPlaneLayout() {
		for(int i=0; i<seatArray.length; i++) {
			if(seatArray[i].isAvailable()) 
				System.out.println("Seat " + i + " = Available");
			else 
				System.out.println("Seat " +i + " = " + seatArray[i].getPassenger());
		}//End of for
	}//End of viewPlaneLayout
	
	public String getFlightID() {return flightID;}

	@Override
	public String toString() {
		return "ScheduledFlight [departureDate=" + departureDate + ", flightID=" + flightID
				+ ", availableFirstClassSeats=" + availableFirstClassSeats + ", availableEconomySeats="
				+ availableEconomySeats + "]";
	}
	
//	public String toString() {
//		return "
//		
//	}
	

}
