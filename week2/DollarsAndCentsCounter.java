package ss.week2;

public class DollarsAndCentsCounter {
	int dollars;
	int cents;
	/*
	 * The dollar count.
	 * @ensures a return value that is bigger or equal to 0
	 */
	public int dollars() {
		return this.dollars;
	}
	
	/*
	 * The cents count.
	 * @ensures a return value in the range of 0 to 99
	 */
	public int cents() {
		return this.cents;
	}
	
	/*
	 * Adds the specified dollars and cents to this Counter.
	 */
	public void add(int newDollars, int newCents) {
		this.dollars += newDollars;
		int totalCents = this.cents + newCents;
		while (totalCents > 99) {
			this.dollars += 1;
			totalCents -= 100;
		}
		this.cents = totalCents;
	}
	
	/*
	 * Reset this Counter to 0
	 * @ensures this Counter is set to 0 dollars and 0 cents
	 */
	public void reset() {
		this.dollars = 0;
		this.cents = 0;
	}
	
}
