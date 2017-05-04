package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DB {
	protected Connection connection;
	String url=" ";

	public DB(){
	}
	
	protected void connect() throws SQLException {
		try {
			connection = DriverManager.getConnection(url);
			connection.setAutoCommit(false);
		} catch (SQLException | NullPointerException e) {
			throw new SQLException();
		}
	}

	protected void disConnect() {
		try {
			connection.commit();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
