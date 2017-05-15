package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.Customer;

class InsetCustomer extends DB{
	void execute(Customer kunde)throws SQLException{
		connect();
		PreparedStatement statement = connection.prepareStatement("INSERT INTO CUSTOMER (NAVN, CPRNR,CREDITRATING) VALUES(?,?,?)");
		statement.setString(0, kunde.getName());
		statement.setString(1, kunde.getCprNr());
		statement.execute();
		disConnect();
		
	}
}
