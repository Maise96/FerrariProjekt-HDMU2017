package presentation;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PrimaryStage extends Stage {
	BorderPane root;
	Scene scene;

	public PrimaryStage(){
		this.setTitle("Ferrari Regioanl Software inc.");
		root = new BorderPane();
		scene = new Scene(root);
		
		this.sizeToScene();
		this.setScene(scene);
		this.setResizable(false);
		scene.setOnKeyReleased(k->{
			if(k.getCode().equals(KeyCode.ESCAPE)){
				System.exit(0);
			}
		});
		this.setOnCloseRequest(e->{
			System.exit(0);
		});
	}
	
	public void start() {
		root.setCenter(new KundeTable());
		root.setBottom(new opretKundeGrid());
		
		this.show();
	}

}
