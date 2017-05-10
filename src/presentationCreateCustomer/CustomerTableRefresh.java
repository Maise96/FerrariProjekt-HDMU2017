package presentationCreateCustomer;

import java.util.List;

import domain.Customer;

class CustomerTableRefresh {
static CustomerTable customerTable;
static PrimaryStage location;	
	public CustomerTableRefresh(PrimaryStage lokation){
		CustomerTableRefresh.location = lokation;
	}
	public static void refresh(List<Customer> customers){
		location.setCustomerTable(customerTable.refreshTable(customerTable,customers));
	}
	public static void tilmeld(CustomerTable kundeTable){
		CustomerTableRefresh.customerTable=kundeTable;
	}
}
