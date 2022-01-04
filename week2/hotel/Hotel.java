package ss.week2.hotel;

public class Hotel {
	private String name;
	private Room k101 = new Room(101);
	private Room k102 = new Room(102);
	
	public Hotel(String name) {
		this.name = name;
	}
	
	/**
	 * Checks the guest in.
	 * @param name - name  indicating the name of the guest.
	 * @return {@code Room} object with a (new) Guest of the given name checked in, 
	 * or null in case there is already a guest with this name or the hotel is full.
	 */
	public Room checkIn(String name) {
		if (this.k101.getGuest() == null) {
			this.k101.setGuest(new Guest(name));
			return k101;
		} else if (this.k102.getGuest() == null) {
			this.k102.setGuest(new Guest(name));
			return k102;
		} else {
			return null;
		}
	}
	
	public void checkOut(String name ) {
		if (this.k101.getGuest() != null && this.k101.getGuest().getName().equals(name)) {
			this.k101.setGuest(null);
			this.k101.getSafe().deactivate();
		} else if (this.k102.getGuest() != null && this.k102.getGuest().getName().equals(name)) {
			this.k102.setGuest(null);
			this.k102.getSafe().deactivate();
		}
	}
	
	public Room getFreeRoom() {
		if (this.k101.getGuest() == null) {
			return k101;
		} else if (this.k102.getGuest() == null) {
			return k102;
		} else {
			return null;
		}
	}
	
	public Room getRoom(String name ) {
		if (this.k101.getGuest() != null &&  this.k101.getGuest().getName().equals(name)) {
			return this.k101;
		} else if (this.k102.getGuest() != null && this.k102.getGuest().getName().equals(name)) {
			return this.k102;
		} else {
			return null;
		}
	}
	
	
    /**
	 * String representation of the {@code Hotel}.
	 */
	public String toString() {
		String result = "";
		if (this.k101.getGuest() != null) {
			result += k101.getGuest().getName() + " is in room 101. \n";
		}
		if (this.k101.getGuest() == null) {
			result += "Their is nobody is in room 101. \n";
		}
		result += "The safe in room 101 is ";
		if (this.k101.getSafe().isActive()) {
			result += "active. \n";
		}
		if (!this.k101.getSafe().isActive()) {
			result += "not active. \n";
		}
		
		if (this.k102.getGuest() != null) {
			result += k102.getGuest().getName() + " is in room 102. \n";
		}
		if (this.k102.getGuest() == null) {
			result += "Their is nobody is in room 102. \n";
		}
		result += "The safe in room 102 is ";
		if (this.k102.getSafe().isActive()) {
			result += "active. \n";
		}
		if (!this.k102.getSafe().isActive()) {
			result += "not active. \n";
		}
		
		System.out.println(result);
		return result;
	}
	
	public String getName() {
		return this.name;
	}
	
}
