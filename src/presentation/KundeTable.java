package presentation;

import java.sql.SQLException;

import database.DataBaseFacade;
import domain.Kunde;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import utill.KundeTableRefresh;

public class KundeTable extends TableView<Kunde>{
	
	public KundeTable(){
	KundeTableRefresh.tilmeld(this);

	TableColumn<Kunde,String> navnCol = new TableColumn<Kunde,String>("Navn");
	navnCol.setCellValueFactory(new PropertyValueFactory<Kunde,String>("navn"));
	
	TableColumn<Kunde,Long> cprCol = new TableColumn<Kunde,Long>("CprNr");
	cprCol.setCellValueFactory(new PropertyValueFactory<Kunde,Long>("cprNr"));
	
	this.getColumns().setAll(navnCol,cprCol);
	this.autosize();
	this.setPrefSize(150, 300);
	this.setMaxSize(200, 300);

	}
	public KundeTable refreshTable(KundeTable kundeTable){
		
		ObservableList<Kunde> kundeListe = FXCollections.observableArrayList();
		try {
			kundeListe = FXCollections.observableArrayList(new DataBaseFacade().hentAlleKunder());
		} catch (SQLException e) {
			new ErrorMessage("Failed to load customers, check your connection to the database and try again");
		}
		
		TableColumn<Kunde,String> navnCol = new TableColumn<Kunde,String>("Navn");
		navnCol.setCellValueFactory(new PropertyValueFactory<Kunde,String>("navn"));

		TableColumn<Kunde,Long> cprCol = new TableColumn<Kunde,Long>("CprNr");
		cprCol.setCellValueFactory(new PropertyValueFactory<Kunde,Long>("cprNr"));
		
		kundeTable.setItems(kundeListe);
		kundeTable.getColumns().setAll(navnCol,cprCol);
		
		return kundeTable;
	}
	
}
