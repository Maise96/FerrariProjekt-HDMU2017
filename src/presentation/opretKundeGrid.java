package presentation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public class opretKundeGrid extends GridPane {
	public opretKundeGrid(){
		this.setAlignment(Pos.BASELINE_CENTER);
		this.setPadding(new Insets(20,20,20,20));
		this.add(new NavnTextField(), 0, 0);
		this.add(new CprTextField(), 1, 0);
		this.add(new OpretKundeButton(), 2, 0);
	}
}
