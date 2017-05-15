package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

abstract class DBAccess {
	protected Connection connection;
	String url="jdbc:hsqldb:hsql://localhost/FerrariProgram";
	
	protected void connect() throws SQLException {
		try {
			connection = DriverManager.getConnection(url, "SA", "");
			connection.setAutoCommit(false);
		} catch (SQLException | NullPointerException e) {
			throw new SQLException();
		}
	}

	protected void disConnect()throws SQLException{
		try {
			connection.commit();
			connection.close();
		} catch (SQLException e) {
			abort();
		}
	}
	protected void abort () throws SQLException{
		try {
			connection.rollback();
		} catch (SQLException e) {
			throw new SQLException();
		}
	}
	protected PreparedStatement prepareStatement(String statement)throws SQLException{
		return connection.prepareStatement(statement);
	}
}
