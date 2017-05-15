package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ferrari.finances.dk.rki.Rating;

import domain.Customer;

class FetchAllCustomers extends DB {
	List<Customer> execute() throws SQLException{
		connect();
		List<Customer> customers = new ArrayList<Customer>();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROMT KUNDE");
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Customer customer = new Customer(rs.getString("NAVN"), rs.getString("CPRNR"));

				customers.add(customer);
			}
			disConnect();
			rs.close();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				throw new SQLException();
			}
			throw new SQLException();
		}
		return customers;

	}
}
