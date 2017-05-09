package presentationCreateCustomer;

import javafx.scene.control.TextField;
import utill.InputKontrol;

class CprTextField extends TextField {
	
	public CprTextField(NewCustomerObserver op){
		op.observeTextField(this);
		this.setOnKeyReleased(k->{
			new InputKontrol().allowNumbers(this);
			op.check();
		});
	}

}
