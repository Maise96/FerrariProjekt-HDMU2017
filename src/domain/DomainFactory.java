package domain;

public class DomainFactory {
	public Customer newCustomer(String navn,String cpr){
		Customer c = new Customer(navn,cpr,false);
		return c;
	}
}
