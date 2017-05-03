package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Exceptions.KundenFindesIkkeException;
import domain.Kunde;

public class HentKunde extends DB{
PreparedStatement statement;
ResultSet rs;
	Kunde execute(long cprNr) throws KundenFindesIkkeException{
		Kunde kunde = null;
		try{
			connect();
			statement = connection.prepareStatement("select * from kunde where cpr = ?");
			statement.setLong(0, cprNr);
			rs = statement.executeQuery();
			if(rs.next()){
				kunde = new Kunde(rs.getString("navn"), cprNr);
			}
			else{
				throw new KundenFindesIkkeException();
			}
		
		}	
		catch(SQLException e){
			e.printStackTrace();
		}
		return kunde;
	}
}
