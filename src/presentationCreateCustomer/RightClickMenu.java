package presentationCreateCustomer;

import java.sql.SQLException;
import java.util.List;

import domain.Customer;
import exceptions.CustomerDoesNotExistException;
import exceptions.ErrorMessage;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import logic.InformationController;
import presentationCreditPlan.CreditPlanStage;

class RightClickMenu extends ContextMenu{
	RightClickMenu(Customer customer){
		MenuItem flagCustomer;
		if(customer.getTrouble())
			flagCustomer = new MenuItem("unflag customer");
		else flagCustomer = new MenuItem("flag customer");
		flagCustomer.setOnAction(e->{
			Customer customer2 = customer;
			customer2.setTrouble(true);
			List<Customer> customers = CustomerTableRefresh.lastRefresh;
			try{
			customers.set(getIndexOf(customer,customers), customer2);
			}
			catch(NullPointerException n){
			}
			CustomerTableRefresh.refresh(customers);
			
		});
		MenuItem creditPlan = new MenuItem("issue loan");
		creditPlan.setOnAction(e->{
			new CreditPlanStage(customer);
		});
		MenuItem delete = new MenuItem("delete");
		delete.setOnAction(e->{
			try {
				new InformationController().deleteCustomer(customer);
			} catch (SQLException | CustomerDoesNotExistException e1) {
				if(e1.getClass().equals(CustomerDoesNotExistException.class))
					new ErrorMessage("somehow, the customer does not exist");
				else new ErrorMessage("connection to database failed, check error log");
			}
		});
		this.getItems().setAll(flagCustomer,creditPlan,delete);
	}
	private int getIndexOf(Customer customer,List<Customer> customers)throws NullPointerException{
		for(int i = 0; i<customers.size();i++){
			if(customers.get(i).equals(customer))
				return i;
		}
		throw new NullPointerException();
	}
	
}
