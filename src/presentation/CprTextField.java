package presentation;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class CprTextField extends TextField {
	
	public CprTextField(){
		this.setOnKeyReleased(k->{
			inputKontrol(k); //kontrollere at inputtet er et tal
			
		});
	}
	private void inputKontrol(KeyEvent k){
		String input = k.getCode().toString();
		if(erBogstav(input)){
			this.setText(this.getText().substring(0,this.getText().length()-1));
			this.positionCaret(this.getText().length());
		}
	}
	private boolean erBogstav(String s){
		return "abcdefghijklmopqrstuvxyzæøå".toUpperCase().contains(s);
	}

}
