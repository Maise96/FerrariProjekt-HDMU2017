package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.Salesman;

public class InsetSalesmanDB extends DBAccess {
	void execute(Salesman salesman) throws SQLException {
		connect();
		PreparedStatement statement = prepareStatement("INSERT INTO SALESMEN (NAME, LOANLIMIT) VALUES(?,?)");
		
		statement.setString(0, salesman.getName());
		statement.setBigDecimal(1, salesman.getLoanLimit());
		
		statement.execute();
		disConnect();
	}
}

