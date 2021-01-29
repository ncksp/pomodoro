package observer;

import java.util.Date;

public interface Observable {
	void broadcast(Date time);
	void addObserver(Observer o);
}
