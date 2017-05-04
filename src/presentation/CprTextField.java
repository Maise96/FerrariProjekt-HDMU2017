package presentation;

import javafx.scene.control.TextField;
import utill.InputKontrol;

class CprTextField extends TextField {
	
	public CprTextField(OpretKundeObserver op){
		op.tilmeldTextField(this);
		this.setOnKeyReleased(k->{
			new InputKontrol().tilladTal(this);
			op.check();
		});
	}

}
