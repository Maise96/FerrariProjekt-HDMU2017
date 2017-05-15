package presentationCreateCustomer;

import java.sql.SQLException;

import exceptions.ErrorMessage;
import exceptions.IllegalCprException;
import exceptions.IllegalNameException;
import javafx.scene.control.Button;
import logic.InformationExpert;

class NewCustomerButton extends Button {
	NameTextField name;
	CprTextField cprNr;

	public NewCustomerButton(NameTextField name, CprTextField cprNr,NewCustomerObserver observer) {
		this.setText("Save Customer");
		this.setPrefSize(125, 75);
		this.name = name;
		this.cprNr = cprNr;
		this.setDisable(true);
		observer.assignButton(this);
		this.setOnMouseClicked(e -> {
			try{
				new InformationExpert().newCustomer(name.getText(), cprNr.getText() );
				}
			catch(IllegalNameException e1){
				new ErrorMessage("name can't be empty");
			}
			catch(IllegalCprException e2){
				new ErrorMessage("Illegal Cpr");
			}
			catch (SQLException e1) {
				new ErrorMessage("Connection to database failed");
			}
			observer.searchCustomerTable();
		});
		
	}

	public void insetCustomerIntoDB(NameTextField navn, CprTextField cprNr)
			throws IllegalNameException, IllegalCprException {
		
		if (navn.getText().isEmpty()) {
			throw new IllegalNameException();
		}

		try {
		}  catch (NumberFormatException e) {
			throw new IllegalCprException();
		}
	}

}
