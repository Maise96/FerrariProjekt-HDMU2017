package launch;

import javafx.application.Application;
import javafx.stage.Stage;
import presentation.PrimaryStage;

import com.ferrari.finances.dk.bank.*;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		new PrimaryStage();
	}
}
