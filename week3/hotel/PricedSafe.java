package ss.week3.hotel;

import ss.week3.password.Password;

public class PricedSafe extends Safe implements ss.week3.bill.Bill.Item {
	
	public double price;
	private Password pass;
	
	/** Constructs a PricedSafe.
	*   @parameters price - price for the safe, pass of type Password, open, active
	*   @requires price >= 0
	*   @ensures isActive() == false, isOpen() == false, this.getPassword() != null
	*/
	public PricedSafe(double price) {
		this.price = price;
		this.pass = new Password();
		this.active = false;
		this.open = false;
		assert price >= 0;
	}
	
	
	/** Activates the safe.
	*   @requires that the input matches the password 
	*   @ensures isActive() == True
	*/
	public void activate(String input) {
		if (this.pass.testWord(input)) {
			this.active = true;
		}
	}
	
	@Override
	public void activate() {
		System.out.print("Warning: You should enter a password");
	}
	
	/** Opens the safe.
	*   @requires that the input matches the password 
	*   @ensures isOpen() == True
	*/
	public void open(String input) {
		if (this.isActive() && this.pass.testWord(input)) {
			this.open = true;
		}
	}
	
	@Override
	public void open() {
		System.out.print("Warning: Enter a valid password");
	}
	
	
	/** Returns the current price of the safe.
	*   @return the the price of the safe
	*   @ensures price >= 0
	*/
	@Override
	public double getAmount() {
		return this.price;
	}
	
	/** Returns the current password object.
	*   @return the current password object.
	*/
	public Password getPassword() {
		return this.pass;
	}
	
	/**
	*   @return String - which states the current price of the safe.
	*/
	public String toString() {
		return "Safe price: " + this.price;
	}
	
	
	//public static void main(String[] args) {
	//	PricedSafe safe = new PricedSafe(-1);
	//}

}