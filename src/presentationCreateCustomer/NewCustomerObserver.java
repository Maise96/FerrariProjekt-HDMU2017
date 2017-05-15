package presentationCreateCustomer;

import java.sql.SQLException;

import exceptions.ErrorMessage;
import logic.InformationExpert;

public class NewCustomerObserver {
	CprTextField cprNr;
	NameTextField name;
	NewCustomerButton newCustomerButton;

	void check() {
		if (cprNr != null && newCustomerButton != null) {
			if (cprNr.getText().length() == 10) {
				newCustomerButton.setDisable(false);
			} else {
				newCustomerButton.setDisable(true);
			}
			searchCustomerTable();
			
		}
	}
	void searchCustomerTable(){
		try {
			CustomerTableRefresh.refresh(new InformationExpert().searchCustomers(name.getText(), cprNr.getText()));
		} catch (SQLException e) {
			new ErrorMessage("failed connection to the database");
		}
	}

	void observeTextField(CprTextField cprNr) {
		this.cprNr = cprNr;
	}
	void observeTextField(NameTextField name){
		this.name = name;
	}

	void assignButton(NewCustomerButton e) {
		this.newCustomerButton = e;
	}
}
