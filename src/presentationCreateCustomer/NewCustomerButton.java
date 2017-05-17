package presentationCreateCustomer;

import java.sql.SQLException;

import exceptions.CustomerAlreadyExistException;
import exceptions.ErrorMessage;
import exceptions.IllegalCprException;
import exceptions.IllegalNameException;
import javafx.scene.control.Button;
import logic.InformationController;

class NewCustomerButton extends Button {
	NameTextField name;
	CprTextField cprNr;

	public NewCustomerButton(NameTextField name, CprTextField cprNr, NewCustomerObserver observer) {
		this.setText("Save Customer");
		this.setPrefSize(125, 75);
		this.name = name;
		this.cprNr = cprNr;
		this.setDisable(true);
		observer.assignButton(this);
		this.setOnMouseClicked(e -> {
			insetCustomerIntoDB(name, cprNr);
			observer.check();
		});

	}

	public void insetCustomerIntoDB(NameTextField navn, CprTextField cprNr) {
		try {
			new InformationController().newCustomer(name.getText(), cprNr.getText());
		} catch (IllegalNameException e1) {
			new ErrorMessage("illegal name");
		} catch (IllegalCprException e2) {
			new ErrorMessage("Illegal Cpr");
		} catch (SQLException e1) {
			new ErrorMessage("Connection to database failed");
		}
		catch(CustomerAlreadyExistException e){
			new ErrorMessage("customer already exist");
			
		}

	}

}
