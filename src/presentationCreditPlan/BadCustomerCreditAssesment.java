package presentationCreditPlan;

import com.ferrari.finances.dk.rki.Rating;

import domain.BankRate;
import domain.CreditAssesment;

public class BadCustomerCreditAssesment extends CreditAssesment{

	BadCustomerCreditAssesment() {
		this.setCreditRating(Rating.D);
		this.setCustomerRate(100000);
		this.setInterestRate(BankRate.rate);
	}

}
