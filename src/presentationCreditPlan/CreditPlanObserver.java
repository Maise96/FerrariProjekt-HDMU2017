package presentationCreditPlan;

import java.math.BigDecimal;

import domain.CreditPlan;
import javafx.scene.control.TextField;
import logic.InformationController;

class CreditPlanObserver {
	TextField amountTextField;
	TextField downPaymentTextField;
	CreditPlanOverview overview;
	CreditAssesmentGrid grid;
	CreditPlanStage creditPlanStage;
	boolean ekstraProcent = false;
	boolean ekstraProcent2 = false;
	
	void update() { // håndtere hvis der skal ligges 1% procent til kundens
					// rente.
		double amount = 0;
		double downPayment = 0;
		double newCustomerRate = Double.parseDouble(grid.getCustomerRate());
		if (!this.amountTextField.getText().isEmpty())
			amount = Double.parseDouble(this.amountTextField.getText());

		if (!this.downPaymentTextField.getText().isEmpty())
			downPayment = Double.parseDouble(this.downPaymentTextField.getText());

		if (amount / 2 >= downPayment && !ekstraProcent) {
			ekstraProcent = true;
			newCustomerRate++;
		} else if (amount / 2 <= downPayment && ekstraProcent) {
			ekstraProcent = false;
			newCustomerRate--;
		}
		
		
		
		if(downPayment!=0){ // laver en ny creditPlan og updatere overview
			CreditPlan creditPlan = new InformationController().newCreditPlan(BigDecimal.valueOf(amount),
					BigDecimal.valueOf(downPayment), Double.parseDouble(grid.getCustomerRate()));
			if(creditPlan.size()>=36 && !ekstraProcent2){
				ekstraProcent2 = true;
				newCustomerRate++;
			}else if (creditPlan.size()<36 && ekstraProcent2){
				ekstraProcent2 = false;
				newCustomerRate--;
			}
			creditPlanStage.setOverview(
				overview.update(creditPlan));
		}
		grid.setCustomerRate(Double.toString(newCustomerRate));
		grid.update();
	}
	
	void assignAmountTextField(TextField amount) {
		this.amountTextField = amount;
	}

	void assigndownPaymentTextField(TextField downPayment) {
		this.downPaymentTextField = downPayment;
	}

	void assignOverView(CreditPlanOverview overview) {
		this.overview = overview;
	}

	void tilmeldCreditAssesmentGrid(CreditAssesmentGrid grid) {
		this.grid = grid;
	}

	void assignStage(CreditPlanStage creditPlanStage) {
		this.creditPlanStage = creditPlanStage;
	}
}
