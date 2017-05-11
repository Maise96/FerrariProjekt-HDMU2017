package database;

import java.sql.SQLException;
import java.util.List;

import Exceptions.NoSuchCustomerException;
import domain.Customer;

public class DataBaseFacade {

	public void insetCustomer(Customer kunde) throws SQLException {
		new InsetCustomer().execute(kunde);
	}

	public Customer hentKunde(long cprNr) throws NoSuchCustomerException {
		return new GetCustomer().execute(cprNr);
	}

	public List<Customer> getAllCustomers() throws SQLException {
		return new FetchAllCustomers().execute();
	}

	public List<Customer> searchCustomers(String navn,String cpr) {
		return new SearchCustomers().execute(navn,cpr);
	}
}
