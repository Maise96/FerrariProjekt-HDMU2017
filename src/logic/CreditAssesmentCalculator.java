package logic;

import com.ferrari.finances.dk.rki.CreditRator;
import com.ferrari.finances.dk.rki.Rating;

import domain.BankRate;
import domain.CreditAssesment;
import domain.Customer;
import exceptions.BadCustomerException;

class CreditAssesmentCalculator {
	CreditAssesment newCreditAssesment(Customer customer,CreditAssesment creditAssesment)/*throws BadCustomerException*/{
		CreditRatorThread ratingThread = new CreditRatorThread();
		ratingThread.setCreditAssesment(creditAssesment);
		ratingThread.setCustomer(customer);
		ratingThread.start();
		double customerRate = BankRate.rate;
		switch(CreditRator.i().rate(customer.getCprNr())){
		case A:
			creditAssesment.setCreditRating(Rating.A);
			customerRate +=1;
			break;
		case B:
			creditAssesment.setCreditRating(Rating.B);
			customerRate +=2;
			break;
		case C: 
			creditAssesment.setCreditRating(Rating.C);
			customerRate +=3;
			break;
		case D:
			creditAssesment.setCreditRating(Rating.D);
			customerRate +=10000;
			/*	throw new BadCustomerException();*/
		}
		
		creditAssesment.setCustomerRate(customerRate);
		//Tilskrivningen af et ekstraProcentpoint sker i creditPlanObserver
		
		//TODO: hvis tilbagebetalingen er over 3år customerRate +=1
		
		return creditAssesment;
	}
}
