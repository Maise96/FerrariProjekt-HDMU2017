package presentationCreateCustomer;

import java.sql.SQLException;

import logic.InformationController;

public class NewCustomerObserver {
	CprTextField cprNr;
	NameTextField name;
	NewCustomerButton newCustomerButton;
	SearchCustomerThread searchCustomerThread;
	public NewCustomerObserver(){
		searchCustomerThread = new SearchCustomerThread();
		searchCustomerThread.start();
	}
	void check() {
		if (cprNr != null && newCustomerButton != null) {
			if (cprNr.getText().length() == 10) {
				newCustomerButton.setDisable(false);
			} else {
				newCustomerButton.setDisable(true);
			}
			searchCustomerThread.setSearchName(name.getText());
			searchCustomerThread.setCpr(cprNr.getText());
			searchCustomerThread.wakeUp();
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
