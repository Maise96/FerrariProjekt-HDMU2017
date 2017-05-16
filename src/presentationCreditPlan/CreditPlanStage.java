package presentationCreditPlan;

import com.ferrari.finances.dk.rki.Rating;

import domain.CreditAssesment;
import domain.CreditPlan;
import domain.Customer;
import exceptions.BadCustomerException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import logic.InformationExpert;

public class CreditPlanStage extends  Stage{
CreditPlanOverview overview = new CreditPlanOverview(new CreditPlan());
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
		
		
		AmountGrid amountGrid = new AmountGrid();
		overview.setObserver(amountGrid.getObserver());
		amountGrid.getObserver().assignStage(this);
		root.setTop(utill);
		Customer testCustomer = new Customer("delete later","0123456788",false);
		
		try {
		CreditAssesmentGrid creditGrid = new CreditAssesmentGrid(new InformationExpert().newCreditAssesment(testCustomer));
		creditGrid.setObserver(amountGrid.getObserver());
		root.setLeft(creditGrid); //fejl her, indtil videre.
		} catch (BadCustomerException e) {
			CreditAssesment badCustomerAssesment = new CreditAssesment();
			badCustomerAssesment.setCreditRating(Rating.D);
			badCustomerAssesment.setCustomerRate(10000);
			badCustomerAssesment.setInterestRate(10000000);
			root.setLeft(new CreditAssesmentGrid(badCustomerAssesment));
		}
		root.setBottom(overview);
		root.setRight(amountGrid);
		this.show();
	}
	void setOverview(CreditPlanOverview creditPlanOverview){
		this.overview = creditPlanOverview;
	}
}
