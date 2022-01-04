package ss.week3.bill;

public interface Printer {
	
	default String format(String text, double price) {
		return String.format("%1$-10s %2$10.2f\n", text, price);
	}
		
	void printLine(String text, double price);
}
