package ss.week2;

import ss.utils.TextIO;

public class ThreeWayLampTUI {

	public static void main(String[] args) {
		boolean exit = false;
		
		ThreeWayLamp lamp = new ThreeWayLamp();
		
		lamp.menue();
		
		while (exit == false) {
			System.out.print("Enter a command: ");
			String input = TextIO.getln();
			
			switch (input) {
				case "OFF":
					lamp.setState(input);
					System.out.println("The lamp is now " + lamp.getState());
					break;
				case "LOW":
					lamp.setState(input);
					System.out.println("The lamp is now " + lamp.getState());
					break;
				case "MEDIUM":
					lamp.setState(input);
					System.out.println("The lamp is now " + lamp.getState());
					break;
				case "HIGH":
					lamp.setState(input);
					System.out.println("The lamp is now " + lamp.getState());
					break;
				case "STATE":
					System.out.println("The lamp is now " + lamp.getState());
					break;
				case "NEXT":
					lamp.nextState();
					System.out.println("The lamp is now " + lamp.getState());
					break;
				case "HELP":
					lamp.help();
					break;
				case "EXIT":
					exit = true;
					break;
				default:
					System.out.println("This is not an option. Please try agian.");
					break;
			}
		}

	}

}
