package presentation;

import domain.Kunde;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LaanStage extends  Stage{
BorderPane root;
Scene scene;
	public LaanStage(Kunde kunde){
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
/*test ændring */
