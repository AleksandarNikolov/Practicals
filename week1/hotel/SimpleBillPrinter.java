package ss.week1.hotel;

public class SimpleBillPrinter {
	
	
	public static void main(String[] args) {
		String bill;
		String description;
		Double money;
		
		description = "Hotel night is";
		money = 85.00;
		bill = String.format("%s %10.2f", description, money);
		System.out.println(bill);
		
	}
}
