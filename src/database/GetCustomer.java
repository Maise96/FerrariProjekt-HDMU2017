package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Customer;
import exceptions.NoSuchCustomerException;

class GetCustomer extends DB{
	Customer execute(String cprNr) throws NoSuchCustomerException{
		Customer kunde = null;
		try{
			connect();
			PreparedStatement statement = connection.prepareStatement("select * from customer where cpr = ?");
			statement.setString(0, cprNr);
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				kunde = new Customer(rs.getString("navn"), cprNr);
			}
			else{
				throw new NoSuchCustomerException();
			}
		rs.close();
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
		return kunde;
	}
}
