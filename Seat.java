//Chana Riva Levine 
//Hadass d'Ancona

package TravelAgency;

public class Seat {
	private boolean available;
	private Passenger p;
	private String seatType;
	
	public Seat(String seatType) throws InvalidDataException{
		if(seatType.equals(null)) {
			throw new InvalidDataException("Please fill in the required fields.");
		}
		else
		{
			this.seatType = seatType;
			p = null;
			available = true;
		}
	}//End of ctor
	
	public void bookSeat(Passenger p) throws SeatNotAvailableException {
		if(available) {
			this.p = p;
			available = false;
		}
		else
		{
			throw new SeatNotAvailableException("I'm sorry, this seat is unavailable.");
		}
	}//End of bookSeat
	
	public void cancelReservation() throws InvalidDataException 
	{
		if(available) 
			throw new InvalidDataException("You have entered an invalid seat.");
		else
			this.p = null;
			available = true;
	}//End of cancelReservation
	
	public String getSeatType() {return seatType;}
	public Passenger getPassenger() {return p;}
	public boolean isAvailable() {return available;}
	
	public String toString() {
		return "Seat type - " + seatType + "\n"
				+ available + "\n" + p;
	}

}
