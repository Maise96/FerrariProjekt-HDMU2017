package database;

import java.sql.SQLException;
import java.util.List;

import domain.Customer;

public class DataBaseFacade {

	public void insetCustomer(Customer kunde) throws SQLException {
		new InsetCustomerDB().execute(kunde);
	}

	public List<Customer> searchCustomers(String navn,String cpr) {
		return new SearchCustomersDB().execute(navn,cpr);
	}
}
