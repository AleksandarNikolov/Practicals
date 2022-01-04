package ss.week2.hotel;

public class Guest {
	// the name of the guest
	private String name;
	// the room of the guest
	private Room room;
	
    /**
    * Creates a {@code Guest} with the given name and without {@code Room}.
    * @param name - name of the new {@code Guest}
    */
	public Guest(String name) {
		this.name = name;
	}
	
	/**
	 * Rents a {@code Room} to this {@code Guest}. 
	 * This is only possible if this {@code Guest} does not already have a {@code Room}. 
	 * And the {@code Room} to be assigned is not already rented. 
	 * Also adapts the {@code Guest}-reference of the {@code Room}. 
	 * @param room - Room to be rented to this {@code Guest}.
	 * @return {@code true} if checkin succeeded; {@code false} if this Guest already had a Room, 
	 * or room already had a Guest.
	 * @requires room != null;
	 */
	public boolean checkin(Room room) {
		boolean result = false;
		if (this.getRoom() == null && room.getGuest() == null && room != null) {
			room.setGuest(this);
			this.room = room;
			result = true;
		}
		return result;
	}
	
	/**
	 * Sets the {@code Room} of this {@code Guest} to null. 
	 * Also resets the {@code Guest}-reference of the (current) {@code Room}.
	 * @return {@code true} if this action succeeded; 
	 * {@code false} if Guest does not have a Room when this method is called
	 */
	public boolean checkout() {
		boolean result = false;
		if (this.getRoom() != null) {
			this.room.setGuest(null);
			this.room = null;
			result = true;
		}
		return result;
	}
	
	/**
	 * Returns the name of this {@code Guest}.
	 * @return {@code Room} rented by this Guest; null if this Guest does not rent a room
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns the {@code Room} that is rented by this Guest.
	 * @return the {@code Room} of the {@code Guest}, null if the {@code Guest} does not have a room
	 */
	public Room getRoom() {
		return this.room;
	}
	
	/**
	 * String representation of {@code Guest}.
	 */
	public String toString() {
		return "Guest " + this.getName();
	}
}
