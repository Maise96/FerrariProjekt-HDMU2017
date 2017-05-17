package presentationCreateCustomer;

import java.sql.SQLException;
import java.util.List;

import domain.Customer;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import logic.InformationController;

class CustomerTable extends TableView<Customer> {
	TableColumn<Customer, String> nameCol;
	TableColumn<Customer, Long> cprCol;

	public CustomerTable() {
		CustomerTableRefresh.tilmeld(this);

		TableColumn<Customer, String> nameCol = new TableColumn<Customer, String>("Navn");
		nameCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("name"));

		TableColumn<Customer, String> cprCol = new TableColumn<Customer, String>("CprNr");
		cprCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("cprNr"));

		TableColumn<Customer, Boolean> troubleCol = new TableColumn<Customer, Boolean>("Trouble");
		troubleCol.setCellValueFactory(new PropertyValueFactory<Customer, Boolean>("trouble"));

		this.getColumns().setAll(nameCol, cprCol, troubleCol);
		this.autosize();
		this.setPrefSize(250, 300);
		this.setMaxSize(300, 300);
		this.setOnMouseClicked(m -> {
			if (m.getButton().equals(MouseButton.SECONDARY) && this.getSelectionModel().getSelectedItem() != null) {
				this.setContextMenu(new RightClickMenu(this.getSelectionModel().getSelectedItem()));
			}

			if (m.getClickCount() >= 2) {

			}
		});

	}

	public CustomerTable refreshTable(List<Customer> customers) {
		this.setItems(FXCollections.observableArrayList(customers));
		this.refresh();
		return this;
	}

}
