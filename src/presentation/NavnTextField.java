package presentation;

import javafx.scene.control.TextField;
import utill.InputKontrol;

class NavnTextField extends TextField{
	public NavnTextField(){
		this.setOnKeyReleased(k->{
			new InputKontrol().tilladBogstaver(this);
		});
	}

}
