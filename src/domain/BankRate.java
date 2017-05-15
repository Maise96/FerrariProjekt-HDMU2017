package domain;

import com.ferrari.finances.dk.bank.*;

public class BankRate {
	public static double rate;
	
	public void update() {
		rate = InterestRate.i().todaysRate();
	}

}
