package presentationCreateCustomer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import domain.Customer;
import exceptions.ErrorMessage;
import logic.InformationController;
import threads.Sleeper;

public class SearchCustomerThread extends Thread {
	boolean awake;
	List<Customer> customers;
	String searchName;
	String searchCpr;

	public void run() {
		while (true) {
			if (awake) {
				try {
					CustomerTableRefresh.refresh(new InformationController().searchCustomers(searchName, searchCpr));
					awake = false;
				} catch (SQLException e) {
					new ErrorMessage("SQLException in searchCustomerThread");
					
					e.printStackTrace();
				}
			} else {
				Sleeper.sleep(0.01);
			}
		}

	}

	public void wakeUp() {
		awake = true;
	}

	public void setSearchName(String name) {
		this.searchName = name;
	}

	public void setCpr(String cpr) {
		this.searchCpr = cpr;
	}

	public List<Customer> getResults() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
}
