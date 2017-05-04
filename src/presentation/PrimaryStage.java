package presentation;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PrimaryStage extends Stage {
	BorderPane root;
	Scene scene;
	CustomerTable kundeTable;
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
		start();
	}
	
	public void start() {
		setUpTable();
		root.setCenter(kundeTable);
		root.setBottom(new CreateCustomerGrid());
		this.show();
	}
	public void setKundeTable(CustomerTable kundeTable){
		this.kundeTable = kundeTable;
	}
	private void setUpTable(){
		kundeTable = new CustomerTable();
		new CustomerTableRefresh(this);
		kundeTable.refreshTable(kundeTable);
	}

}
