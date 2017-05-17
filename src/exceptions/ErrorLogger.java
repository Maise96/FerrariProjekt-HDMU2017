package exceptions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ErrorLogger {
	public ErrorLogger(Exception e){
		try {
			String errorLog = "";
			errorLog += e.toString() + "\n";
			errorLog += "at: " + LocalDate.now().toString() + LocalTime.now(Clock.systemUTC())+ "\n";
			
			StackTraceElement[] st = e.getStackTrace();
			for(int i = 0; i<st.length;i++){
				errorLog+=(st[i].toString() + "\n");
			}
			errorLog += "\n\n\n\n";
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("error log",true));
			bw.write(errorLog);
			bw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
