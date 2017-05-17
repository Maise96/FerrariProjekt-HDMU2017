package launch;

import logic.InformationController;
import presentationCreditPlan.CreditPlanStage;

class UpdateInterestRate extends Thread{
	public void run(){
		new InformationController().updateBankRate();
	}
}
