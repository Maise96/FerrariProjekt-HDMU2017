package presentation;

import java.sql.SQLException;

import database.DataBaseFacade;
import domain.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

class CustomerTable extends TableView<Customer>{
TableColumn<Customer,String> nameCol;
TableColumn<Customer,Long> cprCol;
	public CustomerTable(){
	CustomerTableRefresh.tilmeld(this);

	nameCol = new TableColumn<Customer,String>("Navn");
	nameCol.setCellValueFactory(new PropertyValueFactory<Customer,String>("navn"));
	
	cprCol = new TableColumn<Customer,Long>("CprNr");
	cprCol.setCellValueFactory(new PropertyValueFactory<Customer,Long>("cprNr"));
	
	this.getColumns().setAll(nameCol,cprCol);
	this.autosize();
	this.setPrefSize(150, 300);
	this.setMaxSize(200, 300);

	}
	public CustomerTable refreshTable(CustomerTable customerTable){
		
		ObservableList<Customer> customerList = FXCollections.observableArrayList();
		try {
			customerList = FXCollections.observableArrayList(new DataBaseFacade().hentAlleKunder());
		} catch (SQLException e) {
			new ErrorMessage("Failed to load customers, check your connection to the database and try again");
		}
				
		customerTable.setItems(customerList);
		customerTable.getColumns().setAll(nameCol,cprCol);
		
		return customerTable;
	}
	
}
