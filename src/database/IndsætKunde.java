package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.Kunde;

class IndsætKunde extends DB{
PreparedStatement statement;
	void execute(Kunde kunde) throws SQLException{
		super.connect();
		statement = connection.prepareStatement("INSERT INTO KUNDE (NAVN, CPRNR) VALUES(?,?)");
		statement.setString(0, kunde.getNavn());
		statement.setLong(1, kunde.getCprNr());
		statement.execute();
		super.disConnect();
	}
}
