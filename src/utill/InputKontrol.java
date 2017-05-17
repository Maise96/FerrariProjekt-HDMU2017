package utill;

import javafx.scene.control.TextField;

public class InputKontrol {
	private boolean erTal(String s) {
		return "1234567890".contains(s);
	}

	private boolean erBogstav(String s) {
		return "abcdefghijklmnopqrstuvxyzæøå ".toUpperCase().contains(s) || "abcdefghijklmnopqrstuvxyzæøå".contains(s);
	}

	private void updateTextField(TextField tekst, String s) {
		tekst.setText(s);
		tekst.positionCaret(s.length());
	}

	public void allowLetters(TextField text) {
		String s = text.getText();
		for (int i = 0; i < s.length(); i++) {
			String checkLetter = s.substring(i, i + 1);
			if (!erBogstav(checkLetter)) {
				s = s.substring(0, i) + s.substring(i + 1, s.length());
				updateTextField(text, s);
				i = 0;
			}
		}
		if (s.length() == 1 && !erBogstav(s)) {
			s = "";
			updateTextField(text, s);
		}
	}

	public void allowNumbers(TextField text) {
		String s = text.getText();
		for (int i = 0; i < s.length(); i++) {
			String checkLetter = s.substring(i, i + 1);
			if (!erTal(checkLetter)) {
				s = s.substring(0, i) + s.substring(i + 1, s.length());
				updateTextField(text, s);
				i = 0;
			}
		}
		if (s.length() == 1 && !erTal(s)) {
			s = "";
			updateTextField(text, s);
		}
	}
	public boolean illegalName(String text){
		for (int i = 0; i < text.length(); i++) {
			String checkLetter = text.substring(i, i + 1);
			if (!erBogstav(checkLetter)) {
				return true;
			}
		}
		return false;
	}
}
