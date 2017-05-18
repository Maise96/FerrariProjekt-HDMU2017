package logic;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import database.DataBaseFacade;
import domain.BankRate;
import domain.CreditAssesment;
import domain.CreditPlan;
import domain.Customer;
import exceptions.CustomerAlreadyExistException;
import exceptions.CustomerDoesNotExistException;
import exceptions.IllegalCprException;
import exceptions.IllegalNameException;

public class InformationController {
	List<Customer> searchResult;

	public void newCustomer(String name, String cprNr)
			throws IllegalNameException, IllegalCprException, SQLException, CustomerAlreadyExistException {
		Customer customer = new ExceptionControl().newCustomer(name, cprNr, searchResult);
		new DataBaseFacade().insetCustomer(customer);

	}

	public List<Customer> searchCustomers(String navn, String cpr) throws SQLException {
		searchResult = new DataBaseFacade().searchCustomers(navn, cpr);
		return searchResult;
	}

	public void updateBankRate() {
		new BankRate().update();
	}

	public double newCustomerRate(Customer customer,
			CreditAssesment creditAssesment)/* throws BadCustomerException */ {
		creditAssesment = new CreditAssesmentCalculator().newCreditAssesment(customer, creditAssesment);
		return creditAssesment.getCustomerRate();
	}

	public CreditPlan newCreditPlan(BigDecimal amount, BigDecimal downPayment, double customerRate) {
		CreditPlan creditPlan = new CreditPlanCalculator().calculateNewCreditPlan(amount, downPayment, customerRate);
		if(creditPlan.size()>=36)
			return new CreditPlanCalculator().calculateNewCreditPlan(amount, downPayment, customerRate+1);
		return creditPlan;
	}

	public void deleteCustomer(Customer customer) throws SQLException, CustomerDoesNotExistException {
		new ExceptionControl().deleteCustomer(customer, searchResult);
		new DataBaseFacade().deleteCustomer(customer);
	}

	public void switchTroubleState(Customer customer) throws SQLException, CustomerDoesNotExistException {
		new DataBaseFacade().switchTroubleState(customer);
	}
}
