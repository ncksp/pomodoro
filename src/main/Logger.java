package main;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import observer.Observer;

public class Logger implements Observer {

    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssX");  
    
	@Override
	public void update(Date time) {
        System.out.println(formatter.format(new Timestamp(time.getTime())));
		// TODO Auto-generated method stub
		
	}

}
