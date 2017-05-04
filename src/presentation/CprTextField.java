package presentation;

import javafx.scene.control.TextField;
import threads.OpretKundeObserver;
import utill.InputKontrol;

public class CprTextField extends TextField {
	
	public CprTextField(OpretKundeObserver op){
		op.tilmeldTextField(this);
		this.setOnKeyReleased(k->{
			new InputKontrol().tilladTal(this);
			op.check();
		});
	}

}
