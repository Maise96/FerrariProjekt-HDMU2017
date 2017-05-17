package logic;

import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.Test;

import exceptions.IllegalCprException;
import exceptions.IllegalNameException;

public class newCustomerTest {

	@Test(expected = IllegalNameException.class)
	public void test() throws IllegalNameException{
		try {
			new InformationController().newCustomer("0703942881", "Dennis");
		} catch (IllegalCprException | SQLException e) {
			fail("The wrong thing went wrong");
		} catch (IllegalNameException e) {
			throw new IllegalNameException();
		}
		
	}

	@Test(expected = IllegalNameException.class)
	public void nameContainsNumbers() throws IllegalNameException {
		try {
			new InformationController().newCustomer("1Dennis", "0703942881");
		} catch (IllegalNameException e) {
			throw new IllegalNameException();
		} catch (SQLException | IllegalCprException g) {
			fail("the wrong thing went wrong");

		}
		
	}

	@Test(expected = IllegalNameException.class)
	public void nameContainsSymbols() throws IllegalNameException{
		try {
			new InformationController().newCustomer("!Dennis", "0703942881");
		} catch (IllegalCprException | SQLException e) {
			fail("the wrong thing went wrong");
		} catch (IllegalNameException e) {
			throw new IllegalNameException();
		}
		
	}

	@Test(expected = IllegalCprException.class)
	public void CprTooShort() throws IllegalCprException {
		try {
			new InformationController().newCustomer("Dennis", "070394288");
		} catch (IllegalCprException e) {
			throw new IllegalCprException();
		} catch (SQLException | IllegalNameException g) {
			fail("the wrong thing went wrong");
		}
		
	}

	@Test(expected = IllegalCprException.class)
	public void CprContainsSymbols()throws IllegalCprException {
		try {
			new InformationController().newCustomer("Dennis", "1234567a89");
		} catch (IllegalCprException e) {
			throw new IllegalCprException();
		} catch (SQLException | IllegalNameException g) {
			fail("the wrong thing went wrong");
		}
		
	}

	@Test(expected = IllegalCprException.class)
	public void CprTooLong()throws IllegalCprException {
		try {
			new InformationController().newCustomer("Dennis", "07039428811");
		} catch (IllegalCprException e) {
			throw new IllegalCprException();
		} catch (SQLException | IllegalNameException g) {
			fail("the wrong thing went wrong");
		}
		
	}

}