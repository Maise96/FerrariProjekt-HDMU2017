package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Salesman;
import exceptions.ErrorMessage;

class SearchSalesmenDB extends DBAccess {
	List<Salesman> execute(String name) {
		List<Salesman> salesmen = new ArrayList<Salesman>();
		try {
			connect();

			PreparedStatement statement = prepareStatement("SELECT * FROM SALESMEN WHERE NAME = ?");
			statement.setString(0, "%" + name + "%");

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				salesmen.add(new Salesman(rs.getString("NAME"), rs.getBigDecimal("LOANLIMIT")));
			}

			rs.close();
			disConnect();

		} catch (SQLException e) {
			new ErrorMessage("Search function went wrong");
		}

		return salesmen;
	}
}
