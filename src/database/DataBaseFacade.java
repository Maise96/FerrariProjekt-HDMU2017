package database;

import java.sql.SQLException;
import java.util.List;

import domain.Customer;
import exceptions.CustomerDoesNotExistException;

public class DataBaseFacade {

	public void insetCustomer(Customer kunde) throws SQLException {
		new InsetCustomerDB().execute(kunde);
	}

	public List<Customer> searchCustomers(String navn, String cpr) {
		return new SearchCustomersDB().execute(navn, cpr);
	}

	public void deleteCustomer(Customer customer) throws CustomerDoesNotExistException, SQLException {
		new DeleteCustomerDB().execute(customer);
	}

	public void switchTroubleState(Customer customer) throws SQLException, CustomerDoesNotExistException {
		new SetCustomerTroubleOppositeDB().execute(customer);
	}
}
