package logic;

import domain.Customer;

public class DomainFactory {
	Customer newCustomer(String navn,String cpr){
		Customer c = new Customer(navn,cpr);
		return c;
	}
}
