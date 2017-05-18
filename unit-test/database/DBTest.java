package database;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;

import domain.Customer;
import exceptions.CustomerAlreadyExistException;
import exceptions.CustomerDoesNotExistException;
import exceptions.IllegalCprException;
import exceptions.IllegalNameException;
import logic.InformationController;

public class DBTest {
	@Test(expected = CustomerDoesNotExistException.class)
	public void customerDoesNotExistTest() throws CustomerDoesNotExistException {
		Customer testCustomer = new Customer("nonExistent", "bullshit", true);
		try {
			new InformationController().deleteCustomer(testCustomer);
		} catch (CustomerDoesNotExistException e) {
			throw new CustomerDoesNotExistException(testCustomer);
		} catch (SQLException e) {
			fail("failed connection to database");
		}
	}

	@Test
	public void testAbort() {
		new dbAccessTest().testAbort();
	}

	@Test
	public void deleteCustomer() {
		db db = new db();
		Customer testCustomer = new Customer("testCustomer", "0703942881", true);
		try {
			db.insetCustomer(testCustomer);
			db.deleteCustomer(testCustomer);
			assertFalse(db.searchCustomers("", "").contains(testCustomer));
		} catch (SQLException | CustomerDoesNotExistException e) {
			if (e.getClass().equals(SQLException.class))
				fail("failed connection to database");
			if (e.getClass().equals(CustomerDoesNotExistException.class))
				fail("failed to insert customer into db");
		}
	}

	@Test
	public void insetCustomer() throws SQLException {
		db db = new db();
		Customer testCustomer = new Customer("testCustomer", "0703942881", true);
		db.insetCustomer(testCustomer);
		assertTrue(!new InformationController().searchCustomers(testCustomer.getName(), testCustomer.getCprNr())
				.isEmpty());

		try {
			db.deleteCustomer(testCustomer);
		} catch (CustomerDoesNotExistException e) {
			fail("customer wasn't found and couldn't be deleted");
		}
	}

	@Test
	public void testSQLException0() throws SQLException {
		new DBAccessMock();
	}

	@Test(expected = SQLException.class)
	public void testSQLExceptionConnect() throws SQLException {
		DBAccessMock dbAccess = new DBAccessMock();
		dbAccess.url = "";
		dbAccess.connect();

	}

	@Test
	public void testDBLogger() {
		try {
			new DBLogger("test", new InsetCustomerDB());
		} catch (IOException e) {
			fail("IOException");
		}
	}

	@Test
	public void switchTroubleStateTest() {
		Customer customer = new Customer("test", "0703942881", false);
		try {
			new InformationController().newCustomer(customer.getName(), customer.getCprNr());
		} catch (IllegalNameException | IllegalCprException | SQLException | CustomerAlreadyExistException e) {
		}
		db db = new db();
		try {
			db.switchTroubleState(customer);
		} catch (SQLException | CustomerDoesNotExistException e) {
		}
		assertTrue(db.searchCustomers("test", "0703942881").get(0).getTrouble());
		try {
			db.deleteCustomer(customer);
		} catch (CustomerDoesNotExistException e) {
		} catch (SQLException e) {
		}
	}

	@Test(expected = CustomerDoesNotExistException.class)
	public void testSwitchTroubleStateCustomerDoesNotExistException() throws CustomerDoesNotExistException {
		db db = new db();
		try {
			db.switchTroubleState(new Customer("as�dlhbkjhaldjsfhl", "1234567890", false));
		} catch (SQLException e) {
		}
	}

	@Test(expected = SQLException.class)
	public void testSQLExceptionDisConnect() throws SQLException {
		DBAccessMock dbAccess = new DBAccessMock();
		dbAccess.connect();
		dbAccess.prepareStatement("INSERT INTO CUSTOMERS (NAME,CPR,TROUBLE) values(testShouldntBeHere,0703942881,true")
				.execute();
		dbAccess.url = "";
		dbAccess.disConnect();
	}

	@Test(expected = SQLException.class)
	public void testSQLExceptionPrepareStatement() throws SQLException {
		DBAccessMock dbAccess = new DBAccessMock();
		dbAccess.connect();
		dbAccess.url = "";
		dbAccess.prepareStatement("wtf");
	}

	private class db extends DataBaseFacade {

	}

	private class dbAccessTest extends DBAccess {
		void testAbort() {
			try {
				connect();
				abort();
				disConnect();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private class DBAccessMock extends DBAccess {
	}

}
