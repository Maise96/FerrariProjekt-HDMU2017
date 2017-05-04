package presentation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

class CreateCustomerGrid extends GridPane {
CprTextField cprNr;
NameTextField name;
NewCustomerButton createCustomerButton;
	public CreateCustomerGrid(){
		name = new NameTextField();
		createCustomerButton = new NewCustomerButton(name,cprNr);
		this.setAlignment(Pos.BASELINE_CENTER);
		this.setPadding(new Insets(20,20,20,20));
		NewCustomerObserver op = new NewCustomerObserver(createCustomerButton);
		cprNr = new CprTextField(op);
		this.add(new Label("KundeNavn"), 0, 0);
		this.add(name, 1, 0);
		this.add(new Label("CprNr: "), 2, 0);
		this.add(cprNr, 3, 0);
		this.add(createCustomerButton, 4, 0);
		
	}
}
