package presentation;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class NavnTextField extends TextField{
	public NavnTextField(){
		this.setOnKeyReleased(k->{
			inputKontrol(k); // kontrollere at inputtet er et bogstav
		});
	}
	public void inputKontrol(KeyEvent k){
		String input = k.getCode().toString();
		
		if(erTal(input.substring(input.length()-1,input.length()))){
			this.setText(this.getText().substring(0,this.getText().length()-1));
			this.positionCaret(this.getText().length());
		}
	}
	private boolean erTal(String s){
		return "1234567890".contains(s);
	}
}
