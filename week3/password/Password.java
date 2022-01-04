package ss.week3.password;

public class Password {
	private Checker checker;
	public String initPass;
	
	
	
	public Password(Checker checker) {
		this.checker = checker;
		this.initPass = checker.generatePassword();
	}
	
	public Password() {
		this(new BasicChecker());
	}
	
	
	/**
    * Test if a given string is an acceptable password. 
	* Not acceptable: A word with less than 6 characters 
	* or a word that contains a space.
    * @param suggestion - Word that should be tested
    * @return true If suggestion is acceptable
    * @requires suggestion != null
    * @ensures returns true If the suggestion has at least 6 characters and no spaces
    */
	
	public boolean acceptable(String suggestion) {
		return checker.acceptable(suggestion);
	}
	
	
	/**
    * Tests if a given word is equal to the current password.
    * @param test - Word that should be tested
    * @return true If test is equal to the current password
    * @requires test != null;
    */	
	public boolean testWord(String test) {
		return this.initPass.equals(test);
	}
	
	
	/**
    * Changes this password.
    * @param oldpass - The current password, newpass - The new password
    * @return true If oldPass is equal to thecurrent password and newpass is anacceptable password
    * @requires oldpass != null, newpass != null
    * @ensures returns true if the old password is correct and the new one is acceptable
    */	
	
	public boolean setWord(String oldpass, String newpass) {
		if (oldpass.equals(this.initPass) && this.acceptable(newpass)) {
			this.initPass = newpass;
			return true;
		}
		return false;
	}
	
	public Checker getChecker() {
		return this.checker;
	}
	
	public String getInitPass() {
		return this.initPass;
	}
	
}
