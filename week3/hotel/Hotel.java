package ss.week3.hotel;

import ss.week2.hotel.Guest;
import ss.week3.bill.Bill;
import ss.week3.bill.Printer;

public class Hotel {
	public static int ROOM_PRICE = 180;
	public static int SAFE_PRICE = 30;
	private String name;
	public Room k101 = new PricedRoom(101, ROOM_PRICE, SAFE_PRICE);
	public Room k102 = new Room(102);
	
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
	
	public void checkOut(String name) {
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
	
	public Room getRoom(String name) {
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
	
	public Bill getBill(String guestName, int nights, Printer printer) {
		if (getRoom(guestName) != null) {
			if (getRoom(guestName).getClass().equals(PricedRoom.class)) {
				PricedRoom room = (PricedRoom) getRoom(guestName);
				PricedSafe safe = (PricedSafe) room.getSafe();
				Bill bill = new Bill(printer);
				for (int i = 1; i <= nights; i++) {
					bill.addItem(room);
				}
				if (safe.isActive()) {
					bill.addItem(safe);
				}
				bill.close();
				return bill;
			} else {
				return null;
			}
		} else {
			return null;
		}
		
		
	}
	
}
