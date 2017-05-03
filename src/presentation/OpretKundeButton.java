package presentation;

import javafx.scene.control.Button;

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
			//TODO:indsæt i database
		});
		
	}
	
}
