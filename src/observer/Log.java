package observer;

import java.util.Date;
import java.util.Vector;

public class Log implements Observable {
	private Vector<Observer> observers = new Vector<Observer>();
	
	@Override
	public void broadcast(Date time) {
        for (Observer o : observers) {
			o.update(time);
		}
	}

	@Override
	public void addObserver(Observer o) {
        if(observers.size() > 1) observers.remove(1); //remove multiple viewStats object
        
		observers.add(o);
	}

}
