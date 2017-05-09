package presentationCreateCustomer;

public class NewCustomerObserver {
	CprTextField cprNr;
	NewCustomerButton newCustomerButton;

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
	public void assignButton(NewCustomerButton e){
		this.newCustomerButton = e;
	}
}
