package threads;

import presentation.CprTextField;
import presentation.OpretKundeButton;

public class OpretKundeObserver extends Thread{
CprTextField cprNr;
OpretKundeButton opretKundeButton;
	public OpretKundeObserver(CprTextField cprNr, OpretKundeButton opretKundeButton){
		this.cprNr = cprNr;
		this.opretKundeButton = opretKundeButton;
	}

	@Override
	public void run() {
		while(true){
			if(cprNr.getText().length()==10){
				opretKundeButton.setDisable(false);
			} else {
				opretKundeButton.setDisable(true);
				Sleeper.nap();
			}
		}
	}
}
