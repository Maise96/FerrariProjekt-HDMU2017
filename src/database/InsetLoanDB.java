package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import domain.Loan;

class InsetLoanDB extends DBAccess {
	void execute(Loan loan) throws SQLException {
		connect();
		PreparedStatement statement = prepareStatement("INSERT INTO ISSUEDLOANS (AMOUNT, INTERESTRATE, CUSTOMERID, SALESMANIS, ESTIMATEDENDDATE) VALUES(?,?,?,?,?)");
		
		statement.setBigDecimal(0, loan.getAmount());
		statement.setInt(1, loan.getInterestRate());
		statement.setInt(2, loan.getCustomerID());
		statement.setInt(3, loan.getSalesmanID());
		statement.setDate(4, loan.getEstimatedEndDate());
		
		statement.execute();
		disConnect();
	}
}
