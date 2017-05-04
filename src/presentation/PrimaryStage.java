package presentation;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import utill.KundeTableRefresh;

public class PrimaryStage extends Stage {
	BorderPane root;
	Scene scene;
	KundeTable kundeTable;
	public PrimaryStage(){
		this.setTitle("Ferrari Regional Software inc.");
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
		setUpTable();
		root.setCenter(kundeTable);
		root.setBottom(new OpretKundeGrid());
		this.show();
	}
	public void setKundeTable(KundeTable kundeTable){
		this.kundeTable = kundeTable;
	}
	private void setUpTable(){
		kundeTable = new KundeTable();
		new KundeTableRefresh(this);
		kundeTable.refresh();
	}

}
