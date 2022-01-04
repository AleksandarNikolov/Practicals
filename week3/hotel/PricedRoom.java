package ss.week3.hotel;

public class PricedRoom extends Room implements ss.week3.bill.Bill.Item {

	double roomPrice;

	public PricedRoom(int number, double roomPrice, double safePrice) {
		super(number, new PricedSafe(safePrice));
		this.roomPrice = roomPrice;
		
	}

	@Override
	public double getAmount() {
		return this.roomPrice;
	}
	
	@Override
	public String toString() {
		return "Room " + this.getNumber() + ": " + this.roomPrice;
	}

}
