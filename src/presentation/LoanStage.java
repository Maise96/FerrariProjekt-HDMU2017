package presentation;

import domain.Customer;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

class LoanStage extends  Stage{
BorderPane root;
Scene scene;
	public LoanStage(Customer kunde){
		this.setTitle("Ferrari Regional Software Inc.");
		root = new BorderPane();
		scene = new Scene(root);
		this.setHeight(300);
		this.setWidth(450);
		this.setResizable(false);
		this.setScene(scene);
		this.show();
	}
}
