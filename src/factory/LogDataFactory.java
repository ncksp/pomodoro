package factory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class LogDataFactory {
	private static String today = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssX").format(new Date());
	
	public static int convertToDay(String date) {
	    try {
			Date d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssX").parse(date);
			Date now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssX").parse(today);
			
			long diffInTime = Math.abs(now.getTime() - d.getTime());
			long diffDay = TimeUnit.DAYS.convert(diffInTime, TimeUnit.MILLISECONDS);
			if(diffDay > 7) 
				return 8;
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			
			return calendar.get(Calendar.DAY_OF_WEEK) - 1;
		} catch (ParseException e) {
			return -1;
		}
	}
}
