package exceptions;

import domain.Customer;

public class CustomerDoesNotExistException extends Exception {
	public CustomerDoesNotExistException(Customer customer){
		new ErrorLogger(this,"customer: " + customer.getName() + " with cpr " + customer.getCprNr());
	}
}
