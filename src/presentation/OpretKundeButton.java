package presentation;

import java.sql.SQLException;

import Exceptions.IllegalCprException;
import Exceptions.IllegalNavnException;
import database.DataBaseFacade;
import domain.Kunde;
import javafx.scene.control.Button;

class OpretKundeButton extends Button {
	NavnTextField navn;
	CprTextField cprNr;

	public OpretKundeButton(NavnTextField navn, CprTextField cprNr) {
		this.setText("Opret Kunde");
		this.setPrefSize(125, 75);
		this.navn = navn;
		this.cprNr = cprNr;
		this.setDisable(true);
		this.setOnMouseClicked(e -> {
			try{
				indsætKundeIDB(navn,cprNr);
			}
			catch(IllegalNavnException e1){
				new ErrorMessage("name can't be empty");
			}
			catch(IllegalCprException e2){
				new ErrorMessage("Illegal Cpr");
			}
			KundeTableRefresh.refresh();
		});
	}

	public void indsætKundeIDB(NavnTextField navn, CprTextField cprNr)
			throws IllegalNavnException, IllegalCprException {
		
		if (navn.getText().isEmpty()) {
			throw new IllegalNavnException();
		}

		try {
			new DataBaseFacade().indsætKunde(new Kunde(navn.getText(), Long.parseLong(cprNr.getText())));
		} catch (SQLException e1) {
			new ErrorMessage("Connection to database failed");
		} catch (NumberFormatException e) {
			throw new IllegalCprException();
		}
	}

}
