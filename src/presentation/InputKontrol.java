package presentation;

import javafx.scene.control.TextField;

public class InputKontrol {
	private boolean erTal(String s){
		return "1234567890".contains(s);
	}
	private boolean erBogstav(String s){
		return "abcdefghijklmnopqrstuvxyzæøå ".toUpperCase().contains(s) || "abcdefghijklmnopqrstuvxyzæøå".contains(s);
	}
	public void tilladBogstaver(TextField tekst){
		String s = tekst.getText();
		for(int i = 0; i< s.length();i++){
			String kontrolOmråde = s.substring(i,i+1);
			if(!erBogstav(kontrolOmråde) || erTal(kontrolOmråde)){
				s = s.substring(0,i)+ s.substring(i+1,s.length());
				tekst.setText(s);
				tekst.positionCaret(s.length());
			
			}
		}
		
	}
	public void tilladTal(TextField tekst){
		String s = tekst.getText();
		for(int i = 0; i< s.length();i++){
			String kontrolOmråde = s.substring(i,i+1);
			if(erBogstav(kontrolOmråde) || !erTal(kontrolOmråde)){
				System.out.println(s.substring(0,i+1));
				s = s.substring(0,i)+ s.substring(i+1,s.length());
				i=0;
				tekst.setText(s);
				tekst.positionCaret(s.length());
			
			}
		}
		
	}
}
