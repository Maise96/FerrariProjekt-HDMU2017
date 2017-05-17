package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.Customer;

class DeleteCustomerDB extends DBAccess {
	void execute(Customer customer)throws SQLException{
		connect();
		PreparedStatement statement = prepareStatement("DELETE FROM CUSTOMERS WHERE NAME = ? AND CPR = ?");
		statement.setString(1, customer.getName());
		statement.setString(2, customer.getCprNr());
		statement.execute();
		disConnect();
	}
}
