package exceptions;

public class IllegalCprException extends Exception {
	public IllegalCprException(String cpr) {
		new ErrorLogger(this, cpr + "isn't a valid cpr number");
	}
}
