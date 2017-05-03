package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Kunde;

public class SøgKunder extends DB{
PreparedStatement statement;
ResultSet rs;
	List<Kunde> execute(String søgeord){
		List<Kunde> kunder = new ArrayList<Kunde>();
		try{
		connect();
		statement = connection.prepareStatement("select * from kunde where navn like ? or cprnr like ?");
		rs = statement.executeQuery();
		while(rs.next()){
			kunder.add(new Kunde(rs.getString("navn"), rs.getLong("cprnr")));
		}
		disConnect();
		rs.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return kunder;
		}
}
