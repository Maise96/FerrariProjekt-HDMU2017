package presentationCreditPlan;

import domain.BankRate;
import domain.CreditAssesment;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

class CreditAssesmentGrid extends GridPane{
private Label interestRateLabel;
private Label creditRatingLabel;
private Label customerRateLabel;
private String interestRate;
private String creditRating;
private String customerRate;
CreditPlanObserver obs;
	CreditAssesmentGrid(CreditAssesment creditAssesment){
		
		interestRate = Double.toString(creditAssesment.getInterestRate());
		creditRating = creditAssesment.getCreditRating().toString();
		customerRate = Double.toString(creditAssesment.getCustomerRate());
		
		interestRateLabel = new Label("bank rate : " + interestRate);
		creditRatingLabel = new Label("credit rating : " + creditRating);
		customerRateLabel = new Label("customer rate : " + customerRate);
		
		this.add(interestRateLabel,0,0);
		this.add(creditRatingLabel, 0, 1);
		this.add(customerRateLabel, 0, 2);
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
	void update(){
		interestRateLabel.setText("bank rate : " + interestRate.substring(0, 4));
		creditRatingLabel.setText("credit rating : " + creditRating);
		customerRateLabel.setText("customer rate : " + customerRate.substring(0, 4));
	}
	void setObserver(CreditPlanObserver obs){
		this.obs = obs;
		obs.tilmeldCreditAssesmentGrid(this);
	}
}
