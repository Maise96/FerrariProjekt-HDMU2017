package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Loan;
import exceptions.ErrorMessage;

class SearchLoanDB extends DBAccess {
	List<Loan> execute(int customerID, int salesmanID) {
		List<Loan> loans = new ArrayList<Loan>();
		try {
			connect();

			PreparedStatement statement = prepareStatement("SELECT * FROM ISSUEDLOANS WHERE CUSTOMERID = ? OR SALESMANID = ?");
			statement.setInt(0, customerID);
			statement.setInt(1, salesmanID);

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				loans.add(new Loan(rs.getBigDecimal("AMUONT"),rs.getInt("INTERESTRATE"),rs.getInt("CUSTOMERID"),rs.getInt("SALESMANID"),rs.getDate("ESTIMATEDENDDATE")));
			}

			rs.close();
			disConnect();

		} catch (SQLException e) {
			new ErrorMessage("Search function went wrong");
		}

		return loans;
	}
}
