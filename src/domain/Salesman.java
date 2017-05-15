package domain;

import java.math.BigDecimal;

public class Salesman {
	String name;
	BigDecimal LoanLimit;
	
	public Salesman(String name, BigDecimal LoanLimit){
		this.name = name;
		this.LoanLimit= LoanLimit;
	}
	
	public String getName() {
		return name;
	}
	
	public BigDecimal getLoanLimit() {
		return LoanLimit;
	}
}
