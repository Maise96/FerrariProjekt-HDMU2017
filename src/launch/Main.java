package launch;

import java.math.BigDecimal;

import javafx.application.Application;
import javafx.stage.Stage;
import logic.cprKryptering;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
//		new PrimaryStage();
		BigDecimal cprNr = new BigDecimal("0703942881");
		new cprKryptering().krypter(cprNr);
	}
}
