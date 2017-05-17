package exceptions;

import domain.Customer;

public class CustomerAlreadyExistException extends Exception {
	public CustomerAlreadyExistException(Customer customer){
		new ErrorLogger(this, "customer already exist and can't be saved : " + customer.getName() + " " + customer.getCprNr());
	}
}
