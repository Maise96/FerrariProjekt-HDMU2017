package presentationCreditPlan;

import domain.CreditAssesment;
import domain.CreditPlan;
import domain.Customer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import threads.Sleeper;

public class CreditPlanStage extends  Stage implements Runnable{
CreditPlanOverview overview = new CreditPlanOverview(new CreditPlan());
CreditAssesmentGrid creditGrid;
BorderPane root;
AmountGrid amountGrid;
CreditAssesmentThread thread;
	public CreditPlanStage(Customer customer){ //TODO Sæt det hele pænt op.
		thread = new CreditAssesmentThread(this,customer);
		thread.start();
		this.setTitle("Ferrari Regional Software Inc.");
		root = new BorderPane();
		Scene scene = new Scene(root);
		this.setHeight(600);
		this.setWidth(450);
		this.setResizable(false);
		this.setScene(scene);
		
		GridPane utill = new GridPane();
		utill.add(new CustomerNameLabel("CustomerName"), 0, 0,10,1);
		utill.setAlignment(Pos.CENTER);
		
		
		amountGrid = new AmountGrid();
		overview.setObserver(amountGrid.getObserver());
		amountGrid.getObserver().assignStage(this);
		root.setTop(utill);

		amountGrid.setDisable(true);	
		
		
/*		CreditAssesmentThread creditAssesmentThread = new CreditAssesmentThread(creditGrid);
		creditAssesmentThread.setCustomer(customer);
		creditAssesmentThread.start();*/
		
		
		root.setLeft(new Label("Waiting for RKI")); 
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
		run();
	}

	public void rkiResponse(CreditAssesment creditAssesment) {
		creditGrid = new CreditAssesmentGrid(creditAssesment);
		creditGrid.setObserver(amountGrid.getObserver());
		root.setLeft(creditGrid);
		amountGrid.setDisable(false);
	}
	@Override
	public void run() {
		
		while(!thread.isDone())
			Sleeper.nap();
			
		rkiResponse(thread.getCreditAssesment());
	
	}
	
	
}
