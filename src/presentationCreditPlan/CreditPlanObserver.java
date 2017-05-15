package presentationCreditPlan;

import domain.BankRate;
import javafx.scene.control.TextField;

class CreditPlanObserver {
	TextField amount;
	TextField downPayment;
	CreditPlanOverview overview;
	CreditAssesmentGrid grid;
	boolean ekstraProcent = false;

	void update() { //håndtere hvis der skal ligges 1% procent til kundens rente.
		double amount = 0;
		double downPayment = 0;
		if (!this.amount.getText().isEmpty())
			amount = Double.parseDouble(this.amount.getText());

		if (!this.downPayment.getText().isEmpty())
			downPayment = Double.parseDouble(this.downPayment.getText());
		// overview.update();
		
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
			System.out.println("jeg er her");
			grid.setInterestRate(Double.toString(BankRate.rate));
			grid.setCustomerRate(Double.toString(amount += BankRate.rate));
		}
		grid.update();

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
}
