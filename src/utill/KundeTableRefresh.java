package utill;

import presentation.KundeTable;
import presentation.PrimaryStage;

public class KundeTableRefresh {
static KundeTable kundeTable;
static PrimaryStage lokation;	
	public KundeTableRefresh(PrimaryStage lokation){
		KundeTableRefresh.lokation = lokation;
	}
	public static void refresh(){
		lokation.setKundeTable(kundeTable.refreshTable(kundeTable));
	}
	public static void tilmeld(KundeTable kundeTable){
		KundeTableRefresh.kundeTable=kundeTable;
	}
}
