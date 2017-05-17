package presentationCreditPlan;

import java.math.BigDecimal;

import domain.BankRate;
import javafx.scene.control.TextField;
import logic.InformationController;

class CreditPlanObserver {
	TextField amount;
	TextField downPayment;
	CreditPlanOverview overview;
	CreditAssesmentGrid grid;
	CreditPlanStage creditPlanStage;
	boolean ekstraProcent = false;

	void update() { // håndtere hvis der skal ligges 1% procent til kundens
					// rente.
		double amount = 0;
		double downPayment = 0;
		double newCustomerRate = Double.parseDouble(grid.getCustomerRate());
		if (!this.amount.getText().isEmpty())
			amount = Double.parseDouble(this.amount.getText());

		if (!this.downPayment.getText().isEmpty())
			downPayment = Double.parseDouble(this.downPayment.getText());

		if (amount / 2 >= downPayment && !ekstraProcent) {
			ekstraProcent = true;
			newCustomerRate++;
		} else if (amount / 2 <= downPayment && ekstraProcent) {
			ekstraProcent = false;
			newCustomerRate--;
		}
		
		grid.setCustomerRate(Double.toString(newCustomerRate));
		grid.update();
		if(downPayment!=0) // laver en ny creditPlan og updatere overview
		creditPlanStage.setOverview(
				overview.update(new InformationController().newCreditPlan(BigDecimal.valueOf(amount),
						BigDecimal.valueOf(downPayment), Double.parseDouble(grid.getCustomerRate()))));
	}

	void assignAmountTextField(TextField amount) {
		this.amount = amount;
	}

	void assigndownPaymentTextField(TextField downPayment) {
		this.downPayment = downPayment;
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
