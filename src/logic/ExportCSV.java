package logic;
import java.io.EOFException;
import java.io.File;
import java.io.FileWriter;

import domain.Something;
import javafx.stage.FileChooser;


class ExportCSV 
{
	void exportCSV (Something something)
	{
		/*		try
		{

			 FileChooser fileChooser = new FileChooser();
			 File savedFile = fileChooser.showSaveDialog(null);
			 
			 FileWriter fileWriter = new FileWriter(savedFile);
			 for(int i=0; i<5;i++){
//				 fileWriter.append(something.get(i).getLoanOffer() + ",\n");
//				 fileWriter.append(something.get(i).getBackPayment() + ",\n");
				 fileWriter.append(something.get(i).getMonth() + ",\t");
				 fileWriter.append(something.get(i).getPayment() + ",\t");
				 fileWriter.append(something.get(i).getMissingOfLoan() + ",\n");
					
			 }
			fileWriter.write(fileWriter.toString());
			fileWriter.flush();
			fileWriter.close(); 
		} catch (EOFException e) {
			throw e;
		}
		*/	System.out.println("CSV export done.");
	}
}
