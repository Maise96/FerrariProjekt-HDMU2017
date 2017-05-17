package logic;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import database.DataBaseFacade;
import domain.BankRate;
import domain.CreditAssesment;
import domain.CreditPlan;
import domain.Customer;
import domain.DomainFactory;
import exceptions.CustomerAlreadyExistException;
import exceptions.IllegalCprException;
import exceptions.IllegalNameException;
import utill.InputKontrol;

public class InformationController {
	List<Customer> searchResult;

	public void newCustomer(String name, String cprNr)
			throws IllegalNameException, IllegalCprException, SQLException, CustomerAlreadyExistException {

		Customer customer = new DomainFactory().newCustomer(name, cprNr);
		if (name.isEmpty() || new InputKontrol().illegalName(name))
			throw new IllegalNameException();
		if (!new CprControl(cprNr).getResult())
			throw new IllegalCprException();
		if (searchResult.contains(customer))
			throw new CustomerAlreadyExistException();
		new DataBaseFacade().insetCustomer(customer);
	}

	public List<Customer> searchCustomers(String navn, String cpr) throws SQLException {
		searchResult = new DataBaseFacade().searchCustomers(navn, cpr);
		return searchResult;
	}

	public void updateBankRate() {
		new BankRate().update();
	}

	public CreditAssesment newCreditAssesment(
			Customer customer)/* throws BadCustomerException */ {
		CreditAssesment creditAssesment = new CreditAssesment();
		creditAssesment = new CreditAssesmentCalculator().newCreditAssesment(customer, new CreditAssesment());
		return creditAssesment;
	}

	public CreditPlan newCreditPlan(BigDecimal amount, BigDecimal downPayment, double customerRate) {
		return new CreditPlanCalculator().calculateNewCreditPlan(amount, downPayment, customerRate);
	}
}
