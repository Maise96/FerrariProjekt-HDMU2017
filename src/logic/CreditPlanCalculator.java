package logic;

import java.math.BigDecimal;

import domain.CreditPlan;
import domain.Payment;

public class CreditPlanCalculator {
	
	public CreditPlan calculateNewCreditPlan(BigDecimal amount, BigDecimal downPayment, double customerRate){
		BigDecimal BDCustomerRate = BigDecimal.valueOf(customerRate)
				.divide(BigDecimal.valueOf(100),3).add(BigDecimal.valueOf(1));
		CreditPlan creditPlan = new CreditPlan();
		BigDecimal remaining = amount;
		BigDecimal nextPayment = nextPayment(remaining,downPayment,BDCustomerRate);
		do{
			nextPayment = nextPayment(remaining,downPayment,BDCustomerRate);
			remaining = remaining.subtract(nextPayment).add(interest(remaining,BDCustomerRate));
			
			nextPayment = nextPayment.setScale(3,BigDecimal.ROUND_HALF_EVEN);
			remaining = remaining.setScale(3, BigDecimal.ROUND_HALF_EVEN);
			
			creditPlan.add(new Payment(nextPayment.doubleValue(), remaining.doubleValue() ));
			
		}
		while(remaining.subtract(nextPayment).compareTo(BigDecimal.valueOf(0)) == 1);
		creditPlan.add(new Payment(remaining.doubleValue(),0));
		return creditPlan;
	}
	BigDecimal nextPayment(BigDecimal currentAmount,BigDecimal downPayment, BigDecimal customerRate){
		
		return interest(currentAmount,customerRate).add(downPayment);
	}
	BigDecimal interest(BigDecimal currentAmount,BigDecimal customerRate){
				//yearly													//Recalculated to monthly
		return (currentAmount.multiply(customerRate).subtract(currentAmount)).divide(BigDecimal.valueOf(12),BigDecimal.ROUND_HALF_EVEN);
	}
	
}
