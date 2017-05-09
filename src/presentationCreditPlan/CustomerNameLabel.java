package presentationCreditPlan;


import javafx.geometry.Pos;
import javafx.scene.control.Label;

class CustomerNameLabel extends Label {

	CustomerNameLabel(String name){
		this.setText(name);
		this.setWidth(200);
		this.setHeight(75);
		//TODO: lav navnet stort og flot, som en overskrift-agtigt-noget.
	}

}
