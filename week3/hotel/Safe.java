package ss.week3.hotel;

public class Safe {
	
	public boolean open;
	public boolean active;
	
	/*
	 * Constructor
	 */
	public Safe() {
		this.active = false;
		this.open = false;
	}
	
	/*
	 * activate safe
	 */
	public void activate() {
		this.active = true;
	}
	
	/*
	 * deactivate safe
	 */
	public void deactivate() {
		this.active = false;
	}
	
	/*
	 * open safe
	 */
	public void open() {
		this.open = true;
	}
	
	/*
	 * close safe
	 */
	public void close() {
		this.open = false;
	}
	
	/*
	 * return true if Safe is active, else return false
	 */
	public boolean isActive() {
		return this.active;
	}
	
	/*
	 * return true if Safe is open, else return false
	 */
	public boolean isOpen() {
		return this.open;
	}
	
}
