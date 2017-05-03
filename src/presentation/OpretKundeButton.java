package presentation;

import database.DataBaseFacade;
import domain.Kunde;
import javafx.scene.control.Button;
import utill.KundeTableRefresh;

public class OpretKundeButton extends Button {
NavnTextField navn;
CprTextField cprNr;
	public OpretKundeButton(NavnTextField navn, CprTextField cprNr){
		this.setText("Opret Kunde");
		this.setPrefSize(125,75);
		this.navn = navn;
		this.cprNr = cprNr;
		this.setDisable(true);
		this.setOnMouseClicked(e->{
			new DataBaseFacade().indsætKunde(new Kunde(navn.getText(),Long.parseLong(cprNr.getText())));
			new KundeTableRefresh().Refresh();
		});
	}
	
}
