package domain;

import java.math.BigDecimal;

public class Car {
	private BigDecimal price;
	private String model;
	private Boolean avaible;
	
	public Car(BigDecimal price, String model, Boolean avaible){
		this.price = price;
		this.model = model;
		this.avaible = avaible;
	}
	
	public BigDecimal getPrice() {
		return price;
	}

	public String getModel() {
		return model;
	}

	public Boolean getAvaible() {
		return avaible;
	}

}