package presentationCreditPlan;

import com.ferrari.finances.dk.rki.CreditRator;

import domain.CreditAssesment;
import domain.Customer;
import logic.InformationController;
import threads.Sleeper;

public class CreditAssesmentThread extends Thread{
CreditAssesment creditAssesment;
Customer customer;
CreditAssesmentGrid grid;
	public CreditAssesmentThread(CreditAssesmentGrid grid){
		creditAssesment = new CreditAssesment();
		this.grid = grid;
	}
	public void run(){
		grid.setCreditRating("waiting for rki");
		grid.setCreditRating(CreditRator.i().rate(customer.getCprNr()).toString());
	}
	public void setCustomer(Customer customer){
		this.customer = customer;
	}
	CreditAssesment getCreditAssesment(){
		return creditAssesment;
	}

}
