package bozoException;

/**
 * @author 10284667	Fabio F. Destro
 * @author 10284952	Vitor G. Torres
 */
@SuppressWarnings("serial")
public class BozoException extends Exception {

	/**
	 * @param message
	 */
	public BozoException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public BozoException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BozoException(String message, Throwable cause) {
		super(message, cause);
	}

}
