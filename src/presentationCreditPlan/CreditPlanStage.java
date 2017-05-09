package presentationCreditPlan;

import domain.CreditPlan;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CreditPlanStage extends  Stage{
	public CreditPlanStage(/*Customer kunde*/){ //TODO Sæt det hele pænt op.
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
		
		
		CreditPlanOverview overview = new CreditPlanOverview(new CreditPlan()); //TODO: lav creditPlan i logic laget.
		AmountGrid amountGrid = new AmountGrid();
		overview.setObserver(amountGrid.getObserver());
		
		root.setTop(utill);
		root.setLeft(new CreditAssesmentGrid(/*new CreditAssesment(customer)*/"interest rate goes here","customer creditrating goes here", "customers rate goes here"));
		
		root.setBottom(overview);
		root.setRight(amountGrid);
		this.show();
		
	}
}
