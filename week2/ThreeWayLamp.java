package ss.week2;

public class ThreeWayLamp {


	private State lamp;
	
	public ThreeWayLamp() {
		lamp = State.OFF;
	}
	
	
	public void setState(String input) {
		assert input == "OFF";
		switch (input) {
			case "OFF":
				lamp = State.OFF;
				break;
			case "LOW":
				lamp = State.LOW;
				break;
			case "MEDIUM":
				lamp = State.MEDIUM;
				break;
			case "HIGH":
				lamp = State.HIGH;
				break;
		}
	}
	
	public String getState() {
		String result;
		switch (lamp) {
			case OFF:
				result = "OFF";
				break;
			case LOW:
				result = "LOW";
				break;
			case MEDIUM:
				result = "MEDIUM";
				break;
			case HIGH:
				result = "HIGH";
				break;
			default:
				result = "ERROR";
				break;
		}
		return result;
	}
	
	public void nextState() {
		switch (lamp) {
			case OFF:
				lamp = State.LOW;
				break;
			case LOW:
				lamp = State.MEDIUM;
				break;
			case MEDIUM:
				lamp = State.HIGH;
				break;
			case HIGH:
				lamp = State.OFF;
				break;
		}
	}
	
	public void menue() {
		String menue = "Use the followig commands: OFF, LOW, MEDIUM, HIGH, STATE, NEXT, HELP, EXIT";
		System.out.println(menue);
	}
	
	public void help() {
		String help = "OFF - switching of the lamp\n" +
				  "LOW - switching the lamp to low state\n" +
				  "MEDIUM - switching the lamp to medium state\n" +
				  "HIGH - switching the lamp to low state\n" +
				  "STATE - checking the current state of the lamp\n" +
				  "NEXT - switching the lamp to the next state\n" +
				  "HELP - to get more information about the commands\n" +
				  "EXIT - for exiting the program\n";
		System.out.println(help);
	}
	
}
