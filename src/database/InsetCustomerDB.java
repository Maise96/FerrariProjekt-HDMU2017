package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import domain.Customer;

class InsetCustomerDB extends DBAccess {
	void execute(Customer customer) throws SQLException {
		connect();
		PreparedStatement statement = prepareStatement("INSERT INTO CUSTOMERS (NAME,CPR,TROUBLE) VALUES(?,?,?)");
		
		statement.setString(1, customer.getName());
		statement.setString(2, customer.getCprNr());
		statement.setBoolean(3, customer.getTrouble());
		
		statement.execute();
		disConnect();
	}
}
