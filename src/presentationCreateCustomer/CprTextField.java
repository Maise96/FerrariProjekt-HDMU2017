package presentationCreateCustomer;

import javafx.scene.control.TextField;
import utill.InputKontrol;

class CprTextField extends TextField {
NewCustomerObserver obs;	
	public CprTextField(){
		this.setOnKeyReleased(k->{
			new InputKontrol().allowNumbers(this);
			obs.check();
		});
	}
	void assignObserver(NewCustomerObserver obs){
		this.obs = obs;
		obs.observeTextField(this);
	}

}
