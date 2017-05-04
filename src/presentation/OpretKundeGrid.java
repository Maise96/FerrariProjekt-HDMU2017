package presentation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import threads.OpretKundeObserver;

public class OpretKundeGrid extends GridPane {
CprTextField cprNr;
NavnTextField navn;
OpretKundeButton opretKundeButton;
	public OpretKundeGrid(){
		navn = new NavnTextField();
		opretKundeButton = new OpretKundeButton(navn,cprNr);
		this.setAlignment(Pos.BASELINE_CENTER);
		this.setPadding(new Insets(20,20,20,20));
		OpretKundeObserver op = new OpretKundeObserver(opretKundeButton);
		cprNr = new CprTextField(op);
		this.add(new Label("KundeNavn"), 0, 0);
		this.add(navn, 1, 0);
		this.add(new Label("CprNr: "), 2, 0);
		this.add(cprNr, 3, 0);
		this.add(opretKundeButton, 4, 0);
		
	}
}
