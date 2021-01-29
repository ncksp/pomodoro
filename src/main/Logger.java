package main;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import observer.Observer;

public class Logger implements Observer {

    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssX");  
    
	@Override
	public void update(Date time) {
		try {
			FileWriter writer = new FileWriter("log.csv");
			writer.append(formatter.format(new Timestamp(time.getTime()))+",Work");
			writer.close();
		} catch (IOException e) {
			System.out.println("Failed to write Work Log");
			e.printStackTrace();
		}
	}

}
