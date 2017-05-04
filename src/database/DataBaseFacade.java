package database;

import java.sql.SQLException;
import java.util.List;

import Exceptions.KundenFindesIkkeException;
import domain.Kunde;

public class DataBaseFacade {

	public void indsætKunde(Kunde kunde) throws SQLException{
			new IndsætKunde().execute(kunde);
	
	}

	public Kunde hentKunde(long cprNr) throws NullPointerException{
		try {
			return new HentKunde().execute(cprNr);
		} catch (KundenFindesIkkeException e) {
			throw new NullPointerException();
			//Håndteres med den nullpointerException som der bliver kastet
		}
	}
	public List<Kunde> hentAlleKunder() throws SQLException{
		return new HentAlleKunder().execute();
	}
	public List<Kunde> søgKunder(String søgeOrd){
		return new SøgKunder().execute(søgeOrd);
	}
}
