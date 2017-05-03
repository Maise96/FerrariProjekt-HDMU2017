package utill;

import presentation.KundeTable;

public class KundeTableRefresh {
static KundeTable kundeTable;
	public void Refresh(){
		kundeTable = kundeTable.refreshTable(kundeTable);
	}
	public static void tilmeld(KundeTable kundeTable){
		KundeTableRefresh.kundeTable=kundeTable;
	}
}
