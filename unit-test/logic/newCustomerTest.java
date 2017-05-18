package logic;

import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.Test;

import database.DataBaseFacade;
import domain.Customer;
import exceptions.CustomerAlreadyExistException;
import exceptions.CustomerDoesNotExistException;
import exceptions.IllegalCprException;
import exceptions.IllegalNameException;
import logic.InformationController;

public class newCustomerTest {

	@Test(expected = IllegalNameException.class)
	public void nameContainsNumbers() throws IllegalNameException {
		try {
			new InformationController().newCustomer("1Dennis", "0703942881");
		} catch (IllegalNameException e) {
			throw new IllegalNameException("1Dennis");
		} catch (IllegalCprException | CustomerAlreadyExistException | SQLException e) {
			fail("The wrong thing went wrong");
		}

	}

	@Test(expected = IllegalNameException.class)
	public void nameContainsSymbols() throws IllegalNameException {
		try {
			new InformationController().newCustomer("!Dennis", "0703942881");
		} catch (IllegalCprException | CustomerAlreadyExistException | SQLException e) {
			fail("The wrong thing went wrong");
		} catch (IllegalNameException e) {
			throw new IllegalNameException("!Dennis");
		}

	}

	@Test(expected = IllegalCprException.class)
	public void CprTooShort() throws IllegalCprException {
		try {
			new InformationController().newCustomer("Dennis", "070394288");
		} catch (IllegalCprException e) {
			throw new IllegalCprException("070394288");
		} catch (IllegalNameException | CustomerAlreadyExistException | SQLException e) {
			fail("The wrong thing went wrong");
		}

	}

	@Test(expected = IllegalCprException.class)
	public void CprContainsSymbols() throws IllegalCprException {
		try {
			new InformationController().newCustomer("Dennis", "1234567a89");
		} catch (IllegalCprException e) {
			throw new IllegalCprException("1234567a89");
		} catch (IllegalNameException | CustomerAlreadyExistException | SQLException e) {
			fail("The wrong thing went wrong");
		}

	}

	@Test(expected = IllegalCprException.class)
	public void CprTooLong() throws IllegalCprException {
		try {
			new InformationController().newCustomer("Dennis", "07039428811");
		} catch (IllegalCprException e) {
			throw new IllegalCprException("07039428811");
		} catch (IllegalNameException | CustomerAlreadyExistException | SQLException e) {
			fail("The wrong thing went wrong");
		}
	}

	@Test(expected = CustomerAlreadyExistException.class)
	public void customerAlreadyExistTest()
			throws CustomerAlreadyExistException, SQLException, CustomerDoesNotExistException {
		Customer testCustomer = new Customer("uniqueName", "0703942881", false);
		db db = new db();
		db.insetCustomer(testCustomer);

		try {
			new InformationController().newCustomer(testCustomer.getName(), testCustomer.getCprNr());
		} catch (IllegalNameException | IllegalCprException | SQLException e) {
			fail("not legit customer or db connection failure");
		} catch (CustomerAlreadyExistException e) {
			db.deleteCustomer(testCustomer);
			throw new CustomerAlreadyExistException(testCustomer);
		}

	}

	public class db extends DataBaseFacade {

	}
}
