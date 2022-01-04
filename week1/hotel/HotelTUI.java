package ss.week1.hotel;

import ss.utils.TextIO;

public class HotelTUI {
	static final char IN = 'i';
	static final char OUT = 'o';
	static final char ROOM = 'r';
	static final char HELP = 'h';
	static final char PRINT = 'p';
	static final char EXIT = 'x';
	
	public static void main(String[] args) {
		boolean exit = false;
		String input;
		char command;
		String[] inputWords;
		String param = null;
		String guest = null;
		String info = "This is hotel infomation.\n";
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
		while (!exit) {
			param = null;
			TextIO.put("\nCommand: ");
			input = TextIO.getlnString();
			
			inputWords = input.split(" ");
			command = input.split(" ")[0].charAt(0);
			
			if (inputWords.length > 1) {
				param = inputWords[1];
			}
			switch (command) {
				case IN:
					if (param == null) {
						System.out.println("Error: no name given.");
					} else if (guest == null) {
						guest = param;
						System.out.printf("%s gets room 101", param);
					} else {
						System.out.printf("Error: room is already taken by %s.", guest);
					}
					break;
				case OUT:
					if (param == null) {
						System.out.println("Error: no name given.");
					} else if (!param.equals(guest)) {
						System.out.printf("%s does not have a room", param);
					} else {
						guest = null;
						param = null;
					}
					break;
				case ROOM:
					if (param == null) {
						System.out.println("Error: no name given.");
					} else if (!param.equals(guest)) {
						System.out.printf("%s does not have a room.", param);
					} else {
						System.out.printf("%s does have room 101.", param);
					}
					break;
				case HELP:
					System.out.printf("\n%s", menu);
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
}