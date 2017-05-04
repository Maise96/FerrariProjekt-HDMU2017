package domain;

public class Customer {
private long cprNr;
private String name;
	public Customer(String navn, long cprNr){
		this.name = navn;
		this.cprNr = cprNr;
	}
	public String getNavn(){
		return name;
	}
	public long getCprNr(){
		return cprNr;
	}
	@Override
	public String toString(){
		return name + " " + cprNr;
	}
}
