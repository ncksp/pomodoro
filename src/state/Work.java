package state;

import java.awt.Color;

public class Work extends PomodoroState{
	private int position; 
	
	public Work(int pos) {
		this.position = pos;
	}
	
	@Override
	protected int getMinute() {
		return 25;
	}

	@Override
	protected Color getBackgroundColor() {
		return Color.RED;
	}

	@Override
	protected boolean isBreak() {
		return false;
	}
	
	@Override
	protected PomodoroState next() {
		if(position < 4)
			return new Break(position);
		
		return new LongBreak(); 
				
	}
}
