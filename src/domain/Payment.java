package domain;

public class Payment {
	double value;
	double remaining;
	public Payment(double value, double remaining) {
		this.value = value;
		this.remaining = remaining;
	}

	public double getRemaining() {
		return remaining;
	}

	public void setRemaining(double remaining) {
		this.remaining = remaining;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return format(Double.toString(value) +format(Double.toString(remaining)));
	}
	String format(String s){
		int antalDecimaler = (s.indexOf(".") - s.length()) * -1;
		if (antalDecimaler > 3)
			return s.substring(0, s.indexOf(".") + 3);
		else
			return s;
	
	}
}
