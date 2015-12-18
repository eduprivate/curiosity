package br.com.curiosity.exception;

@SuppressWarnings("serial")
public class OutOfGroundException extends Throwable {

	public OutOfGroundException() {
		super();
	}

	public OutOfGroundException(String message) {
		super(message);
	}

	public OutOfGroundException(Throwable cause) {
		super(cause);
	}

	public OutOfGroundException(String message, Throwable cause) {
		super(message, cause);
	}

	public OutOfGroundException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
