package ss.week3.bill;

public class Bill {
	public static interface Item {
		public double getAmount();
	}
	
	
	public Printer printer;
	private double sum;
	
	/** Constructs a Bill sending the output to a given Printer.
	*   @parameters printer - the printer to send the bill to
	*   @requires printer != null
	*   @ensures getSum() == 0
	*/
	public Bill(Printer printer) {
		this.printer = printer;
		sum = 0;
	}

	
	/** Adds an item to this Bill.The item is sent to the printer.
	*   The amount is added to the sum of the Bill
	*   @parameters item - the new item
	*   @requires item != null;
	*   @ensures this.getSum() == \old(getSum()) + item.getAmount();
	*   
	*/
	public void addItem(Item add) {
		sum += add.getAmount();
		this.printer.printLine(add.toString(), add.getAmount());
	}
	
	/**
	 * Sends the sum total of the bill to the printer.
	 */
	public void close() {
		this.printer.printLine("Total sum: ", getSum());
		//if (printer.getClass() == StringPrinter.class) {
		//	((StringPrinter) this.printer).getResult();
		//}
	}
	
	
	/** Returns the current sum total of the Bill.
	*   @return the current sum total of the Bill
	*   @ensures result >= 0
	*/
	public double getSum() {
		return sum;
	}
}
