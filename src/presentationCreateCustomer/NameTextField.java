package presentationCreateCustomer;

import javafx.scene.control.TextField;
import utill.InputKontrol;

class NameTextField extends TextField{
NewCustomerObserver obs;	
	NameTextField(){
		this.setOnKeyReleased(k->{
			new InputKontrol().allowLetters(this);
			obs.check();
		});
	}
	void assignObserver(NewCustomerObserver obs){
		this.obs = obs;
		obs.observeTextField(this);
	}
}
