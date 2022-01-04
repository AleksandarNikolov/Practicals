package ss.week3.test;

import ss.week3.bill.*;

import static org.junit.jupiter.api.Assertions.*;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;

class BillTest {

	private Bill bill;
	private StringPrinter stringPrinter = new StringPrinter();
	
	
	class Item implements Bill.Item {
		private String text;
		private double amount;
		
		Item(String text, double amount) {
			this.text = text;
			this.amount = amount;
		}
		
		public String toString() {
			return this.text;
		}
		
		public double getAmount() {
			return this.amount;
		}
		
	}
	
	
	@BeforeEach
	void setUp() throws Exception {
		bill = new Bill(stringPrinter);
	}

	@Test
	void testBeginState() {
		assertEquals(this.bill.getSum(), 0);
	}
	
	@Test
	void testNewItem() {
		Item test = new Item("test", 10);
		Item test1 = new Item("test1", 5);
		this.bill.addItem(test);
		assertEquals(this.bill.getSum(), 10);
		this.bill.addItem(test1);
		assertEquals(this.bill.getSum(), 15);
		
		this.bill.close();
		StringPrinter printer =  (StringPrinter) bill.printer;
		String line = printer.line;
		assertThat(line, CoreMatchers.containsString("test"));
		assertThat(line, CoreMatchers.containsString("Total sum:"));
		assertThat(line, CoreMatchers.containsString("15"));
	}
	

}
