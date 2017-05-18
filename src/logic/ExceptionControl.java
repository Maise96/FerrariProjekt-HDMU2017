package logic;

import java.sql.SQLException;
import java.util.List;

import domain.Customer;
import domain.DomainFactory;
import exceptions.CustomerAlreadyExistException;
import exceptions.CustomerDoesNotExistException;
import exceptions.IllegalCprException;
import exceptions.IllegalNameException;
import utill.InputKontrol;

class ExceptionControl {

	Customer newCustomer(String name, String cprNr, List<Customer> searchResult)
			throws IllegalNameException, IllegalCprException, CustomerAlreadyExistException, SQLException {

		Customer customer = new DomainFactory().newCustomer(name, cprNr);
		if (name.isEmpty() || new InputKontrol().illegalName(name))
			throw new IllegalNameException(name);
		if (!new CprControl(cprNr).getResult())
			throw new IllegalCprException(cprNr);
		try {
			if (searchResult.isEmpty())
				throw new CustomerAlreadyExistException(customer);
		} catch (NullPointerException e) {
			if (!new InformationController().searchCustomers(customer.getName(), customer.getCprNr()).isEmpty())
				throw new CustomerAlreadyExistException(customer);
		}
		return customer;
	}
	void deleteCustomer(Customer customer,List<Customer>searchResult)throws CustomerDoesNotExistException,SQLException{
		if(searchResult!=null){
			if(!searchResult.contains(customer))
				throw new CustomerDoesNotExistException(customer);
		}
		else if(searchResult == null){	
		if(new InformationController().searchCustomers(customer.getName(),customer.getCprNr()).isEmpty())
			throw new CustomerDoesNotExistException(customer);
		}
	}
	
}
