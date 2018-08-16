//Chana Riva Levine 
//Hadass d'Ancona

package TravelAgency;
import java.time.LocalDate;


public class CreditCard {
	private int creditlimit = 5000;
	private double balance = 0;
	private String creditcardID, pin;
	private LocalDate expirationdate;
	
	public CreditCard( String creditcardID, String pin, String expirationdate) 
		throws InvalidDataException
	{
		if( creditcardID.equals("") || pin.equals("")) {
			throw new InvalidDataException("Please fill in required fields");
		}
		else {
			this.creditcardID = creditcardID;
			this.pin = pin;
			this.expirationdate = LocalDate.parse(expirationdate);
		}
	}
	
	public CreditCard(CreditCard c) {
		this.creditcardID = c.creditcardID;
		this.pin = c.pin;
		this.expirationdate = c.expirationdate;
	}
	
	public boolean checkPin(String pin) {
		if(this.pin.equals(pin))
			return false;
		else
			return true;
	}
	
	public void addCharge(double charge, String pinNumber)
			throws InvalidPinException, InsufficientFundsException, CardExpiredException
	{
		if(expirationdate.isBefore(LocalDate.now())){
			throw new CardExpiredException("Your card is expired.");
		}
		else if(checkPin(pinNumber)) {
			throw new InvalidPinException("You entered an invalid pin.");
		}
		else if((balance + charge) > creditlimit) {
			throw new InsufficientFundsException("Insufficient funds on card.");
		}
		else
			balance += charge;
	}


	
	public double getBalance() {return balance;}
	
	public String getCreditCardID() {return creditcardID;}


	public int getCreditlimit() {return creditlimit;}
	public void setCreditlimit(int creditlimit) {this.creditlimit = creditlimit;}

	public LocalDate getExpirationdate() {return expirationdate;}
	public void setExpirationdate(LocalDate expirationdate) {this.expirationdate = expirationdate;}
	
	public String toString() {
		return "ID - " + this.creditcardID + "\n" + 
			   "Pin - " + this.pin + "\n" +
			   "Expiration Date - " + this.expirationdate + "\n" +
			   "Balance - " + this.balance + "\n" +
			   "Credit Limit - " + this.creditlimit;
			   
	}



}
