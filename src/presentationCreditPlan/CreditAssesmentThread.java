package presentationCreditPlan;

import com.ferrari.finances.dk.rki.CreditRator;

import domain.BankRate;
import domain.CreditAssesment;
import domain.Customer;
import logic.InformationController;

public class CreditAssesmentThread extends Thread{
CreditAssesment creditAssesment;
Customer customer;
CreditAssesmentGrid grid;
	public CreditAssesmentThread(CreditAssesmentGrid grid,Customer customer){
		creditAssesment = new CreditAssesment();
		this.customer = customer;
		this.grid = grid;
	}
	public void run(){
		System.out.println("assesmentThread started");
		creditAssesment.setCreditRating(CreditRator.i().rate(customer.getCprNr()));
		creditAssesment.setInterestRate(BankRate.rate);
		creditAssesment.setCustomerRate(new InformationController().newCustomerRate(customer, creditAssesment));
		grid.setCreditAssesment(creditAssesment);
		System.out.println("done");
	}

}
