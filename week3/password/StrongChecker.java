package ss.week3.password;

public class StrongChecker extends BasicChecker {
	
	@Override
	public boolean acceptable(String suggestion) {
		return super.acceptable(suggestion) &&
				Character.isLetter(suggestion.charAt(0)) &&
				Character.isDigit(suggestion.charAt(suggestion.length() - 1));
	}

}
