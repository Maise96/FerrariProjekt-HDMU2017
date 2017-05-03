package presentation;

import javafx.scene.control.TextField;

public class NavnTextField extends TextField{
	public NavnTextField(){
		this.setOnKeyReleased(k->{
			new InputKontrol().tilladBogstaver(this);
		});
	}

}
