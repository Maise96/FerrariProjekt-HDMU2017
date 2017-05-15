package domain;

import java.math.BigDecimal;
import java.sql.Date;

public class Loan {
	BigDecimal amount;
	int interestRate;
	int customerID;
	int salesmanID;
	Date estimatedEndDate;
	
	public Loan(BigDecimal amount, int interestRate, int customerID, int salesmanID, Date estimatedEndDate) {
		this.amount = amount;
		this.interestRate = interestRate;
		this.customerID = customerID;
		this.salesmanID = salesmanID;
		this.estimatedEndDate = estimatedEndDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public int getInterestRate() {
		return interestRate;
	}

	public int getCustomerID() {
		return customerID;
	}

	public int getSalesmanID() {
		return salesmanID;
	}

	public Date getEstimatedEndDate() {
		return estimatedEndDate;
	}
}
