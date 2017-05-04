package presentation;

import java.sql.SQLException;

import Exceptions.IllegalCprException;
import Exceptions.IllegalNameException;
import database.DataBaseFacade;
import domain.Customer;
import javafx.scene.control.Button;

class NewCustomerButton extends Button {
	NameTextField name;
	CprTextField cprNr;

	public NewCustomerButton(NameTextField name, CprTextField cprNr) {
		this.setText("Save Customer");
		this.setPrefSize(125, 75);
		this.name = name;
		this.cprNr = cprNr;
		this.setDisable(true);
		this.setOnMouseClicked(e -> {
			try{
				indsætKundeIDB(name,cprNr);
			}
			catch(IllegalNameException e1){
				new ErrorMessage("name can't be empty");
			}
			catch(IllegalCprException e2){
				new ErrorMessage("Illegal Cpr");
			}
			CustomerTableRefresh.refresh();
		});
	}

	public void indsætKundeIDB(NameTextField navn, CprTextField cprNr)
			throws IllegalNameException, IllegalCprException {
		
		if (navn.getText().isEmpty()) {
			throw new IllegalNameException();
		}

		try {
			new DataBaseFacade().indsætKunde(new Customer(navn.getText(), Long.parseLong(cprNr.getText())));
		} catch (SQLException e1) {
			new ErrorMessage("Connection to database failed");
		} catch (NumberFormatException e) {
			throw new IllegalCprException();
		}
	}

}
