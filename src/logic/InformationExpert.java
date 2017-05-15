package logic;

import java.sql.SQLException;
import java.util.List;

import database.DataBaseFacade;
import domain.BankRate;
import domain.CreditAssesment;
import domain.Customer;
import exceptions.BadCustomerException;
import exceptions.ErrorMessage;
import exceptions.IllegalCprException;
import exceptions.IllegalNameException;

public class InformationExpert {
	
	public void newCustomer(String name, String cprNr)throws IllegalNameException, IllegalCprException,SQLException{
		if (name.isEmpty()) 
			throw new IllegalNameException();
		
		if(cprNr.length()!=10)
			throw new IllegalCprException();
		
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
	public void updateBankRate(){
		new BankRate().update();
	}
	public CreditAssesment newCreditAssesment(Customer customer){
		CreditAssesment creditAssesment = new CreditAssesment();
		try{
		creditAssesment = new CreditAssesmentCalculator().newCreditAssesment(customer, new CreditAssesment());
		}
		catch(BadCustomerException e){
			new ErrorMessage("customer doesn't qulify for a loan");
		}
		return creditAssesment;
		
		
	}
}
