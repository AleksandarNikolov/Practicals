package ss.week5;

public class TooFewArgumentsException extends WrongArgumentException {

	public TooFewArgumentsException() {
		super("error: too few command line arguments");
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
