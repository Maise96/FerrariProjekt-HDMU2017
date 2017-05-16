package domain;


public class Customer {
private String cprNr;
private String name;
private Boolean trouble;

	public Customer(String navn, String cprNr, Boolean trouble){
		this.name = navn;
		this.cprNr = cprNr;
		this.trouble = false;
	}
	
	public String getName(){
		return name;
	}
	
	public String getCprNr(){
		return cprNr;
	}
	
	public Boolean getTrouble() {
		return trouble;
	}
	
	@Override
	public String toString(){
		return name + " " + cprNr;
	}




	
}
