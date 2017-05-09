package presentationCreditPlan;

import javafx.scene.control.TextField;

class CreditPlanObserver {
TextField amount;
TextField downPayment;
CreditPlanOverview overview;	

	void update(){
		try{
			
		}
		catch(NullPointerException n){
			
		}
	}

	void assignAmountTextField(TextField amount){
		this.amount = amount;
	}
	void assigndownPaymentTextField(TextField downPayment){
		this.downPayment = downPayment;
	}
	void assignOverView(CreditPlanOverview overview){
		this.overview = overview;
	}
}
