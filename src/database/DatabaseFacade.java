package database;

import java.sql.SQLException;

import Exceptions.KundenFindesIkkeException;
import domain.Kunde;

public class DatabaseFacade {

	public void indsætKunde(Kunde kunde) {
		try {
			new IndsætKunde().execute(kunde);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Kunde hentKunde(long cprNr) throws NullPointerException{
		try {
			return new HentKunde().execute(cprNr);
		} catch (KundenFindesIkkeException e) {
			throw new NullPointerException();
			//Håndteres med den nullpointerException som der bliver kastet
		}
	}
}
