package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import domain.Customer;

class FetchAllCustomers extends DB {
	List<Customer> execute() throws SQLException{
		connect();
		List<Customer> kunder = new ArrayList<Customer>();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROMT KUNDE");
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				kunder.add(new Customer(rs.getString("NAVN"), rs.getLong("CPRNR")));
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
		return kunder;

	}
}
