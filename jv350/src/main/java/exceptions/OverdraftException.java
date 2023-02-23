package exceptions;

@SuppressWarnings("serial")
public class OverdraftException extends InsufficientException {

	public OverdraftException(String msg) {
		super(msg);
	}

}
