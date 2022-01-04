package ss.week3.hotel;

import ss.utils.TextIO;
import ss.week3.bill.SysoutPrinter;

public class HotelTUI {
	static final char IN = 'i';
	static final char OUT = 'o';
	static final char ROOM = 'r';
	static final char SAFE = 'a';
	static final char BILL = 'b';
	static final char HELP = 'h';
	static final char PRINT = 'p';
	static final char EXIT = 'x';
	
	private Hotel hotel;
	
	public static void main(String[] args) {
		new HotelTUI("U Parkhotel").start();
	}
	
	public HotelTUI(String name) {
		this.hotel = new Hotel(name);
	}
	
	public void start() {
		boolean exit = false;
		String input;
		char command;
		String[] inputWords;
		String param;
		String param2;
		

		
		printHelpMenu();
		while (!exit) {
			TextIO.put("\nCommand: ");
			input = null;
			input = TextIO.getlnString();
			
			param = null;
			
			param2 = null;
			
			inputWords = input.split(" ");
			command = input.split(" ")[0].charAt(0);
			
			if (inputWords.length > 1) {
				param = inputWords[1];
			}
			if (inputWords.length > 2) {
				param2 = inputWords[2];
			}
			switch (command) {
				case IN:
					if (param == null) {
						System.out.println("Error: no name given.");
					} else if (hotel.getFreeRoom() != null) {
						hotel.checkIn(param);
						int roomnumber = hotel.getRoom(param).getNumber();
						System.out.printf("%s gets room %d", param, roomnumber);
					} else {
						System.out.printf("All rooms are full!");
					}
					break;
				case OUT:
					if (param == null) {
						System.out.println("Error: no name given.");
					} else if (hotel.getRoom(param) == null) {
						System.out.printf("%s does not have a room", param);
					} else {
						hotel.checkOut(param);
					}
					break;
				case ROOM:
					if (param == null) {
						System.out.println("Error: no name given.");
					} else if (hotel.getRoom(param) == null) {
						System.out.printf("%s doesn ’t have a room.", param);
					} else {
						System.out.printf("%s does have room %d.", param, hotel.getRoom(param).getNumber());
						}
					break;
				case SAFE:
					if (param == null) {
						System.out.println("Error: no name given.");
					} else if (hotel.getRoom(param) == null) {
						System.out.printf("%s doesn ’t have a room.", param);
					} else if (hotel.getRoom(param).getSafe().getClass().equals(PricedSafe.class)) {
						if (param2 == null) {
							System.out.println("No password given.");
						} else {
							PricedSafe safe = (PricedSafe) hotel.getRoom(param).getSafe();
							safe.activate(param2);
							if (safe.isActive()) {
								System.out.println("Safe in room " + hotel.getRoom(param).getNumber() + " of guest " + param + " has been activated.");
							} else {
								System.out.println("Wrong password!");
							}
						}
					} else {
						hotel.getRoom(param).getSafe().activate();
						System.out.println("Safe in room " + hotel.getRoom(param).getNumber() + " of guest " + param + " has been activated.");
					}
					break;
				case BILL:
					if (param == null || param2 == null) {
						System.out.println("Error: no name or no amount of nights given.");
					} else if (hotel.getRoom(param) == null) {
						System.out.printf("%s does not have a room", param);
					} else {
						hotel.getBill(param, Integer.parseInt(param2), new SysoutPrinter());
					}
					break;
				case HELP:
					printHelpMenu();
					break;
				case PRINT:
					printInfo();
					break;
				case EXIT:
					exit = true;
					break;
				default:
					System.out.println("This is not an option. Try again.");
					break;
			}
			
		}
	
	}
	
	private void printHelpMenu() {
		String menu = "Welcome to the Hotel booking system of the U Parkhotel\r\n" + 
				"Commands :\r\n" + 
				"i name ........... checkin guest with name\r\n" + 
				"o name ........... checkout guest with name\r\n" + 
				"r name ........... request room of guest\r\n" + 
				"a name password .. activate safe , password required for PricedSafe\r\n" + 
				"b name nights ..... print bill for guest ( name ) and number of nights\r\n" + 
				"h ................ help ( this menu )\r\n" + 
				"p ................ print state of the hotel\r\n" + 
				"x ................ exit\r\n";
		System.out.println(menu);
	}

	private void printInfo() {
		String info = "Hotel U Parkhotel:\r\n" + 
						" Room 101 (" + hotel.ROOM_PRICE + "/ night ):\r\n" + 
						"   rented by: " + hotel.k101.getGuest() + "\r\n" + 
						"   safe active: " + hotel.k101.getSafe().isActive() + "\r\n" + 
						" Room 102:\r\n" + 
						"   rented by: " + hotel.k102.getGuest() + "\r\n" + 
						"   safe active: " + hotel.k102.getSafe().isActive() + "\r\n";
		System.out.println(info);
	}
}
