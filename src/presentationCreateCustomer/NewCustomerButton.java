package presentationCreateCustomer;

import java.sql.SQLException;

import Exceptions.ErrorMessage;
import Exceptions.IllegalCprException;
import Exceptions.IllegalNameException;
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
		this.setOnMouseClicked(e -> {
			try{
				System.out.println(name);
				System.out.println(cprNr);
				new InformationExpert().newCustomer(name.getText(), Long.parseLong(cprNr.getText()) );
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
			CustomerTableRefresh.refresh();
		});
		observer.assignButton(this);
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
