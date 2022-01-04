package ss.week3.password;

public class BasicChecker implements Checker {

	public boolean acceptable(String suggestion) {
		return suggestion.length() > 6 && !suggestion.contains(" ");
	}

	public String generatePassword() {
		return "TestPass123";
	}
	
}
