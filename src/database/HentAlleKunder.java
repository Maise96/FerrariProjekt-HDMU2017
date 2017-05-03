package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Kunde;

class HentAlleKunder extends DB {
private PreparedStatement statement;
private	ResultSet rs;

	List<Kunde> execute() {
		connect();
		List<Kunde> kunder = new ArrayList<Kunde>();
		try {
			connection.prepareStatement("SELECT * FROMT KUNDE");
			rs = statement.executeQuery();

			while (rs.next()) {
				kunder.add(new Kunde(rs.getString("NAVN"), rs.getLong("CPRNR")));
			}
			disConnect();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kunder;

	}
}
