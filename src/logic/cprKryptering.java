package logic;

import java.math.BigDecimal;

import presentation.ErrorMessage;

public class cprKryptering {
	long cprNr;
	BigDecimal nøgle = new BigDecimal("120356148756120397845661032487561092743");

	public BigDecimal krypter(BigDecimal cprNr) {
		BigDecimal krypteretCprNr;


		krypteretCprNr = nøgle.multiply(cprNr);
		String utillString = krypteretCprNr.toString();
		String utillString2 = "";
		for(int i = 0; i<utillString.length();i++){
				switch(utillString.substring(i, i+1)){
				case "1": {utillString2 += "E";break;}
				case "2": {utillString2 += "T"; break;}
				case "3": {utillString2 += "Tr"; break;}
				case "4": {utillString2 += "Fi"; break;}
				case "5": {utillString2 += "Fe"; break;}
				case "6": {utillString2 += "Se"; break;}
				case "7": {utillString2 += "Sy"; break;}
				case "8": {utillString2 += "O"; break;}
				case "9": {utillString2 += "N"; break;}
				case "0": {utillString2 += "Nu"; break;}
			}
		}
		
		System.out.println(krypteretCprNr);
		System.out.println(utillString2);
		return krypteretCprNr;
	}

	long deKrypter(BigDecimal cprNrKrypteret) throws NullPointerException{
		BigDecimal cprNr = null;
		
		try{
		cprNr = cprNrKrypteret.divide(nøgle,10,BigDecimal.ROUND_UNNECESSARY);
		}
		catch(ArithmeticException e){
			new ErrorMessage("Kryptering failed, this should never happen");
		}
		
		return cprNr.longValueExact();
	}
}
