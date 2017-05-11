package presentationCreditPlan;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

class CreditAssesmentGrid extends GridPane{
Label interestRateLabel;
Label creditRatingLabel;
Label customerRateLabel;
String interestRate;
String creditRating;
String customerRate;
	CreditAssesmentGrid(String interestRate,String creditRating,String customerRate){
		this.interestRate = interestRate;
		this.creditRating = creditRating;
		this.customerRate = customerRate;
		
		
		interestRateLabel = new Label(interestRate);
		creditRatingLabel = new Label(creditRating);
		customerRateLabel = new Label(customerRate);
		
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
		interestRateLabel.setText(interestRate);
		creditRatingLabel.setText(creditRating);
		customerRateLabel.setText(customerRate);
	}
}
