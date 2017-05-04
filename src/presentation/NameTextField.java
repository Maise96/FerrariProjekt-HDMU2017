package presentation;

import javafx.scene.control.TextField;
import utill.InputKontrol;

class NameTextField extends TextField{
	public NameTextField(){
		this.setOnKeyReleased(k->{
			new InputKontrol().allowLetters(this);
		});
	}

}
