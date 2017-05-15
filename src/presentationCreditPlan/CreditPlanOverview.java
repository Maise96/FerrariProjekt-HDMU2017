package presentationCreditPlan;

import domain.CreditPlan;
import domain.Payment;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

class CreditPlanOverview extends TableView<Payment>{
CreditPlanObserver obs;		
	CreditPlanOverview(CreditPlan creditPlan){
		
		TableColumn<Payment,Double> amountCol = new TableColumn<Payment,Double>("Payment");
		amountCol.setCellValueFactory(new PropertyValueFactory<Payment,Double>("value"));
		
		TableColumn<Payment,Double> remainderCol = new TableColumn<Payment,Double>("remaining");
		remainderCol.setCellValueFactory(new PropertyValueFactory<Payment,Double>("remaining"));
		
		this.setItems(FXCollections.observableArrayList(creditPlan));
		this.getColumns().setAll(amountCol,remainderCol);
	}
	CreditPlanOverview update(CreditPlan creditPlan){
		this.setItems(FXCollections.observableArrayList(creditPlan));
		this.refresh();
		return this;
	}
	
	void setObserver(CreditPlanObserver obs){ //workaround
		this.obs = obs;
		obs.assignOverView(this);
	}
}
