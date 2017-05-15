package presentationCreditPlan;

import java.math.BigDecimal;

import domain.BankRate;
import javafx.scene.control.TextField;
import logic.InformationExpert;

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
		if (!this.amount.getText().isEmpty())
			amount = Double.parseDouble(this.amount.getText());

		if (!this.downPayment.getText().isEmpty())
			downPayment = Double.parseDouble(this.downPayment.getText());

		if (amount / 2 >= downPayment && !ekstraProcent) {
			ekstraProcent = true;
			double currentCustomerRate = Double.parseDouble(grid.getCustomerRate());
			grid.setCustomerRate(Double.toString(currentCustomerRate + 1));
		} else if (amount / 2 <= downPayment && ekstraProcent) {
			ekstraProcent = false;
			double currentCustomerRate = Double.parseDouble(grid.getCustomerRate());
			grid.setCustomerRate(Double.toString(currentCustomerRate - 1));
		}
		if (Double.parseDouble(grid.getInterestRate()) != BankRate.rate) {
			grid.setInterestRate(Double.toString(BankRate.rate));
			grid.setCustomerRate(Double.toString(amount += BankRate.rate));
		}
		grid.update();
		if(downPayment!=0) // laver en ny creditPlan og updatere overview
		creditPlanStage.setOverview(
				overview.update(new InformationExpert().newCreditPlan(BigDecimal.valueOf(amount),
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
