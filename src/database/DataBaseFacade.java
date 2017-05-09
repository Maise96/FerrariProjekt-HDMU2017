package database;

import java.sql.SQLException;
import java.util.List;

import Exceptions.NoSuchCustomerException;
import domain.Customer;

public class DataBaseFacade {

	public void indsetCustomer(Customer kunde) throws SQLException {
		new InsetCustomer().execute(kunde);
	}

	public Customer hentKunde(long cprNr) throws NoSuchCustomerException {
		return new GetCustomer().execute(cprNr);
	}

	public List<Customer> hentAlleKunder() throws SQLException {
		return new FetchAllCustomers().execute();
	}

	public List<Customer> søgKunder(String søgeOrd) {
		return new SearchCustomers().execute(søgeOrd);
	}
}
