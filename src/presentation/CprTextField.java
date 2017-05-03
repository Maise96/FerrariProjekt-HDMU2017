package presentation;

import javafx.scene.control.TextField;

public class CprTextField extends TextField {
	
	public CprTextField(){
		this.setOnKeyReleased(k->{
			new InputKontrol().tilladTal(this);
		});
	}

}
