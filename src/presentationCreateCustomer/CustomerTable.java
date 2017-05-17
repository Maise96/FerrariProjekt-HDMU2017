package presentationCreateCustomer;

import java.util.List;

import domain.Customer;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import presentationCreditPlan.CreditPlanStage;

class CustomerTable extends TableView<Customer>{
TableColumn<Customer,String> nameCol;
TableColumn<Customer,Long> cprCol;
	public CustomerTable(){
	CustomerTableRefresh.tilmeld(this);

	
	nameCol = new TableColumn<Customer,String>("Navn");
	nameCol.setCellValueFactory(new PropertyValueFactory<Customer,String>("name"));
	
	cprCol = new TableColumn<Customer,Long>("CprNr");
	cprCol.setCellValueFactory(new PropertyValueFactory<Customer,Long>("cprNr"));
	
	TableColumn<Customer,Boolean> troubleCol = new TableColumn<Customer,Boolean>("Trouble");
	troubleCol.setCellValueFactory(new PropertyValueFactory<Customer,Boolean>("trouble"));
	
	this.getColumns().setAll(nameCol,cprCol,troubleCol);
	this.autosize();
	this.setPrefSize(250, 300);
	this.setMaxSize(300, 300);
	this.setOnMouseClicked(m->{
		if(m.getClickCount()>=2 && this.getSelectionModel().getSelectedItem()!=null){
			new CreditPlanStage(this.getSelectionModel().getSelectedItem());
		}
	});
	
	}
	public CustomerTable refreshTable(List<Customer> customers){
		this.setItems(FXCollections.observableArrayList(customers));
		this.refresh();
		return this;
	}
	
}
