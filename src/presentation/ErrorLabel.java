package presentation;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

class ErrorLabel extends Label{
	public ErrorLabel(String s){
		this.setText(s);
		this.setTextFill(Color.FIREBRICK);
		this.setWrapText(true);
	}
}
