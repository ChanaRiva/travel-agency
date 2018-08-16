//Chana Riva Levine 
//Hadass d'Ancona

package TravelAgency;

public class Customer extends Person {
	private int customerID;
	private CreditCard creditcard;
	
	public Customer(String firstname, String lastname, char gender, String phonenumber, String street, String city, String state, String zipcode, int customerID, String creditcardID, String pin, String expirationdate )
		throws InvalidDataException
	{	
		super(firstname, lastname, gender, phonenumber, street, city, state, zipcode);
		if(customerID == 0 || creditcardID.equals("") || pin.equals("")) {
			throw new InvalidDataException("Please fill in required fields");
		}
		else {
			this.customerID = customerID;
			creditcard = new CreditCard(creditcardID, pin, expirationdate);
		}
	}
	
	
	public Customer(String firstname, String lastname, char gender, String phonenumber, Address adrs, int customerID, CreditCard creditcard)
		throws InvalidDataException
	{
		super(firstname, lastname, gender, phonenumber, adrs);
		if(customerID == 0) {
			throw new InvalidDataException("Please fill in required fields");
		}
		else {
		this.customerID = customerID;
		this.creditcard = new CreditCard(creditcard);
		}
	}
	
	public Customer(Customer c) throws InvalidDataException{
		super(c.getFirstName(), c.getLastName(), c.gender, c.getPhoneNumber(), c.getAddress());
		this.customerID = c.customerID;
		this.creditcard = new CreditCard(c.creditcard);
	}
	
	public int getCustomerID() {return customerID;}
	public void setCustomerID(int customerID) {this.customerID = customerID;}	

	public void setCreditCard(CreditCard creditcard) {this.creditcard = new CreditCard(creditcard);}
	
	public void chargeCard(double amount, String pin) 
		throws InvalidPinException, InsufficientFundsException, CardExpiredException
	{
		creditcard.addCharge( amount, pin);
	}

	public String toString() {
		return "Customer ID - " + customerID + "/n" +
				creditcard;
	}

}
