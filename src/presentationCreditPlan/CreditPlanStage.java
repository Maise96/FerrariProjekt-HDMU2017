package presentationCreditPlan;

import com.ferrari.finances.dk.rki.Rating;

import domain.CreditPlan;
import domain.Customer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import logic.InformationExpert;

public class CreditPlanStage extends  Stage{
	public CreditPlanStage(/*Customer customer*/){ //TODO Sæt det hele pænt op.
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
		Customer testCustomer = new Customer("delete later","0123456789");
		
		CreditAssesmentGrid creditGrid = new CreditAssesmentGrid(new InformationExpert().newCreditAssesment(testCustomer));
		creditGrid.setObserver(amountGrid.getObserver());
		root.setLeft(creditGrid); //fejl her, indtil videre.
		
		root.setBottom(overview);
		root.setRight(amountGrid);
		this.show();
		
	}
}
