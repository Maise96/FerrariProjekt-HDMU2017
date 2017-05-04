package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Exceptions.NoSuchCustomerException;
import domain.Customer;

class FetchCustomer extends DB{
private PreparedStatement statement;
private ResultSet rs;
	Customer execute(long cprNr) throws NoSuchCustomerException{
		Customer kunde = null;
		try{
			connect();
			statement = connection.prepareStatement("select * from kunde where cpr = ?");
			statement.setLong(0, cprNr);
			rs = statement.executeQuery();
			if(rs.next()){
				kunde = new Customer(rs.getString("navn"), cprNr);
			}
			else{
				throw new NoSuchCustomerException();
			}
		
		}	
		catch(SQLException e){
			e.printStackTrace();
		}
		return kunde;
	}
}
