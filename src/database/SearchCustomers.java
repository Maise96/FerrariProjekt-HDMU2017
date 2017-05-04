package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Customer;

class SearchCustomers extends DB{
private PreparedStatement statement;
private ResultSet rs;
	List<Customer> execute(String søgeord){
		List<Customer> kunder = new ArrayList<Customer>();
		try{
		connect();
		statement = connection.prepareStatement("select * from kunde where navn like ? or cprnr like ?");
		rs = statement.executeQuery();
		while(rs.next()){
			kunder.add(new Customer(rs.getString("navn"), rs.getLong("cprnr")));
		}
		disConnect();
		rs.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return kunder;
		}
}
