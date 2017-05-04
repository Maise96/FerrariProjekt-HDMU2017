package presentation;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class ErrorMessage extends Stage {
	GridPane grid;
	Scene scene;
	String errorMessage;
		public ErrorMessage(String errorMessage){
			grid = new GridPane();
			scene = new Scene(grid);
			Button button = new Button("ok");
			button.setOnAction(e->{
				this.close();
			});
			button.setDefaultButton(true);
			this.setWidth(300);
			this.setHeight(125);
			ErrorLabel error = new ErrorLabel(errorMessage);
			VBox vbox = new VBox();
			vbox.getChildren().addAll(error,button);
			vbox.setAlignment(Pos.CENTER);
			grid.add(vbox, 0, 0);
			grid.setAlignment(Pos.CENTER);
			this.setScene(scene);
			scene.setOnKeyReleased(k->{
				if(k.getCode().equals(KeyCode.ESCAPE)){
					this.close();
				}
			});
			this.show();
		}
	
}
