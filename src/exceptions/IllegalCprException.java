package exceptions;

public class IllegalCprException extends Exception {
	public IllegalCprException() {
		new ErrorLogger(this);
	}

}
