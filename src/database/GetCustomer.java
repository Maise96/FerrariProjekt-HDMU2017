package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Exceptions.NoSuchCustomerException;
import domain.Customer;

class GetCustomer extends DB{
	Customer execute(long cprNr) throws NoSuchCustomerException{
		Customer kunde = null;
		try{
			connect();
			PreparedStatement statement = connection.prepareStatement("select * from kunde where cpr = ?");
			statement.setLong(0, cprNr);
			ResultSet rs = statement.executeQuery();
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
