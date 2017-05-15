package domain;


public class Customer {
private String cprNr;
private String name;
	public Customer(String navn, String cprNr){
		this.name = navn;
		this.cprNr = cprNr;
	}
	public String getName(){
		return name;
	}
	public String getCprNr(){
		return cprNr;
	}
	
	@Override
	public String toString(){
		return name + " " + cprNr;
	}
	
}
