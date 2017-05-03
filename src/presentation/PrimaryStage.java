package presentation;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PrimaryStage extends Stage {
	BorderPane root;
	Scene scene;
	
	public PrimaryStage(){
		this.setTitle("Ferrari Regioanl Software inc.");
		root = new BorderPane();
		
		this.sizeToScene();
		this.setScene(scene);
		this.setResizable(false);
		root.setPrefSize(800, 500);
	}
	
	public void start() {
		root.setBottom(new opretKundeGrid());
		
		
		this.show();
		
		
	}

}
