package ss.week3.hotel;

import ss.week2.hotel.Guest;

public class Room {
    private int number;
    private Guest guest;
    private Safe safe;
    
    /**
    * Creates a <code>Room</code> with the given number, without a guest.
    * @param no number of the new <code>Room</code>
    */
    public Room(int number) {
    	this(number, new Safe());
    	this.number = number;
    }
    
    public Room(int number, Safe safe) {
    	this.number = number;
    	this.safe = safe;
    }
    
    /**
     * Returns the number of this Room.
     */
    public int getNumber() {
    	return number;
    }

    /**
     * Returns the current guest living in this Room.
     * @return the guest of this Room, null if not rented
     */
    public Guest getGuest() {
    	return guest;
    }
    
    
    /**
     * Assigns a Guest to this Room.
     * @param guest the new guest renting this Room, if null is given, Room is empty afterwards
     */
    public void setGuest(Guest guest) {
    	this.guest = guest;
    }

    /**
	 * String representation of {@code Room}.
	 */
	public String toString() {
		return "Room " + this.getNumber();
	}
	
	public Safe getSafe() {
		return this.safe;
	}
    
}
