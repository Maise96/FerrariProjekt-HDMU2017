package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.Test;

import database.DataBaseFacade;
import domain.Customer;
import exceptions.CustomerDoesNotExistException;
import logic.InformationController;

public class DBTest {
	@Test(expected = CustomerDoesNotExistException.class)
	public void customerDoesNotExistTest() throws CustomerDoesNotExistException {
		Customer testCustomer =new Customer("nonExistent", "bullshit", true); 
		try{
		new InformationController().deleteCustomer(testCustomer);
		}
		catch(CustomerDoesNotExistException e){
			throw new CustomerDoesNotExistException(testCustomer);
		}
		catch(SQLException e){
			fail("failed connection to database");
		}
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
	public void insetCustomer()throws SQLException {
		db db = new db();
		Customer testCustomer = new Customer("testCustomer", "0703942881", true);
		db.insetCustomer(testCustomer);
		assertTrue(!new InformationController().searchCustomers(testCustomer.getName(), testCustomer.getCprNr()).isEmpty());
		
		try{
		db.deleteCustomer(testCustomer);
		}
		catch(CustomerDoesNotExistException e){
			fail("customer wasn't found and couldn't be deleted");
		}

	}

	private class db extends DataBaseFacade {

	}
}
