package exceptions;

public class IllegalNameException extends Exception{
	public IllegalNameException(String name){
		new ErrorLogger(this, name + "isn't a valid name");
	}
}
