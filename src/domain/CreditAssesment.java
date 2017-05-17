package domain;

import com.ferrari.finances.dk.rki.Rating;

public class CreditAssesment {
	double customerRate;
	double interestRate;
	Rating creditRating;

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public void setCreditRating(Rating creditRating) {
		this.creditRating = creditRating;
	}

	public void setCustomerRate(double customerRate) {
		this.customerRate = customerRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public double getCustomerRate() {
		return customerRate;
	}

	public Rating getCreditRating() {
		return creditRating;
	}

}
