package logic;

import java.sql.SQLException;

import Exceptions.IllegalCprException;
import Exceptions.IllegalNameException;
import database.DataBaseFacade;
import domain.Customer;

public class InformationExpert {
	public void newCustomer(String name, long cprNr)throws IllegalNameException, IllegalCprException,SQLException{
		Customer customer = new DomainFactory().newCustomer(name, cprNr);
		new DataBaseFacade().indsetCustomer(customer);
		
	}
}
