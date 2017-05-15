package logic;

import com.ferrari.finances.dk.rki.CreditRator;
import com.ferrari.finances.dk.rki.Rating;

import domain.CreditAssesment;
import domain.Customer;

class CreditRatorThread extends Thread{
CreditAssesment creditAssesment;	
static Rating r;
Customer customer;
	public void run(){
		creditAssesment.setCreditRating(CreditRator.i().rate(customer.getCprNr()));
	}
	void setCustomer(Customer customer){
		this.customer = customer;
	}
	void setCreditAssesment(CreditAssesment creditAssesment){
		this.creditAssesment=creditAssesment;
	}

}
