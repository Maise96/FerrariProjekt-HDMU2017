package exceptions;

public class IllegalNameException extends Exception{
	public IllegalNameException(){
		new ErrorLogger(this);
	}
}
