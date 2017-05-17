package database;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class DBLogger {
	public DBLogger(String message,DBAccess command){
		try {
			String dbLog = "";
			
			dbLog = message +"\n at:" + LocalDate.now().toString() + LocalDateTime.now(Clock.systemUTC());
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("database log",true));
			bw.write(dbLog);
			bw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
