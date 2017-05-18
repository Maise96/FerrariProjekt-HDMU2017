package logic;

import com.ferrari.finances.dk.rki.CreditRator;
import com.ferrari.finances.dk.rki.Rating;

import domain.BankRate;
import domain.CreditAssesment;
import domain.Customer;
import exceptions.BadCustomerException;

class CreditAssesmentCalculator {
	CreditAssesment newCreditAssesment(Customer customer,CreditAssesment creditAssesment)/*throws BadCustomerException*/{
		double customerRate = BankRate.rate;
		switch(CreditRator.i().rate(customer.getCprNr())){
		case A:
			customerRate +=1;
			break;
		case B:
			customerRate +=2;
			break;
		case C: 
			customerRate +=3;
			break;
		case D:
			customerRate +=10000;
		}
		
		creditAssesment.setCustomerRate(customerRate);
		//Tilskrivningen af et ekstraProcentpoint sker i creditPlanObserver
		//TODO: hvis tilbagebetalingen er over 3år customerRate +=1
		
		return creditAssesment;
	}
}
