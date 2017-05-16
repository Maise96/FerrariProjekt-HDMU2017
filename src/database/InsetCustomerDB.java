package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import domain.Customer;

class InsetCustomerDB extends DBAccess {
	void execute(Customer kunde) throws SQLException {
		connect();
		PreparedStatement statement = prepareStatement("INSERT INTO CUSTOMERS (NAME,CPR,TROUBLE) VALUES(?,?,?)");
		
		statement.setString(1, kunde.getName());
		statement.setString(2, kunde.getCprNr());
		statement.setBoolean(3, kunde.getTrouble());
		
		statement.execute();
		disConnect();
	}
}
