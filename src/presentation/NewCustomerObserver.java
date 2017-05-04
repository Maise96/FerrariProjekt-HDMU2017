package presentation;

public class NewCustomerObserver {
	CprTextField cprNr;
	NewCustomerButton newCustomerButton;

	public NewCustomerObserver(NewCustomerButton opretKundeButton) {
		this.newCustomerButton = opretKundeButton;
	}

	public void check() {
		if (cprNr.getText().length() == 10) {
			newCustomerButton.setDisable(false);
		} else {
			newCustomerButton.setDisable(true);
		}
	}

	public void observeTextField(CprTextField cprNr) {
		this.cprNr = cprNr;

	}
}
