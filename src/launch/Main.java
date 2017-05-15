package launch;

import javafx.application.Application;
import javafx.stage.Stage;
import logic.CreditPlanCalculator;
import presentationCreateCustomer.PrimaryStage;
import presentationCreditPlan.CreditPlanStage;


public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		new UpdateInterestRate().start();
		new PrimaryStage();
		new CreditPlanStage();
	}

}
