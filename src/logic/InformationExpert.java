package logic;

import java.sql.SQLException;
import java.util.List;

import Exceptions.IllegalCprException;
import Exceptions.IllegalNameException;
import database.DataBaseFacade;
import domain.Customer;

public class InformationExpert {
	
	public void newCustomer(String name, long cprNr)throws IllegalNameException, IllegalCprException,SQLException{
		Customer customer = new DomainFactory().newCustomer(name, cprNr);
		new DataBaseFacade().insetCustomer(customer);
	}
	public List<Customer> getAllCustomers() throws SQLException{
		List<Customer> allCustomers = new DataBaseFacade().getAllCustomers();
		return allCustomers;
	}
	public List<Customer> searchCustomers(String navn, String cpr)throws SQLException{
		return new DataBaseFacade().searchCustomers(navn,cpr);
	}
}
