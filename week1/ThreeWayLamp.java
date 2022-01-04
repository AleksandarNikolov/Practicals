package ss.week1;

import ss.utils.TextIO;

public class ThreeWayLamp {

	enum State {
		OFF,
		LOW,
		MEDIUM,
		HIGH
	}
	
	
	public static void main(String[] args) {
		
		boolean exit = false;
		String menue = "Use the followig commands: OFF, LOW, MEDIUM, HIGH, STATE, NEXT, HELP, EXIT";
		String help = menue + "\n" +
					  "OFF - switching of the lamp\n" +
					  "LOW - switching the lamp to low state\n" +
					  "MEDIUM - switching the lamp to medium state\n" +
					  "HIGH - switching the lamp to low state\n" +
					  "STATE - checking the current state of the lamp\n" +
					  "NEXT - switching the lamp to the next state\n" +
					  "HELP - to get more information about the commands\n" +
					  "EXIT - for exiting the program\n";
		State lamp = State.OFF;
		System.out.println(menue);
		
		while (exit == false) {
			System.out.print("Enter a command: ");
			String input = TextIO.getln();
			switch (input) {
				case "OFF":
					lamp = State.OFF;
					System.out.println("The lamp is now " + lamp);
					break;
				case "LOW":
					lamp = State.LOW;
					System.out.println("The lamp is now " + lamp);
					break;
				case "MEDIUM":
					lamp = State.MEDIUM;
					System.out.println("The lamp is now " + lamp);
					break;
				case "HIGH":
					lamp = State.HIGH;
					System.out.println("The lamp is now " + lamp);
					break;
				case "STATE":
					System.out.println("The current state of the lamp is " + lamp);
					break;
				case "NEXT":
					lamp = nextState(lamp);
					System.out.println("The lamp is now " + lamp);
					break;
				case "HELP":
					System.out.println(help);
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
	
	static State nextState(State lamp) {
		State newState;
		newState = State.LOW;
		switch (lamp) {
			case OFF:
				newState = State.LOW;
				break;
			case LOW:
				newState = State.MEDIUM;
				break;
			case MEDIUM:
				newState = State.HIGH;
				break;
			case HIGH:
				newState = State.OFF;
				break;
		}
		return newState;
	}

}
