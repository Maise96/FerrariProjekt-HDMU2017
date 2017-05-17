package presentationCreateCustomer;

import java.util.ArrayList;
import java.util.List;

import domain.Customer;

class CustomerTableRefresh {
static CustomerTable customerTable;
static PrimaryStage location;	
static List<Customer> lastRefresh = new ArrayList<Customer>();	
	public CustomerTableRefresh(PrimaryStage lokation){
		CustomerTableRefresh.location = lokation;
	}
	public static void refresh(List<Customer> customers){
		CustomerTableRefresh.lastRefresh = customers;
		
		location.setCustomerTable(customerTable.refreshTable(customers));//sætter customerTable på primarystage til at være det refreshede customerTable.
	}
	public static void tilmeld(CustomerTable kundeTable){
		CustomerTableRefresh.customerTable=kundeTable;
	}
}
