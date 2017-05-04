package database;

import java.sql.SQLException;
import java.util.List;

import Exceptions.NoSuchCustomerException;
import domain.Customer;

public class DataBaseFacade {

	public void indsætKunde(Customer kunde) throws SQLException{
			new InsetCustomer().execute(kunde);
	
	}

	public Customer hentKunde(long cprNr) throws NullPointerException{
		try {
			return new FetchCustomer().execute(cprNr);
		} catch (NoSuchCustomerException e) {
			throw new NullPointerException();
			//Håndteres med den nullpointerException som der bliver kastet
		}
	}
	public List<Customer> hentAlleKunder() throws SQLException{
		return new FetchAllCustomers().execute();
	}
	public List<Customer> søgKunder(String søgeOrd){
		return new SearchCustomers().execute(søgeOrd);
	}
}
