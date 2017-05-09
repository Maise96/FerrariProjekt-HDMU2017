package logic;

import domain.Customer;

public class DomainFactory {
	Customer newCustomer(String navn,long cpr){
		Customer c = new Customer(navn,cpr);
		//TODO: tilskriv kunden en kreditVurdering
		return c;
	}
}
