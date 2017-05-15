package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ferrari.finances.dk.rki.Rating;

import domain.Customer;
import exceptions.ErrorMessage;

class SearchCustomers extends DB{
private PreparedStatement statement;
private ResultSet rs;
	List<Customer> execute(String name,String cpr){
		List<Customer> customers = new ArrayList<Customer>();
		try{
		connect();
		statement = connection.prepareStatement("select * from customer where navn like ? or cprnr like ?");
		statement.setString(0, name);
		statement.setLong(1, Long.parseLong(cpr));
		
		rs = statement.executeQuery();
		while(rs.next()){
			customers.add(new Customer(rs.getString("navn"),rs.getString("cprnr")));
			
		}
		disConnect();
		rs.close();
		}
		catch(SQLException e){
			new ErrorMessage("Search function went wrong");
		}
		return customers;
		}
}
