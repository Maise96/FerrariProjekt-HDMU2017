package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.Customer;

class SetCustomerTroubleOppositeDB extends DBAccess {
	void execute(Customer kunde) throws SQLException {
		connect();
		PreparedStatement statement = prepareStatement("UPDATE CUSTOMERS SET TROUBLE = NOT TROUBLE WHERE NAME = ? AND CPR = ?");

		statement.setString(1, kunde.getName());
		statement.setString(2, kunde.getCprNr());

		statement.execute();
		disConnect();
	}
}
