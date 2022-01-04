package ss.week5;

public class ArgumentLengthsDifferException extends WrongArgumentException {

	public ArgumentLengthsDifferException(Integer one, Integer two) {
		super("error: length of command line arguments differ + (" + one + ", " + two + ")");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
