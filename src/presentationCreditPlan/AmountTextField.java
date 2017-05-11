package presentationCreditPlan;

import javafx.scene.control.TextField;
import utill.InputKontrol;

class AmountTextField extends TextField {

	AmountTextField(CreditPlanObserver obs){	
		this.setOnKeyReleased(k->{
			new InputKontrol().allowNumbers(this);
			obs.update();
		});
	}

}
