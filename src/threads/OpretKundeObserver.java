package threads;

import presentation.CprTextField;
import presentation.OpretKundeButton;

public class OpretKundeObserver {
	CprTextField cprNr;
	OpretKundeButton opretKundeButton;

	public OpretKundeObserver(OpretKundeButton opretKundeButton) {
		this.opretKundeButton = opretKundeButton;
	}

	public void check() {
		if (cprNr.getText().length() == 10) {
			opretKundeButton.setDisable(false);
		} else {
			opretKundeButton.setDisable(true);
		}
	}

	public void tilmeldTextField(CprTextField cprNr) {
		this.cprNr = cprNr;

	}
}
