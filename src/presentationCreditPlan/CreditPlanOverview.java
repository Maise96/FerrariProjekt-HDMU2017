package presentationCreditPlan;

import java.sql.Date;

import domain.CreditPlan;
import domain.Payment;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

class CreditPlanOverview extends TableView<Payment>{
CreditPlanObserver obs;	
	public CreditPlanOverview(CreditPlan creditPlan){
		
		TableColumn<Payment,Double> amountCol = new TableColumn<Payment,Double>("Payment");
		
		TableColumn<Payment,Date> dateCol = new TableColumn<Payment,Date>("Dato");
		
		this.setItems(FXCollections.observableArrayList(creditPlan));
		this.getColumns().setAll(amountCol,dateCol);
	}
	void setObserver(CreditPlanObserver obs){ //workaround
		this.obs = obs;
		obs.assignOverView(this);
	}
}
