package presentationCreditPlan;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

class AmountGrid extends GridPane{
TextField amountTextField;
TextField downPaymentTextField;
CreditPlanObserver obs;
	AmountGrid(){
		
		obs = new CreditPlanObserver();
		
		HBox amountHBox = new HBox();
		amountTextField = new AmountTextField(obs);
		obs.assignAmountTextField(amountTextField);
		

		amountHBox.getChildren().addAll(new Label("Amount: "), amountTextField);
		
		HBox downPaymentHBox = new HBox();
		downPaymentTextField = new AmountTextField(obs);
		obs.assigndownPaymentTextField(downPaymentTextField);
		downPaymentHBox.getChildren().addAll(new Label("down-payment:"),downPaymentTextField);
		
		
		this.add(amountHBox, 0, 0);
		this.add(downPaymentHBox, 0, 1);
	}
	TextField getAmountTextField(){
		return amountTextField;
	}
	TextField getDownPaymentTextField(){
		return downPaymentTextField;
	}
	CreditPlanObserver getObserver(){
		return obs;
	}
}
