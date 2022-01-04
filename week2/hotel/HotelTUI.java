package ss.week2.hotel;

import ss.utils.TextIO;

public class HotelTUI {
	static final char IN = 'i';
	static final char OUT = 'o';
	static final char ROOM = 'r';
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
		String param = null;
		String info = "This is some hotel information.\n";

		
		printHelpMenu();
		while (!exit) {
			TextIO.put("\nCommand: ");
			input = null;
			input = TextIO.getlnString();
			
			param = null;
			
			inputWords = input.split(" ");
			command = input.split(" ")[0].charAt(0);
			
			if (inputWords.length > 1) {
				param = inputWords[1];
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
				case HELP:
					printHelpMenu();
					break;
				case PRINT:
					System.out.printf("\n%s", info);
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
				"i name ............... check in guest with name\r\n" + 
				"o name ............... check out guest with name\r\n" + 
				"r name ............... request room of guest\r\n" + 
				"h .................... help ( this menu )\r\n" + 
				"p .................... print state\r\n" + 
				"x .................... exit\r\n" + 
				"";
		System.out.println(menu);
	}
}
