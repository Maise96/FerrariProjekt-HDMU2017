package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Customer;
import exceptions.ErrorMessage;

class SearchCustomersDB extends DBAccess {
	List<Customer> execute(String name, String cprNr) {
		List<Customer> customers = new ArrayList<Customer>();
		try {
			connect();
			
			PreparedStatement statement = prepareStatement("SELECT * FROM CUSTOMERS WHERE CPR LIKE ? AND NAME LIKE ?");
			statement.setString(1, "%" + cprNr + "%");
			statement.setString(2, "%" + name + "%");

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				customers.add(new Customer(rs.getString("NAME"), rs.getString("CPR"), rs.getBoolean("TROUBLE")));
			}
			rs.close();
			disConnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customers;
	}
}
