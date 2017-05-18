package presentationCreditPlan;

import domain.BankRate;
import domain.CreditAssesment;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

class CreditAssesmentGrid extends GridPane {
	private Label interestRateLabel;
	private Label creditRatingLabel;
	private Label customerRateLabel;
	private String interestRate;
	private String creditRating;
	private String customerRate;
	private CreditAssesment creditAssesment;
	CreditPlanObserver obs;

	CreditAssesmentGrid() {
		
		interestRate = Double.toString(BankRate.rate);
		creditRating = "waiting for rki";
		customerRate = interestRate;
		
		interestRateLabel = new Label("bank rate : " + BankRate.rate);
		creditRatingLabel = new Label("credit rating : " + creditRating);
		customerRateLabel = new Label("customer rate : " +BankRate.rate);

		this.add(interestRateLabel, 0, 0);
		this.add(creditRatingLabel, 0, 1);
		this.add(customerRateLabel, 0, 2);

		update();
	}

	String getInterestRate() {
		return interestRate;
	}

	void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}

	String getCreditRating() {
		return creditRating;
	}

	void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}

	String getCustomerRate() {
		return customerRate;
	}

	void setCustomerRate(String customerRate) {
		this.customerRate = customerRate;
	}

	void update() {
		interestRateLabel.setText("bank rate : " + format(interestRate));
		creditRatingLabel.setText("credit rating : " + creditRating);
		customerRateLabel.setText("customer rate : " + format(customerRate));
	}
	void newCreditAssesment(CreditAssesment assesment){
		this.interestRate = Double.toString(assesment.getInterestRate());
		this.creditRating = assesment.getCreditRating().toString();
		this.customerRate = Double.toString(assesment.getCustomerRate());
		update();
	}
	void setObserver(CreditPlanObserver obs) {
		this.obs = obs;
		obs.tilmeldCreditAssesmentGrid(this);
	}

	private String format(String s) {
		int antalDecimaler = (s.indexOf(".") - s.length()) * -1;
		if (antalDecimaler > 3)
			return s.substring(0, s.indexOf(".") + 3);
		else
			return s;
	}
	void setCreditAssesment(CreditAssesment assesment){
		this.creditAssesment = assesment;
		newCreditAssesment(assesment);
	}
}
