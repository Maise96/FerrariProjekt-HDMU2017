package test;

import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.Test;

import database.DataBaseFacade;
import domain.Customer;
import exceptions.CustomerAlreadyExistException;
import exceptions.IllegalCprException;
import exceptions.IllegalNameException;
import logic.InformationController;

class newCustomerTest {

	@Test(expected = IllegalNameException.class)
	private void test() throws IllegalNameException{
		try {
			new InformationController().newCustomer("0703942881", "Dennis");
		} catch (IllegalCprException | CustomerAlreadyExistException | SQLException e) {
			fail("The wrong thing went wrong");
		} catch (IllegalNameException e) {
			throw new IllegalNameException();
		}
		
	}

	@Test(expected = IllegalNameException.class)
	private void nameContainsNumbers() throws IllegalNameException {
		try {
			new InformationController().newCustomer("1Dennis", "0703942881");
		} catch (IllegalNameException e) {
			throw new IllegalNameException();
		} catch (IllegalCprException | CustomerAlreadyExistException | SQLException e) {
			fail("The wrong thing went wrong");
		}
		
	}

	@Test(expected = IllegalNameException.class)
	private void nameContainsSymbols() throws IllegalNameException{
		try {
			new InformationController().newCustomer("!Dennis", "0703942881");
		} catch (IllegalCprException | CustomerAlreadyExistException | SQLException e) {
			fail("The wrong thing went wrong");
		} catch (IllegalNameException e) {
			throw new IllegalNameException();
		}
		
	}

	@Test(expected = IllegalCprException.class)
	private void CprTooShort() throws IllegalCprException {
		try {
			new InformationController().newCustomer("Dennis", "070394288");
		} catch (IllegalCprException e) {
			throw new IllegalCprException();
		} catch (IllegalNameException | CustomerAlreadyExistException | SQLException e) {
			fail("The wrong thing went wrong");
		}
		
	}

	@Test(expected = IllegalCprException.class)
	private void CprContainsSymbols()throws IllegalCprException {
		try {
			new InformationController().newCustomer("Dennis", "1234567a89");
		} catch (IllegalCprException e) {
			throw new IllegalCprException();
		} catch (IllegalNameException | CustomerAlreadyExistException | SQLException e) {
			fail("The wrong thing went wrong");
		}
		
	}

	@Test(expected = IllegalCprException.class)
	private void CprTooLong()throws IllegalCprException {
		try {
			new InformationController().newCustomer("Dennis", "07039428811");
		} catch (IllegalCprException e) {
			throw new IllegalCprException();
		} catch (IllegalNameException | CustomerAlreadyExistException | SQLException e) {
			fail("The wrong thing went wrong");
		}
	}
	@Test(expected = CustomerAlreadyExistException.class)
	private void customerAlreadyExistTest() throws CustomerAlreadyExistException{
		Customer testCustomer = new Customer("uniqueName","0703942881",false);
		db db = new db();
		try {
			db.insetCustomer(testCustomer);
		} catch (SQLException e) {
			fail("database exceptioN");
		}
		try {
			new InformationController().newCustomer(testCustomer.getName(), testCustomer.getCprNr());
		} catch (IllegalNameException | IllegalCprException | SQLException e) {
			fail("not legit customer or db connection failure");
		}
		db.
		
	}
	private class db extends DataBaseFacade{
		
	}
}