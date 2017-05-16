package launch;

import logic.InformationExpert;
import presentationCreditPlan.CreditPlanStage;

class UpdateInterestRate extends Thread{
	public void run(){
		new InformationExpert().updateBankRate();
		
	}
}
