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

	public void tilladBogstaver(TextField tekst) {
		String s = tekst.getText();
		for (int i = 0; i < s.length(); i++) {
			String kontrolOmråde = s.substring(i, i + 1);
			if (!erBogstav(kontrolOmråde)) {
				s = s.substring(0, i) + s.substring(i + 1, s.length());
				updateTextField(tekst, s);
				i = 0;
			}
		}
		if (s.length() == 1 && !erBogstav(s)) {
			s = "";
			updateTextField(tekst, s);
		}
	}

	public void tilladTal(TextField tekst) {
		String s = tekst.getText();
		for (int i = 0; i < s.length(); i++) {
			String kontrolOmråde = s.substring(i, i + 1);
			if (!erTal(kontrolOmråde)) {
				s = s.substring(0, i) + s.substring(i + 1, s.length());
				updateTextField(tekst, s);
				i = 0;
			}
		}
		if (s.length() == 1 && !erTal(s)) {
			s = "";
			updateTextField(tekst, s);
		}
	}
}
