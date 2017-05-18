package presentationCreditPlan;

import domain.CreditPlan;
import domain.Customer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import logic.InformationController;

public class CreditPlanStage extends  Stage{
CreditPlanOverview overview = new CreditPlanOverview(new CreditPlan());
CreditAssesmentGrid creditGrid;
	public CreditPlanStage(Customer customer){ //TODO Sæt det hele pænt op.
		this.setTitle("Ferrari Regional Software Inc.");
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root);
		this.setHeight(600);
		this.setWidth(450);
		this.setResizable(false);
		this.setScene(scene);
		
		GridPane utill = new GridPane();
		utill.add(new CustomerNameLabel("CustomerName"), 0, 0,10,1);
		utill.setAlignment(Pos.CENTER);
		
		
		AmountGrid amountGrid = new AmountGrid();
		overview.setObserver(amountGrid.getObserver());
		amountGrid.getObserver().assignStage(this);
		root.setTop(utill);
		
		
		creditGrid = new CreditAssesmentGrid();
		creditGrid.setObserver(amountGrid.getObserver());
		
/*		CreditAssesmentThread creditAssesmentThread = new CreditAssesmentThread(creditGrid);
		creditAssesmentThread.setCustomer(customer);
		creditAssesmentThread.start();*/
		
		
		root.setLeft(creditGrid); 
		root.setBottom(overview);
		root.setRight(amountGrid);
	}
	void setOverview(CreditPlanOverview creditPlanOverview){
		this.overview = creditPlanOverview;
	}
	public CreditAssesmentGrid getCreditAssesmentGrid(){
		return creditGrid;
	}
	public void start(){
		this.show();
	}
}
