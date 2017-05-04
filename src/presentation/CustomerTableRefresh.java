package presentation;

import presentation.CustomerTable;
import presentation.PrimaryStage;

class CustomerTableRefresh {
static CustomerTable customerTable;
static PrimaryStage location;	
	public CustomerTableRefresh(PrimaryStage lokation){
		CustomerTableRefresh.location = lokation;
	}
	public static void refresh(){
		location.setKundeTable(customerTable.refreshTable(customerTable));
	}
	public static void tilmeld(CustomerTable kundeTable){
		CustomerTableRefresh.customerTable=kundeTable;
	}
}
